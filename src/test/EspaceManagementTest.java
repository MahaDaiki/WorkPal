package test;

import services.Implementation.AuthetificationServiceImpl;
import services.Implementation.EspaceServiceImpl;
import services.Implementation.GestionnairedespaceServiceImpl;
import services.Interfaces.AuthentificationService;
import services.Interfaces.EspaceService;
import entities.Espace;
import entities.User;
import services.Interfaces.GestionnaireDespacesService;

import java.util.List;
import java.util.Scanner;

public class EspaceManagementTest {
    private static final EspaceService espaceService = new EspaceServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthentificationService authService = new AuthetificationServiceImpl();
    private static final GestionnaireDespacesService gestionnaireRepo = new GestionnairedespaceServiceImpl();

    public static void main(String[] args) {
        // Retrieve user and gestionnaire ID once in main()
        int userId = authService.getCurrentUser().getUser_id();
        int gestionnaireId = gestionnaireRepo.getGestionnaireIdByUserId(userId);

        // Check if the gestionnaireId is valid
        if (gestionnaireId == -1) {
            System.out.println("Error: No gestionnaire found for the current user.");
            return;
        }

        // Display the espace menu
        displayEspaceMenu(gestionnaireId);
    }

    public static void displayEspaceMenu(int gestionnaireId) {
        User currentUser = authService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("No user is currently logged in.");
            return;
        }

        List<Espace> espaces = espaceService.getEspacesByGestionnaireId(gestionnaireId);

        System.out.println("Available Espaces:");
        int index = 1;
        for (Espace espace : espaces) {
            System.out.println(index + ". " + espace.getName());
            index++;
        }

        System.out.println("\n1. Add Espace");
        System.out.println("2. Modify Espace");
        System.out.println("3. Delete Espace");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (choice) {
            case 1:
                addEspace(gestionnaireId);
                break;
            case 2:
                modifyEspace(espaces, gestionnaireId);
                break;
            case 3:
                deleteEspace(espaces, gestionnaireId);
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addEspace(int gestionnaireId) {
        System.out.println("Enter Espace Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Espace Type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Espace Size: ");
        String taille = scanner.nextLine();

        // Create a new Espace object with the gestionnaireId
        Espace newEspace = new Espace(name, type, true, taille, gestionnaireId);

        if (espaceService.addEspace(newEspace, gestionnaireId)) {
            System.out.println("Espace added successfully.");
        } else {
            System.out.println("Failed to add Espace.");
        }
    }

    private static void modifyEspace(List<Espace> espaces, int gestionnaireId) {
        System.out.println("Select the Espace to modify:");
        int selectedEspace = scanner.nextInt();
        scanner.nextLine();

        if (selectedEspace < 1 || selectedEspace > espaces.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Espace espaceToModify = espaces.get(selectedEspace - 1);

        System.out.println("Enter new name (current: " + espaceToModify.getName() + "): ");
        String newName = scanner.nextLine();
        System.out.println("Enter new type (current: " + espaceToModify.getType() + "): ");
        String newType = scanner.nextLine();
        System.out.println("Enter new size (current: " + espaceToModify.getTaille() + "): ");
        String newSize = scanner.nextLine();

        espaceToModify.setName(newName);
        espaceToModify.setType(newType);
        espaceToModify.setTaille(newSize);

        if (espaceService.updateEspace(espaceToModify, gestionnaireId)) {
            System.out.println("Espace updated successfully.");
        } else {
            System.out.println("Failed to update Espace.");
        }
    }

    private static void deleteEspace(List<Espace> espaces, int gestionnaireId) {
        System.out.println("Select the Espace to delete:");
        int selectedEspace = scanner.nextInt();
        scanner.nextLine();

        if (selectedEspace < 1 || selectedEspace > espaces.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Espace espaceToDelete = espaces.get(selectedEspace - 1);

        if (espaceService.deleteEspace(espaceToDelete.getEspace_id(), gestionnaireId)) {
            System.out.println("Espace deleted successfully.");
        } else {
            System.out.println("Failed to delete Espace.");
        }
    }
}
