/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be1;
import java.io.*;
import java.util.*;
/**
 *
 * @author mac
 */
public class RegistrationManager {
    private List<Student> students = new ArrayList<>();

    
    public void newRegistration(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (findById(id) != null) {
            System.out.println("This ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Mountain Code: ");
        String mountain = sc.nextLine();

        double fee = 6000000;
        if (phone.startsWith("098") || phone.startsWith("097") || phone.startsWith("086")) {
            fee *= 0.65; // 35% discount
        }

        Student s = new Student(id, name, phone, email, mountain, fee);
        students.add(s);
        System.out.println("Registration added successfully!");
    }

    
    public void updateRegistration(Scanner sc) {
        System.out.print("Enter Student ID to update: ");
        String id = sc.nextLine();
        Student s = findById(id);
        if (s == null) {
            System.out.println("This student has not registered yet.");
            return;
        }

        System.out.print("New Name (Enter to keep old): ");
        String name = sc.nextLine();
        if (!name.isEmpty()) s.setName(name);

        System.out.print("New Phone (Enter to keep old): ");
        String phone = sc.nextLine();
        if (!phone.isEmpty()) s.setPhone(phone);

        System.out.print("New Email (Enter to keep old): ");
        String email = sc.nextLine();
        if (!email.isEmpty()) s.setEmail(email);

        System.out.print("New Mountain Code (Enter to keep old): ");
        String mountain = sc.nextLine();
        if (!mountain.isEmpty()) s.setMountainCode(mountain);

        System.out.println("Registration updated successfully!");
    }

    
    public void displayRegisteredList() {
        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }
        System.out.println("StudentID | Name           | Phone      | Peak | Fee");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    
    public void deleteRegistration(Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        Student s = findById(id);
        if (s == null) {
            System.out.println("This student has not registered yet.");
            return;
        }
        students.remove(s);
        System.out.println("The registration has been successfully deleted.");
    }


    public void searchByName(Scanner sc) {
        System.out.print("Enter full or partial name: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("No one matches the search criteria!");
    }
    
    
    private Student findById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) return s;
        }
        return null;
    }

    
    public void filterByCampus(Scanner sc) {
        System.out.print("Enter Campus Code (SE, HE, DE, QE, CE): ");
        String campus = sc.nextLine().toUpperCase();
        boolean found = false;
        for (Student s : students) {
            if (s.getStudentId().startsWith(campus)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("No students have registered under this campus.");
    }

 
    public void registrationStatistics() {
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> feeMap = new HashMap<>();
        for (Student s : students) {
            countMap.put(s.getMountainCode(),
                    countMap.getOrDefault(s.getMountainCode(), 0) + 1);
            feeMap.put(s.getMountainCode(),
                    feeMap.getOrDefault(s.getMountainCode(), 0.0) + s.getTuitionFee());
        }
        if (countMap.isEmpty()) {
            System.out.println("No data available for statistics.");
            return;
        }
        System.out.println("Peak Code | Participants | Total Fee");
        for (String mountain : countMap.keySet()) {
            System.out.printf("%-9s | %-12d | %.0f\n",
                    mountain, countMap.get(mountain), feeMap.get(mountain));
        }
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("registrations.txt"))) {
            for (Student s : students) {
                pw.println(s.getStudentId() + "," + s.getName() + "," +
                           s.getPhone() + "," + s.getEmail() + "," +
                           s.getMountainCode() + "," + s.getTuitionFee());
            }
            System.out.println("Registration data has been saved to registrations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
