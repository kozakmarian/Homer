package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.Recipe;

/**
 *
 * @author dyske
 */
public interface RecipeDao {
    public List<Recipe>         list();
    public Recipe               find(Long id);
    public List<Recipe>         find(String name);
    public void                 store(Recipe recipe);
    public void                 delete(Recipe recipe);
}
