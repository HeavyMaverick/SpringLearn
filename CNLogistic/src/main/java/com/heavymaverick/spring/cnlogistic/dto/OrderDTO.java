package com.heavymaverick.spring.cnlogistic.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Table(name = "orders")
public class OrderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(nullable = false)
    @NotEmpty
    private String username;

    @Column
    @NotEmpty
    private int amountCny;

    @Column
    @NotEmpty
    private int totalCost;

    @Column
    @NotEmpty
    private String orderStatus;

    @Column
    @NotEmpty
    private String orderDate;

    @Column
    @NotEmpty
    private String orderLink;
}
