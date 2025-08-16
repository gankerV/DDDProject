package com.example.DDDProject.controller;

import com.example.DDDProject.domain.entities.User;
import com.example.DDDProject.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> account) {
        String username = account.get("username");
        String password = account.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Username and password must be provided.");
        }

        User user = userService.getUserByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        }
        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password.");
        }
        return ResponseEntity.ok("Login successful for user: " + user.getUsername());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> account) {
        String username = account.get("username");
        String password = account.get("password");
        String confirmPassword = account.get("confirmPassword");

        if (username == null || password == null || confirmPassword == null) {
            return ResponseEntity.badRequest().body("Username, password, and confirm password must be provided.");
        }
        if (!password.equals(confirmPassword)) {
            return ResponseEntity.badRequest().body("Passwords do not match.");
        }
        if (userService.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists.");
        }

        User newUser = userService.createUser(username, password);
        return ResponseEntity.ok("Registration successful for user: " + newUser.getUsername());
    }
}
