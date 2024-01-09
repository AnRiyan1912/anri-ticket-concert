package com.enigma.anriticket.controller;

import com.enigma.anriticket.dto.customer.request.CustomerRequestAuth;
import com.enigma.anriticket.dto.reponse.CommondResponse;
import com.enigma.anriticket.entity.Customer;
import com.enigma.anriticket.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerRequestAuth customerRequestAuth) {
        Customer responseCreate = customerService.createCustomer(customerRequestAuth);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommondResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Success created customer")
                        .data(responseCreate)
                        .build()
        );
    }
}
