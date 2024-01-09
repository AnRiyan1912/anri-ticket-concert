package com.enigma.anriticket.entity;

import com.enigma.anriticket.constant.ERole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 150)
    private String password;
    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
