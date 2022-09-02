package Function;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Record {
    public static HashMap<String, Integer> recording = new HashMap<>();
    public static HashMap<String, String> dateToWords = new HashMap<>();
    public static void recordWord(String word, int time) throws IOException {
        recording.clear();
        String nextline;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("LearningTime.txt"));
        while ((nextline = bufferedReader.readLine()) != null){
            recording.put(nextline.split(" ")[0], Integer.parseInt(nextline.split(" ")[1]));
        }
        if(recording.containsKey(word)) {
            recording.replace(word, recording.get(word)+time);
        }
        else {
            recording.put(word, time);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("LearningTime.txt"));
        for(String w : recording.keySet()){
            bufferedWriter.write(w + " " + recording.get(w));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static void recordDatetime(String word) throws IOException {
        dateToWords.clear();
        String nextline;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String datetime = sdf.format(date);
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Datetime.txt"));
        while ((nextline = bufferedReader.readLine()) != null){
            dateToWords.put(nextline.split("//")[0], nextline.split("//")[1]);
        }
        if(dateToWords.containsValue(word)) {
            dateToWords.replace(word, datetime);
        }
        else {
            dateToWords.put(word, datetime);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Datetime.txt"));
        for(String w : dateToWords.keySet()){
            bufferedWriter.write(w + "//" + dateToWords.get(w));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static void recordWrongWord(String word) throws IOException {
        HashMap<String, Integer> words = new HashMap<>();
        String nextline;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("WrongWords.txt"));
        while ((nextline = bufferedReader.readLine()) != null){
            words.put(nextline.split(" ")[0], Integer.parseInt(nextline.split(" ")[1]));
        }
        if(words.containsKey(word)){
            words.replace(word, words.get(word) + 1);
        }
        else {
            words.put(word, 1);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("WrongWords.txt"));
        for(String w : words.keySet()){
            bufferedWriter.write(w + " " + words.get(w));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
    public static ArrayList<String> getUserDate() throws IOException {
        ArrayList<String> userDate = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("UserDate.txt"));
        String nextline;
        while ((nextline = bufferedReader.readLine()) != null){
            userDate.add(nextline);
        }
        return userDate;
    }

    public static void recordUserDate(String date) throws IOException {
        ArrayList<String> userDate = getUserDate();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserDate.txt"));
        userDate.add(date);
        for(String w : userDate){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
