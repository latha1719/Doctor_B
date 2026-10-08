package com.hospital.dto;

import jakarta.validation.constraints.NotBlank;

public class DoctorRequest {

    @NotBlank(message = "Doctor name is required")
    private String name;

    @NotBlank(message = "Specialization is required")
    private String specialization;

    private String experience;
    private Double fee;
    private String image;

    public DoctorRequest() {
    }

    public DoctorRequest(String name, String specialization, String experience, Double fee, String image) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.fee = fee;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "DoctorRequest{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience='" + experience + '\'' +
                ", fee=" + fee +
                '}';
    }
}
