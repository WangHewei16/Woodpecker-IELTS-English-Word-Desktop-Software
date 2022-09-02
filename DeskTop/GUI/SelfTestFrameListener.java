package GUI;

import Function.Plan;
import Function.Record;
import Function.TestWordRecommend;
import Function.Translate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.lang.String;
import java.text.ParseException;
import java.util.ArrayList;


public class SelfTestFrameListener implements ActionListener{
    public SelfTestFrame previewSelfTestFrame;
    public int flag = 0;
    public ArrayList<String> wordsToTest = TestWordRecommend.recommend();
    public String chinesequest = Translate.doTranslateEnglishToChinese(wordsToTest.get(flag));
    public JTextField answer;
    public String correctanswerstr = wordsToTest.get(flag);
    public String[] strs;
    public int number;

    public SelfTestFrameListener() throws IOException, ParseException {
        if(Integer.parseInt(Plan.readPlan()[5]) > 0) {
            this.number = Math.min(Integer.parseInt(Plan.readPlan()[5]), wordsToTest.size());
        }else {
            this.number = 15;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnstr = e.getActionCommand();
        boolean result;
        if(btnstr.equals("Confirm")){
            try{
                //correctanswerstr = Translate.doTranslateChineseToEnglish(chinesequest);
                if(answer.getText().equals(correctanswerstr)){
                    result = true;
                }else {
                    result = false;
                    Record.recordWrongWord(correctanswerstr);
                }
                previewSelfTestFrame.intiUI(chinesequest,correctanswerstr,result,false);
            } catch (ParseException e2){
                e2.printStackTrace();
            } catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if(btnstr.equals("Next")){
            if (flag < number-1) {
                flag += 1;
                System.out.println(chinesequest + correctanswerstr);
                try {
                    chinesequest = Translate.doTranslateEnglishToChinese(wordsToTest.get(flag));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                correctanswerstr = wordsToTest.get(flag);
                try {
                    previewSelfTestFrame.intiUI(chinesequest, correctanswerstr, true, true);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                previewSelfTestFrame.progressBar.setValue(flag*100/(number-1));
                System.out.println(flag);
                System.out.println(correctanswerstr);
            }
        }
    }
}