package com.company.kotlinapp_apis.api.login_register.controller;

import com.company.kotlinapp_apis.dto.UserDto.UserDto;
import com.company.kotlinapp_apis.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    private final UserServiceImpl userServiceImpl;

    public RegisterController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello";
    }

    //CREATE
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return userServiceImpl.createUser(userDto);
    }

    //LIST
    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        return userServiceImpl.getAllUsers();
    }

}
