package model;

public class Doctor extends Person implements Treatable {

    private String specialization;

    public Doctor(int id, String name, int age,
                  int experienceYears, String specialization) {
        super(id, name, age, experienceYears);
        setSpecialization(specialization);
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name +
                " is treating patients in " + specialization);
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    @Override
    public void treatPatient(String patientName) {
        System.out.println("Doctor " + name +
                " is treating patient " + patientName);
    }

    public boolean isSeniorDoctor() {
        return experienceYears >= 10;
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.trim().isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty");
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
