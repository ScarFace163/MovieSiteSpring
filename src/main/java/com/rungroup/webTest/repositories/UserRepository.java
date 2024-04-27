package com.rungroup.webTest.repositories;

import com.rungroup.webTest.models.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
    UserEntity  findByUsername(String username);

    UserEntity findFirstByUsername(String username);
}
