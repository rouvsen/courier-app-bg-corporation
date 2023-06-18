package com.company.kotlinapp_apis.service.inter;

import com.company.kotlinapp_apis.dto.UserDto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInter {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    Boolean deleteUser(Long id);

}
