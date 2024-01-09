package com.enigma.anriticket.service;

import com.enigma.anriticket.dto.user.request.UserRequestAuth;
import com.enigma.anriticket.entity.User;

public interface UserService {
    User createUser(UserRequestAuth userRequestAuth);
}
