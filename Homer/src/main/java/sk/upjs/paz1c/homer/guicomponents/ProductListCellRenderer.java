package sk.upjs.paz1c.homer.guicomponents;

import com.alee.extended.image.WebImage;
import java.awt.Component;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sk.upjs.paz1c.homer.FileStorage;
import sk.upjs.paz1c.homer.entity.Product;

/**
 *
 * @author ntb
 */
public class ProductListCellRenderer extends JLabel implements ListCellRenderer<Product> {

    private DefaultListCellRenderer delegate = new DefaultListCellRenderer();

    @Override
    public Component getListCellRendererComponent(JList<? extends Product> list, Product product, int index, boolean isSelected, boolean cellHasFocus) {

        Component component = delegate.getListCellRendererComponent(list, product, index, isSelected, cellHasFocus);
        WebImage webImage = new WebImage();

        if (component instanceof JLabel) {
            JLabel label = (JLabel) component;
            label.setText(product.getName());

            try {
                webImage.setImage(ImageIO.read(FileStorage.getFile("product" + product.getId() + ".jpg", new URL(product.getImage()))));
                label.setIcon((Icon) webImage);
            } catch (MalformedURLException ex) {
                Logger.getLogger(ProductListCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ProductListCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }

            return label;

        }
        return null;
    }
}
