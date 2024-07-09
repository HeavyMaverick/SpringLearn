package com.heavymaverick.sharpstore.controller;

import com.heavymaverick.sharpstore.models.ClothingItem;
import com.heavymaverick.sharpstore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("clothingItems", productService.getClothingItems());
        return "products";
    }
    @GetMapping("/item/{id}")
    public String itemInfo(@PathVariable Long id, Model model) {
        model.addAttribute("clothingItem", productService.getProductById(id));
        return "itemInfo";
    }

    @PostMapping("/item/create")
    public String createItem(ClothingItem clothingItem) {
        productService.saveClothingItem(clothingItem);
        return "redirect:/";
    }
    @PostMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        productService.deleteClothingItem(id);
        return "redirect:/";
    }
}
