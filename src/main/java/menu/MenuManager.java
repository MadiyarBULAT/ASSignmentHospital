package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Person> staff = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        staff.add(new Doctor(1, "Murat", 45, 12, "Cardiology"));
        staff.add(new Nurse(2, "Dana", 30, 4, 120));
    }

    @Override
    public void displayMenu() {
        System.out.println("""
                ===== HOSPITAL SYSTEM =====
                1. View Staff
                2. Polymorphism Demo
                0. Exit
                """);
    }

    @Override
    public void run() {
        int choice;
        do {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> viewAll();
                    case 2 -> demonstratePolymorphism();
                    case 0 -> System.out.println("Exit");
                    default -> System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number!");
                choice = -1;
            }
        } while (choice != 0);
    }

    private void viewAll() {
        for (Person p : staff) {
            System.out.println(p);
        }
    }

    private void demonstratePolymorphism() {
        for (Person p : staff) {
            p.work();
        }
    }
}
