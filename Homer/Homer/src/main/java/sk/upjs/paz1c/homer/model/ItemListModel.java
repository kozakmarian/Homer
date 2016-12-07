package sk.upjs.paz1c.homer.model;

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

    private ShoppingList shoppingList;
    private List<Item> items;
    private ItemDao itemDao;

    public ItemListModel(ShoppingList shoppingList) {
        itemDao = ObjectFactory.INSTANCE.getItemDao();

    }

    @Override

    public int getSize() {
        return items.size();
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

        //refresh?
    }

}
