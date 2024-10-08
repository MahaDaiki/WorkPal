package entities;

public class Espace {

    public int Gestionnaire_id;
    private int espace_id;
    private String name;
    private String type;
    private boolean disponibilite;
    private String taille;
    private int gestionnaire_id;
    private int prix;


    public Espace(int espace_id , String name, String type, boolean disponibilite, String taille ,int gestionnaire_id, int prix) {
        this.espace_id = espace_id;
        this.name = name;
        this.type = type;
        this.disponibilite = disponibilite;
        this.taille = taille;
        this.gestionnaire_id = gestionnaire_id;
        this.prix = prix;
    }


    public int getEspace_id() {
        return espace_id;
    }

    public void setEspace_id(int espace_id) {
        this.espace_id = espace_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {

        this.disponibilite = disponibilite;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {

        this.taille = taille;
    }

    public int getGestionnaire_id() {
        return gestionnaire_id;
    }

    public void setGestionnaire_id(int gestionnaire_id) {
        this.gestionnaire_id = gestionnaire_id;
    }
    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "Espace{" +
                "espace_id=" + espace_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", disponibilite=" + disponibilite +
                ", taille='" + taille + '\'' +
                ", prix=" + prix +
                '}';
    }


}
