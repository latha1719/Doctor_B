package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String doctorName;

    private String doctorImage;

    private String experience;

    private Double fee;

    @NotNull
    private LocalDate date;

    @NotBlank
    private String time;

    @NotBlank
    private String patientName;

    private String age;

    private String contact;

    @Column(columnDefinition = "TEXT")
    private String problem;

    private String paymentMethod;

    @Column(nullable = false)
    private String status = "Confirmed";

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Appointment() {
    }

    public Appointment(Long id, String doctorName, String doctorImage, String experience,
                       Double fee, LocalDate date, String time, String patientName,
                       String age, String contact, String problem, String paymentMethod,
                       String status, LocalDateTime createdAt, User user) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorImage = doctorImage;
        this.experience = experience;
        this.fee = fee;
        this.date = date;
        this.time = time;
        this.patientName = patientName;
        this.age = age;
        this.contact = contact;
        this.problem = problem;
        this.paymentMethod = paymentMethod;
        this.status = status != null ? status : "Confirmed";
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
        this.user = user;
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(String doctorImage) {
        this.doctorImage = doctorImage;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorName='" + doctorName + '\'' +
                ", doctorImage='" + doctorImage + '\'' +
                ", experience='" + experience + '\'' +
                ", fee=" + fee +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", patientName='" + patientName + '\'' +
                ", age='" + age + '\'' +
                ", contact='" + contact + '\'' +
                ", problem='" + problem + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", userId=" + (user != null ? user.getId() : null) +
                '}';
    }
}
