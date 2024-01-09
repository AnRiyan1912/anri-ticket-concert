package com.enigma.anriticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column()
    private Double saldo;
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
