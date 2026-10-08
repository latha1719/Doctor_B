package com.hospital.dto;

import jakarta.validation.constraints.NotBlank;

public class AppointmentRequest {

    @NotBlank(message = "Doctor name is required")
    private String doctorName;

    private String doctorImage;
    private String experience;
    private Double fee;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Time is required")
    private String time;

    @NotBlank(message = "Patient name is required")
    private String patientName;

    private String age;
    private String contact;
    private String problem;
    private String paymentMethod;

    public AppointmentRequest() {
    }

    public AppointmentRequest(String doctorName, String doctorImage, String experience, Double fee,
                              String date, String time, String patientName, String age,
                              String contact, String problem, String paymentMethod) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    @Override
    public String toString() {
        return "AppointmentRequest{" +
                "doctorName='" + doctorName + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", patientName='" + patientName + '\'' +
                ", fee=" + fee +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
