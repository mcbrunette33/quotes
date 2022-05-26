package quotes;

import java.util.ArrayList;
import java.util.Arrays;

public class Quotes {
    public String author;
    public String text;

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "Quote{" +
                "Author: " + author + "\n" +
                "body: " + text + "}"+ "\n" ;
    }

}
