package services.Implementation;

import entities.Admin;
import repositories.Implementation.AdminRepositoryImpl;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.AdminRepository;
import repositories.Interface.UserRepository;
import services.Interfaces.AdminService;

public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository = new UserRepositoryImpl();
    private final AdminRepository adminRepository = new AdminRepositoryImpl();


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
    public boolean login(String email, String password) {
        return userRepository.login(email, password);
    }
}
