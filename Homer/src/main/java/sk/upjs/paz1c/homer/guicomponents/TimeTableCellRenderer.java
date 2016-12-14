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
        if (minutes <= 0) {
            label.setText("");
            return label;
        }
        if (minutes < 60) {
            time += " " + getLocalizedName(minutes, false);
        } else {
            int hours = (int)(minutes / 60);
            int rem = minutes % 60;
            time = hours + " " + getLocalizedName(hours, true);
            time += (rem != 0) ? " a " + rem +  " " + getLocalizedName(rem, false) : "";
        }
        label.setText(time);
        return label;
    }
    
    private String getLocalizedName(int value, boolean isHours) {
        if (isHours) {
            if (value == 1) return "hodina";
            if (value < 5) return "hodiny";
            return "hodín";
        } else {
            if (value == 1) return "minúta";
            if (value < 5) return "minúty";
        }
        return "minút";
    }
}
