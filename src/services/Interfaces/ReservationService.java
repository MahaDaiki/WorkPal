package services.Interfaces;

import entities.Reservation;

import java.util.List;

public interface ReservationService {
    void createReservation(Reservation reservation);
    Reservation getReservationById(int reservationId);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservation(int reservationId);
    void updateRatingAndNote(int reservationId, Integer newRating, String newNote);
    void updateFavoris(int reservationId, boolean favoris);
    List<Reservation> getReservationsByMembreId(int membreId);
}
