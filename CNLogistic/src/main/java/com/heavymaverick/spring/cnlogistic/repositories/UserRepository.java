package com.heavymaverick.spring.cnlogistic.repositories;

import com.heavymaverick.spring.cnlogistic.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUsername(String username);
}