package sk.upjs.paz1c.homer.dao;
import java.util.List;
import sk.upjs.paz1c.homer.*;
/**
 *
 * @author dyske
 */
public interface CommodityDao {
    public List<Commodity>      list();
    public Commodity            find(Long id);
    public List<Commodity>      find(String name);
    public List<Commodity>      find(Recipe recipe);
    public void                 store(Commodity commodity);
    public void                 delete(Commodity commodity);
}
