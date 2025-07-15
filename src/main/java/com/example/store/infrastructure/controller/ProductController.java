package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.ProductService;
import com.example.store.domain.model.Product;
import com.example.store.shared.dto.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto productDto) {
        Product product = toModel(productDto);
        Product savedProduct = productService.create(product);
        return ResponseEntity.created(URI.create("/api/products/" + savedProduct.getId()))
                .body(toDto(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> products = productService.findAll().stream().map(this::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
        Product product = productService.getById(id);
        return ResponseEntity.ok(toDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setBrandId(product.getBrandId());
        return productDto;
    }

    private Product toModel(ProductDto productDto) {
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
