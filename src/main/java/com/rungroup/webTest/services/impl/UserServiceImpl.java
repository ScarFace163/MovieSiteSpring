package com.rungroup.webTest.services.impl;

import com.rungroup.webTest.dtos.MovieDto;
import com.rungroup.webTest.dtos.RegistrationDto;
import com.rungroup.webTest.models.Movie;
import com.rungroup.webTest.models.Role;
import com.rungroup.webTest.models.UserEntity;
import com.rungroup.webTest.repositories.RoleRepository;
import com.rungroup.webTest.repositories.UserRepository;
import com.rungroup.webTest.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

import static com.rungroup.webTest.mapper.MovieMapper.mapToMovie;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
}
