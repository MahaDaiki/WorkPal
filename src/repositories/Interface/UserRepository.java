package repositories.Interface;

import entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    boolean login(String email, String password);
    void logout();
    boolean updateUser(User user);
    boolean deleteUser(int userId);
    List<User> getAllUsers();
    User getUserById(int userId);
}
