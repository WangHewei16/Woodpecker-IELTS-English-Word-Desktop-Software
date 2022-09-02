package GUI;
import javax.swing.*;
import java.awt.*;

public class IncorrectIcon implements Icon {
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.RED);
        int[] xP = {5+0,5+25,5+50,5+75,5+100,5+75,5+100,5+75,5+50,5+25,5+0,5+25};
        int[] yP = {5+25,5+0,5+25,5+0,5+25,5+50,5+75,5+100,5+75,5+100,5+75,5+50};
        g.fillPolygon(xP,yP,12);



    }

    @Override
    public int getIconWidth() {
        return 200/2+20/2;
    }

    @Override
    public int getIconHeight() {
        return 200/2+20/2;
    }
}