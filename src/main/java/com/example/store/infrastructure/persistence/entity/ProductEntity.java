package com.example.store.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;


    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;


}
