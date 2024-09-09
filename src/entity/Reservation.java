package entity;

import java.sql.Timestamp;

public class Reservation {

    private int reservation_id;
    private Timestamp date_debut;
    private Timestamp date_fin;
    private int membre_id;
    private int espace_id;
    private int suplservice_id;
    private int rating;
    private String note;
    private boolean favoris;


    public Reservation(Timestamp date_debut, Timestamp date_fin, int membre_id, int espace_id, int suplservice_id, int rating, String note, boolean favoris) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
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

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public Timestamp getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Timestamp date_fin) {
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

    public int getSuplservice_id() {
        return suplservice_id;
    }

    public void setSuplservice_id(int suplservice_id) {
        this.suplservice_id = suplservice_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    // toString method
    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", membre_id=" + membre_id +
                ", espace_id=" + espace_id +
                ", suplservice_id=" + suplservice_id +
                ", rating=" + rating +
                ", note='" + note + '\'' +
                ", favoris=" + favoris +
                '}';
    }
}
