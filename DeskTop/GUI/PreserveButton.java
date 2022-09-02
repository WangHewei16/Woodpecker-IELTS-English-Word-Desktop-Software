package GUI;

import CloudButton.ButtonIcon1;
import CloudButton.RollOverIcon1;

import javax.swing.*;
import java.awt.*;

public class PreserveButton extends JButton {
    public PreserveButton() {
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setIcon(new PreserveButtonIcon());
        this.setRolloverIcon(new PreserveRollover());
        this.setPressedIcon(new PreserveButtonIcon());
    }
}
