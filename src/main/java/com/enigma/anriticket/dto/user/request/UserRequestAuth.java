package com.enigma.anriticket.dto.user.request;

import com.enigma.anriticket.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserRequestAuth {
    private String id;
    private String username;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
