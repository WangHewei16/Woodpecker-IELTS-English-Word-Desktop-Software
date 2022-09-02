package Function;

import java.io.*;
import java.net.*;
import java.util.*;
import com.google.gson.*;
import com.squareup.okhttp.*;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.json.JSONException;
import org.json.JSONObject;

public class DictionaryLookup {
    private static String subscriptionKey = "20aac29db2a741f29f7d0b17538fa46a";

    // Add your location, also known as region. The default is global.
    // This is required if using a Cognitive Services resource.
    private static String location = "japaneast";

    HttpUrl url = new HttpUrl.Builder()
            .scheme("https")
            .host("api.cognitive.microsofttranslator.com")
            .addPathSegment("/dictionary/lookup")
            .addQueryParameter("api-version", "3.0")
            .addQueryParameter("from", "en")
            .addQueryParameter("to", "zh-Hans")
            .build();

    // Instantiates the OkHttpClient.
    OkHttpClient client = new OkHttpClient();

    // This function performs a POST request.
    public String Post(String word) throws IOException {
        String wordToTranslate = "[{\"Text\": \"" + word + "\"}]";
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,
                wordToTranslate);
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

    public static ArrayList<ArrayList<String>> getSource(String word) throws IOException, JSONException {
        DictionaryLookup dictionaryLookupRequest = new DictionaryLookup();
        String response = dictionaryLookupRequest.Post(word);
        String jason = response.substring(1, response.length()-1);
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        System.out.println(prettify(jason));
        JSONObject jsonObject = new JSONObject(jason);
        System.out.println(jsonObject.getJSONArray("translations").getJSONObject(0).getString("normalizedTarget"));
        System.out.println(jsonObject.getJSONArray("translations").getJSONObject(0).getJSONArray("backTranslations").getJSONObject(0).getString("normalizedText"));
        String[] strings = new String[]{jsonObject.getJSONArray("translations").getJSONObject(0).getJSONArray("backTranslations").getJSONObject(0).getString("normalizedText"), jsonObject.getJSONArray("translations").getJSONObject(0 ).getString("normalizedTarget")};
        for (int i = 0; i < jsonObject.getJSONArray("translations").length(); i++){
            JSONObject jsonObject1 = jsonObject.getJSONArray("translations").getJSONObject(i);
            ArrayList<String> arrayList1 = new ArrayList<>();
            arrayList1.add(jsonObject1.getString("normalizedTarget"));
            arrayList1.add(jsonObject1.getString("posTag"));
            for (int j = 0; j < jsonObject1.getJSONArray("backTranslations").length(); j++){
                JSONObject jsonObject2 = jsonObject1.getJSONArray("backTranslations").getJSONObject(j);
                if(!jsonObject2.getString("normalizedText").equals(word)) {
                    arrayList1.add(jsonObject2.getString("normalizedText"));
                }
            }
            arrayList.add(arrayList1);
        }
        System.out.println(arrayList);
        return arrayList;
    }
}
