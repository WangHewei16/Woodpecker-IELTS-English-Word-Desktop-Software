package Function;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestWordRecommend {
    public static ArrayList<String> recommend() throws IOException, ParseException {
        int[] flags = new int[]{0, 20, 60, 480, 720, 1440, 4320};
        double[] percentage = new double[]{1, 0.58, 0.44, 0.36, 0.34, 0.28, 0.25};
        HashMap<String, Integer> recording = new HashMap<>();
        HashMap<String, String> dateToWords = new HashMap<>();
        HashMap<String, Double> wordScore = new HashMap<>();
        String nextline;

        // 根据单词学习时长计算分数
        BufferedReader bufferedReader = new BufferedReader(new FileReader("LearningTime.txt"));
        while ((nextline = bufferedReader.readLine()) != null){
            recording.put(nextline.split(" ")[0], Integer.parseInt(nextline.split(" ")[1]));
        }
        for (String word: recording.keySet()){
            if(recording.get(word) > 300){
                wordScore.put(word, (double) 0);
            }
            else {
                wordScore.put(word, (double) (30 - recording.get(word)/10));
            }
        }

        //根据上次学习日期计算分数
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        long nowTime = calendar.getTime().getTime();
        BufferedReader reader = new BufferedReader(new FileReader("Datetime.txt"));
        while ((nextline = reader.readLine()) != null){
            dateToWords.put(nextline.split("//")[0], nextline.split("//")[1]);
        }
        for (String word: dateToWords.keySet()){
            long lastTime = sdf.parse(dateToWords.get(word)).getTime();
            long time = (nowTime - lastTime) / (1000*60);
            for(int i = 0; i < 7; i++){
                if (i == 6){
                    if (wordScore.containsKey(word)){
                        wordScore.replace(word, wordScore.get(word) + 30*percentage[i]);
                    }
                    else {
                        wordScore.put(word, 30*percentage[i]);
                    }
                }
                else if (time >= flags[i] && time < flags[i+1]){
                    if (wordScore.containsKey(word)){
                        wordScore.replace(word, wordScore.get(word) + 30*percentage[i]);
                    }
                    else {
                        wordScore.put(word, 30*percentage[i]);
                    }
                    break;
                }
            }
        }


        //根据错题计算分数
        for (String word : wordScore.keySet()){
            wordScore.replace(word, wordScore.get(word) + 30);
        }
        HashMap<String, Integer> words = new HashMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader("WrongWords.txt"));
        while ((nextline = fileReader.readLine()) != null){
            words.put(nextline.split(" ")[0], Integer.parseInt(nextline.split(" ")[1]));
        }
        for(String word : words.keySet()){
            if(words.get(word) >= 3){
                wordScore.replace(word, wordScore.get(word) - 30);
            }
            else {
                wordScore.replace(word, wordScore.get(word) - 10*words.get(word));
            }
        }


        Map<String, Double> result = new LinkedHashMap<>();
        wordScore.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        ArrayList<String> testWords = new ArrayList<>(result.keySet());
        System.out.println(result);
        return testWords;
    }
}
