package com.enigma.anriticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;
    @Column(name = "date_start", nullable = false)
    private LocalDate dateStart;
    @Column(name = "date_end", nullable = false)
    private LocalDate dateEnd;
    @Column(name = "time_start", nullable = false)
    private LocalTime timeStart;
    @Column(name = "time_end", nullable = false)
    private LocalTime timeEnd;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;
    @OneToOne(mappedBy = "event")
    private Ticket ticket;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "update_at")
    private String updatedAt;


}
