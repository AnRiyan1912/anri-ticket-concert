package com.enigma.anriticket.repository;

import com.enigma.anriticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, String> {
    @Query(value = "INSERT INTO m_ticket ()")
    public create()
}
