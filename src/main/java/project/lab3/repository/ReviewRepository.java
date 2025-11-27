package project.lab3.repository;

import project.lab3.models.Review;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepository {
    private final DataSource dataSource;

    public ReviewRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save(String author, String text, int gameId) {
        String sql = "INSERT INTO reviews (author, text, game_id) VALUES (?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, author);
            pstmt.setString(2, text);
            pstmt.setInt(3, gameId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM reviews WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Review> findAll() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews ORDER BY id";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                reviews.add(new Review(
                        rs.getInt("id"),
                        rs.getString("author"),
                        rs.getString("text"),
                        rs.getInt("game_id")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }
}