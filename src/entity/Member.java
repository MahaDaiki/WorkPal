package entity;

import enums.Role;

public class Member extends User {

    private int member_id;
    private int abonnement_id;

    public Member(String name, String email, String phone_number, String adresse, String password, Role role, int abonnement_id) {
        super(name, email, phone_number, adresse, password, Role.MEMBER);
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
                ", adresse='" + getAdresse() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", role=" + getRole() +
                '}';
    }
}
