package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogInFrameListener implements ActionListener{

    public LogInFrame logInFrame;  //第一层窗口  --  为了实现第一层窗口隐藏
    public JTextField accountStr;
    public JPasswordField passwardStr;

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

    public void actionPerformed(ActionEvent e) {
        String btnstr = e.getActionCommand();
        if(btnstr.equals("Register")) {
            logInFrame.jf.setVisible(false);
            RegisterFrame rf = new RegisterFrame();//第二层窗口
            rf.fl.logInFrame = this.logInFrame;
            rf.initUI();

        }else if(btnstr.equals("Log In")) {
            //读取userInformation一行一行比
            //File f = new File("a.txt");
            //System.out.println(f.getAbsolutePath());
            try(BufferedReader br = new BufferedReader(new FileReader("./userInformation.txt"))){
                String line = br.readLine();
                boolean pass = false;
                while(line != null) {
                    String[] linePieces = line.split(", ");
                    String accountStr1 = linePieces[0];
                    String passwardStr1 = linePieces[5];
                    //System.out.println(accountStr1);
                    //System.out.println(passwardStr1);
                    if(accountStr.getText().equals(accountStr1) && md5Encode(passwardStr.getText()).equals(passwardStr1)) {
                        logInFrame.jf.setVisible(false);
                        logInFrame.accountField.setText("");
                        logInFrame.passwardField.setText("");
                        HomeFrame hf = new HomeFrame();//第二层窗口
                        hf.fl.logInFrame = this.logInFrame.jf;
                        hf.initUI();
                        pass = true;
                        break;
                    }
                    line = br.readLine();
                }


                if(!pass){
                    JOptionPane.showMessageDialog (null, "Login failed with incorrect account or password") ;
                }
            }
            catch (IOException e1) {
                e1.printStackTrace();
            } catch (NoSuchAlgorithmException e1) {
                e1.printStackTrace();
            }
        }
    }
}
