package GUI;

import Function.Plan;
import org.json.JSONException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class HomeFrameListener implements ActionListener {

    public HomeFrame homeFrame;
    public JFrame logInFrame;

    public HomeFrameListener() {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeFrame.button6) {
            this.homeFrame.setVisible(false);
            logInFrame.setVisible(true);
        }
        else if (e.getSource() == homeFrame.button2){
            LookUpWordsFrame lf = new LookUpWordsFrame();
            lf.initUI("");
            lf.setLocationRelativeTo(null);
        }
        else if (e.getSource() == homeFrame.button5){
            try {
                WordsPushFrame wordsPushFrame = new WordsPushFrame(Integer.parseInt(Plan.readPlan()[0]));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }
        }
        else if(e.getSource() == homeFrame.button3) {
            NoteFrame frame = new NoteFrame();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        else if(e.getSource() == homeFrame.button1){
            ProgressCheckinFrame progressCheckinFrame = null;
            try {
                progressCheckinFrame = new ProgressCheckinFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                progressCheckinFrame.initUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            progressCheckinFrame.setLocationRelativeTo(null);
        }
        else if(e.getSource() == homeFrame.button4){
            TestChooseFrame testChooseFrame = new TestChooseFrame();
        }

    }

}
