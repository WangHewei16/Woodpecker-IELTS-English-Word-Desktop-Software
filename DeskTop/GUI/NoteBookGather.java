package GUI;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
public class NoteBookGather {

    private static final String path = "C:\\Users\\86155\\recite-ielts-words\\notebook.txt";

    public static final String openFileStyle = "r";

    public static final String fieldLimitChar = "//";

    public static final int fieldAllCount = 3;

    private int count;

    private String Chinese;

    private String English;

    private String Extra;

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
            Chinese = tranStr(fields[0]);
            English = tranStr(fields[1]);
            Extra = tranStr(fields[2]);
            System.out.println(Chinese + " " + English+ " " + Extra);
            InsertNoteBook db = new InsertNoteBook();
            db.insertNB(Chinese, English, Extra);
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
