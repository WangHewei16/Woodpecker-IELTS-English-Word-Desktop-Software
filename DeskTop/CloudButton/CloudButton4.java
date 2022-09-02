package CloudButton;

import javax.swing.*;
import java.awt.*;

public class CloudButton4 extends JButton {
    public CloudButton4() {
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new ButtonIcon4());
        this.setRolloverIcon(new RollOverIcon4());
        this.setPressedIcon(new RollOverIcon4());
    }
}
