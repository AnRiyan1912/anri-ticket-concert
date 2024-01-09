package com.enigma.anriticket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "trx_detail")
public class TransactionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false)
    private Integer quantity;
    @OneToMany
    @JsonBackReference
    private List<Transaction> transaction;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
