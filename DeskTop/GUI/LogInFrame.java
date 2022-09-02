package GUI;

import javax.swing.*;
import java.awt.*;

public class LogInFrame extends JFrame{
    //1. 窗体及其中主体内容
    JFrame jf = new JFrame();
    CloudPanel panel1 = new CloudPanel(); //上方面板
    JPanel panel2 = new JPanel(null); //下方面板
    Moving moving = new Moving(panel1);
    Timer timer = new Timer(7, moving); //云的线程
    JTextField accountField;
    JPasswordField passwardField;

    public LogInFrame(){
        timer.start();
        panel1.setLayout(null);
        panel2.setBackground(Color.WHITE);
    }

    public void initUI() {
        //2. 窗体属性
        jf.setTitle("Log In");
        jf.setSize(700, 500);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置定点布局
        jf.setLayout(null);

        //3. 组件

        //图片（标签）
        ImageIcon img = new ImageIcon(this.getClass().getResource("./1.jpeg"));
        JLabel imgJlabel = new JLabel(img);
        imgJlabel.setBounds(20, 55, 150, 150);


        //文字（标签）
        JLabel accountJla = new JLabel("Account:");
        JLabel passwardJla = new JLabel("Password:");
        accountJla.setBounds(168, 70, 50, 35);
        passwardJla.setBounds(168, 150, 70, 35);


        //输入框
        accountField = new JTextField();
        passwardField = new JPasswordField();
        accountField.setBounds(235, 70, 400, 35);
        passwardField.setBounds(235, 150, 400, 35);


        //复选框
        //JCheckBox box = new JCheckBox("Remember Password");
        //box.setBounds(190, 210, 150, 35);
        //box.setBackground(Color.WHITE);

        //按钮
        JButton btn = new JButton();
        btn.setText("Log In");
        btn.setBounds(297, 210, 90, 35);
        JButton btn1 = new JButton();
        btn1.setText("Register");
        btn1.setBounds(447, 210, 90, 35);


        // 布局  JFrame 默认 边框布局  空布局  // 面板 容器 默认流式
        panel1.setBounds(0, 0, 700, 150);
        panel2.setBounds(0,150, 700, 350);

        panel2.add(accountField);
        panel2.add(passwardField);
        panel2.add(accountJla);
        panel2.add(passwardJla);
        panel2.add(imgJlabel);
        panel2.add(btn);
        panel2.add(btn1);

        jf.add(panel1);
        jf.add(panel2);
        jf.setVisible(true);

        LogInFrameListener fl = new LogInFrameListener();
        fl.logInFrame = this;
        btn.addActionListener(fl);
        btn1.addActionListener(fl);

        fl.accountStr = accountField;
        fl.passwardStr = passwardField;
        fl.logInFrame = this;
    }
}
