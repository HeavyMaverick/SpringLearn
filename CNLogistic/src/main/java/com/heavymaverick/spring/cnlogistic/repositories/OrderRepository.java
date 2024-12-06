package com.heavymaverick.spring.cnlogistic.repositories;

import com.heavymaverick.spring.cnlogistic.models.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel, Integer> {
    Optional<OrderModel> findByOrderId(Long orderId);
    List<OrderModel> findAllByUsername(String username);
}
