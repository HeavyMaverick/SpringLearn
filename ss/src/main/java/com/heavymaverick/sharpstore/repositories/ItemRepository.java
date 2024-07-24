package com.heavymaverick.sharpstore.repositories;

import com.heavymaverick.sharpstore.models.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByTitle(String title);
}
