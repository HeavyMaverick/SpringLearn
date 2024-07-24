package com.heavymaverick.sharpstore.repositories;

import com.heavymaverick.sharpstore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
