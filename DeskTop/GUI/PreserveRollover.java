package GUI;

import javax.swing.*;
import java.awt.*;

public class PreserveRollover implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(10, 0, 20, 400);
        g.setColor(Color.YELLOW);
        g.fillRect(12, 2, 16, 396);
        g.setColor(Color.gray);
        g.fillOval(2, 387, 35, 35);
        g.setColor(Color.CYAN);
        g.fillOval(7, 392, 25, 25);
    }

    @Override
    public int getIconWidth() {
        return 60;
    }

    @Override
    public int getIconHeight() {
        return 430;
    }
}
