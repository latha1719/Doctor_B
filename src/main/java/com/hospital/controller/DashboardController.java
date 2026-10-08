package com.hospital.controller;

import com.hospital.dto.DashboardStats;
import com.hospital.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/patient")
    public ResponseEntity<DashboardStats> getPatientStats(Authentication auth) {
        return ResponseEntity.ok(dashboardService.getPatientStats(auth.getName()));
    }

    @GetMapping("/admin")
    public ResponseEntity<DashboardStats> getAdminStats() {
        return ResponseEntity.ok(dashboardService.getAdminStats());
    }
}
