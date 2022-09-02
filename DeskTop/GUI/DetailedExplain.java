package GUI;

import Function.DictionaryExamples;
import Function.DictionaryLookup;
import org.json.JSONException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class DetailedExplain extends JFrame {
    String word;
    JPanel mainPanel = new JPanel(null);
    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10));
    JTextArea explainArea = new JTextArea();
    //JScrollPane buttonScroll = new JScrollPane();
    JScrollPane wordScroll = new JScrollPane();
    ArrayList<TranslateButton> buttonList = new ArrayList<>();
    DetailExplainListener detailExplainListener = new DetailExplainListener();
    public DetailedExplain(String word) throws IOException, JSONException {
        this.word = word;
        this.setTitle("Detailed Explain to " + word);
        this.setSize(600,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel.setBounds(0, 0, 600, 800);
        mainPanel.setBackground(Color.CYAN);

        ArrayList<ArrayList<String>> translations = DictionaryLookup.getSource(word);
        for (int i = 0; i < translations.size(); i++){
            TranslateButton translateButton = new TranslateButton(translations.get(i));
            translateButton.addActionListener(detailExplainListener);
            buttonList.add(translateButton);
        }

        buttonPanel.setBounds(10, 10, 560, 730);
        buttonPanel.setBackground(Color.CYAN);
        /*buttonScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        buttonScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        buttonScroll.setBounds(10, 10, 570, 750);
        buttonScroll.setViewportView(buttonPanel);
        buttonScroll.setBorder(null);*/
        //mainPanel.add(wordScroll);

        for (int i = 0; i < buttonList.size(); i++){
            TranslateButton button = buttonList.get(i);
            button.setSize(200, 500);
            buttonPanel.add(button);
        }

        detailExplainListener.detailedExplain = this;

        explainArea.setBackground(Color.CYAN);
        explainArea.setBounds(10, 50, 560, 700);
        explainArea.setWrapStyleWord(true);
        explainArea.setEditable(true);
        explainArea.setLineWrap(true);
        explainArea.setEditable(false);
        explainArea.setFont(new Font("微软雅黑", Font.BOLD, 20));

        mainPanel.add(buttonPanel);
        //showExplains(translations.get(0));
        this.add(mainPanel);
    }

    public void showExplains(ArrayList<String> explains) throws IOException, JSONException {
        //mainPanel.remove(wordScroll);
        String[] strings = new String[]{word, explains.get(0)};
        ArrayList<String[]> exampleList = DictionaryExamples.generateExamples(strings);
        JFrame explainFrame = new JFrame();
        explainFrame.setSize(650, 800);
        explainFrame.setLocationRelativeTo(null);

        explainArea.setText("");

        explainArea.append("Translation: " + explains.get(0) + "\n" + "\n");
        explainArea.append("Part of Speech: " + explains.get(1) + "\n" + "\n");
        explainArea.append("Synonym: " + "\n");
        for(int i = 2; i < explains.size(); i++){
            explainArea.append(explains.get(i));
            if(i != explains.size() - 1){
                explainArea.append(", ");
            }
            else {
                explainArea.append("\n" + "\n");
            }
        }
        explainArea.append("Example Sentences: " + "\n");
        for (int i = 0; i < exampleList.size(); i++){
            explainArea.append(i+1 + ". " + exampleList.get(i)[0] + exampleList.get(i)[1] + exampleList.get(i)[2] + "\n" + exampleList.get(i)[3] + exampleList.get(i)[4] + exampleList.get(i)[5] + "\n" + "\n");
        }
        wordScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        wordScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        wordScroll.setViewportView(explainArea);
        wordScroll.setBounds(10, 10, 580, 780);
        wordScroll.setBorder(null);

        explainArea.setCaretPosition(0);
        explainFrame.getContentPane().add(wordScroll);
        explainFrame.setVisible(true);
    }
}
