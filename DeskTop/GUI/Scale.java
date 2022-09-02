package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Scale extends JPanel
{
    public JSlider jSlider1;
    public JTextField textField1;
    public JLabel label1;

    public Scale(String input, String def)
    {
        //super( "水平" );
        setBounds(400,250, 350, 200 );

        setLayout(null);
        textField1 = new JTextField( 10 );
        textField1.setBounds(135,15,120,20);
        textField1.setHorizontalAlignment((JTextField.CENTER));
        textField1.setText(def);

        jSlider1=new JSlider();
        jSlider1.setBounds(15,50,300,50);
        //设置是否在JSlider加上刻度
        jSlider1.setPaintTicks(true);
        //设置大刻度之间的距离
        jSlider1.setMajorTickSpacing(10);
        //设置与小刻度之间的距离
        jSlider1.setMinorTickSpacing(2);
        //设置是否数字标记，若设为true，则JSlider刻度上就会有数值出现
        Color backGroundColor0 = new Color(206, 221, 255);
        jSlider1.setBackground(backGroundColor0);
        jSlider1.setPaintLabels(true);
        jSlider1.setValue(Integer.parseInt(def));
        jSlider1.setFocusable(false);
        add(jSlider1);

        jSlider1.addChangeListener
                (
                        new ChangeListener()
                        {
                            public void stateChanged(ChangeEvent e)
                            {
                                textField1.setText(Integer.toString(jSlider1.getValue()));
                            }
                        }
                );


        add( textField1 );
        textField1.addActionListener
                (
                        new ActionListener()
                        {
                            public void actionPerformed(ActionEvent event)
                            {
                                int num = 0;
                                try{
                                    num = Integer.parseInt(textField1.getText());
                                    jSlider1.setValue(num);
                                }
                                catch(NumberFormatException yb)
                                {
                                    textField1.setText("输入错误");
                                }
                            }
                        }
                );

        label1 = new JLabel(input);
        label1.setBounds(0,15,150,20);
        label1.setFont( new Font( "黑体", Font.PLAIN, 18 ) );
        add( label1 );
        setVisible( true );
    }
}
