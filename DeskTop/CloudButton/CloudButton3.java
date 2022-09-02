package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton3 extends JButton {
    public CloudButton3() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon3());
        this.setRolloverIcon(new RollOverIcon3());
        this.setPressedIcon(new RollOverIcon3());
    }
}
