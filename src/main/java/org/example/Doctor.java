public class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, int age,
                  int experienceYears, String specialization) {
        super(id, name, age, experienceYears);
        this.specialization = specialization;
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name +
                " is treating patients in " + specialization + ".");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public void treatPatient(String patientName) {
        System.out.println("Doctor " + name +
                " is treating patient " + patientName);
    }

    public boolean isSeniorDoctor() {
        return experienceYears >= 10;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Specialization: " + specialization;
    }
}
