package com.hospital.dto;

import jakarta.validation.constraints.NotBlank;

public class NotificationRequest {

    @NotBlank(message = "Target is required")
    private String target;

    @NotBlank(message = "Message is required")
    private String message;

    private String priority = "Normal";

    public NotificationRequest() {
    }

    public NotificationRequest(String target, String message) {
        this.target = target;
        this.message = message;
        this.priority = "Normal";
    }

    public NotificationRequest(String target, String message, String priority) {
        this.target = target;
        this.message = message;
        this.priority = priority != null ? priority : "Normal";
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

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "target='" + target + '\'' +
                ", message='" + message + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
