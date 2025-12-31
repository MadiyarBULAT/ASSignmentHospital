public class Nurse extends Person {

    private int patientsAssisted;

    public Nurse(int id, String name, int age,
                 int experienceYears, int patientsAssisted) {
        super(id, name, age, experienceYears);
        this.patientsAssisted = patientsAssisted;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name +
                " is assisting patients.");
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public void assistPatient() {
        patientsAssisted++;
        System.out.println("Nurse " + name +
                " assisted a patient. Total: " + patientsAssisted);
    }

    public boolean isHeadNurse() {
        return patientsAssisted > 100;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Patients Assisted: " + patientsAssisted;
    }
}