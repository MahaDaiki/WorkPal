package repositories.Implementation;

import config.DatabaseConnection;
import entities.User;
import repositories.Interface.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, email, phone_number, adresse, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone_number());
            stmt.setString(4, user.getAdresse());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getRole().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
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
