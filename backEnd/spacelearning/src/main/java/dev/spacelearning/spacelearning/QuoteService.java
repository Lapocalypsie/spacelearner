package dev.spacelearning.spacelearning;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class QuoteService {

    //  chemin vers le JSON
    private static final String JSON_FILE_PATH = "backEnd/spacelearning/src/main/resources/QUOTESFILE.json";
    private List<Quote> quotes;

    public static List<Quote> readQuotesFromFile() {
        List<Quote> quoteList = new ArrayList<>();

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Aobjets associés à l'array quotes
            JSONArray quotesArray = jsonObject.getJSONArray("quotes");

            for (int i = 0; i < quotesArray.length(); i++) {
                JSONObject quoteObject = quotesArray.getJSONObject(i);
                long id = quoteObject.getLong("id");
                String text = quoteObject.getString("text");
                quoteList.add(new Quote(id, text));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return quoteList;
    }

    //pour piocher une citation au hasard :
    public Quote getRandomQuote() {
        Random random = new Random();
        int randomIndex = random.nextInt(quotes.size());
        return quotes.get(randomIndex);
    }
}
