package test;

import entities.Admin;
import entities.Member;
import enums.Role;
import services.Implementation.AdminServiceImpl;
import services.Implementation.AuthetificationServiceImpl;
import services.Interfaces.AdminService;
import services.Interfaces.AuthentificationService;
import entities.User;

import java.util.Scanner;

public class AuthentificationTest {
    AdminService adminService = new AdminServiceImpl();
    private static final AuthentificationService authService = new AuthetificationServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register Member");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerMember() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        Member member = new Member(name, email, phoneNumber, address, password, Role.member.ordinal());

        if (authService.registerMember(member)) {
            System.out.println("Member registered successfully!");
        } else {
            System.out.println("Failed to register member.");
        }
    }

    private static void login() {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.login(email, password)) {
            System.out.println("Login successful!");
            displayRoleMenu();
        } else {
            System.out.println("Login failed. Please check your email and password.");
        }
    }

    private static void displayRoleMenu() {
        User currentUser = authService.getCurrentUser();

        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        System.out.println("Welcome, " + currentUser.getName());
        switch (currentUser.getRole()) {
            case admin:
                displayAdminMenu();
                break;
            case gestionnaire:
                displayGestionnaireMenu();
                break;
            case member:
                displayMemberMenu();
                break;
            default:
                System.out.println("Unknown role.");
        }
    }

    private static void displayAdminMenu() {

        System.out.println("Admin Menu:");

    }

    private static void displayGestionnaireMenu() {

        System.out.println("Gestionnaire Menu:");

    }

    private static void displayMemberMenu() {

        System.out.println("Member Menu:");

    }
    }

