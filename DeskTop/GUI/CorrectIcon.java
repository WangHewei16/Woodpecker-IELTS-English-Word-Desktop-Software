package GUI;
import javax.swing.*;
import java.awt.*;

public class CorrectIcon implements Icon {
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        int[] xP = {10/2,10/2+100/2,10/2+300/2,10/2+100/2};
        int[] yP = {110/2,210/2,10/2,150/2};
        g.fillPolygon(xP,yP,4);



    }

    @Override
    public int getIconWidth() {
        return 300/2+20/2;
    }

    @Override
    public int getIconHeight() {
        return 200/2+20/2;
    }
}