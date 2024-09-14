package repositories.Implementation;

import config.DatabaseConnection;
import entities.SuplService;
import repositories.Interface.SuplserviceRepository;
import utils.InputValidator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SuplserviceRepositoryImpl implements SuplserviceRepository {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();


    @Override
    public boolean addSuplservice(SuplService suplservice) {
        String query = "INSERT INTO suplservice (type, details, prix, gestionnaire_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, suplservice.getType());
            stmt.setString(2, suplservice.getDetails());
            stmt.setInt(3, suplservice.getPrix());
            stmt.setInt(4, suplservice.getGestionnaire_id());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSuplservice(SuplService suplservice, int gestionnaireId) {
        String query = "UPDATE suplservice SET type = ?, details = ?, prix = ? WHERE suplservice_id = ? AND gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, suplservice.getType());
            stmt.setString(2, suplservice.getDetails());
            stmt.setInt(3, suplservice.getPrix());
            stmt.setInt(4, suplservice.getSuplservice_id());
            stmt.setInt(5, gestionnaireId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSuplservice(int suplserviceId, int gestionnaireId) {
        String query = "DELETE FROM suplservice WHERE suplservice_id = ? AND gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, suplserviceId);
            stmt.setInt(2, gestionnaireId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public SuplService getSuplserviceById(int suplserviceId) {
        String query = "SELECT * FROM suplservice WHERE suplservice_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, suplserviceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SuplService(
                            rs.getInt("suplservice_id"),
                            rs.getString("type"),
                            rs.getString("details"),
                            rs.getInt("prix"),
                            rs.getInt("gestionnaire_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SuplService> getAllSuplservices() {
        List<SuplService> suplservices = new ArrayList<>();
        String query = "SELECT * FROM suplservice";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                suplservices.add(new SuplService(
                        rs.getInt("suplservice_id"),
                        rs.getString("type"),
                        rs.getString("details"),
                        rs.getInt("prix"),
                        rs.getInt("gestionnaire_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suplservices;
    }

    @Override
    public List<SuplService> getSuplservicesByGestionnaireId(int gestionnaireId) {
        List<SuplService> suplservices = new ArrayList<>();
        String query = "SELECT * FROM suplservice WHERE gestionnaire_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, gestionnaireId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    suplservices.add(new SuplService(
                            rs.getInt("suplservice_id"),
                            rs.getString("type"),
                            rs.getString("details"),
                            rs.getInt("prix"),
                            rs.getInt("gestionnaire_id")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suplservices;
    }
    }

