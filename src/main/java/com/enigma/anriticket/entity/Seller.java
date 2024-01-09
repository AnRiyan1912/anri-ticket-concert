package com.enigma.anriticket.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_seller")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "first_name", nullable = false, length = 60)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 60)
    private String lastName;
    @Column(name = "birth_date", nullable = false)
    private LocalDateTime birthDate;
    @JoinColumn(name = "user_id", nullable = false)
    @OneToOne
    private User user;
    @OneToMany
    private List<Event> events;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

}
