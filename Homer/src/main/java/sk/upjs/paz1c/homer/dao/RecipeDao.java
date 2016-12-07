package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 * Small interface holding only single signature, but it is required as we want
 * to be consistent in application design.
 * 
 * @author dyske
 */
public interface RecipeDao extends GenericDao<Recipe>{

    /**
     * Fetches all recipes of which name matches passed argument. The search is
     * case-sensitive with UTF-8 recognition.
     * 
     * @param name      List of matching recipes
     * @return List<Recipe> or null if no matches were found
     */
    List<Recipe>         find(String name);
}
