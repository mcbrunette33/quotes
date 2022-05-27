package quotes;

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
}
