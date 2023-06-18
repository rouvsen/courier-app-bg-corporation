package com.company.kotlinapp_apis.service.impl;

import com.company.kotlinapp_apis.dao.UserRepository;
import com.company.kotlinapp_apis.dto.UserDto.UserDto;
import com.company.kotlinapp_apis.model.Role;
import com.company.kotlinapp_apis.model.User;
import com.company.kotlinapp_apis.service.inter.UserServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        User userEntity = modelMapper.map(userDto, User.class);
        if(isEmailTaken(userEntity.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        userEntity.setRole(Role.USER);
        User savedUser = userRepository.save(userEntity);
        return ResponseEntity.ok(modelMapper.map(savedUser, UserDto.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> listDto = new ArrayList<>();

        List<User> listEntity = userRepository.findAll();

        for (User entity : listEntity) {
            UserDto dto = modelMapper.map(entity, UserDto.class);
            listDto.add(dto);
        }

        return listDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        User entity = userRepository.findById(id).orElseThrow(() ->
                new UnsupportedOperationException("id is not exist.."));
        return modelMapper.map(entity, UserDto.class);
    }

    @Override
    public Boolean isEmailTaken(String email) {
        return userRepository.findUserByEmail(email).isPresent();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public Boolean deleteUser(Long id) {
        return null;
    }

//    public static UserDto toDto(User user) {
//        return UserDto.builder()
//                .id(user.getId())
//                .firstName(user.getFirstName())
//                .lastName(user.getLastName())
//                .email(user.getEmail())
//                .oneSignal(user.getOneSignal())
//                .password(user.getPassword())
//                .role(Role.USER)
//                .build();
//    }

//    public static User toEntity(UserDto userDto) {
//        return User.builder()
//                .id(userDto.getId())
//                .firstName(userDto.getFirstName())
//                .lastName(userDto.getLastName())
//                .email(userDto.getEmail())
//                .oneSignal(userDto.getOneSignal())
//                .password(userDto.getPassword())
//                .role(Role.USER)
//                .build();
//    }

}
