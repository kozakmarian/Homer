package sk.upjs.paz1c.homer;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.dao.RecipeDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Product;
import sk.upjs.paz1c.homer.entity.Recipe;
import static java.nio.charset.StandardCharsets.*;

/**
 *
 * @author dyske
 */
public class RecipeParser {

    /**
     * Downloads and parses recipe from website at given URL address. Currently
     * supports only recipes from http://recepty.sk/ using either HTTP or HTTPS
     * protocol. Method inserts all the data into database using available DAOs.
     * Warning: this method is parsing and processing a lot of text and it is not
     * a good idea to run it on a batch of urls.
     * 
     * Uses library JSoup for HTML parsing.
     * @see https://jsoup.org/
     * 
     * @param url       URL to parse content from.
     * @throws IOException  Thrown when URL is malformed/unavailable
     * @throws UnsupportedOperationException    Thrown when URL does not point to
     *                                          recepty.sk domain.
     */
    public static void fetchFromUrl(String url) throws IOException, UnsupportedOperationException {
        if (!url.contains("recepty.sk")) {
            throw new UnsupportedOperationException("Recipe loading is curerntly supported only from 'recepty.sk' website");
        }
        Connection connection = Jsoup.connect(url)
                                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                                .referrer("http://www.google.com");
        // @todo fix encoding
        String html = new String(connection.execute().bodyAsBytes(), UTF_8);
        Document doc = Jsoup.parse(html);
        Recipe recipe = new Recipe();
        Element recipeNode = doc.select("article").get(0);

        recipe.setUrl(url);
        recipe.setName(recipeNode.select(".main-title").text());
        recipe.setImage(
                recipeNode
                .select("picture[data-image-source='recipe_content']>img")
                .attr("data-src")
        );
        recipe.setPreparation(Integer.parseInt(
                recipeNode
                .select(".preparation>.info-text")
                .text().replaceAll("[A-z]", "")
        ));
        recipe.setCooking(Integer.parseInt(
                recipeNode
                .select(".cooking>.info-text")
                .text().replaceAll("[A-z]", "")
        ));
        recipe.setPortions(Integer.parseInt(
                recipeNode
                .select(".chunks>.info-text")
                .text()
        ));
        
        recipe.setInstructions(
                recipeNode
                .select(".procedure-item").stream()
                .map(Element::text)
                .collect(Collectors.joining("\n"))
        );
        recipe.setStatus(Status.NORMAL);
        RecipeDao recipeDao = ObjectFactory.INSTANCE.getDao(Recipe.class);
        recipeDao.store(recipe);

        Elements ingredients = recipeNode.select("ul.ingredients-list>li.ingredient-item");
        ProductDao productDao = ObjectFactory.INSTANCE.getDao(Product.class);
        ItemDao itemDao = ObjectFactory.INSTANCE.getDao(Item.class);

        ingredients.stream().forEach((i) -> {
            Product p = new Product();
            p.setName(i.select(".name").text());
            p.setStatus(Status.NORMAL);
            productDao.store(p);

            Item it = new Item();
            String[] c = i.select(".count").get(0).text().trim().split("\\s+");
            try{
                it.setAmount(Float.parseFloat(c[0]));
            } catch (NumberFormatException e) {
                if (c[0].contains("/")) {
                    double[] frac = Arrays.stream(c[0].split("/"))
                                    .mapToDouble(Float::parseFloat)
                                    .toArray();
                    it.setAmount((float)(frac[0] / frac[1]));
                }
            }
            it.setUnit((c.length==2) ? c[1] : "");
            it.setStatus(Status.NORMAL);
            it.setProduct_id(p.getId());
            it.setRecipeId(recipe.getId());

            itemDao.store(it);
        });

    }
}
