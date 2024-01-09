package com.enigma.anriticket.service.impl;

import com.enigma.anriticket.constant.ERole;
import com.enigma.anriticket.entity.Role;
import com.enigma.anriticket.repository.RoleRepository;
import com.enigma.anriticket.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role createRole(ERole role) {
        return roleRepository.create(ERole.ROLE_ADMIN.name(), LocalDateTime.now());
    }

    @Override
    public Role getRoleByRole(ERole role) {
        return roleRepository.getRole(role);
    }
}
