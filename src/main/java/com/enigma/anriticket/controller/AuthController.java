package com.enigma.anriticket.controller;

import com.enigma.anriticket.dto.auth.AuthRequest;
import com.enigma.anriticket.dto.auth.AuthResponse;
import com.enigma.anriticket.dto.reponse.CommondResponse;
import com.enigma.anriticket.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth/customer")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity createAuthCustomer(@RequestBody AuthRequest authRequest) {
        AuthResponse authResponse  = authService.createCustomerUser(authRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success create auth customer")
                        .data(authResponse)
                        .build()
        );
    }

}
