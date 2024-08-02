package com.heavymaverick.servingwebcontent.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
