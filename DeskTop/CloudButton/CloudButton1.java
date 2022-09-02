package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton1 extends JButton {

    public CloudButton1() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon1());
        this.setRolloverIcon(new RollOverIcon1());
        this.setPressedIcon(new RollOverIcon1());
    }
}
