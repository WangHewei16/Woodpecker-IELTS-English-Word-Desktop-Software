package GUI;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame {
	// 1. 创建一个窗体对象 
	JFrame jf = new JFrame();
	RegisterFrameListener fl = new RegisterFrameListener();
	public void initUI() {
		//2. 窗体属性
		jf.setTitle("Register");
		jf.setSize(500,700);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// *创建添加组件前，先设置窗口中的组件布局 -- 流式
		FlowLayout f1 = new FlowLayout();
		jf.setLayout(f1);
		
		//3. 组件
		
		//图片（标签）
		ImageIcon img = new ImageIcon(this.getClass().getResource("RegisterPicture.png"));
		JLabel imgJlabel = new JLabel(img);
		
		//文字（标签）
		JLabel accountJla = new JLabel("Account:        ");
		JLabel nameJla = new JLabel("Name:            ");
		JLabel genderJla = new JLabel("Gender:         ");
		JLabel emailJla = new JLabel("Email:             ");
		JLabel passwardJla = new JLabel("Password:     ");
		JLabel againpasswardJla = new JLabel("Re-enter:      ");
		
		//输入框
		JTextField accountField = new JTextField();
		JTextField nameField = new JTextField();
		JTextField genderField = new JTextField();
		JTextField emailField = new JTextField();
		JPasswordField passwardField = new JPasswordField();
		JPasswordField againpasswardField = new JPasswordField();
		
		//输入框 -- 尺寸
		Dimension dim = new Dimension(380,35);
		accountField.setPreferredSize(dim);
		nameField.setPreferredSize(dim);
		genderField.setPreferredSize(dim);
		emailField.setPreferredSize(dim);
		passwardField.setPreferredSize(dim);
		againpasswardField.setPreferredSize(dim);
		
		
		//按钮
		JButton btn = new JButton();
		btn.setText("Confirm");
		JButton btn1 = new JButton();
		btn1.setText("Cancel");
		
		// 布局  JFrame 默认 边框布局  流式布局   空布局  // 面板 容器 默认流式
		JPanel panel = new JPanel();
		Color backGroundColor = new Color(176, 200, 255);
		panel.setBackground(backGroundColor);
		Dimension dim2 = new Dimension(500,800);
		panel.setPreferredSize(dim2);
		panel.add(imgJlabel);
		panel.add(accountJla);
		panel.add(accountField);
		panel.add(nameJla);
		panel.add(nameField);
		panel.add(genderJla);
		panel.add(genderField);
		panel.add(emailJla);
		panel.add(emailField);
		panel.add(passwardJla);
		panel.add(passwardField);
		panel.add(againpasswardJla);
		panel.add(againpasswardField);
		panel.add(btn);
		panel.add(btn1);

        jf.add(panel);
        jf.setVisible(true);

        btn.addActionListener(fl);
        btn1.addActionListener(fl);
        fl.accountStr = accountField;
        fl.passwardStr = passwardField;
        fl.againPasswardStr = againpasswardField;
        fl.emailStr = emailField;
        fl.nameStr = nameField;
        fl.genderStr = genderField;
        fl.registerFrame = jf;
    }
}
