package GUI;

import javax.swing.*;
import java.awt.*;

public class CloudPanel extends JPanel {
    Color backGroundColor;
    Cloud[] clouds = new Cloud[8];
    public CloudPanel() {
        backGroundColor = new Color(176, 200, 255);
        for(int i=0; i<8; i++){
            clouds[i] = new Cloud(i);
            clouds[i].setLocation(10+80*i, 15+(i%2)*50);
        }
    }

    public void paint(Graphics g){
        g.setColor(backGroundColor);
        g.fillRect(0, 0, 700, 150);
        for(Cloud cloud : clouds){
            cloud.draw(g);
        }
    }
}
