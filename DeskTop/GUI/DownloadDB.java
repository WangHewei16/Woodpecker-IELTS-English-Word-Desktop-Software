package GUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DownloadDB {
    PrintWriter pw = null;
    FileWriter fw = null;
    String url = "jdbc:mysql://rm-uf64qbw853c74v26feo.mysql.rds.aliyuncs.com/user_information";
    String user = "group17";
    String password = "Didi0617";
    String Chinese;
    String English;
    String Extra;
    String id;
    public void DDBConnection(){
        try {
            System.out.println("DDB running");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            String sql = "select Chinese, English, Extra,account from notebook order by account";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            int i = 0;
            String[] accountlst = new String[100];
            boolean refresh = false;
            while (rs.next()) {
                Chinese = rs.getString("Chinese");
                English = rs.getString("English");
                Extra = rs.getString("Extra");
                id = rs.getString("account");
                String filename = id + ".txt";
                if (i==0) {
                    accountlst[i]=id;
                    refresh = true;
                } else if(i>0&&!(id.toString().equals(accountlst[i-1]))) {
                    accountlst[i]=id.toString();
                    System.out.print("element id: "+id+" ");
                    System.out.print("list !i-1: "+accountlst[i-1]+" ");
                    System.out.print("id?=i- "+accountlst[i-1]+" ");
                    System.out.print("list i: "+accountlst[i]+" ");
                    refresh = true;
                } else if(i>0&&id.toString().equals(accountlst[i-1])) {
                    System.out.print("list =i-1: "+accountlst[i-1]);
                    System.out.print("list i: "+accountlst[i]+" ");
                    i--;
                }
                i++;
                File f = new File(filename);
                if(!f.exists()) {
                    try {
                        f.createNewFile();
                        pw = new PrintWriter(f);
                        pw.print(Chinese + "//");
                        pw.print(English + "//");
                        pw.print(Extra);
                        pw.println();
                        pw.flush();
                        System.out.println("created txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        if(refresh==true) {
                            System.out.println("cleaning");
                            fw = new FileWriter(f);
                            fw.write("");
                            fw.flush();
                            fw.close();
                        }
                        refresh = false;
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("rewriting");
                        fw = new FileWriter(f,true);
                        fw.write(Chinese + "//");
                        fw.write(English + "//");
                        fw.write(Extra+"\n");
                        fw.flush();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            i++;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("failed to load MYSQL in DDB");
        }  catch (SQLException e) {
            e.printStackTrace();
            System.out.println("failed to connect MYSQL in DDB");
            System.exit(1);
        }
    }
    public void close(ResultSet rs, Statement stm, Connection con) {
        if (rs != null)
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        if (stm != null)
            try {
                stm.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        if (con != null)
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}