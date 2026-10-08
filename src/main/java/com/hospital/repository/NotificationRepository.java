package com.hospital.repository;

import com.hospital.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByOrderBySentAtDesc();
    List<Notification> findByTarget(String target);
}
