package entity;

import enums.Role;

public class Admin extends User {

    private int admin_id;

    public Admin(String name, String email, String phone_number, String adresse, String password, Role role) {
        super(name, email, phone_number, adresse, password, Role.ADMIN);
    }


    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
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
