package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton6 extends JButton {
    public CloudButton6() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon6());
        this.setRolloverIcon(new RollOverIcon6());
        this.setPressedIcon(new RollOverIcon6());
    }
}
