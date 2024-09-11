package repositories.Interface;

import entities.User;

import java.util.Optional;

public interface UserRepository {

    boolean login(String email, String password);
    void logout();


}
