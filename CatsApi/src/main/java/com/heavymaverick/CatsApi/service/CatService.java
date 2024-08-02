package com.heavymaverick.CatsApi.service;

import com.heavymaverick.CatsApi.dto.CatDto;
import com.heavymaverick.CatsApi.entity.Cat;
import com.heavymaverick.CatsApi.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatService {

    private final CatRepository catRepository;
    public Cat save(CatDto catDto) {
        Cat cat = new Cat()
                .setName(catDto.getName())
                .setBirthDay(catDto.getBirthday())
                .setId(UUID.randomUUID().toString())
                .setCreatedAt(LocalDateTime.now());
        return  catRepository.save(cat);
    }

    public Iterable<Cat> getAll() {
        return catRepository.findAll();
    }
}
