package test;

import entities.SuplService;
import services.Implementation.AuthetificationServiceImpl;
import services.Implementation.GestionnairedespaceServiceImpl;
import services.Implementation.SuplserviceServiceImpl;
import services.Interfaces.AuthentificationService;
import services.Interfaces.GestionnaireDespacesService;

import java.util.List;
import java.util.Scanner;

public class SuplserviceTest {


    private static final Scanner scanner = new Scanner(System.in);
    private static final AuthentificationService authService = new AuthetificationServiceImpl();
    private static final GestionnaireDespacesService gestionnaireRepo = new GestionnairedespaceServiceImpl();
    private static final SuplserviceServiceImpl suplservice =new SuplserviceServiceImpl();

    public static void main(String[] args) {

        int userId = authService.getCurrentUser().getUser_id();
        int gestionnaireId = gestionnaireRepo.getGestionnaireIdByUserId(userId);

        if (gestionnaireId == -1) {
            System.out.println("Error: No gestionnaire found for the current user.");
            return;
        }

        displaySuplServiceMenu(gestionnaireId);
    }

    static void displaySuplServiceMenu(int gestionnaireId) {
        while (true) {
            displayAllSuplservices(gestionnaireId);
            System.out.println("\n---- Gestionnaire Suplservice Menu ----");
            System.out.println("1. Add Suplservice");
            System.out.println("2. Modify Suplservice");
            System.out.println("3. Delete Suplservice");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSuplservice(gestionnaireId);
                    break;
                case 2:
                    modifySuplservice(gestionnaireId);
                    break;
                case 3:
                    deleteSuplservice(gestionnaireId);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSuplservice(int gestionnaireId) {
        System.out.println("Enter Suplservice Type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Suplservice Details: ");
        String details = scanner.nextLine();
        System.out.println("Enter Suplservice Price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        SuplService newSuplservice = new SuplService(0,type, details, price, gestionnaireId);

        if (suplservice.addSuplservice(newSuplservice)) {
            System.out.println("Suplservice added successfully.");
        } else {
            System.out.println("Failed to add Suplservice.");
        }
    }

    private static void modifySuplservice(int gestionnaireId) {
        displayAllSuplservices(gestionnaireId);

        System.out.println("Enter the ID of the Suplservice you want to modify: ");
        int suplserviceId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        SuplService suplserviceToModify = suplservice.getSuplserviceById(suplserviceId);

        if (suplserviceToModify == null) {
            System.out.println("Suplservice not found.");
            return;
        }

        System.out.println("Enter new Suplservice Type (current: " + suplserviceToModify.getType() + "): ");
        String newType = scanner.nextLine();
        System.out.println("Enter new Suplservice Details (current: " + suplserviceToModify.getDetails() + "): ");
        String newDetails = scanner.nextLine();
        System.out.println("Enter new Suplservice Price (current: " + suplserviceToModify.getPrix() + "): ");
        int newPrice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        suplserviceToModify.setType(newType);
        suplserviceToModify.setDetails(newDetails);
        suplserviceToModify.setPrix(newPrice);

        if (suplservice.updateSuplservice(suplserviceToModify, gestionnaireId)) {
            System.out.println("Suplservice updated successfully.");
        } else {
            System.out.println("Failed to update Suplservice.");
        }
    }

    private static void deleteSuplservice(int gestionnaireId) {
        displayAllSuplservices(gestionnaireId);

        System.out.println("Enter the ID of the Suplservice you want to delete: ");
        int suplserviceId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (suplservice.deleteSuplservice(suplserviceId, gestionnaireId)) {
            System.out.println("Suplservice deleted successfully.");
        } else {
            System.out.println("Failed to delete Suplservice.");
        }
    }

    private static void displayAllSuplservices(int gestionnaireId) {
        List<SuplService> suplservices = suplservice.getSuplservicesByGestionnaireId(gestionnaireId);

        if (suplservices.isEmpty()) {
            System.out.println("No Suplservices found.");
            return;
        }

        System.out.println("\n--- List of Suplservices ---");
        for (SuplService suplservice : suplservices) {
            System.out.println(suplservice);
        }
    }
}
