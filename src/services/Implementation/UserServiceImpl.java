package services.Implementation;

import entities.User;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.UserRepository;
import services.Interfaces.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public boolean updateUser(User user) {

        return userRepository.updateUser(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }
}
