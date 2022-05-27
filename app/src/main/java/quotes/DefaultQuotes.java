package quotes;

public class DefaultQuotes {
    public String author;
    public String text;

    @Override
    public String toString()
    {
        return "Quote{ " +
                "Author: " + author + "\n" +
                "Text: " + text + "\n" +
                "}";
    }

}
