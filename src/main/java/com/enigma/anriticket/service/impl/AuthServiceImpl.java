package com.enigma.anriticket.service.impl;

import com.enigma.anriticket.constant.ERole;
import com.enigma.anriticket.dto.auth.AuthRequest;
import com.enigma.anriticket.dto.auth.AuthResponse;

import com.enigma.anriticket.dto.customer.request.CustomerRequestAuth;
import com.enigma.anriticket.dto.user.request.UserRequestAuth;
import com.enigma.anriticket.entity.Customer;
import com.enigma.anriticket.entity.Role;
import com.enigma.anriticket.entity.User;
import com.enigma.anriticket.service.AuthService;
import com.enigma.anriticket.service.CustomerService;
import com.enigma.anriticket.service.RoleService;
import com.enigma.anriticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final CustomerService customerService;
    private final UserService userService;
    private final RoleService roleService;


    @Override
    public AuthResponse createCustomerUser(AuthRequest authRequest) {
        Role saveRole = roleService.createRole(ERole.ROLE_CUSTOMER);

        User saveUser = userService.createUser(UserRequestAuth.builder()
                        .username(authRequest.getUsername())
                        .email(authRequest.getEmail())
                        .password(authRequest.getPassword())
                        .role(saveRole)
                        .createdAt(LocalDateTime.now())
                .build());

        Customer saveCustomer = customerService.createCustomer(CustomerRequestAuth.builder()
                        .firstName(authRequest.getFirstName())
                        .lastName(authRequest.getLastName())
                        .birthDate(authRequest.getBirthDate())
                        .createdAt(LocalDateTime.now())
                        .user(saveUser)
                .build());
        return AuthResponse.builder()
                .id(saveCustomer.getId())
                .firstName(saveCustomer.getFirstName())
                .lastName(saveCustomer.getLastName())
                .birthDate(saveCustomer.getBirthDate())
                .saldo(saveCustomer.getSaldo())
                .createdAt(saveCustomer.getCreatedAt())
                .updatedAt(saveCustomer.getUpdatedAt())
                .user(saveUser)
                .build();
    }
}
