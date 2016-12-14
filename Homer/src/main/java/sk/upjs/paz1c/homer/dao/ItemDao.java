package sk.upjs.paz1c.homer.dao;

import java.util.List;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *  Interface declaring methods for more convenient work with {@link Item}s
 * 
 * @author dyske
 */
public interface ItemDao extends GenericDao<Item>{

    /**
     * The method acts as a basic filter, using relation between {@link Item}
     * and {@link ShoppingList}.
     * 
     * @param shoppingList  Shopping list of which Items have to be returned
     * @return              List of requested {@link Item}s, or null if empty
     */
    List<Item>           findAll(ShoppingList shoppingList);

    /**
     * The method acts as a basic filter, using relation between {@link Item}
     * and {@link Recipe}.
     * 
     * @param recipe        A recipe of which Items have to be returned
     * @return              List of requested {@link Item}s, or null if empty
     */
    List<Item>           findAll(Recipe recipe);

    
    /**
     * A quick convenience method, that updates {@link Item} as being bought.
     * 
     * @param item  Item of which {@link Item#status} has to be marked as
     *              {@link Status#DONE}
     */
    void                 done(Item item);

    public List<Item> findAllByProductName(String name);
}
