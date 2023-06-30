package com.company.kotlinapp_apis.api.admin.controller;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.service.impl.admin.AdminServiceImpl;
import org.springframework.http.HttpStatus;
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

    //ID
    @GetMapping("/{adminID}")
    public ResponseEntity<?> getAdminById(@PathVariable("adminID") Long adminId){
        AdminDto admin = adminServiceImpl.getAdminById(adminId);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("admin doesn't exist with given id..");
    }

    //UPDATE
    @PutMapping("/{adminId}")
    public ResponseEntity<?> updateAdmin(
            @PathVariable("adminId") Long id,
            @RequestBody AdminDto adminDto) {
        AdminDto updatedAdmin = adminServiceImpl.updateAdmin(id, adminDto);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        }
        return ResponseEntity.notFound().build();
    }

    //DELETE
    @DeleteMapping("/{adminId}")
    public ResponseEntity<?> deleteAdminById(@PathVariable("adminId") Long adminId) {
        boolean deleted = adminServiceImpl.deleteAdmin(adminId);
        if (deleted) {
            return ResponseEntity.ok("Admin deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
