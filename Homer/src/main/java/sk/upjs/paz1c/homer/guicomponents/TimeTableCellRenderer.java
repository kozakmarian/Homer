package sk.upjs.paz1c.homer.guicomponents;

import com.alee.laf.label.WebLabel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author dyske
 */
public class TimeTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column
    ) {
        JLabel label = new WebLabel();
        String time = value.toString();
        Integer minutes = (Integer) value;
        if (minutes < 60) {
            time += " minút";
        } else {
            int hours = (int)(minutes / 60);
            int rem = minutes % 60;
            time = hours + "h " + ((rem != 0) ? rem + " min" : "");
        }
        label.setText(time);
        return label;
    }
}
