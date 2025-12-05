package project.lab3.repository;

import project.lab3.models.Platform;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatformRepository {
    private final DataSource dataSource;

    public PlatformRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // --- ВРАЗЛИВИЙ МЕТОД  ---
    public void save(String name, String manufacturer) {
        String sql = "INSERT INTO platforms (name, manufacturer) VALUES ('" + name + "', '" + manufacturer + "')";

        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Виконано SQL (Vulnerable): " + sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- БЕЗПЕЧНИЙ МЕТОД  ---
    // Використовує PreparedStatement, тому SQL Injection тут неможлива
    public void saveSecure(String name, String manufacturer) {
        String sql = "INSERT INTO platforms (name, manufacturer) VALUES (?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, manufacturer);

            pstmt.executeUpdate();
            System.out.println("✅ Платформа додана безпечно: " + name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- МЕТОД ВИДАЛЕННЯ  ---
    public void delete(int id) {
        String sql = "DELETE FROM platforms WHERE id = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("🗑️ Платформу з ID=" + id + " видалено.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Platform> findAll() {
        List<Platform> platforms = new ArrayList<>();
        String sql = "SELECT * FROM platforms ORDER BY id";
        try (Connection conn = dataSource.getConnection();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                platforms.add(new Platform(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("manufacturer")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return platforms;
    }
}