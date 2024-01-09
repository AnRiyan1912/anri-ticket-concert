package com.enigma.anriticket.repository;

import com.enigma.anriticket.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "INSERT INTO m_user (id, username, email, password, role_id, created_at, updated_at) " +
            "VALUES (gen_random_uuid() ,:username, :email, :password, :roleId, :createdAt, :updatedAt) RETURNING *", nativeQuery = true)
     User create(@Param("username") String username, @Param("email") String email, @Param("password") String password, @Param("roleId") String roleId,
                 @Param("createdAt") LocalDateTime createdAt, @Param("updatedAt") LocalDateTime updatedAt);
}
