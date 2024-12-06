package com.heavymaverick.spring.cnlogistic.repositories;

import com.heavymaverick.spring.cnlogistic.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}