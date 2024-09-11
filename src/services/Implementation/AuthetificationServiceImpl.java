package services.Implementation;

import entities.Admin;
import entities.GestionnaireDespaces;
import entities.Member;
import entities.User;
import repositories.Implementation.AdminRepositoryImpl;
import repositories.Implementation.GestionnaireDespacesRepositoryImpl;
import repositories.Implementation.MemberRepositoryimpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.AdminRepository;
import repositories.Interface.GestionnaireDespacesRepository;
import repositories.Interface.MemberRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.AuthentificationService;

public class AuthetificationServiceImpl implements AuthentificationService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final GestionnaireDespacesRepository Gestionnaire = new GestionnaireDespacesRepositoryImpl();
    private final AdminRepository adminRepository = new AdminRepositoryImpl();
    private final MemberRepository memberRepository  = new MemberRepositoryimpl();

    @Override
    public boolean registerAdmin(Admin admin) {
        try {
            adminRepository.register(admin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registerGestionnaire(GestionnaireDespaces GestionnaireDespaces) {
        try {

            Gestionnaire.register(GestionnaireDespaces);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registerMember(Member member) {
        try {

            memberRepository.register(member);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean login(String email, String password) {
        return userRepository.login(email, password);
    }

    public User getCurrentUser() {
        return ((UserRepositoryImpl) userRepository).getCurrentUser();
    }
}
