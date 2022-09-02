package Function;

import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;
import org.json.JSONException;
import org.json.JSONObject;

public class DictionaryExamples {
    private static String subscriptionKey = "20aac29db2a741f29f7d0b17538fa46a";

    // Add your location, also known as region. The default is global.
    // This is required if using a Cognitive Services resource.
    private static String location = "japaneast";

    HttpUrl url = new HttpUrl.Builder()
            .scheme("https")
            .host("api.cognitive.microsofttranslator.com")
            .addPathSegment("/dictionary/examples")
            .addQueryParameter("api-version", "3.0")
            .addQueryParameter("from", "en")
            .addQueryParameter("to", "zh-Hans")
            .build();

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String[] words) throws IOException {
        DictionaryLookup dictionaryLookup = new DictionaryLookup();
        String source = "[{\"Text\": \"" + words[0] + "\", \"Translation\": \"" + words[1] + "\"}]";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                source);
        Request request = new Request.Builder().url(url).post(body)
                .addHeader("Ocp-Apim-Subscription-Key", subscriptionKey)
                .addHeader("Ocp-Apim-Subscription-Region", location)
                .addHeader("Content-type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    // This function prettifies the json response.
    public static String prettify(String json_text) {
        JsonParser parser = new JsonParser();
        JsonElement json = parser.parse(json_text);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(json);
    }

    public static ArrayList<String[]> generateExamples(String[] strings) throws IOException, JSONException {
        DictionaryExamples dictionaryExamplesRequest = new DictionaryExamples();
        String response = dictionaryExamplesRequest.Post(strings);
        String jason = response.substring(1, response.length()-1);
        JSONObject jsonObject = new JSONObject(jason);
        ArrayList<String[]> arrayList = new ArrayList<>();
        for (int i = 0; i < jsonObject.getJSONArray("examples").length(); i++){
            JSONObject jsonObject1 = jsonObject.getJSONArray("examples").getJSONObject(i);
            String[] strings1 = new String[]{jsonObject1.getString("sourcePrefix"), jsonObject1.getString("sourceTerm"), jsonObject1.getString("sourceSuffix"), jsonObject1.getString("targetPrefix"), jsonObject1.getString("targetTerm"), jsonObject1.getString("targetSuffix")};
            arrayList.add(strings1);
        }
        System.out.println(prettify(response));
        return arrayList;
    }
}
