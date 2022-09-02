package Function;

import java.io.*;
import java.util.ArrayList;

public class Plan {


    public static String[] readPlan() throws IOException {
        String[] userPlan = new String[7];
        String nextline;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("UserPlan.txt"));
        for (int i = 0; i < 7; i++){
            userPlan[i] = bufferedReader.readLine();
        }
        return userPlan;
    }

    public static void changeLevel(String level) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[0] = level;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeStart(int number) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[2] = number+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeIndex(int index) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[3] = index+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeMaxIndex(int index) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[4] = index+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeSpeakTest(int number) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[6] = number+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeTest(int number) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[5] = number+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void changeDailyPlan(int number) throws IOException {
        String[] userPlan  = readPlan();
        userPlan[1] = number+"";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("UserPlan.txt"));
        for(String w : userPlan){
            bufferedWriter.write(w);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}