package sk.upjs.paz1c.homer.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.homer.dao.GenericDao;
import sk.upjs.paz1c.homer.entity.Entity;

/**
 *
 * @author dyske
 * @param <T>
 */
public class GenericComboBoxModel<T extends Entity> extends DefaultComboBoxModel{
    private final GenericDao dao;

    public GenericComboBoxModel(GenericDao dao) {
        this.dao = dao;
        this.refresh();
    }

    public void refresh() {
        removeAllElements();

        List<T> shoppingLists = dao.list();

        shoppingLists.forEach((shoppingList) -> {
            addElement(shoppingList);
        });
    }
}
