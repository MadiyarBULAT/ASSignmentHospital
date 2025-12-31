import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Person> hospitalStaff = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        hospitalStaff.add(new Person(1, "Aibek", 40, 6));
        hospitalStaff.add(new Doctor(2, "Murat", 45, 12, "Cardiology"));
        hospitalStaff.add(new Nurse(3, "Dana", 30, 4, 80));

        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add General Staff");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Nurse");
            System.out.println("4. View All Staff");
            System.out.println("5. Demonstrate Polymorphism");
            System.out.println("6. View Doctors Only");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStaff();
                case 2 -> addDoctor();
                case 3 -> addNurse();
                case 4 -> viewAll();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewDoctors();
            }

        } while (choice != 0);
    }

    private static void addStaff() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt();

        hospitalStaff.add(new Person(id, name, age, exp));
    }

    private static void addDoctor() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Specialization: ");
        String spec = scanner.nextLine();

        hospitalStaff.add(new Doctor(id, name, age, exp, spec));
    }

    private static void addNurse() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Experience years: ");
        int exp = scanner.nextInt();
        System.out.print("Patients assisted: ");
        int patients = scanner.nextInt();

        hospitalStaff.add(new Nurse(id, name, age, exp, patients));
    }

    private static void viewAll() {
        for (Person p : hospitalStaff) {
            System.out.println(p);

            if (p instanceof Doctor doctor && doctor.isSeniorDoctor()) {
                System.out.println("   ⭐ Senior Doctor");
            }
            if (p instanceof Nurse nurse && nurse.isHeadNurse()) {
                System.out.println("   ⭐ Head Nurse");
            }
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Person p : hospitalStaff) {
            p.work();
        }
    }

    private static void viewDoctors() {
        for (Person p : hospitalStaff) {
            if (p instanceof Doctor doctor) {
                System.out.println(doctor.getName() +
                        " - " + doctor.getSpecialization());
            }
        }
    }
}