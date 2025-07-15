package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.CategoryService;
import com.example.store.domain.model.Category;
import com.example.store.shared.dto.CategoryDto;
import com.example.store.shared.mapper.CategoryDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryDtoMapper categoryDtoMapper;

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto categoryDto) {
        Category category = categoryDtoMapper.toModel(categoryDto);
        Category savedCategory = categoryService.create(category);
        return ResponseEntity.created(URI.create("/api/categories/" + savedCategory.getId()))
                .body(categoryDtoMapper.toDto(savedCategory));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> categories = categoryService.findAll().stream().map(categoryDtoMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable UUID id) {
        Category category = categoryService.getById(id);
        return ResponseEntity.ok(categoryDtoMapper.toDto(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable UUID id, @RequestBody @Valid CategoryDto categoryDto) {
        Category category = categoryDtoMapper.toModel(categoryDto);
        Category updatedCategory = categoryService.update(id, category);
        return ResponseEntity.ok(categoryDtoMapper.toDto(updatedCategory));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryDto> partialUpdate(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) {
        Category existingCategory = categoryService.getById(id);
        
        if (categoryDto.getName() != null) {
            existingCategory.setName(categoryDto.getName());
        }
        
        Category updatedCategory = categoryService.update(id, existingCategory);
        return ResponseEntity.ok(categoryDtoMapper.toDto(updatedCategory));
    }
} 