package com.company.kotlinapp_apis.service.inter.courier;

import com.company.kotlinapp_apis.dto.courier.CourierDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourierServiceInter {

    List<CourierDto> getAllCouriers();
    CourierDto getCourierById(Long id);
    ResponseEntity<CourierDto> createCourier(CourierDto courierDto);
    CourierDto updateCourier(Long id, CourierDto courierDto);
    void deleteCourier(Long id);
    Boolean isCourierEmailTaken(String email);
    CourierDto findCourierByEmail(String email);
}
