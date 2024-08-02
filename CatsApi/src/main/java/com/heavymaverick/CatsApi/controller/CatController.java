package com.heavymaverick.CatsApi.controller;

import com.heavymaverick.CatsApi.dto.CatDto;
import com.heavymaverick.CatsApi.entity.Cat;
import com.heavymaverick.CatsApi.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {

    private final CatService catService;

    @PostMapping
    public Cat save(@RequestBody CatDto cat) {
        return catService.save(cat);
    }

    @GetMapping
    public Iterable<Cat> findAll() {
        return catService.getAll();
    }
}
