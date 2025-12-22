package org.example;

import java.util.ArrayList;

public class Doctor {
    private String name;
    private String specilization;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specilization) {
        this.name = name;
        this.specilization = specilization;
        this.patients = new ArrayList<>();
    }

    public void assignPateint(Patient pateint) {
        patients.add(pateint);
    }

    public void showPateints() {
        System.out.println("Doctor name: " + name + "(" + specilization + ")");
        for(Patient p : patients) {
            p.showInfo();
        }
    }
}