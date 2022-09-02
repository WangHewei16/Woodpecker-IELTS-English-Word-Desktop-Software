package Function;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ScoreExplanation {
    public static ArrayList<ArrayList<ArrayList<String>>> explainScore(JSONObject explanation) throws JSONException {
        try {
            JSONArray syllables = explanation.getJSONObject("read_word").getJSONObject("rec_paper").getJSONObject("read_word").getJSONObject("sentence").getJSONObject("word").getJSONArray("syll");
            ArrayList<ArrayList<ArrayList<String>>> information = new ArrayList<>();
            for (int i = 0; i < syllables.length(); i++) {
                JSONObject syllable = syllables.getJSONObject(i);
                ArrayList<ArrayList<String>> information1 = new ArrayList<>();
                ArrayList<String> information2 = new ArrayList<>();
                information2.add(syllable.getString("content"));
                information2.add(syllable.getString("syll_score"));
                information2.add(syllable.getString("beg_pos"));
                information2.add(syllable.getString("end_pos"));
                information2.add(syllable.getString("syll_accent"));
                information2.add(syllable.getString("serr_msg"));
                information1.add(information2);
                try {
                    for (int j = 0; j < syllable.getJSONArray("phone").length(); j++) {
                        ArrayList<String> information3 = new ArrayList<>();
                        JSONObject phone = syllable.getJSONArray("phone").getJSONObject(j);
                        information3.add(phone.getString("content"));
                        information3.add(phone.getString("beg_pos"));
                        information3.add(phone.getString("end_pos"));
                        information3.add(phone.getString("dp_message"));
                        information1.add(information3);
                    }
                    information.add(information1);
                } catch (JSONException e) {
                    ArrayList<String> information3 = new ArrayList<>();
                    JSONObject phone = syllable.getJSONObject("phone");
                    information3.add(phone.getString("content"));
                    information3.add(phone.getString("beg_pos"));
                    information3.add(phone.getString("end_pos"));
                    information3.add(phone.getString("dp_message"));
                    information1.add(information3);
                    information.add(information1);
                }
            }
            return information;
        }
        catch (JSONException e){
            JSONObject syllable = explanation.getJSONObject("read_word").getJSONObject("rec_paper").getJSONObject("read_word").getJSONObject("sentence").getJSONObject("word").getJSONObject("syll");
            ArrayList<ArrayList<ArrayList<String>>> information = new ArrayList<>();
            ArrayList<ArrayList<String>> information1 = new ArrayList<>();
            ArrayList<String> information2 = new ArrayList<>();
            information2.add(syllable.getString("content"));
            information2.add(syllable.getString("syll_score"));
            information2.add(syllable.getString("beg_pos"));
            information2.add(syllable.getString("end_pos"));
            information2.add(syllable.getString("syll_accent"));
            information2.add(syllable.getString("serr_msg"));
            information1.add(information2);
            try {
                for (int j = 0; j < syllable.getJSONArray("phone").length(); j++) {
                    ArrayList<String> information3 = new ArrayList<>();
                    JSONObject phone = syllable.getJSONArray("phone").getJSONObject(j);
                    information3.add(phone.getString("content"));
                    information3.add(phone.getString("beg_pos"));
                    information3.add(phone.getString("end_pos"));
                    information3.add(phone.getString("dp_message"));
                    information1.add(information3);
                }
                information.add(information1);
            } catch (JSONException e1) {
                ArrayList<String> information3 = new ArrayList<>();
                JSONObject phone = syllable.getJSONObject("phone");
                information3.add(phone.getString("content"));
                information3.add(phone.getString("beg_pos"));
                information3.add(phone.getString("end_pos"));
                information3.add(phone.getString("dp_message"));
                information1.add(information3);
                information.add(information1);
            }
            return information;
        }
    }

    public static boolean isCorrect(JSONObject explanation) throws JSONException {
        String string = explanation.getJSONObject("read_word").getJSONObject("rec_paper").getJSONObject("read_word").getString("reject_type");
        return string.equals("0");
    }
}
