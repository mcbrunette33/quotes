package quotes;

import java.util.ArrayList;
import java.util.Arrays;

public class Quotes {
    String quoteText;
    String quoteAuthor;
    String senderName;
    String senderLink;
    String quoteLink;



    @Override
    public String toString()
    {
        return "QUOTE{ " +
                "quoteText: " + quoteText + "\n"  +
                "quoteAuthor: " + quoteAuthor + "\n" +
                "senderName: " + senderName + "\n" +
                "senderLink: " + senderLink + "\n" +
                "quoteLink: " + quoteLink + "\n" +
                "}";
    }

    @Override
    public String toString()
    {
        return "Quote{" +
                "Author: " + author + "\n" +
                "body: " + text + "}"+ "\n" ;
    }

}
