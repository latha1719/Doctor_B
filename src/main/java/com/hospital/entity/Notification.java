package com.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type = "Alert";

    @Column(nullable = false)
    private String target;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    private String priority = "Normal";

    @Column(updatable = false)
    private LocalDateTime sentAt = LocalDateTime.now();

    public Notification() {
    }

    public Notification(Long id, String type, String target, String message,
                        String priority, LocalDateTime sentAt) {
        this.id = id;
        this.type = type != null ? type : "Alert";
        this.target = target;
        this.message = message;
        this.priority = priority != null ? priority : "Normal";
        this.sentAt = sentAt != null ? sentAt : LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (this.sentAt == null) {
            this.sentAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", target='" + target + '\'' +
                ", message='" + message + '\'' +
                ", priority='" + priority + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
