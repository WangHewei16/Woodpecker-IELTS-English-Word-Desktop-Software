package Function;

import java.io.*;
import java.util.ArrayList;

public class WordsLearned {

    public static ArrayList<String> learnedWords() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        String nextline;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("LearningTime.txt"));
        while ((nextline = bufferedReader.readLine()) != null){
            words.add(nextline.split(" ")[0]);
        }
        return words;
    }
    public static void clear() throws IOException {
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("LearningTime.txt"));
        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("Datetime.txt"));
        BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter("userDate.txt"));
    }
}
