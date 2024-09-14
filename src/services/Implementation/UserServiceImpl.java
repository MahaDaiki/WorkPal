package services.Implementation;

import entities.User;
import repositories.Implementation.UserRepositoryImpl;
import repositories.Interface.UserRepository;
import services.Interfaces.UserService;

import java.util.List;

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

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);

    }

}
