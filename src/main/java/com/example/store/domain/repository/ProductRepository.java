package com.example.store.domain.repository;

import com.example.store.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Optional<Product> findById(UUID id);
    List<Product> findAll();
    Product save(Product product);
    void delete(UUID id);
}
