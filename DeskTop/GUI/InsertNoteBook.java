package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class InsertNoteBook {
    private static final String user = "group17";//阿里云数据库账号
    private static final String pwd = "Didi0617";//云数据库密码
    private static final String url = "jdbc:mysql://rm-uf64qbw853c74v26feo.mysql.rds.aliyuncs.com/user_information";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    public static Connection getCon() {
        Connection con = null;
        try{
            Class.forName(driver).newInstance();
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
    public boolean insertNB(String Chinese, String English, String Extra) {
        Connection con = null;
        Statement stm = null;
        boolean flag = false;
        String sql = "insert into notebook values('" + Chinese + "','"
                + English + "','" + Extra + "')";
        try {
            con = getCon();
            stm = con.createStatement();
            int i = stm.executeUpdate(sql);
            if (i > 0) {
                flag = true;
                System.out.println(flag + "insert notebook successfully!");
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
