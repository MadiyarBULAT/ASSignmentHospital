package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

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
            0. Exit
        """);
    }

    @Override
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> addPatient();
                case 3 -> addAppointment();
                case 4 -> viewAllPeople();
                case 5 -> demonstratePolymorphism();
                case 6 -> showSpecificInfo();
                case 7 -> viewAppointments();
                case 0 -> System.out.println("Exit");
            }
        } while (choice != 0);
    }

    private void addDoctor() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Experience: ");
        int exp = Integer.parseInt(scanner.nextLine());
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        people.add(new Doctor(people.size()+1, name, age, exp, spec));
    }

    private void addPatient() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Disease: ");
        String disease = scanner.nextLine();

        people.add(new Patient(people.size()+1, name, age, disease));
    }

    private void addAppointment() {
        Doctor doctor = null;
        Patient patient = null;

        for (Person p : people) {
            if (p instanceof Doctor && doctor == null)
                doctor = (Doctor) p;
            if (p instanceof Patient && patient == null)
                patient = (Patient) p;
        }

        if (doctor != null && patient != null) {
            appointments.add(new Appointment(doctor, patient));
            System.out.println("Appointment created!");
        } else {
            System.out.println("Need doctor and patient!");
        }
    }

    private void viewAllPeople() {
        people.forEach(System.out::println);
    }

    private void demonstratePolymorphism() {
        for (Person p : people) {
            p.work(); // ПОЛИМОРФИЗМ
        }
    }

    private void showSpecificInfo() {
        for (Person p : people) {
            if (p instanceof Doctor d) {
                System.out.println(d.getName() +
                        " senior: " + d.isSeniorDoctor());
            }
            if (p instanceof Nurse n) {
                System.out.println(n.getName() +
                        " head nurse: " + n.isHeadNurse());
            }
        }
    }

    private void viewAppointments() {
        for (Appointment a : appointments) {
            a.showInfo();
        }
    }
}










/*
package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class

MenuManager implements Menu {

    private ArrayList<Person> staff = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuManager() {

        staff.add(new Doctor(1,"Murat",50,12,"Cardiology"));
        staff.add(new Nurse(2,"Dana",27,3,120));
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

 */




