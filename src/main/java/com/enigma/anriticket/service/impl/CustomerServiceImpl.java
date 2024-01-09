package com.enigma.anriticket.service.impl;

import com.enigma.anriticket.dto.customer.request.CustomerRequestAuth;
import com.enigma.anriticket.entity.Customer;
import com.enigma.anriticket.repository.CustomerRepository;
import com.enigma.anriticket.service.CustomerService;
import com.enigma.anriticket.util.DateParse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public Customer createCustomer(CustomerRequestAuth customerRequestAuth) {
        Customer createCustomer = Customer.builder()
                .firstName(customerRequestAuth.getFirstName())
                .lastName(customerRequestAuth.getLastName())
                .birthDate(DateParse.parseStringToLocaleDate(customerRequestAuth.getBirthDate()))
                .saldo(customerRequestAuth.getSaldo())
                .user(customerRequestAuth.getUser())
                .createdAt(LocalDateTime.now())
                .build();
        return customerRepository.create(createCustomer.getFirstName(), createCustomer.getLastName(), createCustomer.getBirthDate(), createCustomer.getSaldo(), createCustomer.getUser().getId(), createCustomer.getCreatedAt(), createCustomer.getUpdatedAt());
    }
}
