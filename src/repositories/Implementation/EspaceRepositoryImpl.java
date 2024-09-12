package repositories.Implementation;

import config.DatabaseConnection;
import entities.Espace;
import repositories.Interface.EspaceRepository;
import utils.InputValidator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspaceRepositoryImpl implements EspaceRepository {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();

    @Override
    public boolean addEspace(Espace espace, int gestionnaireId) {
        String query = "INSERT INTO espace (name, type, disponibilite, taille, gestionnaire_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, espace.getName());
            stmt.setString(2, espace.getType());
            stmt.setBoolean(3, espace.isDisponibilite());
            stmt.setString(4, espace.getTaille());
            stmt.setInt(5, gestionnaireId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateEspace(Espace espace, int gestionnaireId) {
        String query = "UPDATE espace SET name = ?, type = ?, disponibilite = ?, taille = ? WHERE espace_id = ? AND gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, espace.getName());
            stmt.setString(2, espace.getType());
            stmt.setBoolean(3, espace.isDisponibilite());
            stmt.setString(4, espace.getTaille());
            stmt.setInt(5, espace.getEspace_id());
            stmt.setInt(6, gestionnaireId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEspace(int espaceId, int gestionnaireId) {
        String query = "DELETE FROM espace WHERE espace_id = ? AND gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, espaceId);
            stmt.setInt(2, gestionnaireId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Espace> getEspacesByGestionnaireId(int gestionnaireId) {
        List<Espace> espaces = new ArrayList<>();
        String query = "SELECT * FROM espace WHERE gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, gestionnaireId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Espace espace = new Espace(
                            rs.getInt("espace_id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getBoolean("disponibilite"),
                            rs.getString("taille")
                    );
                    espaces.add(espace);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return espaces;
    }

    @Override
    public List<Espace> getEspacesByDisponibilite(boolean disponibilite) {
        List<Espace> espaces = new ArrayList<>();
        String query = "SELECT * FROM espace WHERE disponibilite = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setBoolean(1, disponibilite);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Espace espace = new Espace(
                            rs.getInt("espace_id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getBoolean("disponibilite"),
                            rs.getString("taille")
                    );
                    espaces.add(espace);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return espaces;
    }
}

