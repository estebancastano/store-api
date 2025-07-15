package com.example.store.shared.mapper;

import com.example.store.domain.model.Category;
import com.example.store.shared.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoMapper {
    public CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public Category toModel(CategoryDto dto) {
        return new Category(dto.getId(), dto.getName());
    }
} 