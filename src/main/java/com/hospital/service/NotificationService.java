package com.hospital.service;

import com.hospital.dto.NotificationRequest;
import com.hospital.entity.Notification;
import com.hospital.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAllByOrderBySentAtDesc();
    }

    public Notification sendNotification(NotificationRequest request) {
        Notification notification = new Notification();
        notification.setType("Alert");
        notification.setTarget(request.getTarget());
        notification.setMessage(request.getMessage());
        notification.setPriority(request.getPriority());
        notification.setSentAt(LocalDateTime.now());
        return notificationRepository.save(notification);
    }
}
