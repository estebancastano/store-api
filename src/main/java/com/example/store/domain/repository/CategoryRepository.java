package com.example.store.domain.repository;

import com.example.store.domain.model.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository {
    Optional<Category> findById(UUID id);
    List<Category> findAll();
    Category save(Category category);
    void delete(UUID id);
} 