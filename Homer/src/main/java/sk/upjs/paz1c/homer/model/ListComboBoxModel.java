package sk.upjs.paz1c.homer.model;

import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.entity.ShoppingList;

/**
 *
 * @author ntb
 */
public class ListComboBoxModel extends GenericComboBoxModel<ShoppingList> {

    public ListComboBoxModel() {
        super(ObjectFactory.INSTANCE.getDao(ShoppingList.class));
        refresh();
    }
}
