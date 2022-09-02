package GUI;

import Function.Plan;
import Function.Record;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class CloseListener extends WindowAdapter {
    WordsPushFrame wordsPushFrame;
    public CloseListener(WordsPushFrame wordsPushFrame){
        this.wordsPushFrame = wordsPushFrame;
    }
    @Override
    public void windowClosing(WindowEvent e) {
        try {
            Record.recordWord(wordsPushFrame.wordsRecommendation.word, wordsPushFrame.learningTime.time);
            Record.recordDatetime(wordsPushFrame.wordsRecommendation.word);
            Plan.changeIndex(wordsPushFrame.wordsRecommendation.index - 1);
            Plan.changeMaxIndex(wordsPushFrame.learnedWords);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
