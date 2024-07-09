package com.heavymaverick.sharpstore.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClothingItem {
    private Long id;
    private String title;
    private String description;
    private String material;
    private int price;
    private String collection;
    private int quantity;

}
