package com.company.kotlinapp_apis.api.finance.controller;

import com.company.kotlinapp_apis.dto.finance.AdminCurrentBalanceDetDto;
import com.company.kotlinapp_apis.service.impl.finance.AdminCurrentBalanceDetImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/adminCurrentBalanceDets")
public class AdminCurrentBalanceDetController {

    private final AdminCurrentBalanceDetImpl service;

    public AdminCurrentBalanceDetController(AdminCurrentBalanceDetImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AdminCurrentBalanceDetDto>> getAllAdminCurrentBalanceDet() {
        List<AdminCurrentBalanceDetDto> all = service.getAllAdminCurrentBalanceDets();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<AdminCurrentBalanceDetDto> getAdminCurrentBalanceDetById(@PathVariable("detId") Long id) {
        AdminCurrentBalanceDetDto det = service.getAdminCurrentBalanceDetById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AdminCurrentBalanceDetDto> saveAdminCurrentBalanceDet(@RequestBody AdminCurrentBalanceDetDto dto) {
        AdminCurrentBalanceDetDto created = service.saveAdminCurrentBalanceDet(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteAdminCurrentBalanceDet(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteAdminCurrentBalanceDet(id);
        if (deleted) {
            return ResponseEntity.ok("AdminCurrentBalanceDet deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }

}
