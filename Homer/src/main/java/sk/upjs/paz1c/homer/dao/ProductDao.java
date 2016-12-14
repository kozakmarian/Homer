package sk.upjs.paz1c.homer.dao;
import java.util.List;
import sk.upjs.paz1c.homer.entity.Product;

/**
 * Interface describing product-specific methods
 * 
 * @author dyske
 */
public interface ProductDao extends GenericDao<Product> {    
    /**
     *
     * @param name              Name to look for
     * @return List<Product>    or null if none
     */
    List<Product>      find(String name);
}
