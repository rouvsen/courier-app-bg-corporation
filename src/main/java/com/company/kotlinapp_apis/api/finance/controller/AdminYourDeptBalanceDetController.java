package com.company.kotlinapp_apis.api.finance.controller;

import com.company.kotlinapp_apis.dto.finance.AdminYourDeptBalanceDetDto;
import com.company.kotlinapp_apis.service.impl.finance.AdminYourDeptBalanceDetImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adminYourDeptBalanceDets")
public class AdminYourDeptBalanceDetController {

    private final AdminYourDeptBalanceDetImpl service;

    public AdminYourDeptBalanceDetController(AdminYourDeptBalanceDetImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdminYourDeptBalanceDetDto>> getAllAdminYourDeptBalanceDet() {
        List<AdminYourDeptBalanceDetDto> all = service.getAllAdminYourDeptBalanceDets();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<AdminYourDeptBalanceDetDto> getAdminYourDeptBalanceDetById(@PathVariable("detId") Long id) {
        AdminYourDeptBalanceDetDto det = service.getAdminYourDeptBalanceDetById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminYourDeptBalanceDetDto> saveAdminYourDeptBalanceDet(@RequestBody AdminYourDeptBalanceDetDto dto) {
        AdminYourDeptBalanceDetDto created = service.saveAdminYourDeptBalanceDet(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminYourDeptBalanceDet(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteAdminYourDeptBalanceDet(id);
        if (deleted) {
            return ResponseEntity.ok("AdminYourDeptBalanceDet deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
