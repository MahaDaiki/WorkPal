package entities;

import enums.Role;

public class Admin extends User {

    private int admin_id;

    public Admin(String name, String email, String phone_number, String address, String password) {
        super(name, email, phone_number, address, password, Role.admin);
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
                ", address='" + getAddress() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() +
                '}';
    }
}
