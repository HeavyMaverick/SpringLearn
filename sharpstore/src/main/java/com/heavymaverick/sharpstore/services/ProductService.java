package com.heavymaverick.sharpstore.services;

import com.heavymaverick.sharpstore.models.ClothingItem;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<ClothingItem> clothingItems = new ArrayList<>();
    private long ID = 0;

    {
        clothingItems.add(new ClothingItem(
                ++ID,
                "Льняная рубашка",
                "Рубашка с вышивкой. Отлично подойдет на лето",
                "Материал: Лен",
                4000,
                "Летняя коллекция",
                35));
        clothingItems.add(new ClothingItem(
                ++ID,
                "Юбка с подтяжками",
                "Яркая и легкая юбка с утяжками",
                "Материал: Хлопок",
                4000,
                "Летняя коллекция",
                30));
    }

    public List<ClothingItem> getClothingItems() {
        return clothingItems;
    }

    public void saveClothingItem(ClothingItem clothingItem) {
        clothingItem.setId(++ID);
        clothingItems.add(clothingItem);
    }

    public void deleteClothingItem(Long id) {
        clothingItems.removeIf(clothingItem -> clothingItem.getId() == id);
    }

    public ClothingItem getProductById(Long id) {
        for (ClothingItem clothingItem : clothingItems) {
            if (clothingItem.getId() == id) {
                return clothingItem;
            }
        }
        return null;
    }
}
