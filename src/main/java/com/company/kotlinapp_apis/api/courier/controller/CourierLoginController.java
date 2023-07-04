package com.company.kotlinapp_apis.api.courier.controller;

import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.model.LoginRequest;
import com.company.kotlinapp_apis.service.inter.courier.CourierServiceInter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/courier/login")
public class CourierLoginController {

    private final CourierServiceInter courierService;

    public CourierLoginController(CourierServiceInter courierService) {
        this.courierService = courierService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        CourierDto courierDto = courierService.findCourierByEmail(email);

        if (courierDto == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

        if(courierDto.getPassword().equals(password)) {
            if(!courierDto.getIsDisable() && !courierDto.getTrash()) {
                return ResponseEntity.ok(courierDto);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("This user is inactive or deleted.");
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }

}
