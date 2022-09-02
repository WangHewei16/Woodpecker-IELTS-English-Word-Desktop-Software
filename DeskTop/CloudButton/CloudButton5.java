package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton5 extends JButton {
    public CloudButton5() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon5());
        this.setRolloverIcon(new RollOverIcon5());
        this.setPressedIcon(new RollOverIcon5());
    }
}
