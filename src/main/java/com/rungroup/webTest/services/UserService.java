package com.rungroup.webTest.services;

import com.rungroup.webTest.dtos.RegistrationDto;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
}
