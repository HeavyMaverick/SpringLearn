package com.heavymaverick.spring.cnlogistic.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Table(name = "orders")
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    @NotEmpty
    private String username;

    @Column
    @NotEmpty
    private int amountCny;

    @Column
    @NotEmpty
    private int totalCost;
}
