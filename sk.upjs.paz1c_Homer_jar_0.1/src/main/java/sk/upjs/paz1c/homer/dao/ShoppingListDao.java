package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 * Yet another interface extending {@link GenericDao}.
 * 
 * @author dyske
 */
public interface ShoppingListDao extends GenericDao<ShoppingList> {

    /**
     * Looks for all ShoppingLists containing a specific item. Looks like there
     * is a many-to-many relation.
     * 
     * @see sk.upjs.paz1c.homer.dao.mysql.MysqlShoppingListDao#findAll(sk.upjs.paz1c.homer.entity.Item) 
     * @param item  An Item to look for
     * @return List<ShoppingList> A list of lists, nice isn't it?
     */
    public List<ShoppingList> findAll(Item item);
}
