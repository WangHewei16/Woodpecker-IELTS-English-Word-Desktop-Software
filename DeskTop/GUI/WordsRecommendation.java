package GUI;

import Function.Plan;
import Function.Record;
import Function.WordsLearned;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class WordsRecommendation {
    protected int i;
    protected int index;
    int length = 0;
    private String str1;
    String word;
    ArrayList<String> totalWords;
    protected ArrayList<String> words;
    int start;
    int number = Integer.parseInt(Plan.readPlan()[1]);

    public WordsRecommendation(int i) throws IOException {
        this.i = i;
        try {
            //Set encoding format
            FileInputStream fis = new FileInputStream("WordRecommendation_" + i + ".txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            totalWords = new ArrayList<>();
            words = new ArrayList<>();
            while((str1=br.readLine())!=null){
                totalWords.add(str1);
            }
            start = Integer.parseInt(Plan.readPlan()[2]);
            for (int j = start; j < (Math.min(start + number, 800)); j++  ){
                words.add(totalWords.get(j));
                length += 1;
            }
            index = Integer.parseInt(Plan.readPlan()[3]);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public String NextWord(){
        index += 1;
        word = words.get(index);
        return word;
    }

    public String LastWord(){
        index -= 1;
        word = words.get(index);
        return word;
    }
}
