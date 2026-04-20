package com.sprint.food_delivery.component;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    private static final Map<String, String> USERS = new HashMap<>();

    static {
        USERS.put("hemanth", "123456");
        USERS.put("kisol", "bob123");
        USERS.put("annie", "charlie123");
        USERS.put("thenmozli", "diana123");
        USERS.put("jeevitha", "eric123");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

        String username = request.get("username");
        String password = request.get("password");

        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("Missing credentials");
        }

        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
            Map<String, String> response = new HashMap<>();
            response.put("username", username);
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).body("Invalid username or password");
    }
}