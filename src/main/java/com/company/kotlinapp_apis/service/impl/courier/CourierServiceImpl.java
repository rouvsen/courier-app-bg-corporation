package com.company.kotlinapp_apis.service.impl.courier;

import com.company.kotlinapp_apis.dao.courier.CourierRepository;
import com.company.kotlinapp_apis.dto.admin.AdminDto;
import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.model.admin.Admin;
import com.company.kotlinapp_apis.model.courier.Courier;
import com.company.kotlinapp_apis.service.inter.courier.CourierServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierServiceInter {

    private final CourierRepository courierRepository;
    private final ModelMapper modelMapper;

    public CourierServiceImpl(CourierRepository courierRepository, ModelMapper modelMapper) {
        this.courierRepository = courierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<CourierDto> createCourier(CourierDto courierDto) {
        Courier courierEntity = modelMapper.map(courierDto, Courier.class);
        if(isCourierEmailTaken(courierEntity.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        Courier savedCourier = courierRepository.save(courierEntity);
        return ResponseEntity.ok(modelMapper.map(savedCourier, CourierDto.class));
    }

    @Override
    public List<CourierDto> getAllCouriers() {
        List<CourierDto> listDto = new ArrayList<>();

        List<Courier> listEntity = courierRepository.findAll();

        for (Courier entity : listEntity) {
            CourierDto dto = modelMapper.map(entity, CourierDto.class);
            listDto.add(dto);
        }

        return listDto;
    }

    @Override
    public CourierDto getCourierById(Long id) {
        Courier entity = courierRepository.findById(id).orElseThrow(() ->
                new UnsupportedOperationException("courier id is not exist.."));
        return modelMapper.map(entity, CourierDto.class);
    }

    @Override
    public Boolean isCourierEmailTaken(String email) {
        return courierRepository.findCourierByEmail(email) != null;
    }

    @Override
    public CourierDto findCourierByEmail(String email) {
        Courier courier = courierRepository.findCourierByEmail(email);
        System.out.println(courier);
        if(courier != null) {
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }

    @Override
    public CourierDto updateCourier(Long id, CourierDto adminDto) {
        return null;
    }

    @Override
    public Boolean deleteCourier(Long id) {
        return null;
    }
}
