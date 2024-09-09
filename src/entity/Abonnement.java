package entity;

import java.time.LocalDate;

public class Abonnement {

    private int abonnement_id;
    private LocalDate date_debut;
    private LocalDate date_fin;

    public Abonnement(LocalDate date_debut, LocalDate date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }


    public int getAbonnement_id() {
        return abonnement_id;
    }

    public void setAbonnement_id(int abonnement_id) {
        this.abonnement_id = abonnement_id;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "abonnement_id=" + abonnement_id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                '}';
    }
}
