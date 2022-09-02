package GUI;


import org.pushingpixels.substance.api.skin.SubstanceNebulaBrickWallLookAndFeel;

import javax.swing.*;

public class MainF {
    public static void main(String[] args){

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        /*javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                //设置外观
                UIManager.setLookAndFeel(new SubstanceNebulaBrickWallLookAndFeel());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });*/
        LogInFrame sif = new LogInFrame();
        sif.initUI();



    }
}