package menu;

import database.StaffDAO;
import model.*;

import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {

    private final StaffDAO staffDAO = new StaffDAO();
    private final Scanner scanner = new Scanner(System.in);

    //      MENU DISPLAY
    @Override
    public void displayMenu() {
        System.out.println("""
            ===== HOSPITAL SYSTEM =====
            1. Add Doctor
            2. Add Patient
            3. Add Appointment
            4. View All People
            5. Demonstrate Polymorphism
            6. Show Specific Information
            7. View All Appointments
            8. Update Doctor
            9. Update Nurse
            10. Delete Staff
            11. Search Staff by Name
            12. Search Staff by Salary Range
            13. Search Staff by Min Salary
            0. Exit
        """);
    }

    //       MAIN LOOP
    @Override
    public void run() {
        int choice = -1;

        do {
            displayMenu();

            String input = scanner.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            switch (choice) {
                case 1 -> addDoctor();                 // заглушка
                case 2 -> addPatient();                // заглушка
                case 3 -> addAppointment();            // заглушка
                case 4 -> viewAllPeople();             // заглушка
                case 5 -> demonstratePolymorphism();   // заглушка
                case 6 -> showSpecificInformation();   // заглушка
                case 7 -> viewAllAppointments();       // заглушка

                case 8 -> updateDoctor();              // ✅ есть
                case 9 -> updateNurse();               // ✅ добавили
                case 10 -> deleteStaff();              // ✅ есть
                case 11 -> searchByName();             // ✅ есть
                case 12 -> searchBySalaryRange();      // ✅ есть
                case 13 -> searchByMinSalary();        // ✅ добавили

                case 0 -> System.out.println("Exit");
                default -> System.out.println("Invalid option");
            }

        } while (choice != 0);
    }

    //      JDBC / DAO PART

    private void updateDoctor() {
        System.out.print("Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Experience years: ");
        int exp = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, salary, exp, spec);
        boolean success = staffDAO.updateDoctor(doctor);

        System.out.println(success ? "Doctor updated successfully" : "Update failed");
    }

    //          Update Nurse
    private void updateNurse() {
        System.out.print("Nurse ID: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Experience years: ");
        int exp = Integer.parseInt(scanner.nextLine().trim());

        Nurse nurse = new Nurse(id, name, salary, exp);
        boolean success = staffDAO.updateNurse(nurse);

        System.out.println(success ? "Nurse updated successfully" : "Update failed");
    }

    private void deleteStaff() {
        System.out.print("Staff ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine().trim();

        if (confirm.equalsIgnoreCase("yes")) {
            boolean success = staffDAO.deleteStaff(id);
            System.out.println(success ? "Staff deleted" : "Staff not found");
        } else {
            System.out.println("Deletion cancelled");
        }
    }

    private void searchByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        List<Staff> staffList = staffDAO.searchByName(name);
        staffList.forEach(System.out::println);
    }

    private void searchBySalaryRange() {
        System.out.print("Min salary: ");
        double min = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Max salary: ");
        double max = Double.parseDouble(scanner.nextLine().trim());

        List<Staff> staffList = staffDAO.searchBySalaryRange(min, max);
        staffList.forEach(System.out::println);
    }

    //   : Search by Min Salary
    private void searchByMinSalary() {
        System.out.print("Min salary: ");
        double minSalary = Double.parseDouble(scanner.nextLine().trim());

        List<Staff> staffList = staffDAO.searchByMinSalary(minSalary);
        staffList.forEach(System.out::println);
    }

    //      placeholders

    private void addDoctor() {
        System.out.println("Add Doctor (OOP part / optional)");
    }

    private void addPatient() {
        System.out.println("Add Patient (OOP part / optional)");
    }

    private void addAppointment() {
        System.out.println("Add Appointment (OOP part / optional)");
    }

    private void viewAllPeople() {
        System.out.println("View All People (OOP part / optional)");
    }

    private void demonstratePolymorphism() {
        System.out.println("Polymorphism demo (OOP part / optional)");
    }

    private void showSpecificInformation() {
        System.out.println("Show specific info (OOP part / optional)");
    }

    private void viewAllAppointments() {
        System.out.println("View all appointments (OOP part / optional)");
    }
}


