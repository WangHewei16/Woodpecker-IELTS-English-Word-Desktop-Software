package GUI;

import Function.DictionaryExamples;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DetailExplainListener implements ActionListener {
    DetailedExplain detailedExplain;
    @Override
    public void actionPerformed(ActionEvent e) {
        for (TranslateButton translateButton: detailedExplain.buttonList){
            if(e.getSource() == translateButton){
                try {
                    detailedExplain.showExplains(translateButton.arrayList);
                } catch (IOException | JSONException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
