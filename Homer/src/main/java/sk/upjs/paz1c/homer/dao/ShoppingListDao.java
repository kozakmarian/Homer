package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.ShoppingList;

/**
 *
 * @author dyske
 */
public interface ShoppingListDao {
    public List<ShoppingList>   list();
    public ShoppingList         find(Long id);
    public List<ShoppingList>   find(String name);
    public void                 store(ShoppingList shoppingList);
    public void                 delete(ShoppingList shoppingList);
}
