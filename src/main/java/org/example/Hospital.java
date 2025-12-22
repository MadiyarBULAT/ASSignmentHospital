package org.example;

import java.util.ArrayList;

public class Hospital
{
    private String name;
    private String adress;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name, String address) {
        this.name = name;
        this.adress = adress;
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showAllPatients()
    {
        System.out.println("All patients in " + name + " ");
        for(Patient p : patients)
        {
            p.showInfo();
        }
    }

    public void showAllDoctors(){
        System.out.println("All doctors in " + name + " ");
        for (Doctor d : doctors)
        {
            d.showPateints();
        }
    }
}