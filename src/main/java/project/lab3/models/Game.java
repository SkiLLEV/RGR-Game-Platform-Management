package project.lab3.models;

public class Game {
    private int id;
    private String title;
    private double price;
    private int platformId; // Зв'язок з платформою

    public Game() {}

    public Game(int id, String title, double price, int platformId) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.platformId = platformId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getPlatformId() { return platformId; }
    public void setPlatformId(int platformId) { this.platformId = platformId; }
}