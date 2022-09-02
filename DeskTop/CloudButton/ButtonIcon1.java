package CloudButton;

import javax.swing.*;
import java.awt.*;

public class ButtonIcon1 implements Icon {

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        g.fillOval(0, 54, 60, 60);
        g.fillOval(10, 0, 57*2, 57*2);
        g.fillOval(40*2-7, 13*2-3, 45*2, 45*2);
        g.fillOval(120, 52, 62, 62);
        g.drawImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("2.png")), 19, 28, 63, 75, null);
        g.setColor(Color.cyan);
        g.setFont(new Font("Kristen ITC", Font.BOLD, 20));
        g.drawString("Progress", 81, 77);
        g.drawString("Checking", 79, 97);
    }

    @Override
    public int getIconWidth() {
        return 90*2+20;
    }

    @Override
    public int getIconHeight() {
        return 60*2;
    }
}
