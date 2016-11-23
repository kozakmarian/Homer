package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.Item;
import sk.upjs.paz1c.homer.ShoppingList;

/**
 *
 * @author dyske
 */
public interface ItemDao {
    public List<Item>           list();
    public Item                 find(Long id);
    public List<Item>           findAll(ShoppingList shoppingList);
    public void                 store(Item item);
    public void                 delete(Item item);
    public void                 done(Item item);
}
