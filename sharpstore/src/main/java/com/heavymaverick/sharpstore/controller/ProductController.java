package com.heavymaverick.sharpstore.controller;

import com.heavymaverick.sharpstore.models.ClothingItem;
import com.heavymaverick.sharpstore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("clothingItems", productService.listClothingItems(title));
        return "products";
    }

    @GetMapping("/item/{id}")
    public String itemInfo(@PathVariable Long id, Model model) {
        ClothingItem clothingItem = productService.getProductById(id);
        model.addAttribute("clothingItem", clothingItem);
        model.addAttribute("images", clothingItem.getImages());
        return "itemInfo";
    }

    @PostMapping("/item/create")
    public String createItem(@RequestParam(value = "file1") MultipartFile file1,
                             @RequestParam(value = "file2") MultipartFile file2,
                             @RequestParam(value = "file3") MultipartFile file3,
                             ClothingItem clothingItem) throws IOException {
        productService.saveClothingItem(clothingItem, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        productService.deleteClothingItem(id);
        return "redirect:/";
    }
}
