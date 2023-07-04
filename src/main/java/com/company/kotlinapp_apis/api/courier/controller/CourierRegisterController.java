package com.company.kotlinapp_apis.api.courier.controller;

import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.service.impl.courier.CourierServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/couriers")
public class CourierRegisterController {

    private final CourierServiceImpl courierServiceImpl;

    public CourierRegisterController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> createCourier(@RequestBody CourierDto courierDto){
        return courierServiceImpl.createCourier(courierDto);
    }

    //LIST
    @GetMapping
    public List<CourierDto> getAllCouriers(){
        return courierServiceImpl.getAllCouriers();
    }

    //ID
    @GetMapping("/{courierId}")
    public ResponseEntity<?> getCourierById(@PathVariable("courierId") Long courierId){
        CourierDto courier = courierServiceImpl.getCourierById(courierId);
        if (courier != null) {
            return ResponseEntity.ok(courier);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("courier doesn't exist with given id..");
    }

    //UPDATE
    @PutMapping("/{courierId}")
    public ResponseEntity<?> updateCourier(
            @PathVariable("courierId") Long id,
            @RequestBody CourierDto courierDTO) {
        CourierDto updatedCourier = courierServiceImpl.updateCourier(id, courierDTO);
        if (updatedCourier != null) {
            return ResponseEntity.ok(updatedCourier);
        }
        return ResponseEntity.notFound().build();
    }

    //DELETE
    @DeleteMapping("/{courierId}")
    public ResponseEntity<?> deleteCourierById(@PathVariable("courierId") Long courierId) {
        courierServiceImpl.deleteCourier(courierId);
        return ResponseEntity.ok().build();
    }

}
