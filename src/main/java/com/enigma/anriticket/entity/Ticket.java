package com.enigma.anriticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "ticket_code", nullable = false)
    private String ticketCode;
    @JoinColumn(name = "event_id")
    @OneToOne
    private Event event;
    @OneToMany
    @JoinColumn(name = "ticket_price_id")
    private List<TicketPrice> ticketPrice;
    @ManyToMany
    private List<Transaction> transactions;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
