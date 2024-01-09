package com.enigma.anriticket.entity;

import com.enigma.anriticket.constant.ERole;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String  id;
    @Enumerated(EnumType.STRING)
    private ERole role;
    @OneToMany
    @JsonBackReference
    private List<User> user;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
