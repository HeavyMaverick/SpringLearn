package com.heavymaverick.sprsecdemo.repositories;

import com.heavymaverick.sprsecdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


// выдергиваем из таблицы
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existByUsername(String username);

    boolean existByEmail(String email);
}
