package GUI;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class InsertDB {
    
   
    private static final String user = "group17";
    private static final String pwd = "Didi0617";//云数据库密码
    private static final String url = "jdbc:mysql://rm-uf64qbw853c74v26feo.mysql.rds.aliyuncs.com/user_information";//云数据库
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection con = null;
    public static Connection getCon() throws IOException {

        //Connection con = null;
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                System.out.println("Connected to Database:" + con.getCatalog());
            }
        }catch(Exception e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }
        return con;
    }
    public boolean insertDB(String account, String name, String gender,
                            String email, String password, String reenter) {
        Connection con = null;
        Statement stm = null;
        boolean flag = false;
        String sql = "insert into register values('" + account + "','"
                + name + "','" + gender + "','" + email + "','" + password
                + "','" + reenter + "')";
        try {
            con = getCon();
            stm = con.createStatement();
            int i = stm.executeUpdate(sql);
            if (i > 0) {
                flag = true;
                System.out.println(flag + "insert successfully!");
            }
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            close(null, stm, con);
        }
        return flag;
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