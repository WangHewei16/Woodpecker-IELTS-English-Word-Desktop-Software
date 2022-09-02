package GUI;

import Function.Plan;
import Function.Translate;
import org.json.JSONException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class WordsPushFrame extends JFrame {
    LevelChosenFrame lcf;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton explainButton;
    protected static ArrayList<String> words;
    WordsRecommendation wordsRecommendation;
    JPanel jlp ;
    ImageIcon icon;
    Image img;
    JLabel jlabel;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel labelP;
    JLabel labelO;
    WordsPushFrameListener wordsPushFrameListener = new WordsPushFrameListener();
    LearningTime learningTime = new LearningTime();
    Timer timer = new Timer(1000, learningTime);
    JProgressBar progressBar = new JProgressBar();
    int planNumber = Integer.parseInt(Plan.readPlan()[1]);
    int learnedWords = Integer.parseInt(Plan.readPlan()[4]);
    PinkCircleIcon IconP2 = new PinkCircleIcon();
    OrangeCircleIcon IconO2 = new OrangeCircleIcon();

    public WordsPushFrame(int level) throws IOException, JSONException {
        this.setTitle("Recite Words");
        this.setSize(500,730);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jlp = new JPanel(null);
        icon = new ImageIcon(this.getClass().getResource("ReciteWordsPicture.jpg"));
        img = icon.getImage().getScaledInstance(this.getWidth(), this.getHeight(), 1);
        jlabel = new JLabel(new ImageIcon(img));
        button1 = new JButton("Next");
        button1.setBounds(350, 470, 100, 80);
        button1.addActionListener(wordsPushFrameListener);
        button2 = new JButton("Back");
        button2.setBounds(50, 470, 100, 80);
        button2.addActionListener(wordsPushFrameListener);
        button3 = new JButton("Speak");
        button3.setBounds(200, 470, 100, 80);
        button3.addActionListener(wordsPushFrameListener);
        explainButton = new JButton("Explains");
        explainButton.setBounds(350, 50, 85, 30);
        explainButton.addActionListener(wordsPushFrameListener);
        wordsPushFrameListener.wordsPushFrame = this;
        wordsRecommendation = new WordsRecommendation(level);

        //Í¼Æ¬
        jlabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.addWindowListener(new CloseListener(this));
        this.goNext();
        progressBar.setValue(wordsRecommendation.index*100/(wordsRecommendation.words.size()-1));
    }

    public void goNext() throws IOException, JSONException {
        this.remove(jlp);
        learningTime.time = 0;
        timer.start();
        jlp = new JPanel(null);
        jlp.setBackground(new Color(176, 200, 255));
        String word = wordsRecommendation.NextWord();
        label2 = new JLabel(word);
        label2.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label2.setBounds(37, 50, 365, 100);
        label2.setForeground(Color.BLACK);
        label3 = new JLabel("<html>" + Translate.doTranslateEnglishToChinese(word) + "</html");
        label3.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label3.setBounds(37, 100, 450, 200);
        label3.setForeground(Color.BLACK);
        label4 = new JLabel("US: " + Translate.getAmericanStyle(word));
        label4.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label4.setBounds(37, 200, 500, 200);
        label4.setForeground(Color.BLACK);
        label5 = new JLabel("UK: " + Translate.getUKStyle(word));
        label5.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label5.setBounds(37, 300, 500, 200);
        label5.setForeground(Color.BLACK);
        button2.setBounds(50, 470, 100, 80);
        label6 = new JLabel("Checked: " + (wordsRecommendation.index+1));
        label6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        label6.setBounds(125, 625, 100, 20);
        label7 = new JLabel("Left: " + (planNumber-(wordsRecommendation.index+1)));
        label7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        label7.setBounds(365, 625, 100, 20);
        labelP = new JLabel();
        labelP.setIcon(IconP2);
        labelP.setBounds(105, 625, 20, 20);
        labelO = new JLabel();
        labelO.setIcon(IconO2);
        labelO.setBounds(345, 625, 20, 20);

        jlp.add(label2);
        jlp.add(label3);
        jlp.add(label4);
        jlp.add(label5);
        jlp.add(button1);
        jlp.add(button2);
        jlp.add(button3);
        jlp.add(explainButton);
        jlp.add(progressBar);
        //jlp.add(jlabel);
        jlp.add(labelP);
        jlp.add(label6);
        jlp.add(label7);
        jlp.add(labelO);

        Color foreground = new Color(215, 15, 124);
        Color background = new Color(248, 234, 41);
        progressBar.setBackground(background);
        progressBar.setForeground(foreground);
        progressBar.setBounds(105, 590, 300, 30);

        learnedWords = Math.min(planNumber, Math.max(wordsRecommendation.index+1, learnedWords));

        this.add(jlp);
        this.setVisible(true);
    }

    public void goBack() throws IOException, JSONException {
        this.remove(jlp);
        learningTime.time = 0;
        timer.start();
        jlp = new JPanel(null);
        jlp.setBackground(new Color(176, 200, 255));
        String word = wordsRecommendation.LastWord();
        label2 = new JLabel(word);
        label2.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label2.setBounds(37, 50, 365, 100);
        label2.setForeground(Color.BLACK);
        label3 = new JLabel("<html>" + Translate.doTranslateEnglishToChinese(word) + "</html");
        label3.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label3.setBounds(37, 100, 450, 200);
        label3.setForeground(Color.BLACK);
        label4 = new JLabel("US: " + Translate.getAmericanStyle(word));
        label4.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label4.setBounds(37, 200, 500, 200);
        label4.setForeground(Color.BLACK);
        label5 = new JLabel("UK: " + Translate.getUKStyle(word));
        label5.setFont(new Font("ºÚÌå",Font.BOLD, 22));
        label5.setBounds(37, 300, 500, 200);
        label5.setForeground(Color.BLACK);
        button2.setBounds(50, 470, 100, 80);
        label6 = new JLabel("Checked: " + (wordsRecommendation.index+1));
        label6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        label6.setBounds(125, 625, 100, 20);
        label7 = new JLabel("Left: " + (planNumber-(wordsRecommendation.index+1)));
        label7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
        label7.setBounds(365, 625, 100, 20);
        labelP = new JLabel();
        labelP.setIcon(IconP2);
        labelP.setBounds(105, 625, 20, 20);
        labelO = new JLabel();
        labelO.setIcon(IconO2);
        labelO.setBounds(345, 625, 20, 20);

        jlp.add(label2);
        jlp.add(label3);
        jlp.add(label4);
        jlp.add(label5);
        jlp.add(button1);
        jlp.add(button2);
        jlp.add(button3);
        jlp.add(explainButton);
        jlp.add(progressBar);
        jlp.add(labelP);
        jlp.add(label6);
        jlp.add(label7);
        jlp.add(labelO);
        //jlp.add(jlabel);
        Color foreground = new Color(215, 15, 124);
        Color background = new Color(248, 234, 41);
        progressBar.setBackground(background);
        progressBar.setForeground(foreground);
        progressBar.setBounds(105, 590, 300, 30);

        learnedWords = Math.min(planNumber, Math.max(wordsRecommendation.index+1, learnedWords));

        this.add(jlp);
        this.setVisible(true);
    }

    public void end(){
        this.remove(jlp);
        jlp = new JPanel(null);
        JLabel label3 = new JLabel("Congratulate!");
        label3.setFont(new Font("ºÚÌå",Font.BOLD, 32));
        label3.setBounds(130, 150, 365, 100);
        label3.setForeground(Color.MAGENTA);
        JLabel label4 = new JLabel("You have finished learning");
        label4.setFont(new Font("ºÚÌå",Font.BOLD, 18));
        label4.setBounds(120, 300, 365, 100);
        label4.setForeground(Color.CYAN);
        JLabel label5 = new JLabel("all the recommended words, please exit");
        label5.setFont(new Font("ºÚÌå",Font.BOLD, 18));
        label5.setBounds(50, 330, 365, 100);
        label5.setForeground(Color.CYAN);
        button2.setBounds(197, 470, 100, 80);
        jlp.add(button2);
        jlp.add(label3);
        jlp.add(label4);
        jlp.add(label5);
        jlp.add(jlabel);

        this.add(jlp);
        this.setVisible(true);
    }

    public boolean reachEnd(){
        if(wordsRecommendation.index == wordsRecommendation.length - 1){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean reachFirst(){
        if(wordsRecommendation.index <= 0){
            return true;
        }
        else {
            return false;
        }
    }
}