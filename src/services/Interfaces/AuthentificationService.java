package services.Interfaces;

import entities.Admin;
import entities.GestionnaireDespaces;
import entities.Member;
import entities.User;

public interface AuthentificationService {
    boolean registerAdmin(Admin admin);
    boolean registerGestionnaire(GestionnaireDespaces GestionnaireDespaces);
    boolean registerMember(Member member);
    boolean login(String email, String password);
    User getCurrentUser();
}
