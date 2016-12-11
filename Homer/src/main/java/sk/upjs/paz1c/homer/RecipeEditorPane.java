package sk.upjs.paz1c.homer;

import com.alee.laf.text.WebEditorPane;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 *
 * @author dyske
 */
public class RecipeEditorPane extends WebEditorPane {
    
    public RecipeEditorPane() {
        super();
        this.setContentType("text/html");
    }
    
    public RecipeEditorPane(String instructions) {
        super();
        this.setContentType("text/html");
        this.setText(instructions);
    }
    
    public RecipeEditorPane(Recipe recipe) {
        super();
        this.setContentType("text/html");
        this.setText(recipe);
    }

    public void setText(Recipe r) {
        URL templateResource = ClassLoader.getSystemResource("sk/upjs/paz1c/homer/recipeTemplate.html");
        try {
            String html = new Scanner(templateResource.openStream(), "UTF-8").useDelimiter("\\A").next();
            Map<String, String> replacementMap = new HashMap<>();
            replacementMap.put("#recipeName#", r.getName());
            replacementMap.put("#recipeImage#", r.getImage());
            String instructionsHtml = Arrays.stream(r.getInstructions().split("\n"))
                                      .map(s -> "<li>" + s + "</li>")
                                      .collect(Collectors.joining("\n"));
            replacementMap.put("#recipeInstructions#", instructionsHtml);
            for(Map.Entry<String, String> e : replacementMap.entrySet()) {
                html = html.replace(e.getKey(), e.getValue());
            }
            super.setText(html);
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, "Failed to load recipeTemplate");
            super.setText(r.getInstructions());
        }
    }
}
