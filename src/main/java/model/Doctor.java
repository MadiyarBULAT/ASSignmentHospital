package model;

public class Doctor extends Staff {

    private String specialization;

    public Doctor(int staffId, String name, double salary,
                  int experienceYears, String specialization) {
        super(staffId, name, salary, experienceYears);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String getRole() {
        return "DOCTOR";
    }
}
