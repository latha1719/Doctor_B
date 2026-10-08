package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String specialization;

    @NotBlank
    private String experience;

    @Column(nullable = false)
    private Double fee = 500.0;

    private String image;

    @Column(nullable = false)
    private String status = "Active";

    private Integer appointments = 0;

    public Doctor() {
    }

    public Doctor(Long id, String name, String specialization, String experience,
                  Double fee, String image, String status, Integer appointments) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.fee = fee != null ? fee : 500.0;
        this.image = image;
        this.status = status != null ? status : "Active";
        this.appointments = appointments != null ? appointments : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAppointments() {
        return appointments;
    }

    public void setAppointments(Integer appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience='" + experience + '\'' +
                ", fee=" + fee +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
