package project.lab3.models;

public class User {
    private long id;  // змінили на long
    private String username;
    private String passwordHash;
    private String role;

    public User() {}

    public User(long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }


    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
