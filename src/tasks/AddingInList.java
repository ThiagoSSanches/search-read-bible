package tasks;


import models.Bibleapi;

import java.util.ArrayList;
import java.util.List;

public class AddingInList {


    private List<Bibleapi> texts = new ArrayList<>();

    public void saveText(Bibleapi verses){
        texts.add(verses);
    }


    public List<Bibleapi> getTexts() {
        return texts;
    }

    @Override
    public String toString() {
        return "(Added to the List: " +
                "Texts: " + texts +
                ')';
    }
}
