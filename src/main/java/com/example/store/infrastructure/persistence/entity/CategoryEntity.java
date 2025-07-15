package com.example.store.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}
