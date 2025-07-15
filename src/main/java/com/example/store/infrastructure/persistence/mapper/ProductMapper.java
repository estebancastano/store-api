package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Product;
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
                entity.getCategoryId(),
                entity.getBrandId()
        );
    }

    public ProductEntity toEntity(Product model) {
        return new ProductEntity(
                model.getId(),
                model.getName(),
                model.getDescription(),
                model.getPrice(),
                model.getCategoryId(),
                model.getBrandId()
        );
    }
}
