package com.enigma.anriticket.dto.customer.request;

import com.enigma.anriticket.entity.Role;
import com.enigma.anriticket.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CustomerRequestAuth {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private Double saldo;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
