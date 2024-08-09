package com.heavymaverick.webapp.repository;

import com.heavymaverick.webapp.entity.OwnUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WebappUserRepository extends CrudRepository<OwnUser, Integer> {
    Optional<OwnUser> findByUsername(String username);
}
