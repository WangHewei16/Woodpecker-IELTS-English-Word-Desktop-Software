
import Function.Plan;
import GUI.*;
import org.json.JSONException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Test {
    public static void main(String[] args) throws IOException, ParseException, JSONException {
//        SpeakTestFrame speakTestFrame = new SpeakTestFrame(30);
//        String a = "Appropriate.";
//        String b = (a.substring(0, 1).toLowerCase() + a.substring(1)).replace(".", "");
//        System.out.println(b);
        UserPlan userPlan = new UserPlan();
        userPlan.initUI("10", "10", "10");
    }
}
