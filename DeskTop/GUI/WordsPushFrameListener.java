package GUI;

import Function.Record;
import Function.Speaker;
import org.json.JSONException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WordsPushFrameListener implements ActionListener {
    WordsPushFrame wordsPushFrame;
    boolean end = false;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")){
            if(wordsPushFrame.reachEnd()){
                wordsPushFrame.end();
                end = true;
            }
            else {
                try {
                    Record.recordWord(wordsPushFrame.wordsRecommendation.word, wordsPushFrame.learningTime.time);
                    Record.recordDatetime(wordsPushFrame.wordsRecommendation.word);
                    wordsPushFrame.goNext();
                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
            }
            wordsPushFrame.progressBar.setValue(wordsPushFrame.wordsRecommendation.index*100/(wordsPushFrame.wordsRecommendation.words.size()-1));
        }
        if(e.getActionCommand().equals("Back")){
            if(!wordsPushFrame.reachFirst()){
                if (!end){
                    try {
                        Record.recordWord(wordsPushFrame.wordsRecommendation.word, wordsPushFrame.learningTime.time);
                        Record.recordDatetime(wordsPushFrame.wordsRecommendation.word);
                        wordsPushFrame.goBack();
                    } catch (IOException | JSONException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else {
                    wordsPushFrame.wordsRecommendation.index += 1;
                    try {
                        wordsPushFrame.goBack();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    } catch (JSONException jsonException) {
                        jsonException.printStackTrace();
                    }
                    end = false;
                }
                wordsPushFrame.progressBar.setValue(wordsPushFrame.wordsRecommendation.index*100/(wordsPushFrame.wordsRecommendation.words.size()-1));
            }
        }
        if(e.getActionCommand().equals("Speak")){
            Speaker.speak(wordsPushFrame.wordsRecommendation.word);
        }
        if(e.getActionCommand().equals("Explains")){
            try {
                DetailedExplain detailedExplain = new DetailedExplain(wordsPushFrame.wordsRecommendation.word);
                detailedExplain.setVisible(true);
            } catch (IOException | JSONException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
