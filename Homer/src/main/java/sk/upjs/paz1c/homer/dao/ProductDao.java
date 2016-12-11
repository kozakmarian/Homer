package sk.upjs.paz1c.homer.dao;
import java.util.List;
import sk.upjs.paz1c.homer.entity.Product;
import sk.upjs.paz1c.homer.entity.Recipe;

/**
 * Interface describing product-specific methods
 * 
 * @author dyske
 */
public interface ProductDao extends GenericDao<Product> {

    /**
     * Returns {@link java.util.List} of products in specific {@link Recipe}
     * 
     * @param recipe            Recipe of which products are requested
     * @return List<Product>    or null if none
     */
    List<Product>      find(Recipe recipe);
    List<Product> find(String name);
   
}
