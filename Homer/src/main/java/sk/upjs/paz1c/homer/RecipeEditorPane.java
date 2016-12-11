package sk.upjs.paz1c.homer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.xhtmlrenderer.simple.XHTMLPanel;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 * @deprecated Detail UI je uz prerobene.
 * @author dyske
 */
public class RecipeEditorPane extends XHTMLPanel {
    
    public RecipeEditorPane() {
        super();
    }
    
    public RecipeEditorPane(String instructions) {
        super();
        this.setText(instructions);
    }
    
    public RecipeEditorPane(Recipe recipe) {
        super();
        this.setText(recipe);
    }
    public void setText(String s) {
        this.setDocumentFromString(s, "/", this.getSharedContext().getNamespaceHandler());
    }

    public void setText(Recipe r) {
        try {
            File f = FileStorage.getFile("recipe" + r.getId() + ".html");
            if (f == null)
                f = this.generateFromTemplate(r);
            if (f == null)
                this.setText(r.getInstructions());
            else
                this.setDocument(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File generateFromTemplate(Recipe r) {
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
            Path filePath = Files.write(Paths.get(FileStorage.TEMPDIR + File.separator + "recipe" + r.getId() + ".html"), html.getBytes());
            return filePath.toFile();
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, "Failed to load recipeTemplate");
        }
        return null;
    }
}
