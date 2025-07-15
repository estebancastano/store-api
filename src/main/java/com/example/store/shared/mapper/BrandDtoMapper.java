package com.example.store.shared.mapper;

import com.example.store.domain.model.Brand;
import com.example.store.shared.dto.BrandDto;
import org.springframework.stereotype.Component;

@Component
public class BrandDtoMapper {
    public BrandDto toDto(Brand brand) {
        BrandDto dto = new BrandDto();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        return dto;
    }

    public Brand toModel(BrandDto dto) {
        return new Brand(dto.getId(), dto.getName());
    }
} 