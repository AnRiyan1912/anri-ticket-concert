package com.enigma.anriticket.service;

import com.enigma.anriticket.constant.ERole;
import com.enigma.anriticket.entity.Role;
import org.springframework.web.bind.annotation.RestController;


public interface RoleService {
    Role createRole(ERole role);
    Role getRoleByRole(ERole role);

}
