package GUI;

import Function.Translate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class LookUpWordsFrameListener implements ActionListener {
    public LookUpWordsFrame previewLookUpWordsFrame;
    public JTextField word;
    public String result = "";
    public void actionPerformed(ActionEvent e) {
        String btnstr = e.getActionCommand();
        Translate t = new Translate();
        System.out.println(btnstr);
        if(btnstr.equals("Look Up")) {
            String language = checkString(word.getText());
            if(language.equals("英文")){
                try {
                    result = Translate.doTranslateEnglishToChinese(word.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }else if (language.equals("中文")) {
                try {
                    result = Translate.doTranslateChineseToEnglish(word.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println(result);
            }else {
                JOptionPane.showMessageDialog (null, "Incorrect input form :-(") ;
            }
        }
        previewLookUpWordsFrame.initUI(word.getText()+":  "+result);
    }


    public static boolean checkChar(char ch) {
        if ((ch + "").getBytes().length == 1) {
            return true;//英文
        } else {
            return false;//中文
        }
    }

    public static String checkString(String str) {
        String res = "";
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                //只要字符串中有中文则为中文
                if (!checkChar(str.charAt(i))) {
                    res = "中文";
                    break;
                } else {
                    res = "英文";
                }
            }
        }
        return res;
    }
}
