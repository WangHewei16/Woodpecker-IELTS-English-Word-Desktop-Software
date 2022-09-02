package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class TestChooseFrameListener implements ActionListener {
    TestChooseFrame testChooseFrame;
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Spell")) {
            SelfTestFrameListener reader = null;
            try {
                reader = new SelfTestFrameListener();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            //reader.LineReader(1);
            testChooseFrame.selfTestFrame = new SelfTestFrame();
            testChooseFrame.selfTestFrame.stfl = reader;
            try {
                testChooseFrame.selfTestFrame.intiUI(reader.chinesequest, reader.correctanswerstr, true, true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }

            testChooseFrame.selfTestFrame.setLocationRelativeTo(null);
            testChooseFrame.selfTestFrame.setVisible(true);
        }
        else if(e.getActionCommand().equals("Pronounce")){
            try {
                testChooseFrame.speakTestFrame = new SpeakTestFrame();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        }
        testChooseFrame.setVisible(false);
    }
}
