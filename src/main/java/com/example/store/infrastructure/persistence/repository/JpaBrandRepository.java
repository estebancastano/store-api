package com.example.store.infrastructure.persistence.repository;

import com.example.store.infrastructure.persistence.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaBrandRepository extends JpaRepository<BrandEntity, UUID> {} 