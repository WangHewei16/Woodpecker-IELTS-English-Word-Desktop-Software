package GUI;

import java.awt.*;
import javax.swing.*;


public class PinkCircleIcon implements Icon {

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Color foreground = new Color(224, 85, 161);
        g.setColor(foreground);
        g.fillOval(0, 4, 12, 12);
    }
    @Override
    public int getIconWidth() {
        return 20;
    }
    @Override
    public int getIconHeight() {
        return 20;
    }
}