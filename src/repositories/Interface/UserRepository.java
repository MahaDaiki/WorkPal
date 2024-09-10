package repositories.Interface;

import entities.User;

import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(int id);
    void update(User user);



}
