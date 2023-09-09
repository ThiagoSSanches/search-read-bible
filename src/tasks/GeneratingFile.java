package tasks;

import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeneratingFile {
    public void saveJson(AddingInList texts) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter("texts.json");
        writer.write(gson.toJson(texts.getTexts()));
        writer.close();
    }
}
