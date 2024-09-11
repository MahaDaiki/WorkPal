package repositories.Implementation;

import config.DatabaseConnection;
import entities.User;
import enums.Role;
import repositories.Interface.UserRepository;
import utils.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();

    private static User currentUser = null;

    @Override
    public boolean login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    if (password.equals(storedPassword)) {
                        currentUser = new User(
                                rs.getInt("user_id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("phone_number"),
                                rs.getString("address"),
                                rs.getString("password"),
                                Role.valueOf(rs.getString("role"))
                        );
                        return true;  // Login successful
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Login failed
    }

    @Override
    public void logout() {
        currentUser = null;
    }
}
