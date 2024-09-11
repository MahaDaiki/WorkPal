package repositories.Implementation;

import config.DatabaseConnection;
import entities.Admin;
import repositories.Interface.AdminRepository;
import utils.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AdminRepositoryImpl implements AdminRepository {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();

    @Override
    public void register(Admin admin) {

        if (!validator.validateEmail(admin.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!validator.validatePhoneNumber(admin.getPhone_number())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        if (!validator.validateNotEmpty(admin.getName())) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!validator.validatePassword(admin.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        String query = "INSERT INTO admins (name, email, phone_number, address, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, admin.getName());
            stmt.setString(2, admin.getEmail());
            stmt.setString(3, admin.getPhone_number());
            stmt.setString(4, admin.getAddress());
            stmt.setString(5, admin.getPassword());
            stmt.setString(6, admin.getRole().name());

            stmt.executeUpdate();



            System.out.println("Admin registered successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
