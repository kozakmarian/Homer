package sk.upjs.paz1c.homer.model;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.entity.Product;


/**
 *
 * @author ntb
 */
public class ProductComboBoxModel extends DefaultComboBoxModel<Product> {
    
    private ProductDao productDao = ObjectFactory.INSTANCE.getProductDao();
    
    public ProductComboBoxModel() {
        refresh();
    }
    
    public void refresh() {
        removeAllElements();
        
        List<Product> products = productDao.list();
        
        for (Product product : products) {
            addElement(product);
        }
    }
}
