package com.hospital.service;

import com.hospital.dto.DoctorRequest;
import com.hospital.entity.Doctor;
import com.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    public List<Doctor> searchDoctors(String query) {
        return doctorRepository.findByNameContainingIgnoreCaseOrSpecializationContainingIgnoreCase(query, query);
    }

    public Doctor addDoctor(DoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setSpecialization(request.getSpecialization());
        doctor.setExperience(request.getExperience() != null ? request.getExperience() : "0 years");
        doctor.setFee(request.getFee() != null ? request.getFee() : 500.0);
        doctor.setImage(request.getImage() != null ? request.getImage() : "https://via.placeholder.com/150");
        doctor.setStatus("Active");
        doctor.setAppointments(0);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, DoctorRequest request) {
        Doctor doctor = getDoctorById(id);
        if (request.getName() != null) doctor.setName(request.getName());
        if (request.getSpecialization() != null) doctor.setSpecialization(request.getSpecialization());
        if (request.getExperience() != null) doctor.setExperience(request.getExperience());
        if (request.getFee() != null) doctor.setFee(request.getFee());
        if (request.getImage() != null) doctor.setImage(request.getImage());
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        doctorRepository.deleteById(id);
    }
}
