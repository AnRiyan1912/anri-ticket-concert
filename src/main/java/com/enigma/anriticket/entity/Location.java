package com.enigma.anriticket.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Table(name = "m_location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(nullable = false, unique = true)
    private String province;
    @Column(name = "district_citu", nullable = false, unique = true)
    private String districtCity;
    @Column(nullable = false, unique = true)
    private String subdistrict;
    @Column(name = "village_subdistrict", nullable = false, unique = true)
    private String villageSubdistrict;
    @OneToOne(mappedBy = "location")
    private Event event;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

}
