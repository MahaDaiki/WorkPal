package repositories.Implementation;

import config.DatabaseConnection;
import entities.Reservation;
import repositories.Interface.ReservationRepository;
import utils.InputValidator;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReservationRepositoryImpl implements ReservationRepository {
    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final InputValidator validator = InputValidator.getInstance();

    @Override
    public void createReservation(Reservation reservation) {
        String espaceQuery = "SELECT prix FROM espace WHERE espace_id = ?";
        String suplserviceQuery = "SELECT prix FROM suplservice WHERE suplservice_id = ?";
        String updateEspaceDisponibiliteQuery = "UPDATE espace SET disponibilite = FALSE WHERE espace_id = ?";
        reservation.setDate_debut(LocalDateTime.now());

        // Validate
        if (!validator.isValidDateRange(reservation.getDate_debut(), reservation.getDate_fin())) {
            throw new IllegalArgumentException("Invalid date range: date_fin must be after date_debut.");
        }

        // Calculate prix_total
        int espacePrice = 0;
        int suplservicePrice = 0;

        try (PreparedStatement espaceStmt = connection.prepareStatement(espaceQuery)) {
            espaceStmt.setInt(1, reservation.getEspace_id());
            ResultSet rs = espaceStmt.executeQuery();
            if (rs.next()) {
                espacePrice = rs.getInt("prix");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (reservation.getSuplservice_id().isPresent()) {
            try (PreparedStatement suplserviceStmt = connection.prepareStatement(suplserviceQuery)) {
                suplserviceStmt.setInt(1, reservation.getSuplservice_id().get());
                ResultSet rs = suplserviceStmt.executeQuery();
                if (rs.next()) {
                    suplservicePrice = rs.getInt("prix");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        reservation.setPrix_total(espacePrice + suplservicePrice);

        // Insert reservation
        String insertQuery = "INSERT INTO reservations (date_debut, date_fin, prix_total, membre_id, espace_id, suplservice_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            stmt.setTimestamp(1, Timestamp.valueOf(reservation.getDate_debut()));  // Convert LocalDateTime to Timestamp
            stmt.setTimestamp(2, Timestamp.valueOf(reservation.getDate_fin()));    // Convert LocalDateTime to Timestamp
            stmt.setInt(3, reservation.getPrix_total());
            stmt.setInt(4, reservation.getMembre_id());
            stmt.setInt(5, reservation.getEspace_id());

            if (reservation.getSuplservice_id().isPresent()) {
                stmt.setInt(6, reservation.getSuplservice_id().get());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }

            stmt.executeUpdate();
            try (PreparedStatement updateDisponibiliteStmt = connection.prepareStatement(updateEspaceDisponibiliteQuery)) {
                updateDisponibiliteStmt.setInt(1, reservation.getEspace_id());
                updateDisponibiliteStmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Reservation getReservationById(int reservationId) {
        String query = "SELECT * FROM reservations WHERE reservation_id = ?";
        Reservation reservation = null;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reservationId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                reservation = new Reservation(
                        rs.getTimestamp("date_debut").toLocalDateTime(),
                        rs.getTimestamp("date_fin").toLocalDateTime(),
                        rs.getInt("prix_total"),
                        rs.getInt("membre_id"),
                        rs.getInt("espace_id"),
                        rs.getObject("suplservice_id") != null ? Optional.of(rs.getInt("suplservice_id")) : Optional.empty(),
                        rs.getObject("rating") != null ? Optional.of(rs.getInt("rating")) : Optional.empty(),
                        Optional.ofNullable(rs.getString("note")),
                        rs.getBoolean("favoris")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservation;
    }
    @Override
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations";

        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getTimestamp("date_debut").toLocalDateTime(),
                        rs.getTimestamp("date_fin").toLocalDateTime(),
                        rs.getInt("prix_total"),
                        rs.getInt("membre_id"),
                        rs.getInt("espace_id"),
                        rs.getObject("suplservice_id") != null ? Optional.of(rs.getInt("suplservice_id")) : Optional.empty(),
                        rs.getObject("rating") != null ? Optional.of(rs.getInt("rating")) : Optional.empty(),
                        Optional.ofNullable(rs.getString("note")),
                        rs.getBoolean("favoris")
                );
                // Add each reservation to the list
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    @Override
    public void updateReservation(Reservation reservation) {
        String updateQuery = "UPDATE reservations SET date_fin = ?,  espace_id = ?, suplservice_id = ? WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setTimestamp(1, Timestamp.valueOf(reservation.getDate_fin()));

            stmt.setInt(3, reservation.getEspace_id());

            if (reservation.getSuplservice_id().isPresent()) {
                stmt.setInt(4, reservation.getSuplservice_id().get());
            } else {
                stmt.setNull(4, Types.INTEGER);
            }
            stmt.setInt(5, reservation.getReservation_id());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReservation(int reservationId) {
        String deleteQuery = "DELETE FROM reservations WHERE reservation_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
            stmt.setInt(1, reservationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRatingAndNote(int reservationId, Integer newRating, String newNote) {
        String updateQuery = "UPDATE reservations SET rating = ?, note = ? WHERE reservation_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            if (newRating != null) {
                stmt.setInt(1, newRating);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }
            stmt.setString(2, newNote);
            stmt.setInt(3, reservationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFavoris(int reservationId, boolean favoris) {
        String updateQuery = "UPDATE reservations SET favoris = ? WHERE reservation_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setBoolean(1, favoris);
            stmt.setInt(2, reservationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Reservation> getReservationsByMembreId(int membreId) {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE membre_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, membreId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reservation reservation = new Reservation(
                        rs.getTimestamp("date_debut").toLocalDateTime(),
                        rs.getTimestamp("date_fin").toLocalDateTime(),
                        rs.getInt("prix_total"),
                        rs.getInt("membre_id"),
                        rs.getInt("espace_id"),
                        rs.getObject("suplservice_id") != null ? Optional.of(rs.getInt("suplservice_id")) : Optional.empty(),
                        rs.getObject("rating") != null ? Optional.of(rs.getInt("rating")) : Optional.empty(),
                        Optional.ofNullable(rs.getString("note")),
                        rs.getBoolean("favoris")
                );
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
}
