package GUI;

import Function.Translate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TranslateButton extends JButton {
    ArrayList<String> arrayList;
    public TranslateButton (ArrayList<String> arrayList){
        super();
        this.arrayList = arrayList;
        this.setText(arrayList.get(0));
        this.setSize(this.getMaximumSize());
        this.setBackground(Color.blue);
        this.setForeground(Color.white);
        this.setFocusPainted(false);
        this.setFont(new Font("微软雅黑", Font.BOLD, 20));
        //this.setBorderPainted(false);
        this.setSize(this.getMaximumSize());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
}
