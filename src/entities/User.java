package entities;

import enums.Role;
//  Table name =  "users"
public class User {

    private int user_id;
    private String name;
    private String email;
    private String phone_number;
    private String adresse;
    private String password;
    private Role role;

    public User(String name, String email, String phone_number, String adresse, String password, Role role) {
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.adresse = adresse;
        this.password = password;
        this.role = role;
    }


    public int getUser_id() {
        return user_id;
    }

//    public void setUser_id(int user_id) {
//        this.user_id = user_id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", adresse='" + adresse + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
