package test;

import entities.User;

import services.Implementation.AdminServiceImpl;
import services.Implementation.AuthetificationServiceImpl;
import services.Implementation.UserServiceImpl;
import services.Interfaces.AdminService;
import services.Interfaces.AuthentificationService;
import services.Interfaces.UserService;

import java.util.Scanner;

public class MemberManagementTest {
    private static final UserService userService = new UserServiceImpl();
    private static final AuthentificationService authService = new AuthetificationServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        modifyProfile();
    }

    public static void modifyProfile() {
        User currentUser = authService.getCurrentUser();

        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        System.out.println("Current Profile:");
        System.out.println(currentUser);

        System.out.println("Which field do you want to modify?");
        System.out.println("1. Name");
        System.out.println("2. Email");
        System.out.println("3. Phone Number");
        System.out.println("4. Address");
        System.out.println("5. Password");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                currentUser.setName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter new email: ");
                currentUser.setEmail(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter new phone number: ");
                currentUser.setPhone_number(scanner.nextLine());
                break;
            case 4:
                System.out.print("Enter new address: ");
                currentUser.setAddress(scanner.nextLine());
                break;
            case 5:
                System.out.print("Enter new password: ");
                currentUser.setPassword(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid option. No changes made.");
                return;
        }


        if (userService.updateUser(currentUser)) {
            System.out.println("Profile updated successfully!");
        } else {
            System.out.println("Failed to update profile.");
        }
    }
}
