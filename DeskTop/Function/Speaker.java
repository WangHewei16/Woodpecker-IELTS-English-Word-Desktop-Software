package Function;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


public class Speaker {
    static ActiveXComponent  sap = new ActiveXComponent("Sapi.SpVoice");
    static Dispatch sapo = sap.getObject();


    public static void speak(String word){
        try {
            sap.setProperty("Volume", new Variant(100));
            sap.setProperty("Rate", new Variant(0));
            Dispatch.call(sapo, "Speak", new Variant(word));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
