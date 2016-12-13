package sk.upjs.paz1c.homer.guicomponents;

import com.alee.extended.image.WebImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author dyske
 */
public class PortionsTableCellRenderer extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column
    ) {
        Integer portions = (Integer) value;
        int[] circles = new int[2];
        int i = portions;
        while (i != 0) {
            if (i - 5 > 0){i-=5;circles[1]++; continue;}
            i-=1; circles[0]++;
        }

        BufferedImage bi = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.fillRect(0, 0, 100, 40);
        
        for (int j = 0; j < 5; j++) {
            int size = (circles[1] != 0) ? 16 : 8;
            if (circles[1] != 0) circles[1]--;
            else if (circles[0] != 0) circles[0]--;
            else break;
            int x = 10 + j * 20, y = 20;
            g.setPaint(new RadialGradientPaint(x, y, size, new float[]{0f, 1f}, new Color[]{Color.white, Color.darkGray}));
            circle(g, x, y, size);
        }
        
        WebImage webImage = new WebImage(bi);
        webImage.setToolTipText(portions + ((portions == 1) ? " porcia" : (portions <= 4) ? " porcie" :" porcií"));
        return webImage;
    }
    
    private void circle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
    }
}
