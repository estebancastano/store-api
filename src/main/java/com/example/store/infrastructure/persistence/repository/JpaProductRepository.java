package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaProductRepository extends JpaRepository<ProductEntity, UUID> {}
