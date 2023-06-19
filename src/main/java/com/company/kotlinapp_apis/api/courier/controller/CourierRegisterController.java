package com.company.kotlinapp_apis.api.courier.controller;

import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.service.impl.courier.CourierServiceImpl;
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
    public ResponseEntity<CourierDto> createCourier(@RequestBody CourierDto courierDto){
        return courierServiceImpl.createCourier(courierDto);
    }

    //LIST
    @GetMapping
    public List<CourierDto> getAllCouriers(){
        return courierServiceImpl.getAllCouriers();
    }

}
