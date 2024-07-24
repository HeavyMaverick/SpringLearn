package com.heavymaverick.sharpstore.services;

import com.heavymaverick.sharpstore.models.ClothingItem;
import com.heavymaverick.sharpstore.models.Image;
import com.heavymaverick.sharpstore.models.User;
import com.heavymaverick.sharpstore.repositories.ItemRepository;
import com.heavymaverick.sharpstore.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    public List<ClothingItem> listProducts(String title) {
        if (title != null) return itemRepository.findByTitle(title);
        return itemRepository.findAll();
    }
    public void saveProduct(Principal principal, ClothingItem clothingItem, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        clothingItem.setUser(getUserByPrincipal(principal));
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
        log.info("Saving new Product. Title: {}; Author email: {}", clothingItem.getTitle(), clothingItem.getUser().getEmail());
        ClothingItem clothingItemFromDb = itemRepository.save(clothingItem);
        clothingItemFromDb.setPreviewImageId(clothingItemFromDb.getImages().get(0).getId());
        itemRepository.save(clothingItem);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
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

    public void deleteProduct(Long id) {
        itemRepository.deleteById(id);
    }

    public ClothingItem getProductById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }
}
