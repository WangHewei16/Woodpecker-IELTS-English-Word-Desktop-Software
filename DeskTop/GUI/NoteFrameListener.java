package GUI;

import GUI.NoteFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class NoteFrameListener implements ActionListener {
    NoteFrame noteFrame;
    public static String account;
    int counter=0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Preserve")){
            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("./notebook.txt"));
                for(int i = 0; i < 25; i++){
                    for(int j = 0; j <= 3; j++){
                        if(j != 3) {

                            if (noteFrame.table.getModel().getValueAt(i, j) != null && (noteFrame.table.getModel().getValueAt(i, j) != "")) {
                                bw.write((String) noteFrame.table.getModel().getValueAt(i, j));
                                if(((String) noteFrame.table.getModel().getValueAt(i, j)).length() <= 3) {
                                    bw.write("//");
                                }
                                else {
                                    counter++;
                                    bw.write("//");
                                }
                            }
                            else {
                                bw.write(" //");
                                counter++;
                            }
                        }
                        else if (j == 3) {
                            if (counter!=0) {
                                bw.write(account);}
                            bw.write("\n");
                            counter = 0;

                        } else {
                            bw.write("\n");
                        }
                    }
                }
                bw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
