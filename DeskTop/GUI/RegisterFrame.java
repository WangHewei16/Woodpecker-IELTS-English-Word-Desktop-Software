package GUI;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame {
	// 1. ����һ��������� 
	JFrame jf = new JFrame();
	RegisterFrameListener fl = new RegisterFrameListener();
	public void initUI() {
		//2. ��������
		jf.setTitle("Register");
		jf.setSize(500,700);
		jf.setLocationRelativeTo(null);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// *����������ǰ�������ô����е�������� -- ��ʽ
		FlowLayout f1 = new FlowLayout();
		jf.setLayout(f1);
		
		//3. ���
		
		//ͼƬ����ǩ��
		ImageIcon img = new ImageIcon(this.getClass().getResource("RegisterPicture.png"));
		JLabel imgJlabel = new JLabel(img);
		
		//���֣���ǩ��
		JLabel accountJla = new JLabel("Account:        ");
		JLabel nameJla = new JLabel("Name:            ");
		JLabel genderJla = new JLabel("Gender:         ");
		JLabel emailJla = new JLabel("Email:             ");
		JLabel passwardJla = new JLabel("Password:     ");
		JLabel againpasswardJla = new JLabel("Re-enter:      ");
		
		//�����
		JTextField accountField = new JTextField();
		JTextField nameField = new JTextField();
		JTextField genderField = new JTextField();
		JTextField emailField = new JTextField();
		JPasswordField passwardField = new JPasswordField();
		JPasswordField againpasswardField = new JPasswordField();
		
		//����� -- �ߴ�
		Dimension dim = new Dimension(380,35);
		accountField.setPreferredSize(dim);
		nameField.setPreferredSize(dim);
		genderField.setPreferredSize(dim);
		emailField.setPreferredSize(dim);
		passwardField.setPreferredSize(dim);
		againpasswardField.setPreferredSize(dim);
		
		
		//��ť
		JButton btn = new JButton();
		btn.setText("Confirm");
		JButton btn1 = new JButton();
		btn1.setText("Cancel");
		
		// ����  JFrame Ĭ�� �߿򲼾�  ��ʽ����   �ղ���  // ��� ���� Ĭ����ʽ
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
