package quotes;

public class StarWars
{
    public int id;
    public String content;
    public String faction;

    @Override
    public String toString()
    {
        return "QUOTE{ " +
                "id: " + id + "\n"  +
                "content: " + content + "\n" +
                "faction: " + faction + "\n" +
                "}";
    }
}
