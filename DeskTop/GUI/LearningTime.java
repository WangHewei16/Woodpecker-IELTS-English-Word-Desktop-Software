package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LearningTime implements ActionListener {
    int time = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        time += 1;
    }
}
