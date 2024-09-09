package entity;

import java.sql.Timestamp;

public class Evenement {

    private int evenementId;
    private String titre;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private String details;
    private String type;
    private int espaceId;

    public Evenement(String titre, Timestamp dateDebut, Timestamp dateFin, String details, String type, int espaceId) {
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.details = details;
        this.type = type;
        this.espaceId = espaceId;
    }


    public int getEvenementId() {
        return evenementId;
    }

    public void setEvenementId(int evenementId) {
        this.evenementId = evenementId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEspaceId() {
        return espaceId;
    }

    public void setEspaceId(int espaceId) {
        this.espaceId = espaceId;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "evenementId=" + evenementId +
                ", titre='" + titre + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", details='" + details + '\'' +
                ", type='" + type + '\'' +
                ", espaceId=" + espaceId +
                '}';
    }
}
