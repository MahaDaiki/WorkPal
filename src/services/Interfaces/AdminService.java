package services.Interfaces;

import entities.Admin;

public interface AdminService {
    boolean registerAdmin(Admin admin);
    boolean login(String email, String password);
}
