package sk.upjs.paz1c.homer.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.dao.ItemDao;
import sk.upjs.paz1c.homer.entity.Item;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author ntb
 */
public class ItemListModel extends AbstractListModel<Item> {

    private ShoppingList shoppingList = new ShoppingList();
    private List<Item> items = new ArrayList<>();
    private final ItemDao itemDao;

    public ItemListModel(ShoppingList shoppingList) {
        itemDao = ObjectFactory.INSTANCE.getDao(Item.class);
       
        

    }

    @Override
    public int getSize() {
        return (items != null) ? items.size() : 0;
    }

    @Override
    public Item getElementAt(int index) {
        Item item = (Item) items.get(index);
        return item;
    }

    public void refresh(ShoppingList shoppingList) {
      
        items.clear();
        items = itemDao.findAll(shoppingList);
        fireIntervalAdded(this, 0, items.size());
            fireContentsChanged(this,0, items.size());
        //refresh
        
    }

}
