package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.model.LoginRequest;
import com.company.kotlinapp_apis.service.inter.admin.AdminServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/login")
public class AdminLoginController {

    private final AdminServiceInter adminService;

    public AdminLoginController(AdminServiceInter adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        AdminDto adminDto = adminService.findAdminByEmail(email);

        if (adminDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

        if(adminDto.getPassword().equals(password)) {
            return ResponseEntity.ok(adminDto);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }

}
