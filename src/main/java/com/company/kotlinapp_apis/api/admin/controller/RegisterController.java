package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.service.impl.admin.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admins")
public class RegisterController {

    private final AdminServiceImpl adminServiceImpl;

    public RegisterController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }


    //CREATE
    @PostMapping("/admins")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        return adminServiceImpl.createAdmin(adminDto);
    }

    //LIST
    @GetMapping("/admins")
    public List<AdminDto> getAllAdmins(){
        return adminServiceImpl.getAllAdmins();
    }

}
