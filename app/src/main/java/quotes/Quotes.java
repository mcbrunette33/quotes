package quotes;

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
        return "QUOTE{ " +
                "Author: " + author + "\n"  +
                "Text: " + text + "\n" +
                "}";
    }
}
