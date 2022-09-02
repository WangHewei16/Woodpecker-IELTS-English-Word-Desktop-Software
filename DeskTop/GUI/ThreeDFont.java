package GUI;

import java.awt.*;
import javax.swing.*;

public class ThreeDFont extends JLabel {
    /*
    public static void main(String[] args) {
        new ThreeDFont().initUI();
    }
    */
    String s;
    public ThreeDFont(){
    }
    /*
    public ThreeDFont(String s){
        s = this.s;
    }
    */
    /*
    public Graphics initUI() {
        setSize(800,600);
        setDefaultCloseOperation(3);
        setVisible(true);
        Graphics g = getGraphics();
        return g;
    }
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < 13; i++) {
            g.setColor(new Color(19+i*19,209,232));
            g.setFont(new Font("BOLD",Font.PLAIN,50));
            g.drawString("PLAN",15-i,50+i);
        }
    }
}