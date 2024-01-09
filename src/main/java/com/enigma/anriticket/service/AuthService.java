package com.enigma.anriticket.service;

import com.enigma.anriticket.dto.auth.AuthRequest;
import com.enigma.anriticket.dto.auth.AuthResponse;

public interface AuthService {
    AuthResponse createCustomerUser(AuthRequest authRequest);
}
