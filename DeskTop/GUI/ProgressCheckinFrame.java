package GUI;

import Function.Plan;
import Function.Record;
import Function.WordsLearned;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class ProgressCheckinFrame extends JFrame {
    // 1. 创建一个窗体对象
    int ClockInDay;
    JPanel panel0 = new JPanel(null);
    int wordsLearned = WordsLearned.learnedWords().size();
    String[] userPlan = Plan.readPlan();
    int wordsToday = Integer.parseInt(userPlan[4]);
    int wordsPlan = Integer.parseInt(userPlan[1]);
    int level = Integer.parseInt(userPlan[0]);
    JButton button = new JButton("Change the Plan");
    ProgressListener progressListener = new ProgressListener();

    public ProgressCheckinFrame() throws IOException {
        progressListener.progressCheckinFrame = this;
    }

    //    进度条2相关参数
    public void initUI() throws IOException {

        //2. 窗体属性
        setTitle("ProgressChecking");
        setSize(570, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //3. 布局：定点布局
        this.setLayout(null);

        //4. 设置总面板和背景
        //4. 设置面板
        panel0.setBounds(0, 0, 570, 700);
        Color backGroundColor = new Color(176, 200, 255);
        panel0.setBackground(backGroundColor);
        try {
            ClockInDay = 0;
            BufferedReader br = new BufferedReader(new FileReader("userDate.txt"));
            String line = br.readLine();
            //boolean pass = true;
            while (line != null) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH)+1;
                String year1 = Integer.toString(year);
                String month1 = Integer.toString(month);
                String[] dataArray = line.split("-");
                if(dataArray[0].equals(year1) && dataArray[1].equals(month1)){
                    ClockInDay ++;
                }
                line = br.readLine();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //5. 设置标题和确认完毕后返回的confirm按钮

        //JLabel label0 = new JLabel("Progress Checking",JLabel.CENTER);

        JLabel label0 = new ThreeDFont();


        //JButton checkInButtom = new JButton("Chick-In");
        //checkInButtom.setEnabled(true);
        label0.setFont(new Font("微软雅黑",Font.BOLD, 28));
        label0.setBounds(208, 1, 3000, 3000);
        //checkInButtom.setBounds(210, 525, 150, 50);
        //   添加上述组件
        panel0.add(label0);
        //panel0.add(checkInButtom);

        //6. 设置查看单词记忆情况的进度条(此后注释中称为进度条1)
        JProgressBar progressBar1 = new JProgressBar();
        Color foreground = new Color(224, 85, 161);
        Color background = new Color(255, 252, 92, 255);
        progressBar1.setBackground(background);
        progressBar1.setForeground(foreground);
        //进度条1上不显示字迹
        progressBar1.setStringPainted(false);
        //    进度条1相关参数
        int TotalVocabulary = 800;
        int FinishedVocabulary = WordsLearned.learnedWords().size();


        int UnfinishedVocabulary = TotalVocabulary - FinishedVocabulary;

        //progressBar1.setValue(percent);
        //2个充当进度条颜色图例的着色实心圆
        PinkCircleIcon IconP1 = new PinkCircleIcon();
        OrangeCircleIcon IconO1 = new OrangeCircleIcon();



        JLabel jLabel = new JLabel("Your Target Score: " + (level+3));
        jLabel.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel.setBounds(135, 137, 250, 20);

        JLabel jLabel1 = new JLabel("Your Daily Plan: " + wordsPlan);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 20));
        jLabel1.setBounds(135, 206, 300, 20);


        //    进度条1相关文本
        JLabel label1 = new JLabel("Your Word Reciting Progress:");
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel label2 = new JLabel("Finished: " + FinishedVocabulary);
        label2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        JLabel label3 = new JLabel("Unfinished: " + UnfinishedVocabulary);
        label3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        JLabel labelP1 = new JLabel();
        labelP1.setIcon(IconP1);

        JLabel labelO1 = new JLabel();
        labelO1.setIcon(IconO1);


        //    添加进度条1各个组件
        panel0.add(label1, JLayeredPane.DRAG_LAYER);
        panel0.add(label2, JLayeredPane.DRAG_LAYER);
        panel0.add(label3, JLayeredPane.DRAG_LAYER);
        panel0.add(progressBar1, JLayeredPane.DRAG_LAYER);
        panel0.add(labelP1, JLayeredPane.DRAG_LAYER);
        panel0.add(labelO1, JLayeredPane.DRAG_LAYER);

        //    设置进度条1各个组件的位置
        progressBar1.setBounds(135, 127+200, 300, 20);
        label1.setBounds(135, 97+200, 250, 20);
        label2.setBounds(135 + 30, 149+200, 100, 20);
        label3.setBounds(305 + 30, 149+200, 100, 20);
        labelP1.setBounds(105 + 30, 149+200, 20, 20);
        labelO1.setBounds(275 + 30, 149+200, 20, 20);

        //7. 设置查看打卡情况的进度条(此后注释中称为进度条2)
        JProgressBar progressBar2 = new JProgressBar();
        progressBar2.setBackground(background);
        progressBar2.setForeground(foreground);
        //进度条2上不显示字迹
        progressBar2.setStringPainted(false);

        int TotalDaysOfThisMonth = 31;
        int CheckedDaysOfThisMonth = ClockInDay;
        int MissedDaysOfThisMonth = TotalDaysOfThisMonth - CheckedDaysOfThisMonth;
        int percent2 = CheckedDaysOfThisMonth * 100 / TotalDaysOfThisMonth;

        //progressBar2.setValue(percent2);
        //2个充当进度条颜色图例的着色实心圆
        PinkCircleIcon IconP2 = new PinkCircleIcon();
        OrangeCircleIcon IconO2 = new OrangeCircleIcon();

        //    进度条2相关文本
        JLabel label4 = new JLabel("Your Progress Today:");
        label4.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel label5 = new JLabel("Learned: " + wordsToday);
        label5.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        JLabel label6 = new JLabel("Left: " + (wordsPlan-wordsToday));
        label6.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        JLabel labelP2 = new JLabel();
        labelP2.setIcon(IconP2);
        JLabel labelO2 = new JLabel();
        labelO2.setIcon(IconO2);


        button.setBounds(187, 550, 180, 60);
        button.addActionListener(progressListener);



        //    添加进度条2各个组件
        panel0.add(label4);
        panel0.add(label5);
        panel0.add(label6);
        panel0.add(progressBar2);
        panel0.add(labelP2);
        panel0.add(labelO2);
        panel0.add(jLabel);
        panel0.add(jLabel1);
        panel0.add(button);

        //    设置进度条2各个组件的位置
        progressBar2.setBounds(135, 236+200, 300, 20);
        label4.setBounds(135, 206+200, 250, 20);
        label5.setBounds(135 + 30, 258+200, 100, 20);
        label6.setBounds(305 + 30, 258+200, 100, 20);
        labelP2.setBounds(105 + 30, 258+200, 20, 20);
        labelO2.setBounds(275 + 30, 258+200, 20, 20);

        //利用线程实现动态效果
        new ProgressOne(progressBar1).start();
        new ProgressTwo(progressBar2).start();

        //最后把总面板加入容器:

        this.add(panel0);
        setVisible(true);
    }

    //进度条1的线程
    public class ProgressOne extends Thread {
        JProgressBar progressBar1;

        ProgressOne(JProgressBar progressBar1) {
            this.progressBar1 = progressBar1;
        }

        public void run() {
            for (int value1 = 0; value1 <= wordsLearned*100/800; value1++) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //设置进度条的值
                progressBar1.setValue(value1);
            }
            progressBar1.setIndeterminate(false);
        }
    }

    //进度条2的线程
    public class ProgressTwo extends Thread {
        JProgressBar progressBar2;

        ProgressTwo(JProgressBar progressBar1) {

            this.progressBar2 = progressBar1;
        }

        public void run() {

//            try {
//                ClockInDay = 0;
//                BufferedReader br = new BufferedReader(new FileReader("userDate.txt"));
//                String line = br.readLine();
//                //boolean pass = true;
//                while (line != null) {
//                    Calendar c = Calendar.getInstance();
//                    int year = c.get(Calendar.YEAR);
//                    int month = c.get(Calendar.MONTH)+1;
//                    String year1 = Integer.toString(year);
//                    String month1 = Integer.toString(month);
//                    String[] dataArray = line.split("-");
//                    if(dataArray[0].equals(year1) && dataArray[1].equals(month1)){
//                        ClockInDay ++;
//                    }
//                    line = br.readLine();
//                }
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            double percent = (ClockInDay*100)/31.0;
            for (int value2 = 0; value2 <= wordsToday*100/wordsPlan; value2++) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //设置进度条的值
                progressBar2.setValue(value2);
            }
            progressBar2.setIndeterminate(false);
        }
    }
}