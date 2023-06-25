package com.company.kotlinapp_apis.service.impl.finance;

import com.company.kotlinapp_apis.dao.finance.CourierCurrentBalanceDetRepository;
import com.company.kotlinapp_apis.dto.finance.CourierCurrentBalanceDetDto;
import com.company.kotlinapp_apis.model.finance.CourierCurrentBalanceDet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierCurrentBalanceDetImpl {

    private final CourierCurrentBalanceDetRepository repository;
    private final ModelMapper modelMapper;

    public CourierCurrentBalanceDetImpl(CourierCurrentBalanceDetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<CourierCurrentBalanceDetDto> getAllCourierCurrentBalanceDets() {
        List<CourierCurrentBalanceDet> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierCurrentBalanceDetDto.class))
                .toList();
    }

    //ById
    public CourierCurrentBalanceDetDto getCourierCurrentBalanceDetById(Long id) {
        Optional<CourierCurrentBalanceDet> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierCurrentBalanceDetDto.class)).orElse(null);
    }

    //Save
    public CourierCurrentBalanceDetDto saveCourierCurrentBalanceDet(CourierCurrentBalanceDetDto dto) {
        CourierCurrentBalanceDet det = modelMapper.map(dto, CourierCurrentBalanceDet.class);
        det = repository.save(det);
        return modelMapper.map(det, CourierCurrentBalanceDetDto.class);
    }

    //Delete
    public Boolean deleteCourierCurrentBalanceDet(Long id) {
        Optional<CourierCurrentBalanceDet> optional = repository.findById(id);
        if (optional.isPresent()) {
            CourierCurrentBalanceDet det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
