package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Category;
import com.example.store.domain.repository.CategoryRepository;
import com.example.store.infrastructure.persistence.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper mapper;

    @Override
    public Optional<Category> findById(UUID id) {
        return jpaCategoryRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Category save(Category category) {
        return mapper.toModel(jpaCategoryRepository.save(mapper.toEntity(category)));
    }

    @Override
    public void delete(UUID id) {
        jpaCategoryRepository.deleteById(id);
    }
} 