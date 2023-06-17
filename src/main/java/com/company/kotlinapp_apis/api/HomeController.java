package com.company.kotlinapp_apis.api;

import com.company.kotlinapp_apis.api.login.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/home")
public class HomeController {

        @GetMapping("/home")
        public ResponseEntity<Result> homePage() {
            return ResponseEntity.status(HttpStatus.OK).body(Result.builder()
                    .result("It is result...")
                    .build());
        }

}
