package GUI;

import javax.swing.*;
import java.awt.*;

public class PreserveButtonIcon implements Icon {
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(10, 0, 20, 350);
        g.setColor(Color.YELLOW);
        g.fillRect(12, 2, 16, 346);
        g.setColor(Color.gray);
        g.fillOval(2, 337, 35, 35);
        g.setColor(Color.CYAN);
        g.fillOval(7, 342, 25, 25);
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
