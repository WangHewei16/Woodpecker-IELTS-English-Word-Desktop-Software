package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moving implements ActionListener {
    CloudPanel panel;
    public Moving(CloudPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Cloud cloud : panel.clouds){
            cloud.move();
        }
        panel.repaint();

    }
}
