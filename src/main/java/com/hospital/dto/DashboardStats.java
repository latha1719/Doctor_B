package com.hospital.dto;

public class DashboardStats {
    private long upcoming;
    private long past;
    private double totalSpend;
    private long totalDoctors;
    private long totalPatients;
    private long totalAppointments;
    private double totalRevenue;

    public DashboardStats() {
    }

    public DashboardStats(long upcoming, long past, double totalSpend, long totalDoctors,
                          long totalPatients, long totalAppointments, double totalRevenue) {
        this.upcoming = upcoming;
        this.past = past;
        this.totalSpend = totalSpend;
        this.totalDoctors = totalDoctors;
        this.totalPatients = totalPatients;
        this.totalAppointments = totalAppointments;
        this.totalRevenue = totalRevenue;
    }

    public long getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(long upcoming) {
        this.upcoming = upcoming;
    }

    public long getPast() {
        return past;
    }

    public void setPast(long past) {
        this.past = past;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public long getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(long totalDoctors) {
        this.totalDoctors = totalDoctors;
    }

    public long getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(long totalPatients) {
        this.totalPatients = totalPatients;
    }

    public long getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(long totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "DashboardStats{" +
                "upcoming=" + upcoming +
                ", past=" + past +
                ", totalSpend=" + totalSpend +
                ", totalDoctors=" + totalDoctors +
                ", totalPatients=" + totalPatients +
                ", totalAppointments=" + totalAppointments +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}
