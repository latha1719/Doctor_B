package com.hospital.service;

import com.hospital.dto.AppointmentRequest;
import com.hospital.entity.Appointment;
import com.hospital.entity.User;
import com.hospital.repository.AppointmentRepository;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAllByOrderByCreatedAtDesc();
    }

    public List<Appointment> getUserAppointments(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return appointmentRepository.findByUserIdOrderByCreatedAtDesc(user.getId());
    }

    public Appointment createAppointment(AppointmentRequest request, String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Appointment appointment = new Appointment();
        appointment.setDoctorName(request.getDoctorName());
        appointment.setDoctorImage(request.getDoctorImage());
        appointment.setExperience(request.getExperience());
        appointment.setFee(request.getFee());
        appointment.setDate(LocalDate.parse(request.getDate()));
        appointment.setTime(request.getTime());
        appointment.setPatientName(request.getPatientName());
        appointment.setAge(request.getAge());
        appointment.setContact(request.getContact());
        appointment.setProblem(request.getProblem());
        appointment.setPaymentMethod(request.getPaymentMethod());
        appointment.setStatus("Confirmed");
        appointment.setCreatedAt(LocalDateTime.now());
        appointment.setUser(user);

        return appointmentRepository.save(appointment);
    }

    public Appointment updateStatus(Long id, String status) {
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found");
        }
        appointmentRepository.deleteById(id);
    }
}
