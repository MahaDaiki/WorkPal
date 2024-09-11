package test;

import entities.Admin;
import services.Implementation.AdminServiceImpl;
import services.Interfaces.AdminService;

public class AuthentificationTest {
    AdminService adminService = new AdminServiceImpl();

    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();

        Admin newAdmin = new Admin("Joh", "testr@example.com", "1234567890", "123 Main St", "securePassword123");
        boolean registrationSuccess = adminService.registerAdmin(newAdmin);
        if (registrationSuccess) {
            System.out.println("Admin registered successfully.");
        } else {
            System.out.println("Failed to register admin.");
        }

        // Test Login
        boolean loginSuccess = adminService.login("john.doe@example.com", "securePassword123");
        if (loginSuccess) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }
}
