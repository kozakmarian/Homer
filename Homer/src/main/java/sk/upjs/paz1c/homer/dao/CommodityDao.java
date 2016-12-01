package sk.upjs.paz1c.homer.dao;
import java.util.List;
import sk.upjs.paz1c.homer.*;
/**
 *
 * @author dyske
 */
public interface CommodityDao {
    public List<Product>      list();
    public Product            find(Long id);
    public List<Product>      find(String name);
    public List<Product>      find(Recipe recipe);
    public void                 store(Product commodity);
    public void                 delete(Product commodity);
}
