package GUI;

import javax.swing.*;
import java.awt.*;

public class ChooseNumberFrame extends JFrame {
    public static void main(String[] args){
        ChooseNumberFrame chooseNumberFrame = new ChooseNumberFrame();
        chooseNumberFrame.intiUI();
        chooseNumberFrame.setLocationRelativeTo(null);
        chooseNumberFrame.setVisible(true);
    }
    public void intiUI() {
        //2. 窗体属性
        setTitle("ChooseNumberFrame");
        setSize(570, 700);
        //setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // *创建添加组件前，先设置窗口中的组件布局 -- 定点布局
        setLayout(null);
        JLayeredPane panel0 = new JLayeredPane();
        //panel0.setBounds(0, 0, 570, 700);
        Color backGroundColor0 = new Color(176, 200, 255);
        getRootPane().setBackground(backGroundColor0);

        //文字（标签）,问题和正确答案已全部换为标签
        JLabel answerJla = new JLabel("Number of words you want to recite", JLabel.CENTER);
        answerJla.setFont(new Font("微软雅黑", Font.BOLD, 18));

        //按钮
        JButton btn1 = new JButton();
        btn1.setText("20");
        btn1.setBounds(200, 250, 50, 30);
        JButton btn2 = new JButton();
        btn2.setText("30");
        btn2.setBounds(200, 300, 50, 30);
        JButton btn3 = new JButton();
        btn3.setText("40");
        btn3.setBounds(200, 350, 50, 30);
        JButton btn4 = new JButton();
        btn4.setText("50");
        btn4.setBounds(200, 400, 50, 30);
        JButton btn5 = new JButton();
        btn5.setText("60");
        btn5.setBounds(200, 450, 50, 30);

        panel0.add(answerJla, JLayeredPane.DRAG_LAYER);
        panel0.add(btn1, JLayeredPane.DRAG_LAYER);
        panel0.add(btn2, JLayeredPane.DRAG_LAYER);
        panel0.add(btn3, JLayeredPane.DRAG_LAYER);
        panel0.add(btn4, JLayeredPane.DRAG_LAYER);
        panel0.add(btn5, JLayeredPane.DRAG_LAYER);

        //各部件位置调整
        answerJla.setBounds(110, 100, 350, 50);
        btn1.setBounds(250, 230, 50, 30);
        btn2.setBounds(250, 280, 50, 30);
        btn3.setBounds(250, 330, 50, 30);
        btn4.setBounds(250, 380, 50, 30);
        btn5.setBounds(250, 430, 50, 30);
        add(panel0);
        setLayeredPane(panel0);
        panel0.setOpaque(true);
        setVisible(true);

       // setVisible(true);
    }
}
