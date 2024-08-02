package com.heavymaverick.sharpstore.services;

import com.heavymaverick.sharpstore.models.ClothingItem;
import com.heavymaverick.sharpstore.models.Image;
import com.heavymaverick.sharpstore.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ItemRepository itemRepository;
    private List<ClothingItem> clothingItems = new ArrayList<>();
    private long ID = 0;

    public List<ClothingItem> listClothingItems(String title) {
        if (title != null && !title.isEmpty()) {
            return itemRepository.findByTitle(title);
        }
        return itemRepository.findAll();
    }

    public void saveClothingItem(ClothingItem clothingItem, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            clothingItem.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            clothingItem.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            clothingItem.addImageToProduct(image3);
        }
        ClothingItem clothingItemFromDB = itemRepository.save(clothingItem);
        clothingItemFromDB.setPreviewImageId(clothingItemFromDB.getImages().get(0).getId());
        log.info("Save new item. Title: {}; Price: {}", clothingItem.getTitle(), clothingItem.getPrice());
        itemRepository.save(clothingItemFromDB);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void deleteClothingItem(Long id) {
        itemRepository.deleteById(id);
    }

    public ClothingItem getProductById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
