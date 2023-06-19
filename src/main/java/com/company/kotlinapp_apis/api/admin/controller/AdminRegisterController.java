package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.service.impl.admin.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminRegisterController {

    private final AdminServiceImpl adminServiceImpl;

    public AdminRegisterController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        return adminServiceImpl.createAdmin(adminDto);
    }

    //LIST
    @GetMapping
    public List<AdminDto> getAllAdmins(){
        return adminServiceImpl.getAllAdmins();
    }

}
