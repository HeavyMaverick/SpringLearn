package com.heavymaverick.spring.cnlogistic.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String username;

    @Column
    private int amountCny;

    @Column
    private int totalCost;
}
