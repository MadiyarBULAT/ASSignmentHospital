package org.example;

import java.util.ArrayList;

public class Hospital {

    private String name;
    private String address;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;


    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }



    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showAllPatients() {
        System.out.println("All patients in " + name);
        for (Patient p : patients) {
            p.showInfo();
        }
    }

    public void showAllDoctors() {
        System.out.println("All doctors in " + name);
        for (Doctor d : doctors) {
            d.showPatients();
        }
    }

}
