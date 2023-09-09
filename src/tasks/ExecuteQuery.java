package tasks;

import com.google.gson.Gson;
import models.Bibleapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExecuteQuery {
    public Bibleapi searchText(String text){
        URI endereco = URI.create("https://bible-api.com/" + text.replace(" ", "%20"));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Bibleapi.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
