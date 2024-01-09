package com.enigma.anriticket.dto.auth;

import com.enigma.anriticket.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Double saldo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User user;

}
