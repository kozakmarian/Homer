package sk.upjs.paz1c.homer.guicomponents;

import com.alee.extended.image.DisplayType;
import com.alee.extended.image.WebImage;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sk.upjs.paz1c.homer.FileStorage;
import sk.upjs.paz1c.homer.entity.Recipe;
import sk.upjs.paz1c.homer.model.RecipeTableModel;

/**
 *
 * @author dyske
 */
public class ImageTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column
    ) {
        RecipeTableModel model = (RecipeTableModel) table.getModel();
        WebImage image = new WebImage();
        Recipe r = (Recipe) value;
        Dimension size = new Dimension(70, 40);

        image.setSize(size);
        image.setPreferredSize(size);
        image.setMaximumSize(size);
        image.setMinimumSize(size);
        
        image.setDisplayType(DisplayType.fitComponent);
        
        try {
            image.setImage(ImageIO.read(FileStorage.getFile("recipe" + r.getId() + ".jpg", new URL(r.getImage()), true)));
        } catch (IOException ex) {
            Logger.getLogger(ImageTableCellRenderer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }    
}
