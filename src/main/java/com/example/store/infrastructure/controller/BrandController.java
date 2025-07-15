package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.BrandService;
import com.example.store.domain.model.Brand;
import com.example.store.shared.dto.BrandDto;
import com.example.store.shared.mapper.BrandDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandController {
    private final BrandService brandService;
    private final BrandDtoMapper brandDtoMapper;

    @PostMapping
    public ResponseEntity<BrandDto> create(@RequestBody @Valid BrandDto brandDto) {
        Brand brand = brandDtoMapper.toModel(brandDto);
        Brand savedBrand = brandService.create(brand);
        return ResponseEntity.created(URI.create("/api/brands/" + savedBrand.getId()))
                .body(brandDtoMapper.toDto(savedBrand));
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> findAll() {
        List<BrandDto> brands = brandService.findAll().stream().map(brandDtoMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BrandDto> findById(@PathVariable UUID id) {
        Brand brand = brandService.getById(id);
        return ResponseEntity.ok(brandDtoMapper.toDto(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        brandService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDto> update(@PathVariable UUID id, @RequestBody @Valid BrandDto brandDto) {
        Brand brand = brandDtoMapper.toModel(brandDto);
        Brand updatedBrand = brandService.update(id, brand);
        return ResponseEntity.ok(brandDtoMapper.toDto(updatedBrand));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BrandDto> partialUpdate(@PathVariable UUID id, @RequestBody BrandDto brandDto) {
        Brand existingBrand = brandService.getById(id);
        
        if (brandDto.getName() != null) {
            existingBrand.setName(brandDto.getName());
        }
        
        Brand updatedBrand = brandService.update(id, existingBrand);
        return ResponseEntity.ok(brandDtoMapper.toDto(updatedBrand));
    }
} 