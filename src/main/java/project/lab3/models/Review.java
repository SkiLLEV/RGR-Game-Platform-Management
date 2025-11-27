package project.lab3.models;

public class Review {
    private int id;
    private String author;
    private String text;
    private int gameId;

    public Review() {}

    public Review(int id, String author, String text, int gameId) {
        this.id = id;
        this.author = author;
        this.text = text;
        this.gameId = gameId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }
}