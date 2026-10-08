package com.hospital.service;

import com.hospital.dto.DashboardStats;
import com.hospital.entity.Appointment;
import com.hospital.entity.User;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DashboardService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public DashboardService(AppointmentRepository appointmentRepository,
                            DoctorRepository doctorRepository,
                            UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    public DashboardStats getPatientStats(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        List<Appointment> appointments = appointmentRepository.findByUserIdOrderByCreatedAtDesc(user.getId());
        LocalDate today = LocalDate.now();
        long upcoming = appointments.stream().filter(a -> a.getDate() != null && !a.getDate().isBefore(today)).count();
        long past = appointments.stream().filter(a -> a.getDate() != null && a.getDate().isBefore(today)).count();
        double totalSpend = appointments.stream().mapToDouble(a -> a.getFee() != null ? a.getFee() : 0).sum();

        DashboardStats stats = new DashboardStats();
        stats.setUpcoming(upcoming);
        stats.setPast(past);
        stats.setTotalSpend(totalSpend);
        return stats;
    }

    public DashboardStats getAdminStats() {
        DashboardStats stats = new DashboardStats();
        stats.setTotalDoctors(doctorRepository.count());
        stats.setTotalPatients(userRepository.findByRole(User.Role.PATIENT).size());
        stats.setTotalAppointments(appointmentRepository.count());
        List<Appointment> all = appointmentRepository.findAll();
        double revenue = all.stream().mapToDouble(a -> a.getFee() != null ? a.getFee() : 0).sum();
        stats.setTotalRevenue(revenue);
        LocalDate today = LocalDate.now();
        stats.setUpcoming(all.stream().filter(a -> a.getDate() != null && !a.getDate().isBefore(today)).count());
        stats.setPast(all.stream().filter(a -> a.getDate() != null && a.getDate().isBefore(today)).count());
        return stats;
    }
}
