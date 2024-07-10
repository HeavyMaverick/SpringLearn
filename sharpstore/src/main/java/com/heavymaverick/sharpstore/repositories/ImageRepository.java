package com.heavymaverick.sharpstore.repositories;

import com.heavymaverick.sharpstore.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
