package GUI;

import javax.print.attribute.standard.NumberUp;
import javax.swing.*;
import java.awt.*;

public class TestChooseFrame extends JFrame {
    JLabel question1 = new JLabel("Type the number of words you want to test");
    JLabel question2 = new JLabel("Which test would you like to take?");
    JButton button1 = new JButton("Spell");
    JButton button2 = new JButton("Pronounce");
    JPanel panel = new JPanel(null);
    SpeakTestFrame speakTestFrame;
    SelfTestFrame selfTestFrame;
    TestChooseFrameListener testChooseFrameListener = new TestChooseFrameListener();

    public TestChooseFrame(){
        this.setTitle("Choose your test");
        this.setSize(570, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setLayout(null);

        panel.setBounds(0, 0, 570, 700);
        Color backGroundColor = new Color(176, 200, 255);
        panel.setBackground(backGroundColor);

        button1.setBounds(100, 200, 150, 150);
        button2.setBounds(300, 200, 150, 150);

        question1.setBounds(70, 350, 470, 180);
        question1.setFont(new Font("微软雅黑", Font.BOLD, 20));
        question2.setBounds(100, 50, 470, 180);
        question2.setFont(new Font("微软雅黑", Font.BOLD, 20));



        testChooseFrameListener.testChooseFrame = this;

        panel.add(button1);
        panel.add(button2);
        panel.add(question1);
        panel.add(question2);


        button1.addActionListener(testChooseFrameListener);
        button2.addActionListener(testChooseFrameListener);

        this.add(panel);
        this.setVisible(true);
    }
}
