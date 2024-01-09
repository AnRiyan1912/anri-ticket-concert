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
@Table(name = "t_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToMany
    private List<Ticket> ticket;
    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "trx_detail_id")
    private TransactionDetail transactionDetail;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;
}
