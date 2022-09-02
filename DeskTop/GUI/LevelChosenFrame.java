package GUI;

import javax.swing.*;
import java.awt.*;


public class LevelChosenFrame extends JFrame {

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JTextField textField = new JTextField();
    JLabel label1 = new JLabel("Please Select Your IELTS Grade");
    WordsPushFrame wordsPushFrame;
    JLabel question1 = new JLabel("Type the number of words you want to test");
    WordsChosenFrameListener wordsChosenFrameListener = new WordsChosenFrameListener();


    public LevelChosenFrame(){

        //窗体
        this.setTitle("Recite Words");
        this.setSize(500,730);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jlp = new JPanel(null);
        //图片
        ImageIcon icon = new ImageIcon(this.getClass().getResource("ReciteWordsPicture.jpg"));
        Image img = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 1);
        JLabel jlabel = new JLabel(new ImageIcon(img));
        jlabel.setBounds(0, 0, this.getWidth(), this.getHeight());

        //按钮

        button1 = new JButton("4.0 - 4.5");
        button1.setBounds(205, 270, 80, 40);
        button2 = new JButton("5.0 - 5.5");
        button2.setBounds(205, 320, 80, 40);
        button3 = new JButton("6.0 - 6.5");
        button3.setBounds(205, 370, 80, 40);
        button4 = new JButton("7.0 - 7.5");
        button4.setBounds(205, 420, 80, 40);
        button5 = new JButton("8.0 - 8.5");
        button5.setBounds(205, 470, 80, 40);

        question1.setBounds(30, 480, 470, 180);
        question1.setFont(new Font("微软雅黑", Font.BOLD, 20));

        textField.setBounds(50, 600, 400, 30);
        textField.setHorizontalAlignment((JTextField.CENTER));

        JLabel label1 = new JLabel("Please Select Your IELTS Grade");
        label1.setFont(new Font("黑体",Font.BOLD, 22));
        label1.setBounds(50, 10, 365, 100);
        label1.setForeground(Color.RED);

        jlp.add(label1);

        jlp.add(button1);
        jlp.add(button2);
        jlp.add(button3);
        jlp.add(button4);
        jlp.add(button5);
        jlp.add(textField);
        jlp.add(question1);
        jlp.add(jlabel);
        //按钮事件
        wordsChosenFrameListener.levelChosenFrame = this;
        button1.addActionListener(wordsChosenFrameListener);
        button2.addActionListener(wordsChosenFrameListener);
        button3.addActionListener(wordsChosenFrameListener);
        button4.addActionListener(wordsChosenFrameListener);
        button5.addActionListener(wordsChosenFrameListener);

        this.add(jlp);
        this.setVisible(true);
    }
}
