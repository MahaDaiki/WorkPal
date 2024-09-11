package repositories.Implementation;

import config.DatabaseConnection;
import entities.Member;
import repositories.Interface.MemberRepository;
import utils.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberRepositoryimpl implements MemberRepository {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();


    @Override
    public void register(Member member) {
        if (!validator.validateEmail(member.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!validator.validatePhoneNumber(member.getPhone_number())) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        if (!validator.validateNotEmpty(member.getName())) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!validator.validatePassword(member.getPassword())) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        String query = "INSERT INTO members (name, email, phone_number, address, password, role) VALUES ( ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, member.getName());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPhone_number());
            stmt.setString(4, member.getAddress());
            stmt.setString(5, member.getPassword());  // you should hash it
            stmt.setString(6, member.getRole().name());
            stmt.executeUpdate();

            System.out.println("member registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }

