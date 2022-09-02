package GUI;

import java.awt.*;

public class Cloud {
    int x = 30;
    int y = 15;
    int n;
    String[] strings = new String[] {"Persevere", "Confidence", "Strive", "Dreaming", "Motivation", "Openness", "energetic", "strength"};

    public Cloud(int n) {
        this.n = n;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y+21, 37, 37);
        g.fillOval(x+17, y, 37, 37);
        g.fillOval(x+40, y+13, 45, 45);
        g.fillRect(x+15, y+37, 48, 21);
        g.setColor(Color.cyan);
        g.setFont(new Font("Kristen ITC", Font.BOLD, 12));
        g.drawString(strings[n], x+8+(9-strings[n].length())*5, y+43);
    }
    public void move(){
        this.x = this.x + 1;
        if(this.x > 700){
            this.x = -50;
        }
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}
