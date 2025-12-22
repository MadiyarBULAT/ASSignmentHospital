package org.example;

import java.util.ArrayList;

public class Doctor {

    private String name;
    private String specialization;
    private ArrayList<Patient> patients;


    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }



    public void assignPatient(Patient patient) {
        patients.add(patient);
    }

    public void showPatients() {
        System.out.println("Doctor name: " + name + " (" + specialization + ")");
        for (Patient p : patients) {
            p.showInfo();
        }
    }
}
