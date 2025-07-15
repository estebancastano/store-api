package com.example.store.shared.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be greater than zero")
    private BigDecimal price;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;

    @NotNull(message = "Brand ID is required")
    private UUID brandId;
}
