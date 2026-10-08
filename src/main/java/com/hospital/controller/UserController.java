package com.hospital.controller;

import com.hospital.entity.User;
import com.hospital.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.getUsersByRole(User.Role.valueOf(role.toUpperCase())));
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getProfile(Authentication auth) {
        return ResponseEntity.ok(userService.getUserByEmail(auth.getName()));
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateProfile(Authentication auth, @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(userService.updateProfile(
            auth.getName(),
            body.get("fullName"),
            body.get("phone"),
            body.get("profileImage")
        ));
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String query) {
        return ResponseEntity.ok(userService.searchUsers(query));
    }
}
