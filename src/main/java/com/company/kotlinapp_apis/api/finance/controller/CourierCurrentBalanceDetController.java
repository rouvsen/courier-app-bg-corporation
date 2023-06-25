package com.company.kotlinapp_apis.api.finance.controller;

import com.company.kotlinapp_apis.dto.finance.CourierCurrentBalanceDetDto;
import com.company.kotlinapp_apis.service.impl.finance.CourierCurrentBalanceDetImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courierCurrentBalanceDets")
public class CourierCurrentBalanceDetController {

    private final CourierCurrentBalanceDetImpl service;

    public CourierCurrentBalanceDetController(CourierCurrentBalanceDetImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CourierCurrentBalanceDetDto>> getAllCourierCurrentBalanceDets() {
        List<CourierCurrentBalanceDetDto> all = service.getAllCourierCurrentBalanceDets();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{detId}")
    public ResponseEntity<CourierCurrentBalanceDetDto> getCourierCurrentBalanceDetById(@PathVariable("detId") Long id) {
        CourierCurrentBalanceDetDto det = service.getCourierCurrentBalanceDetById(id);
        if (det != null) {
            return ResponseEntity.ok(det);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CourierCurrentBalanceDetDto> saveCourierCurrentBalanceDet(@RequestBody CourierCurrentBalanceDetDto dto) {
        CourierCurrentBalanceDetDto created = service.saveCourierCurrentBalanceDet(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{detId}")
    public ResponseEntity<String> deleteCourierCurrentBalanceDet(@PathVariable("detId") Long id) {
        Boolean deleted = service.deleteCourierCurrentBalanceDet(id);
        if (deleted) {
            return ResponseEntity.ok("CourierCurrentBalanceDet deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
