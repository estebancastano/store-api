package com.example.store.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private UUID categoryId;
    private UUID brandId;
}
