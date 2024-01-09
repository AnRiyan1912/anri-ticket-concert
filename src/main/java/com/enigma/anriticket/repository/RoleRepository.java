package com.enigma.anriticket.repository;

import com.enigma.anriticket.constant.ERole;
import com.enigma.anriticket.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    @Query(value = "INSERT INTO m_role (id, role, created_at) VALUES (gen_random_uuid(), :role, :createdAt) RETURNING *;", nativeQuery = true)
    Role create(@Param("role") String rol, @Param("createdAt")LocalDateTime createdAt);
    @Query(value = "SELECT * FROM m_role WHERE role = :role RETURNING *", nativeQuery = true)
    Role getRole(@Param("role") ERole role);
}
