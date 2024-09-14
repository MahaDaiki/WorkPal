package test;

import entities.User;
import enums.Role;
import services.Implementation.UserServiceImpl;
import services.Interfaces.UserService;

import java.util.List;
import java.util.Scanner;

public class AdminTest {
    private static final UserService userService = new UserServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



    }

    static void updateUser() {
        displayAllUsers();
        System.out.print("Enter User ID to update: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter new name (current: " + user.getName() + "): ");
        String name = scanner.nextLine();
        System.out.print("Enter new email (current: " + user.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number (current: " + user.getPhone_number() + "): ");
        String phone = scanner.nextLine();
        System.out.print("Enter new address (current: " + user.getAddress() + "): ");
        String address = scanner.nextLine();
        System.out.print("Enter new password (current: " + user.getPassword() + "): ");
        String password = scanner.nextLine();
        System.out.print("Enter new role (ADMIN, USER): ");
        Role role = Role.valueOf(scanner.nextLine().toUpperCase());

        // Update user object
        user.setName(name);
        user.setEmail(email);
        user.setPhone_number(phone);
        user.setAddress(address);
        user.setPassword(password);
        user.setRole(role);

        boolean success = userService.updateUser(user);
        if (success) {
            System.out.println("User updated successfully.");
        } else {
            System.out.println("Failed to update user.");
        }
    }

    static void deleteUser() {
        displayAllUsers();
        System.out.print("Enter User ID to delete: ");
        int userId = scanner.nextInt();

        boolean success = userService.deleteUser(userId);
        if (success) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("Failed to delete user.");
        }
    }

    private static void displayAllUsers() {
        List<User> users = userService.getAllUsers();
        System.out.println("--- All Users ---");
        for (User user : users) {
            System.out.println("User ID: " + user.getUser_id());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone Number: " + user.getPhone_number());
            System.out.println("Address: " + user.getAddress());
            System.out.println("Role: " + user.getRole());
            System.out.println("-------------------");
        }
    }
}
