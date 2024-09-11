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

}

