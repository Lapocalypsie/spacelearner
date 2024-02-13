package dev.spacelearning.spacelearning.quotes;


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

    // chemin vers le JSON
    private static final String JSON_FILE_PATH = "spacelearning/src/main/resources/QUOTESFILES.json";
    private List<Quotes> quoteList;

    // Initialize quoteList by calling readQuotesFromFile in the constructor
    public QuoteService() {
        this.quoteList = readQuotesFromFile();
    }

    private static List<Quotes> readQuotesFromFile() {
        List<Quotes> quoteList = new ArrayList<>();
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Aobjets associés à l'array quotes
            JSONArray quotesArray = jsonObject.getJSONArray("quotes");

            for (int i = 0; i < quotesArray.length(); i++) {
                JSONObject quoteObject = quotesArray.getJSONObject(i);
                long id = quoteObject.getLong("id");
                String text = quoteObject.getString("text");
                quoteList.add(new Quotes(id, text));
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return quoteList;
    }

    public Quotes getRandomQuote() {
        if (quoteList.isEmpty()) {
            System.out.println("Quote list is empty");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.size());

        Quotes randomQuote = quoteList.get(randomIndex);
        System.out.println(randomQuote.getText()); // Assuming you have a getText() method in your Quotes class
        return randomQuote;
    }
}