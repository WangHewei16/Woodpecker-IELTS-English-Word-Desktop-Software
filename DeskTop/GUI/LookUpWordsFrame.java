package GUI;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LookUpWordsFrame extends JFrame{

    LookUpWordsFrameListener luwfl;

    public void initUI(String lookUpResult) {
        this.getContentPane().removeAll();
        JPanel panel = new JPanel(null);
        //2. 窗体属性
        this.setTitle("Look Up Words");
        this.setSize(500,730);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);

        //3. 设置面板
        panel.setBounds(0, 0, 500,730);
        Color backGroundColor = new Color(176, 200, 255);
        panel.setBackground(backGroundColor);
        //创建了一个背景图片的对象

        ImageIcon icon = new ImageIcon(this.getClass().getResource("LookUpWordsPicture.jpg"));
        Image img = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 1);   //放缩
        JLabel lab = new JLabel(new ImageIcon(img));
        lab.setBounds(0, 0, this.getWidth(), this.getHeight());


        //按钮
        JButton btn = new JButton();
        btn.setText("Look Up");
        btn.setBounds(196, 470, 100, 80);

        //输入框
        JTextField wordField = new JTextField();
        wordField.setBounds(150, 420, 190, 35);
        // Dimension dim = new Dimension(190, 35);
        // wordField.setPreferredSize(dim);

        luwfl = new LookUpWordsFrameListener();
        luwfl.word = wordField;
        btn.addActionListener(luwfl);
        luwfl.previewLookUpWordsFrame = this;


        //文字（标签）
        //JLabel lookUpResult = new JLabel(luwfl.result);
        JLabel lookUpResult1 = new JLabel(lookUpResult);
        lookUpResult1.setFont(new Font("黑体",Font.BOLD, 17));
        lookUpResult1.setBounds(135, 580, 365, 100);
        panel.add(lookUpResult1);
        panel.add(btn);
        panel.add(wordField);
        panel.add(lab);

        this.add(panel);
        this.setVisible(true);
    }
}


