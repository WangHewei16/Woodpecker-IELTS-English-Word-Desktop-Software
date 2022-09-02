package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SyllableFrame extends JFrame {
    JPanel mainPanel = new JPanel(null);
    JTextArea explainArea = new JTextArea();
    JScrollPane wordScroll = new JScrollPane();

    public SyllableFrame(ArrayList<ArrayList<ArrayList<String>>> information){
        this.setTitle("Score Explanation");
        this.setSize(650,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel.setBounds(0, 0, 650, 800);
        mainPanel.setBackground(Color.CYAN);

        explainArea.setBackground(Color.CYAN);
        explainArea.setBounds(10, 10, 620, 750);
        explainArea.setWrapStyleWord(true);
        explainArea.setEditable(true);
        explainArea.setLineWrap(true);
        explainArea.setEditable(false);
        explainArea.setFont(new Font("微软雅黑", Font.BOLD, 20));

        explainArea.append("Syllable:\n\n");
        for(int i = 0; i < information.size(); i++) {
            ArrayList<String> syllable = information.get(i).get(0);
            explainArea.append((i+1) + ". " + syllable.get(0) + ":\n");
            explainArea.append("Score: " + syllable.get(1) + "\n");
            explainArea.append("Start Time: " + syllable.get(2) + "\n");
            explainArea.append("End Time: " + syllable.get(3) + "\n");
            if (syllable.get(4).equals("1")){
                explainArea.append("This syllable needs to be stressed, ");
                if (syllable.get(5).equals("2048") || syllable.get(5).equals("2049")){
                    explainArea.append("but you didn't stress it.\n");
                }
                else {
                    explainArea.append("and you did stress it.\n");
                }
            }
            else {
                explainArea.append("This syllable does not need to be stressed, ");
                if (syllable.get(5).equals("1")){
                    explainArea.append("but your pronunciation is substandard.\n");
                }
                else {
                    explainArea.append("and your pronunciation is pretty standard.\n");
                }
            }
            System.out.println("\n");
            explainArea.append("Phone:\n");
            for (int j = 1; j < information.get(i).size(); j++){
                explainArea.append("   " + ((char) (96 + j)) + ". " + information.get(i).get(j).get(0) + "\n");
                explainArea.append("     " + "Start Time: " + information.get(i).get(j).get(1) + "\n");
                explainArea.append("     " + "End Time: " + information.get(i).get(j).get(2) + "\n");
                if (information.get(i).get(j).get(3).equals("0")){
                    explainArea.append("     " + "You have read this phone correctly" + "\n");
                }
                else if (information.get(i).get(j).get(3).equals("16")){
                    explainArea.append("     " + "You have miss read this phone" + "\n");
                }
                else if (information.get(i).get(j).get(3).equals("32")){
                    explainArea.append("     " + "You have incremental read this phone" + "\n");
                }
                explainArea.append("\n");
            }
            explainArea.append("\n");
        }
        wordScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        wordScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        wordScroll.setViewportView(explainArea);
        wordScroll.setBounds(10, 10, 620, 750);
        wordScroll.setBorder(null);

        explainArea.setCaretPosition(0);

        mainPanel.add(wordScroll);
        this.add(mainPanel);
        this.setVisible(true);
    }
}
