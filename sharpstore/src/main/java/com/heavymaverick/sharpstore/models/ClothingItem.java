package com.heavymaverick.sharpstore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clothings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClothingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "material")
    private String material;

    @Column(name = "price")
    private int price;

    @Column(name = "collection")
    private String collection;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clothingItem")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateCreated;

    @PrePersist
    private void init(){
        dateCreated = LocalDateTime.now();
    }
    public void addImageToProduct(Image image){
        image.setClothingItem(this);
        images.add(image);
    }
}
