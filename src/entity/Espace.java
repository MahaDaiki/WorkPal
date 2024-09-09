package entity;

public class Espace {

    private int espace_id;
    private String name;
    private String type;
    private boolean disponibilite;
    private String taille;

    public Espace(String name, String type, boolean disponibilite, String taille) {
        this.name = name;
        this.type = type;
        this.disponibilite = disponibilite;
        this.taille = taille;
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

    @Override
    public String toString() {
        return "Espace{" +
                "espace_id=" + espace_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", disponibilite=" + disponibilite +
                ", taille='" + taille + '\'' +
                '}';
    }
}
