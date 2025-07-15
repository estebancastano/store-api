package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Product;
import com.example.store.domain.repository.ProductRepository;
import com.example.store.infrastructure.persistence.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final  JpaProductRepository jpaProductRepository;
    private final ProductMapper mapper;


    @Override
    public Optional<Product> findById(UUID id) {
       return jpaProductRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return mapper.toModel(jpaProductRepository.save(mapper.toEntity(product)));
    }

    @Override
    public void delete(UUID id) {
        jpaProductRepository.deleteById(id);
    }
}
