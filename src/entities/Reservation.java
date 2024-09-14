package entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Reservation {

    private int reservation_id;
    private LocalDateTime date_debut;
    private LocalDateTime date_fin;
    private int prix_total;
    private int membre_id;
    private int espace_id;
    private Optional<Integer> suplservice_id = Optional.empty();  // Use Optional for nullable field
    private Optional<Integer> rating = Optional.empty();  // Use Optional for nullable field
    private Optional<String> note = Optional.empty();
    private boolean favoris;


    public Reservation(LocalDateTime date_debut, LocalDateTime date_fin, int prix_total,int membre_id, int espace_id, Optional<Integer> suplservice_id, Optional<Integer> rating, Optional<String> note, boolean favoris) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix_total = prix_total;
        this.membre_id = membre_id;
        this.espace_id = espace_id;
        this.suplservice_id = suplservice_id;
        this.rating = rating;
        this.note = note;
        this.favoris = favoris;
    }


    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDateTime getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDateTime date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDateTime getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDateTime date_fin) {
        this.date_fin = date_fin;
    }

    public int getMembre_id() {
        return membre_id;
    }

    public void setMembre_id(int membre_id) {
        this.membre_id = membre_id;
    }

    public int getEspace_id() {
        return espace_id;
    }

    public void setEspace_id(int espace_id) {
        this.espace_id = espace_id;
    }

    public Optional<Integer> getSuplservice_id() {
        return suplservice_id;
    }

    public void setSuplservice_id(Optional<Integer> suplservice_id) {
        this.suplservice_id = suplservice_id;
    }

    public Optional<Integer> getRating() {
        return rating;
    }

    public void setRating(Optional<Integer> rating) {
        this.rating = rating;
    }

    public Optional<String> getNote() {
        return note;
    }

    public void setNote(Optional<String> note) {
        this.note = note;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }
    public int getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(int prix_total) {
        this.prix_total = prix_total;
    }

    @Override
    public String toString() {
        return "Reservation "  + reservation_id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", membre_id=" + membre_id +
                ", espace_id=" + espace_id +
                ", suplservice_id=" + suplservice_id +
                ", rating=" + rating +
                ", note='" + note + '\'' +
                ", favoris=" + favoris ;
    }


}
