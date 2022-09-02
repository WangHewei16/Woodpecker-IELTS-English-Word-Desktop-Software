package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton2 extends JButton {
    public CloudButton2() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon2());
        this.setRolloverIcon(new RollOverIcon2());
        this.setPressedIcon(new RollOverIcon2());
    }
}
