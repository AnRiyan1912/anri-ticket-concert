package com.enigma.anriticket.repository;

import com.enigma.anriticket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "INSERT INTO m_customer (id, first_name, last_name, birth_date, saldo, user_id, created_at, updated_at) " +
                    "VALUES (gen_random_uuid() ,:firstName, :lastName, :birthDate, :saldo, :userId, :createdAt, :updatedAt ) RETURNING *", nativeQuery = true)
    Customer create(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("birthDate") LocalDate birthDate, @Param("saldo") Double saldo, @Param("userId") String userId, @Param("createdAt") LocalDateTime createdAt, @Param("updatedAt") LocalDateTime updateAt);


}
