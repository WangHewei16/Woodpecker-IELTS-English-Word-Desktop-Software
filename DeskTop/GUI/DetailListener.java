package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailListener implements ActionListener {
    IseDemo iseDemo;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Detail")){
            iseDemo.syllableFrame = new SyllableFrame(iseDemo.detail);
        }
    }
}
