package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Product;
import com.example.store.infrastructure.persistence.entity.BrandEntity;
import com.example.store.infrastructure.persistence.entity.CategoryEntity;
import com.example.store.infrastructure.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toModel(ProductEntity entity) {
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice(),
                entity.getCategory().getId(),
                entity.getBrand().getId()
        );
    }

    public ProductEntity toEntity(Product model) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(model.getCategoryId());

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(model.getBrandId());

        return new ProductEntity(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                categoryEntity,
                brandEntity
        );
    }
}
