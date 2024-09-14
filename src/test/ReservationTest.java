package test;

import entities.Espace;
import entities.Reservation;
import entities.SuplService;
import services.Implementation.*;
import services.Interfaces.AuthentificationService;
import services.Interfaces.EspaceService;
import services.Interfaces.MemberService;
import services.Interfaces.ReservationService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ReservationTest {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthentificationService authService = new AuthetificationServiceImpl();
    private static final ReservationService reservationService = new ReservationServiceImpl();
    private static final SuplserviceServiceImpl suplservice =new SuplserviceServiceImpl();
    private static EspaceService espaceService = new EspaceServiceImpl();
    private static MemberService memberService = new MemberServiceImpl();

    public static void main(String[] args) {
        manageReservations();
    }

    private static void displayAllEspaces() {
        List<Espace> espaces = espaceService.getEspacesByDisponibilite(true);

        System.out.println("Available Espaces:");
        for (Espace espace : espaces) {
            System.out.println(  espace.getEspace_id() + "_ Name: " + espace.getName() + ", Price: " + espace.getPrix());
        }
    }


    static void manageReservations() {
        displayAllEspaces();
        System.out.println("1. Show your reservations");
        System.out.println("2. Make a reservation");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                showReservationsByMember();
                break;
            case 2:
                makeReservation();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void showReservationsByMember() {

        int userId = authService.getCurrentUser().getUser_id();
        int memberId = memberService.getMemberIdByUserId(userId);
        List<Reservation> reservations = reservationService.getReservationsByMembreId(memberId);
        if (reservations.isEmpty()) {
            System.out.println("No reservations found for this member.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
            updateOrAddReviewMenu(reservations);
        }
    }

    private static void makeReservation() {
        displayAllEspaces();

        System.out.print("Enter Espace  to reserve: ");
        int espaceId = scanner.nextInt();

        int userId = authService.getCurrentUser().getUser_id();
        int memberId = memberService.getMemberIdByUserId(userId);

        System.out.print("Enter end date for reservation (YYYY-MM-DD): ");
        String endDate = scanner.next();
        LocalDateTime date_fin = LocalDateTime.parse(endDate + "T00:00:00");

        System.out.print("Do you want a supplementary service? (yes/no): ");
        String suplserviceChoice = scanner.next();

        Optional<Integer> suplserviceId = Optional.empty();
        if (suplserviceChoice.equalsIgnoreCase("yes")) {
            List<SuplService> suplservices = suplservice.getAllSuplservices();
            System.out.println("---Suplservices ---");
            for (SuplService suplservice : suplservices) {
                System.out.println(suplservice);
            }
            System.out.print("Enter Supplementary Service: ");
            int suplserviceIdInput = scanner.nextInt();
            suplserviceId = Optional.of(suplserviceIdInput);
        }

        //create the reservation object
        Reservation reservation = new Reservation(
                LocalDateTime.now(),
                date_fin,
                0,
                memberId,
                espaceId,
                suplserviceId,
                Optional.empty(),
                Optional.empty(),
                false
        );

        reservationService.createReservation(reservation);

        System.out.println("Reservation made successfully for Espace: " + espaceId);
    }

    private static void updateOrAddReviewMenu(List<Reservation> reservations) {
        int userId = authService.getCurrentUser().getUser_id();
        int memberId = memberService.getMemberIdByUserId(userId);
        List<Reservation> reservationbymember = reservationService.getReservationsByMembreId(memberId);
        System.out.println("---Reservations---");
        for (Reservation reservation : reservationbymember) {
            System.out.println("Reservation ID: " + reservation.getReservation_id());
            System.out.println("Espace ID: " + reservation.getEspace_id());
            System.out.println("Date Debut: " + reservation.getDate_debut());
            System.out.println("Date Fin: " + reservation.getDate_fin());
            System.out.println("Prix Total: " + reservation.getPrix_total());

            if (reservation.getNote().isPresent()) {
                System.out.println("Note: " + reservation.getNote().get());
            } else {
                System.out.println("Note: No note provided");
            }

            if (reservation.getRating().isPresent()) {
                System.out.println("Rating: " + reservation.getRating().get());
            } else {
                System.out.println("Rating: No review provided");
            }

            // Display favoris status
            if (reservation.isFavoris()) {
                System.out.println("Favoris: Yes");
            } else {
                System.out.println("Favoris: No");
            }

            if (reservation.getSuplservice_id().isPresent()) {
                System.out.println("Supplement Service: Yes");
            } else {
                System.out.println("Supplement Service: No");
            }

            System.out.println();
        }

        System.out.println("1. Update a reservation");
        System.out.println("2. Add review and note");
        System.out.println("3. Mark a reservation as favorite");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                updateReservation(reservations);
                break;
            case 2:
                addReview(reservations);
                break;
            case 3:
                markAsFavorite(reservations);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    private static void updateReservation(List<Reservation> reservations) {

        System.out.print("Which Reservation you want to update: ");
        int reservationId = scanner.nextInt();
        Reservation reservation = reservationService.getReservationById(reservationId);
        System.out.print("Enter new Date Fin (YYYY-MM-DD): ");
        String dateFin = scanner.next();
        System.out.print("Enter new total price: ");
        int prixTotal = scanner.nextInt();

        reservation.setDate_fin(LocalDateTime.parse(dateFin + "T00:00:00"));
        reservation.setPrix_total(prixTotal);

        reservationService.updateReservation(reservation);
        System.out.println("Reservation updated successfully.");
    }

    private static void addReview(List<Reservation> reservations) {
        System.out.print("Enter Reservation  to add a review: ");
        int reservationId = scanner.nextInt();
        Reservation reservation = reservationService.getReservationById(reservationId);

        System.out.print("Enter your rating (1-5): ");
        int rating = scanner.nextInt();
        System.out.print("Enter your note: ");
        String note = scanner.next();

        reservation.setRating(Optional.of(rating));
        reservation.setNote(Optional.of(note));

        reservationService.updateRatingAndNote(reservationId, rating,note);
        System.out.println("Review added successfully.");
    }

    private static void markAsFavorite(List<Reservation> reservations) {
        System.out.print("Enter Reservation you want to  mark as favorite: ");
        int reservationId = scanner.nextInt();
        Reservation reservation = reservationService.getReservationById(reservationId);

        // reservation favorite
        reservation.setFavoris(true);
        reservationService.updateFavoris(reservationId, reservation.isFavoris());

        System.out.println("Reservation marked as favorite.");
    }

}
