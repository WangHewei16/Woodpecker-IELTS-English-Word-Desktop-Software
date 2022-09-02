package GUI;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
public class DataGather {

    private static final String path = "C:\\Users\\86155\\recite-ielts-words\\userInformation.txt";

    public static final String openFileStyle = "r";

    public static final String fieldLimitChar = ",";

    public static final int fieldAllCount = 6;

    private int count;

    private String account;

    private String name;

    private String gender;

    private String email;

    private String password;

    private String reenter;

    public void loadFile() {

        try {

            RandomAccessFile raf = new RandomAccessFile(path, openFileStyle);
            String line_record = raf.readLine();
            while (line_record != null) {
                parseRecord(line_record);
                line_record = raf.readLine();
            }
            System.out.println("legal records:" + count );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseRecord(String line_record) throws Exception {
        String[] fields = line_record.split(fieldLimitChar);
        if (fields.length == fieldAllCount) {
            account = tranStr(fields[0]);
            email = tranStr(fields[1]);
            password = tranStr(fields[2]);
            reenter = tranStr(fields[3]);
            name = tranStr(fields[4]);
            gender = tranStr(fields[5]);
            System.out.println(account + " " + email + " " + password + " "+ reenter + " " + name + " " + gender );
            InsertDB db = new InsertDB();
            db.insertDB(account, name, gender, email,  password,  reenter);
            count++;

        }

    }



    private String tranStr(String oldstr) {

        String newstr = "";

        try {

            newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return newstr;

    }

}