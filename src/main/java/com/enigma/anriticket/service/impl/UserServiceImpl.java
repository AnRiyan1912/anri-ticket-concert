package com.enigma.anriticket.service.impl;

import com.enigma.anriticket.dto.user.request.UserRequestAuth;
import com.enigma.anriticket.entity.User;
import com.enigma.anriticket.repository.UserRepository;
import com.enigma.anriticket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequestAuth userRequestAuth) {
        User createUser = User.builder()
                .username(userRequestAuth.getUsername())
                .email(userRequestAuth.getEmail())
                .password(userRequestAuth.getPassword())
                .role(userRequestAuth.getRole())
                .createdAt(LocalDateTime.now())
                .build();
        return userRepository.create(createUser.getUsername(), createUser.getEmail(), createUser.getPassword(), createUser.getRole().getId(), createUser.getCreatedAt(), createUser.getUpdatedAt());
    }
}
