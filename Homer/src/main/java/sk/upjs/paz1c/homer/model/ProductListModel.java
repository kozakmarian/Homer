package sk.upjs.paz1c.homer.model;

import java.util.List;
import javax.swing.AbstractListModel;
import sk.upjs.paz1c.homer.ObjectFactory;
import sk.upjs.paz1c.homer.dao.ProductDao;
import sk.upjs.paz1c.homer.entity.Product;


/**
 *
 * @author ntb
 */
public class ProductListModel extends AbstractListModel<Product> {

  
    private List<Product> products;
    private ProductDao productDao;

    public ProductListModel() {
        productDao = ObjectFactory.INSTANCE.getDao(Product.class);

    }

    @Override
    public int getSize() {
        return (products!= null) ? products.size() : 0;
    }

    @Override
    public Product getElementAt(int index) {
        Product product = (Product) products.get(index);
        return product;
    }

    public void refreshList(List<Product> products) {
        this.products.clear();
        this.products = products;
        fireIntervalAdded(this, 0, products.size());

      
    }
    
    

}