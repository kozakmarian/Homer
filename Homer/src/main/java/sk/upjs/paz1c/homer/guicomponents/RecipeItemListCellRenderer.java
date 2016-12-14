package sk.upjs.paz1c.homer.guicomponents;

import com.alee.laf.label.WebLabel;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sk.upjs.paz1c.homer.entity.Item;

/**
 *
 * @author dyske
 */
public class RecipeItemListCellRenderer extends WebLabel implements ListCellRenderer<Item> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list,
                                                  Item value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus
    ) {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        String amount = new DecimalFormat("#.##").format(value.getAmount());
        String compound = amount + " " + value.getUnit();
        setText(
                String.format(" %1$-15s %2$s",
                        compound, value.getName())
        );
        return this;
    }
}
