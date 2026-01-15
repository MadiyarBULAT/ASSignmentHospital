package model;

public class Nurse extends Person {

    private int patientsAssisted;

    public Nurse(int id, String name, int age,
                 int experienceYears, int patientsAssisted) {
        super(id, name, age, experienceYears);
        this.patientsAssisted = patientsAssisted;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name + " is assisting patients");
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public boolean isHeadNurse() {
        return patientsAssisted > 100;
    }
}
