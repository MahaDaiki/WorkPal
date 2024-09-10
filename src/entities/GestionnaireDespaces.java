package entities;

import enums.Role;

public class GestionnaireDespaces extends User {

    private int gestionnaire_id;

    public GestionnaireDespaces(String name, String email, String phone_number, String adresse, String password, Role role) {
        super(name, email, phone_number, adresse, password, Role.GESTIONNAIRE);
    }


    public int getGestionnaire_id() {
        return gestionnaire_id;
    }

    public void setGestionnaire_id(int gestionnaire_id) {
        this.gestionnaire_id = gestionnaire_id;
    }

    @Override
    public String toString() {
        return "GestionnaireDespaces{" +
                "gestionnaire_id=" + gestionnaire_id +
                ", user_id=" + getUser_id() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone_number='" + getPhone_number() + '\'' +
                ", adresse='" + getAdresse() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() +
                '}';
    }
}
