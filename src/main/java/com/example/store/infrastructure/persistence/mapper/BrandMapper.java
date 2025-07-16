package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Brand;
import com.example.store.infrastructure.persistence.entity.BrandEntity;
import org.springframework.stereotype.Component;

@Component
public class BrandMapper {
    public Brand toModel(BrandEntity entity) {
        return new Brand(entity.getId(), entity.getName());
    }

    public BrandEntity toEntity(Brand model) {
        BrandEntity entity = new BrandEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        return entity;
    }
} 