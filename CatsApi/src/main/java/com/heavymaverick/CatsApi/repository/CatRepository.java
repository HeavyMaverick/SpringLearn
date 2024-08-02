package com.heavymaverick.CatsApi.repository;

import com.heavymaverick.CatsApi.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, String> {
}
