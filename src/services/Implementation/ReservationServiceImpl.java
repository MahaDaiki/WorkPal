package services.Implementation;

import entities.Reservation;
import repositories.Implementation.GestionnaireDespacesRepositoryImpl;
import repositories.Implementation.ReservationRepositoryImpl;
import repositories.Interface.GestionnaireDespacesRepository;
import repositories.Interface.ReservationRepository;
import services.Interfaces.ReservationService;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository Reservation = new ReservationRepositoryImpl();
    @Override
    public void createReservation(Reservation reservation) {
      Reservation.createReservation( reservation);
    }

    @Override
    public Reservation getReservationById(int reservationId) {
        return Reservation.getReservationById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return Reservation.getAllReservations();
    }

    @Override
    public void updateReservation(Reservation reservation) {
       Reservation.updateReservation(reservation);
    }

    @Override
    public void deleteReservation(int reservationId) {
        Reservation.deleteReservation(reservationId);
    }

    @Override
    public void updateRatingAndNote(int reservationId, Integer newRating, String newNote) {
        Reservation.updateRatingAndNote(reservationId, newRating, newNote);
    }

    @Override
    public void updateFavoris(int reservationId, boolean favoris) {
        Reservation.updateFavoris(reservationId, favoris);
    }

    @Override
    public List<entities.Reservation> getReservationsByMembreId(int membreId) {
        return Reservation.getReservationsByMembreId(membreId);
    }
}
