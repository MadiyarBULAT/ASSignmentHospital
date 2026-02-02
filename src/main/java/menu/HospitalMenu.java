package menu;

import database.StaffDAO;
import model.*;

import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {

    private final StaffDAO staffDAO = new StaffDAO();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("""
            ===== HOSPITAL SYSTEM =====
            1. Add Doctor (INSERT)
            2. View All Staff (SELECT)
            3. Update Doctor
            4. Update Nurse
            5. Delete Staff
            6. Search by Name
            7. Search by Salary Range
            8. Search by Min Salary
            0. Exit
        """);
    }

    @Override
    public void run() {
        int choice = -1;

        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Enter number!");
                continue;
            }

            switch (choice) {
                case 1 -> addDoctor();        // INSERT
                case 2 -> viewAllStaff();    // SELECT
                case 3 -> updateDoctor();
                case 4 -> updateNurse();
                case 5 -> deleteStaff();
                case 6 -> searchByName();
                case 7 -> searchBySalaryRange();
                case 8 -> searchByMinSalary();
                case 0 -> System.out.println("Exit");
                default -> System.out.println("Wrong option");
            }
        } while (choice != 0);
    }

    // ================= INSERT =================
    private void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience years: ");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        Doctor doctor = new Doctor(0, name, salary, exp, spec);
        System.out.println(
                staffDAO.insertDoctor(doctor)
                        ? "Doctor added"
                        : "Insert failed"
        );
    }

    // ================= SELECT =================
    private void viewAllStaff() {
        List<Staff> list = staffDAO.getAllStaff();
        list.forEach(System.out::println);
    }

    // ================= UPDATE =================
    private void updateDoctor() {
        System.out.print("Doctor ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience years: ");
        int exp = Integer.parseInt(scanner.nextLine());

        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, salary, exp, spec);
        System.out.println(staffDAO.updateDoctor(doctor) ? "Updated" : "Failed");
    }

    private void updateNurse() {
        System.out.print("Nurse ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience years: ");
        int exp = Integer.parseInt(scanner.nextLine());

        Nurse nurse = new Nurse(id, name, salary, exp);
        System.out.println(staffDAO.updateNurse(nurse) ? "Updated" : "Failed");
    }

    // ================= DELETE =================
    private void deleteStaff() {
        System.out.print("Staff ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(staffDAO.deleteStaff(id) ? "Deleted" : "Not found");
    }

    // ================= SEARCH =================
    private void searchByName() {
        System.out.print("Name: ");
        staffDAO.searchByName(scanner.nextLine())
                .forEach(System.out::println);
    }

    private void searchBySalaryRange() {
        System.out.print("Min: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Max: ");
        double max = Double.parseDouble(scanner.nextLine());

        staffDAO.searchBySalaryRange(min, max)
                .forEach(System.out::println);
    }

    private void searchByMinSalary() {
        System.out.print("Min salary: ");
        double min = Double.parseDouble(scanner.nextLine());

        staffDAO.searchByMinSalary(min)
                .forEach(System.out::println);
    }
}

