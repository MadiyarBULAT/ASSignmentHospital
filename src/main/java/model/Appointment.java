package model;

public class Appointment {

    private Doctor doctor;
    private Patient patient;

    public Appointment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public void showInfo() {
        System.out.println("Appointment: Doctor " +
                doctor.getName() + " ↔ Patient " + patient.getName());
    }
}
