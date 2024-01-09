package com.enigma.anriticket.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AuthRequest {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String username;
    private String email;
    private String password;
}
