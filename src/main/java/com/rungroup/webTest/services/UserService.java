package com.rungroup.webTest.services;

import com.rungroup.webTest.dtos.RegistrationDto;
import com.rungroup.webTest.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);
}
