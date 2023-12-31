package com.protfolio.authenticationservice.repositories;

import com.protfolio.authenticationservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}