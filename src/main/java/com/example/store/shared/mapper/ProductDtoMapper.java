package com.example.store.shared.mapper;

import com.example.store.domain.model.Product;
import com.example.store.shared.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {
    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setBrandId(product.getBrandId());
        return productDto;
    }

    public Product toModel(ProductDto productDto) {
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getCategoryId(),
                productDto.getBrandId()
        );
    }
}
