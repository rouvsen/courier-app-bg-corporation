package com.company.kotlinapp_apis.service.impl.courier;

import com.company.kotlinapp_apis.dao.courier.CourierRepository;
import com.company.kotlinapp_apis.dto.courier.CourierDto;
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
        courierEntity.setDisable(false);
        courierEntity.setTrash(false);
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
        Courier entity = courierRepository.findById(id).orElseGet(() -> null);
        if(entity != null) {
            return modelMapper.map(entity, CourierDto.class);
        }
        return null;
    }

    @Override
    public Boolean isCourierEmailTaken(String email) {
        return courierRepository.findCourierByEmail(email) != null;
    }

    @Override
    public CourierDto findCourierByEmail(String email) {
        Courier courier = courierRepository.findCourierByEmail(email);
        if(courier != null) {
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }

    @Override
    public CourierDto updateCourier(Long id, CourierDto courierDto) {
        Courier existingCourier = courierRepository.findById(id).orElseThrow(() ->
                new UnsupportedOperationException("Courier not found with id:" + id));
        modelMapper.map(courierDto, existingCourier);
        Courier updatedCourier = courierRepository.save(existingCourier);
        return modelMapper.map(updatedCourier, CourierDto.class);
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }
}
