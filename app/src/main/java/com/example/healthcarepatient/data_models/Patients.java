package com.example.healthcarepatient.data_models;

public class Patients {

    private String name;
    private Integer patient_image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPatient_image() {
        return patient_image;
    }

    public void setPatient_image(Integer patient_image) {
        this.patient_image = patient_image;
    }

    public Patients(String name, Integer patient_image) {
        this.name = name;
        this.patient_image = patient_image;
    }
}
