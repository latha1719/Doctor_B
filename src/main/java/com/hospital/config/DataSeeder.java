package com.hospital.config;

import com.hospital.entity.Doctor;
import com.hospital.entity.User;
import com.hospital.repository.DoctorRepository;
import com.hospital.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataSeeder.class);

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(DoctorRepository doctorRepository,
                      UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        seedDoctors();
        seedAdminUser();
    }

    private void seedDoctors() {
        if (doctorRepository.count() == 0) {
            log.info("Seeding initial doctors data...");
            List<Doctor> doctors = List.of(
                createDoctor("Dr. Vikram Malhotra", "Cardiology", "15+ years", 600.0,
                    "https://images.unsplash.com/photo-1537368910025-700350fe46c7?auto=format&fit=crop&q=80&w=1000"),
                createDoctor("Dr. Sneha Verma", "Dermatology", "12+ years", 500.0,
                    "https://images.unsplash.com/photo-1594824476967-48c8b964273f?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Rohan Desai", "Neurosurgery", "18+ years", 800.0,
                    "https://images.unsplash.com/photo-1622253692010-333f2da6031d?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Ananya Singh", "Pediatrics", "10+ years", 450.0,
                    "https://images.unsplash.com/photo-1551836022-d5d88e9218df?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Arjun Sharma", "Orthopedics", "14+ years", 550.0,
                    "https://images.unsplash.com/photo-1622253692010-333f2da6031d?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Priya Patel", "Ophthalmology", "9+ years", 400.0,
                    "https://images.unsplash.com/photo-1594824476967-48c8b964273f?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Sameer Reddy", "Gastroenterology", "11+ years", 650.0,
                    "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Kavita Iyer", "Gynecology", "16+ years", 700.0,
                    "https://images.unsplash.com/photo-1551836022-d5d88e9218df?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Amit Bansal", "Urology", "7+ years", 500.0,
                    "https://images.unsplash.com/photo-1582750433449-648ed127bb54?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Ritu Kapoor", "Psychiatry", "13+ years", 900.0,
                    "https://images.unsplash.com/photo-1527613426441-4da17471b66d?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Rajesh Khanna", "General Medicine", "20+ years", 500.0,
                    "https://images.unsplash.com/photo-1550831107-1553da8c8464?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Sunita Rao", "ENT Specialist", "8+ years", 450.0,
                    "https://plus.unsplash.com/premium_photo-1661764878654-3d0fc2eefcca?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Mani Shankar", "Pulmonologist", "11+ years", 600.0,
                    "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Lakshmi Menon", "Endocrinologist", "9+ years", 550.0,
                    "https://images.unsplash.com/photo-1594824476967-48c8b964273f?auto=format&fit=crop&q=80&w=800"),
                createDoctor("Dr. Varun Joshi", "Dentist", "6+ years", 350.0,
                    "https://images.unsplash.com/photo-1537368910025-700350fe46c7?auto=format&fit=crop&q=80&w=800")
            );
            doctorRepository.saveAll(doctors);
            log.info("Successfully seeded 15 doctors.");
        } else {
            log.info("Doctors table is not empty, skipping seeding.");
        }
    }

    private void seedAdminUser() {
        if (userRepository.count() == 0) {
            log.info("Seeding admin user...");
            User admin = new User();
            admin.setFullName("Admin");
            admin.setEmail("admin@yash.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(User.Role.ADMIN);
            admin.setPhone("1234567890");
            admin.setStatus("Active");
            userRepository.save(admin);
            log.info("Successfully created admin user: admin@yash.com");
        } else {
            log.info("Users table is not empty, skipping admin user seeding.");
        }
    }

    private Doctor createDoctor(String name, String specialization, String experience, Double fee, String image) {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setExperience(experience);
        doctor.setFee(fee);
        doctor.setImage(image);
        doctor.setStatus("Active");
        doctor.setAppointments(0);
        return doctor;
    }
}
