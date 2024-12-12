package com.heavymaverick.spring.cnlogistic.repositories;

import com.heavymaverick.spring.cnlogistic.dto.OrderDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderDTO, Integer> {
    Optional<OrderDTO> findByOrderId(Integer orderId);
    OrderDTO findLast(Integer orderId, Integer userId);
    List<OrderDTO> findAllByUsername(String username);
}
