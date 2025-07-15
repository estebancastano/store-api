package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.ProductService;
import com.example.store.domain.model.Product;
import com.example.store.shared.dto.ProductDto;
import com.example.store.shared.mapper.ProductDtoMapper;
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
    private final ProductDtoMapper productDtoMapper;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid ProductDto productDto) {
        Product product = productDtoMapper.toModel(productDto);
        Product savedProduct = productService.create(product);
        return ResponseEntity.created(URI.create("/api/products/" + savedProduct.getId()))
                .body(productDtoMapper.toDto(savedProduct));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAll() {
        List<ProductDto> products = productService.findAll().stream().map(productDtoMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
        Product product = productService.getById(id);
        return ResponseEntity.ok(productDtoMapper.toDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
