package com.enigma.anriticket.controller;

import com.enigma.anriticket.dto.reponse.CommondResponse;
import com.enigma.anriticket.dto.user.request.UserRequestAuth;
import com.enigma.anriticket.entity.User;
import com.enigma.anriticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody  UserRequestAuth userRequestAuth) {
        User user = userService.createUser(userRequestAuth);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success create user")
                        .data(user)
                        .build()
        );
    }
}
