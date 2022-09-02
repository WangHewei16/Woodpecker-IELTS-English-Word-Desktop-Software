package GUI;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.*;

public class SelfTestFrame extends JFrame{

    SelfTestFrameListener stfl;
    JProgressBar progressBar = new JProgressBar();

    public void intiUI(String chinesequest, String correctanwserstr, boolean result, boolean cover) throws IOException, ParseException {
        this.getContentPane().removeAll();
        JPanel panel0 = new JPanel(null);
        //2. 窗体属性

        setTitle("SelfTest");
        setSize(570,700);
        //setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // *创建添加组件前，先设置窗口中的组件布局 -- 定点布局
        this.setLayout(null);

        panel0.setBounds(0, 0, 570, 700);
        Color backGroundColor = new Color(176, 200, 255);
        panel0.setBackground(backGroundColor);

        //3. 组件
        //图片（标签）
        ImageIcon img1 = new ImageIcon(this.getClass().getResource("./SelftestPicture3.jpg"));
        JLabel imgJlabel1=new JLabel(img1);
        CorrectIcon IconC = new CorrectIcon();
        JLabel imgJlabel2 = new JLabel(IconC);
        IncorrectIcon IconI = new IncorrectIcon();
        JLabel imgJlabel3 = new JLabel(IconI);


        //文字（标签）,问题和正确答案已全部换为标签
        JLabel answerJla = new JLabel("Translation to English",JLabel.CENTER);
        answerJla.setFont(new Font("微软雅黑",Font.BOLD, 25));
        JLabel correctJla = new JLabel("The correct answer is: ");
        correctJla.setFont(new Font("微软雅黑",Font.BOLD, 16));
        JLabel correctanswerJla = new JLabel(correctanwserstr);
        correctanswerJla.setFont(new Font("微软雅黑",Font.BOLD, 16));
        JLabel QuestJla = new JLabel(chinesequest,JLabel.CENTER);
        QuestJla.setFont(new Font("微软雅黑", Font.BOLD, 20));

        //输入框
        JTextField answerFieldA = new JTextField();
        answerFieldA.setHorizontalAlignment((JTextField.CENTER));
        //输入框 -- 尺寸
        Dimension dim = new Dimension(380,30);
        answerFieldA.setPreferredSize(dim);

        //按钮
        JButton btn1 = new JButton();
        btn1.setText("Confirm");
        btn1.setBounds(130, 420, 100, 80);
        JButton btn2 = new JButton();
        btn2.setText("Next");
        btn2.setBounds(350, 420, 100, 80);

        //接口相关
        stfl.answer = answerFieldA;
        btn1.addActionListener(stfl);
        btn2.addActionListener(stfl);
        stfl.previewSelfTestFrame = this;

        panel0.add(answerJla);
        panel0.add(correctJla);
        panel0.add(answerFieldA);
        panel0.add(QuestJla);
        panel0.add(correctanswerJla);
        panel0.add(btn1);
        panel0.add(btn2);
        panel0.add(progressBar);
        panel0.add(imgJlabel1);
        panel0.add(imgJlabel2);
        panel0.add(imgJlabel3);

        Color foreground = new Color(215, 15, 124);
        Color background = new Color(248, 234, 41);
        progressBar.setBackground(background);
        progressBar.setForeground(foreground);
        progressBar.setValue(stfl.flag*100/14);
        progressBar.setBounds(140, 537, 300, 30);


        //各部件位置调整
        imgJlabel1.setBounds(0,0,560,260);
        imgJlabel2.setBounds(200,530,250,140);
        imgJlabel3.setBounds(120,530,250,140);
        answerJla.setBounds(110,270,350,50);
        correctJla.setBounds(280,530,200,40);
        QuestJla.setBounds(110,315,350,20);
        answerFieldA.setBounds(110,350,380,30);
        correctanswerJla.setBounds(280,550,180,50);
        btn1.setBounds(130, 420, 100, 80);
        btn2.setBounds(350, 420, 100, 80);


        //用于控制答案回答后才会显示的部分
        if(result == true){
            imgJlabel2.setVisible(true);
        }else {
            imgJlabel2.setVisible(false);
        }

        if(result == false){
            imgJlabel3.setVisible(true);
            correctanswerJla.setVisible(true);
            correctJla.setVisible(true);
        }else {
            imgJlabel3.setVisible(false);
            correctanswerJla.setVisible(false);
            correctJla.setVisible(false);
        }

        //homeframelistener里初始result设置为true，此处设置boolean cover来确保imgJlable2开始是隐形的
        if(cover == true){
            imgJlabel2.setVisible(false);
        }

        this.add(panel0);
        this.setVisible(true);
    }
}
