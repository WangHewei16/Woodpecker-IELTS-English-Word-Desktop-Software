package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import CloudButton.*;
import Function.Plan;
import Function.Record;
import Function.WordsLearned;

public class HomeFrame extends JFrame {
    JPanel panel = new JPanel(null);
    CloudButton1 button1 = new CloudButton1();
    CloudButton2 button2 = new CloudButton2();
    CloudButton3 button3 = new CloudButton3();
    CloudButton4 button4 = new CloudButton4();
    CloudButton5 button5 = new CloudButton5();
    CloudButton6 button6 = new CloudButton6();
    HomeFrameListener fl = new HomeFrameListener();

    public void initUI() throws IOException {

        //2. 窗体属性
        this.setTitle("Recite Vocabulary");
        this.setSize(570, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //3. 设置定点布局
        this.setLayout(null);

        //4. 设置面板
        panel.setBounds(0, 0, 570, 700);
        Color backGroundColor = new Color(176, 200, 255);
        panel.setBackground(backGroundColor);

        //设置标题
        JLabel title = new JLabel("IELTS ASSISTANT");
        title.setForeground(Color.MAGENTA);
        title.setFont(new Font("Kristen ITC", Font.BOLD, 30));
        title.setBounds(130, 0, 480, 80);

        //设置欢迎语
        JLabel name = new JLabel("Dear A,");
        JLabel welcome = new JLabel("Welcome to IELTS Assistant!");
        name.setForeground(Color.MAGENTA);
        name.setFont(new Font("Kristen ITC", Font.BOLD, 15));
        name.setBounds(30, 100, 80, 20);
        welcome.setForeground(Color.MAGENTA);
        welcome.setFont(new Font("Kristen ITC", Font.BOLD, 15));
        welcome.setBounds(30, 137, 280, 20);

        button1.setBounds(50, 200, 87 * 2 + 20, 60 * 2);
        button2.setBounds(317, 200, 87 * 2 + 20, 60 * 2);
        button3.setBounds(50, 350, 87 * 2 + 20, 60 * 2);
        button4.setBounds(317, 350, 87 * 2 + 20, 60 * 2);
        button5.setBounds(50, 500, 87 * 2 + 20, 60 * 2);
        button6.setBounds(317, 500, 87 * 2 + 20, 60 * 2);

        panel.add(title);
        panel.add(name);
        panel.add(welcome);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        button1.addActionListener(fl);
        button2.addActionListener(fl);
        button3.addActionListener(fl);
        button4.addActionListener(fl);
        button5.addActionListener(fl);
        button6.addActionListener(fl);
        fl.homeFrame = this;

        this.add(panel);
        this.setVisible(true);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(Calendar.getInstance().getTime());
        if (!Record.getUserDate().contains(today)){
            Record.recordUserDate(today);
            Plan.changeStart(WordsLearned.learnedWords().size());
            Plan.changeIndex(-1);
            Plan.changeMaxIndex(0);
        }
    }
}