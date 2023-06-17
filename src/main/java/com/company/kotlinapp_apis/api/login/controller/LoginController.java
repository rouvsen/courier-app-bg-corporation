package com.company.kotlinapp_apis.api.login.controller;

import com.company.kotlinapp_apis.api.login.model.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Perform authentication logic
        if (isValidCredentials(loginRequest.getUsername(), loginRequest.getPassword())) {
            return "valid";//redirect
        } else {
            // Return error message or status code
            return "invalid";
//                    ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Implement your own logic for validating credentials
        // Example: check against user database, external authentication service, etc.
        return username.equals("admin") && password.equals("password");
    }

}

