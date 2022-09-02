package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NoteFrame extends JFrame {
    String[] columnNames = { "Chinese", "English", "Extra Notes" }; // 定义表格列名数组

    String[][] tableValues = new String[25][3];

    JPanel panel = new JPanel(null);
    NotePanel panel1 = new NotePanel();
    JTable table = new JTable(tableValues, columnNames);
    NoteFrameListener noteFrameListener = new NoteFrameListener();


    public NoteFrame(){
        setTitle("Notes");
        setSize(750,730);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        readNote();

        Dimension size = table.getTableHeader().getPreferredSize();
        size.height = 49;
        table.getTableHeader().setPreferredSize(size);
        table.getTableHeader().setBackground(Color.blue);
        table.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 27));
        table.getTableHeader().setForeground(Color.white);

        table.setFont(new Font("微软雅黑", Font.PLAIN, 21));

        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table.setRowHeight(40);

        panel.setSize(750, 730);
        panel1.setSize(200, 730);
        scrollPane.setSize(550, 730);
        BoxLayout boxLayout = new BoxLayout(this.panel, BoxLayout.X_AXIS);
        panel.setLayout(boxLayout);

        panel1.button.addActionListener(noteFrameListener);
        noteFrameListener.noteFrame = this;

        panel.add(panel1);
        panel.add(scrollPane);
        this.add(panel);

        try
        {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer(){
                private static final long serialVersionUID = 1L;
                public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column){
                    if(row%2 == 0)
                        setBackground(new Color(216, 245, 248));//设置奇数行底色
                    else if(row%2 == 1)
                        setBackground(new Color(154, 237, 241));//设置偶数行底色
                    return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
                }
            };
            for(int i = 0; i < table.getColumnCount(); i++) {
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
            }
            tcr.setHorizontalAlignment(JLabel.CENTER);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void readNote(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./notebook.txt"))) {
            for(int i = 0; i < 25; i++){
                String line = bufferedReader.readLine();
                System.out.println(line);
                if(line != null) {
                    tableValues[i] = new String[]{line.split("//")[0], line.split("//")[1], line.split("//")[2]};
                }
                else {
                    tableValues[i] = new String[]{" ", " ", " "};
                }
            }
             table = new JTable(tableValues, columnNames);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
