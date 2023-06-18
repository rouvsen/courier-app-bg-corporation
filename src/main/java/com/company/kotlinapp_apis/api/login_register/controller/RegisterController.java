package com.company.kotlinapp_apis.api.login_register.controller;

import com.company.kotlinapp_apis.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class RegisterController {

    private final UserServiceImpl userServiceImpl;

    public RegisterController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }



}
