package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game1{
    JFrame jf;
    ImageIcon icon;
    Image img;
    JLabel picture;
    JTextField field;
    JLayeredPane jlp;
    JButton button1;
    JButton button2;
    JButton button3;
    WordsRecommendation words_import;
    Game1_Listener listener = new Game1_Listener();
    static boolean check;
    static ArrayList<String> list1;

    public static void main(String[] args) throws IOException {
        new Game1();

    }

    public Game1() throws IOException {
        //Window
        jf = new JFrame("Game1: Find words");
        jf.setSize(1000,800);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        FlowLayout f1 = new FlowLayout();
        jf.setLayout(f1);

        //Picture
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("LookUpWordsPicture.jpg")));
        img = icon.getImage().getScaledInstance(jf.getWidth(), jf.getHeight(), 1);
        picture = new JLabel(new ImageIcon(img));
        picture.setBounds(0, 0, jf.getWidth(), jf.getHeight());

        //Label
        JLabel label1 = new JLabel("The order of each letter in these words has been disrupted.");
        JLabel label2 = new JLabel("Please input the correct word into the text box.");
        JLabel label3 = new JLabel("Note: Each word should be separated by ';'");
        label1.setFont(new Font("Arial",Font.BOLD, 24));
        label1.setBounds(180, 50, 685, 50);
        label1.setForeground(Color.BLUE);
        label1.setOpaque(true);
        label1.setBackground(Color.PINK);
        label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label2.setBounds(181,95,683,50);
        label2.setFont(new Font("Arial",Font.BOLD, 24));
        label2.setForeground(Color.BLUE);
        label2.setOpaque(true);
        label2.setBackground(Color.PINK);
        label3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label3.setBounds(180,145,685,50);
        label3.setFont(new Font("Arial",Font.BOLD, 24));
        label3.setForeground(Color.BLUE);
        label3.setOpaque(true);
        label3.setBackground(Color.PINK);
        label3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //Button
        button1 = new JButton("Start Game!");
        button1.setFont(new Font("Constrain",Font.PLAIN, 30));
        button1.setBounds(360,450,250,100);
        button1.addActionListener(listener);

        //get words
        words_import = new WordsRecommendation(1);

        //Add components to the jframe
        jlp = new JLayeredPane();
        jlp.add(picture,JLayeredPane.DEFAULT_LAYER);
        jlp.add(label1,JLayeredPane.DRAG_LAYER);
        jlp.add(label2,JLayeredPane.DRAG_LAYER);
        jlp.add(label3,JLayeredPane.DRAG_LAYER);
        jlp.add(button1,JLayeredPane.DRAG_LAYER);
        jf.setLayeredPane(jlp);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        //Listener
        Game1_Listener.game1 = this;
    }

    public void goNext(){
        check = false;
        jf.remove(jlp);
        jlp = new JLayeredPane();

        //Get random words and add them into a array list; record their length and each letter
        Random ran = new Random();
        list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        int r = ran.nextInt(3)+2;
        for(int i = 0; i <= r; i++){
            String str = words_import.NextWord();
            list1.add(str);
            char[] ch = str.toCharArray();
            for(char c : ch){
                list2.add(String.valueOf(c));
            }
            list3.add(str.length());
        }
        System.out.println(list3);

        //Check
        button2 = new JButton("Check");
        button2.setFont(new Font("Constrain",Font.PLAIN, 24));
        button2.setBounds(315,500,180,80);
        button2.addActionListener(listener);
        button3 = new JButton("Next");
        button3.setFont(new Font("Constrain",Font.PLAIN, 24));
        button3.setBounds(515,500,180,80);
        button3.addActionListener(listener);

        //Text field
        field = new JTextField();
        field.setBounds(250,400,500,50);
        field.addActionListener(listener);

        //Label
        JLabel label1 = new JLabel("<html>"+list2);
        label1.setFont(new Font("Arial",Font.PLAIN, 20));
        label1.setBounds(250, 50, 450, 120);
        label1.setForeground(Color.GREEN);
        label1.setOpaque(true);
        label1.setBackground(Color.darkGray);


        //Add components to the jframe
        jlp.add(picture,JLayeredPane.DEFAULT_LAYER);
        jlp.add(label1,JLayeredPane.DRAG_LAYER);
        jlp.add(field,JLayeredPane.DRAG_LAYER);
        jlp.add(button2,JLayeredPane.DRAG_LAYER);
        jlp.add(button3,JLayeredPane.DRAG_LAYER);
        jf.setLayeredPane(jlp);
        jf.setVisible(true);

        //Listener
        Game1_Listener.text = field;
        Game1_Listener.game1 = this;

    }

    public void End(){
        jf.remove(jlp);
        jlp = new JLayeredPane();
        JLabel label4 = new JLabel("<html>Congratulate! You have finished this game, please exit.");
        label4.setFont(new Font("Times New Roman",Font.PLAIN, 32));
        label4.setBounds(250, 50, 450, 120);
        label4.setForeground(Color.GREEN);
        label4.setOpaque(true);
        label4.setBackground(Color.darkGray);

        jlp.add(label4, JLayeredPane.DEFAULT_LAYER);
        jlp.add(picture, JLayeredPane.DEFAULT_LAYER);
        jf.setLayeredPane(jlp);
        jf.setVisible(true);
    }

    public boolean reachEnd(){
        return words_import.index == words_import.length - 1;
    }

}

