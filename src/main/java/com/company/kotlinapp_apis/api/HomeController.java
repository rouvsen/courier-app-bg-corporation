package com.company.kotlinapp_apis.api;

import com.company.kotlinapp_apis.api.login.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

        @GetMapping("/home")
        public ResponseEntity<Result> homePage() {
            return ResponseEntity.status(HttpStatus.OK).body(Result.builder()
                    .result("Here Home Page...")
                    .build());
        }

}
