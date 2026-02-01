package model;

public class Nurse extends Staff {

    public Nurse(int staffId, String name, double salary, int experienceYears) {
        super(staffId, name, salary, experienceYears);
    }

    @Override
    public String getRole() {
        return "NURSE";
    }
}
