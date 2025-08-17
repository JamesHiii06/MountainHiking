/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package be1;
import java.util.Scanner;
/**
 *
 * @author mac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegistrationManager manager = new RegistrationManager();

        while (true) {
            System.out.println("\n=== MOUNTAIN HIKING CHALLENGE MENU ===");
            System.out.println("1. New Registration");
            System.out.println("2. Update Registration Information");
            System.out.println("3. Display Registered List");
            System.out.println("4. Delete Registration Information");
            System.out.println("5. Search Participants by Name");
            System.out.println("6. Filter Data by Campus");
            System.out.println("7. Statistics of Registration Numbers by Location");
            System.out.println("8. Save Data to File");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": manager.newRegistration(sc); break;
                case "2": manager.updateRegistration(sc); break;
                case "3": manager.displayRegisteredList(); break;
                case "4": manager.deleteRegistration(sc); break;
                case "5": manager.searchByName(sc); break;
                case "6": manager.filterByCampus(sc); break;
                case "7": manager.registrationStatistics(); break;
                case "8": manager.saveToFile(); break;
                case "9": 
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
    
}
