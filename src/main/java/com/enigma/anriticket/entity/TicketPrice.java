package com.enigma.anriticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_ticket_price")
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private Double price;
    @ManyToOne
    @JsonIgnore
    private Ticket ticket;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
