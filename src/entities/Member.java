package entities;

import enums.Role;

public class Member extends User {

    private int member_id;
    private int abonnement_id;

    public Member(String name, String email, String phone_number, String address, String password,int abonnement_id) {
        super(name, email, phone_number, address, password, Role.member);
        this.abonnement_id = abonnement_id;
    }


    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getAbonnement_id() {
        return abonnement_id;
    }

    public void setAbonnement_id(int abonnement_id) {
        this.abonnement_id = abonnement_id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "member_id=" + member_id +
                ", abonnement_id=" + abonnement_id +
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
