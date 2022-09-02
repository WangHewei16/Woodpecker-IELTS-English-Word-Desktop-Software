package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterFrameListener implements ActionListener {
    public JFrame registerFrame;
    public JTextField accountStr;
    public JPasswordField passwardStr;
    public JTextField nameStr;
    public JTextField genderStr;
    public JTextField emailStr;
    public JPasswordField againPasswardStr;
    public LogInFrame logInFrame;

    public String md5Encode(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(text.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & 0xFF);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnstr = e.getActionCommand();
        if(btnstr.equals("Confirm")){
            try {
                if(passwardStr.getText().equals(againPasswardStr.getText())) {
                    this.logInFrame.jf.setVisible(true);
                    registerFrame.setVisible(false);
                    BufferedWriter bw= new BufferedWriter(new FileWriter("./userInformation.txt", true));
                    BufferedReader br= new BufferedReader(new FileReader("./userInformation.txt"));
                    String line = accountStr.getText()+", "+nameStr.getText()+", "+genderStr.getText()+", "+emailStr.getText()+", "+md5Encode(passwardStr.getText())+", "+md5Encode(againPasswardStr.getText());
                    bw.write(line);
                    bw.newLine();
                    bw.flush();
                    bw.close();
                    br.close();
                }else {
                    JOptionPane.showMessageDialog (null, "The two passwords do not match!") ;
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }


        }else if(btnstr.equals("Cancel")) {
            this.logInFrame.jf.setVisible(true);
            registerFrame.setVisible(false);
        }
    }
}
