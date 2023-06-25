package com.company.kotlinapp_apis.service.impl.finance;

import com.company.kotlinapp_apis.dao.finance.AdminCurrentBalanceDetRepository;
import com.company.kotlinapp_apis.dto.finance.AdminCurrentBalanceDetDto;
import com.company.kotlinapp_apis.model.finance.AdminCurrentBalanceDet;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminCurrentBalanceDetImpl {

    private final AdminCurrentBalanceDetRepository repository;
    private final ModelMapper modelMapper;

    public AdminCurrentBalanceDetImpl(AdminCurrentBalanceDetRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<AdminCurrentBalanceDetDto> getAllAdminCurrentBalanceDets() {
        List<AdminCurrentBalanceDet> list = repository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, AdminCurrentBalanceDetDto.class))
                .toList();
    }

    //ById
    public AdminCurrentBalanceDetDto getAdminCurrentBalanceDetById(Long id) {
        Optional<AdminCurrentBalanceDet> optional = repository.findById(id);
        return optional.map(det -> modelMapper.map(det, AdminCurrentBalanceDetDto.class)).orElse(null);
    }

    //Save
    public AdminCurrentBalanceDetDto saveAdminCurrentBalanceDet(AdminCurrentBalanceDetDto dto) {
        AdminCurrentBalanceDet det = modelMapper.map(dto, AdminCurrentBalanceDet.class);
        det = repository.save(det);
        return modelMapper.map(det, AdminCurrentBalanceDetDto.class);
    }

    //Delete
    public Boolean deleteAdminCurrentBalanceDet(Long id) {
        Optional<AdminCurrentBalanceDet> optional = repository.findById(id);
        if (optional.isPresent()) {
            AdminCurrentBalanceDet det = optional.get();
            repository.delete(det);
            return true;
        }
        return false;
    }
}
