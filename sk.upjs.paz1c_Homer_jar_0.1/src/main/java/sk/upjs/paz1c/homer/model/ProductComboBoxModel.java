package sk.upjs.paz1c.homer.model;

import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.entity.Product;


/**
 *
 * @author ntb
 */
public class ProductComboBoxModel extends GenericComboBoxModel<Product> {
    public ProductComboBoxModel() {
        super(ObjectFactory.INSTANCE.getDao(Product.class));
        refresh();
    }
}
