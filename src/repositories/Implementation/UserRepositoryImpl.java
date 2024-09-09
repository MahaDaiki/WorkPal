package repositories.Implementation;

import entity.User;
import repositories.Interface.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

import static java.sql.DriverManager.getConnection;

public class UserRepositoryImpl implements UserRepository {

    private Connection getConnection() {
    }
    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, email, phone_number, adresse, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone_number());
            stmt.setString(4, user.getAdresse());
            stmt.setString(5, user.getPassword());  // Already hashed
            stmt.setString(6, user.getRole().name());  // Assuming Role is an enum
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(User user) {

    }
}
