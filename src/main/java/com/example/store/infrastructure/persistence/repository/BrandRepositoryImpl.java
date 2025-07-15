package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Brand;
import com.example.store.domain.repository.BrandRepository;
import com.example.store.infrastructure.persistence.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {
    private final JpaBrandRepository jpaBrandRepository;
    private final BrandMapper mapper;

    @Override
    public Optional<Brand> findById(UUID id) {
        return jpaBrandRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Brand> findAll() {
        return jpaBrandRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Brand save(Brand brand) {
        return mapper.toModel(jpaBrandRepository.save(mapper.toEntity(brand)));
    }

    @Override
    public void delete(UUID id) {
        jpaBrandRepository.deleteById(id);
    }
} 