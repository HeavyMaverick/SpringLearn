package com.heavymaverick.sharpstore.repositories;

import com.heavymaverick.sharpstore.models.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<ClothingItem, Long> {

    List<ClothingItem> findByTitle(String title);
}
