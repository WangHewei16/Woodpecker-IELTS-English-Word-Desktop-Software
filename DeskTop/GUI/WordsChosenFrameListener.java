package GUI;

import org.json.JSONException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WordsChosenFrameListener implements ActionListener {
    LevelChosenFrame levelChosenFrame;

    @Override
    public void actionPerformed(ActionEvent e) {
        String button_str = e.getActionCommand();
        if(button_str.equals("4.0 - 4.5")) {
            try {
                levelChosenFrame.wordsPushFrame = new WordsPushFrame(1);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
            levelChosenFrame.setVisible(false);
            levelChosenFrame.wordsPushFrame.setVisible(true);
        }else if(button_str.equals("5.0 - 5.5")) {
            try {
                levelChosenFrame.wordsPushFrame = new WordsPushFrame(2);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
            levelChosenFrame.setVisible(false);
            levelChosenFrame.wordsPushFrame.setVisible(true);
        }else if(button_str.equals("6.0 - 6.5")) {
            try {
                levelChosenFrame.wordsPushFrame = new WordsPushFrame(3);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
            levelChosenFrame.setVisible(false);
            levelChosenFrame.wordsPushFrame.setVisible(true);
        }else if(button_str.equals("7.0 - 7.5")) {
            try {
                levelChosenFrame.wordsPushFrame = new WordsPushFrame(4);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
            levelChosenFrame.setVisible(false);
            levelChosenFrame.wordsPushFrame.setVisible(true);
        }else if(button_str.equals("8.0 - 8.5")) {
            try {
                levelChosenFrame.wordsPushFrame = new WordsPushFrame(5);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
            levelChosenFrame.setVisible(false);
            levelChosenFrame.wordsPushFrame.setVisible(true);
        }
    }
}
