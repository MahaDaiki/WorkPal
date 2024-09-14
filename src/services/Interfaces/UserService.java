package services.Interfaces;

import entities.User;

import java.util.List;

public interface UserService {
    boolean updateUser(User user);
    boolean deleteUser(int userId);
    List<User> getAllUsers();
    User getUserById(int userId);
}
