package com.hospital.repository;

import com.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<Appointment> findByStatus(String status);
    List<Appointment> findAllByOrderByCreatedAtDesc();
}
