package services.Interfaces;

import entities.User;

public interface UserService {
    boolean updateUser(User user);
    boolean deleteUser(int userId)
}
