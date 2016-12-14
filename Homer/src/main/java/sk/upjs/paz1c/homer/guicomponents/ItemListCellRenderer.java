package sk.upjs.paz1c.homer.guicomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sk.upjs.paz1c.homer.Status;
import sk.upjs.paz1c.homer.entity.Item;

/**
 *
 * @author ntb
 */
public class ItemListCellRenderer extends JLabel implements ListCellRenderer<Item>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected, boolean cellHasFocus) {
        setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        String amount = new DecimalFormat("#.##").format(value.getAmount());
        String unit = "";
        if(value.getStatus() == Status.DONE) {
            setBackground(Color.green);
        }
        
        if (value.getUnit() != null) {
            unit = value.getUnit();   
        }
        
        setText(
            String.format(" %1$-40s %2$s",
                    amount + " " + unit,
                    value.getName()
            )
        );
           return this;
    }
    
}
