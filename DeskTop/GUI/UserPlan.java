package GUI;

import Function.Plan;

import java.awt.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserPlan extends JFrame{

    UserPlanListener upl;
    Scale panel0;
    Scale panel1;
    Scale panel2;
    String target = (Integer.parseInt(Plan.readPlan()[0])+3) + "";

    public UserPlan() throws IOException {
    }

    public void initUI(String plan, String speakPlan, String testPlan) {
	        this.getContentPane().removeAll();
	        JPanel panel = new JPanel(null);

	        //2. 窗体属性
	        this.setTitle("User Plan");
	        this.setSize(500,730);
	        this.setLocationRelativeTo(null);
	        this.setResizable(false);
	        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        this.setLayout(null);

            JLabel label1 = new JLabel("Please input your target mark");
            label1.setBounds(110,2,300,100);
            label1.setFont(new Font("黑体",Font.BOLD, 18));

//            JLabel label5 = new JLabel("Expert");
//
//            label5.setBounds(400,230,300,100);
//            label5.setFont(new Font("黑体",Font.BOLD, 14));
//
//            JLabel label6 = new JLabel("Recommendation");

//            label6.setBounds(370,250,300,100);
//            label6.setFont(new Font("黑体",Font.BOLD, 14));


//             JLabel label2 = new JLabel(number1);
//             label2.setBounds(420,300,300,100);
//             label2.setFont(new Font("黑体",Font.BOLD, 18));
//
//             JLabel label3 = new JLabel(number2);
//             label3.setBounds(420,450,300,100);
//             label3.setFont(new Font("黑体",Font.BOLD, 18));
//
//             JLabel label4 = new JLabel(number3);
//             label4.setBounds(420,600,300,100);
//             label4.setFont(new Font("黑体",Font.BOLD, 18));
             //3. 设置面板
        panel.setBounds(0, 0, 500, 730);
        Color backGroundColor = new Color(176, 200, 255);
        panel.setBackground(backGroundColor);

        Color backGroundColor0 = new Color(176, 200, 255);
        panel0 = new Scale("User Plan:", plan);
        panel0.setBounds(95, 150, 330, 140);
        panel0.setBackground(backGroundColor0);
        panel1 = new Scale("Spell Test:", testPlan);
        panel1.setBounds(95, 280, 330, 140);
        panel1.setBackground(backGroundColor0);
        panel2 = new Scale("Pronounce Test:", speakPlan);
        panel2.setBounds(95, 430, 330, 140);
        panel2.setBackground(backGroundColor0);
        add(panel0);
        add(panel1);
        add(panel2);
        //add(panelALL);
        panel0.setOpaque(true);
        panel1.setOpaque(true);
        panel2.setOpaque(true);
        //panelALL.setOpaque(true);

        //按钮
	        JButton btn = new JButton();
	        btn.setText("Preserve");
	        btn.setBounds(166, 580, 160, 70);

	        //输入框
	        JTextField wordField = new JTextField();
	        wordField.setText(target);
	        wordField.setBounds(150, 90, 190, 35);
            wordField.setHorizontalAlignment((JTextField.CENTER));


        upl = new UserPlanListener();
        upl.word = wordField;
        btn.addActionListener(upl);
        upl.previewuserplanFrame = this;


	        panel.add(btn);
	        panel.add(wordField);
            panel.add(label1);
//            panel.add(label2);
//            panel.add(label3);
//            panel.add(label4);
//            panel.add(label5);
//            panel.add(label6);
	        this.add(panel);
	        this.setVisible(true);
	    }


}




