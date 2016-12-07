package sk.upjs.paz1c.homer.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.homer.ObjectFactory;

import sk.upjs.paz1c.homer.dao.ShoppingListDao;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author ntb
 */
public class ListComboBoxModel extends DefaultComboBoxModel<ShoppingList> {

    private ShoppingListDao shoppingListDao = ObjectFactory.INSTANCE.getShoppingListDao();

    public ListComboBoxModel() {
        refresh();
    }

    public void refresh() {
        removeAllElements();

        List<ShoppingList> shoppingLists = shoppingListDao.list();

        for (ShoppingList shoppingList : shoppingLists) {
            addElement(shoppingList);
        }
    }
}
