package GUI;

import javax.swing.*;
import java.awt.*;

public class NotePanel extends JPanel {
    PreserveButton button = new PreserveButton();
    public NotePanel(){
        this.setLayout(null);
        this.setBackground(Color.CYAN);
        this.button.setBounds(50, 0, 40, 500);
        this.add(button);
    }

}
