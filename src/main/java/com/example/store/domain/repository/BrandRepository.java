package com.example.store.domain.repository;

import com.example.store.domain.model.Brand;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandRepository {
    Optional<Brand> findById(UUID id);
    List<Brand> findAll();
    Brand save(Brand brand);
    void delete(UUID id);
} 