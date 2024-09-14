package repositories.Implementation;

import config.DatabaseConnection;
import entities.User;
import enums.Role;
import repositories.Interface.UserRepository;
import utils.InputValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();

    private static User currentUser = null;


    @Override
    public boolean login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);  // Add this line

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve and set user_id
                    int userId = rs.getInt("user_id");

                    currentUser = new User(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address"),
                            rs.getString("password"),
                            Role.valueOf(rs.getString("role"))
                    );
                    currentUser.setUser_id(userId);  // Set user_id here
                    return true;
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
    public User getCurrentUser() {
        return currentUser;
    }

    public boolean updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, phone_number = ?, address = ?, password = ? WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone_number());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getUser_id());

            int rowsAffected = stmt.executeUpdate();
//            System.out.println("Rows affected: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);

            // Directly return whether rows were affected
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Error during deletion
        }
    }
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role"))
                );
                user.setUser_id(rs.getInt("user_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public User getUserById(int userId) {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("address"),
                        rs.getString("password"),
                        Role.valueOf(rs.getString("role").toUpperCase())  // Assuming role is stored as string
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
