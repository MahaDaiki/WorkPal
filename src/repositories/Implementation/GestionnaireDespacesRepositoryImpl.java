package repositories.Implementation;

import config.DatabaseConnection;
import entities.GestionnaireDespaces;
import repositories.Interface.GestionnaireDespacesRepository;
import utils.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionnaireDespacesRepositoryImpl implements GestionnaireDespacesRepository {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();



    @Override
    public void register(GestionnaireDespaces GestionnaireDespaces) {

        if (!validator.validateEmail(GestionnaireDespaces.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!validator.validatePhoneNumber(GestionnaireDespaces.getPhone_number())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        if (!validator.validateNotEmpty(GestionnaireDespaces.getName())) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!validator.validatePassword(GestionnaireDespaces.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        String query = "INSERT INTO gestionnaire_despaces (name, email, phone_number, address, password, role) VALUES ( ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, GestionnaireDespaces.getName());
            stmt.setString(2, GestionnaireDespaces.getEmail());
            stmt.setString(3, GestionnaireDespaces.getPhone_number());
            stmt.setString(4, GestionnaireDespaces.getAddress());
            stmt.setString(5, GestionnaireDespaces.getPassword());  // you should hash it
            stmt.setString(6, GestionnaireDespaces.getRole().name());
            stmt.executeUpdate();
            System.out.println("Done!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }

