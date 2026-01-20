package model;

public class Patient extends Person {

    private String disease;

    public Patient(int id, String name, int age, String disease) {
        super(id, name, age, 0);
        this.disease = disease;
    }

    @Override
    public void work() {
        System.out.println("Patient " + name + " is being treated");
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public String toString() {
        return super.toString() + ", Disease: " + disease;
    }
}
