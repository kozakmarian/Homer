package sk.upjs.paz1c.homer.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class RecipeItemListModel extends AbstractListModel<Item> {

    private List<Item> items = new ArrayList<>();
    private final ItemDao itemDao = ObjectFactory.INSTANCE.getDao(Item.class);
    private final Recipe recipe;
    
    public RecipeItemListModel(Recipe recipe) {
        this.recipe = recipe;
        items = recipe.getIngredients();
        if (items == null) {
            List<Item> ingredients = itemDao.findAll(recipe);
            recipe.setIngredients(ingredients);
            items = ingredients;
        }
    }
    
    @Override
    public Item getElementAt(int index) {
        return items.get(index);
    }

    @Override
    public int getSize() {
        return items.size();
    }
    
    public void refresh() {
        items.clear();
        items = itemDao.findAll(recipe);
    }
}
