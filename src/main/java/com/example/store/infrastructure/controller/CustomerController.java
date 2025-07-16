package com.example.store.infrastructure.controller;

import com.example.store.application.usecase.CustomerService;
import com.example.store.domain.model.Customer;
import com.example.store.shared.dto.CustomerDto;
import com.example.store.shared.mapper.CustomerDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDtoMapper customerDtoMapper;

    @PostMapping
    public ResponseEntity<CustomerDto> create(@RequestBody @Valid CustomerDto customerDto) {
        Customer customer = customerDtoMapper.toModel(customerDto);
        Customer savedCustomer = customerService.create(customer);
        return ResponseEntity.created(URI.create("/api/customers/" + savedCustomer.getId()))
                .body(customerDtoMapper.toDto(savedCustomer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAll() {
        List<CustomerDto> customers = customerService.findAll().stream().map(customerDtoMapper::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable UUID id) {
        Customer customer = customerService.getById(id);
        return ResponseEntity.ok(customerDtoMapper.toDto(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable UUID id, @RequestBody @Valid CustomerDto customerDto) {
        Customer customer = customerDtoMapper.toModel(customerDto);
        Customer updatedCustomer = customerService.update(id, customer);
        return ResponseEntity.ok(customerDtoMapper.toDto(updatedCustomer));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDto> partialUpdate(@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
        Customer existingProduct = customerService.getById(id);

        if (customerDto.getName() != null) {
            existingProduct.setName(customerDto.getName());
        }
        if (customerDto.getEmail() != null) {
            existingProduct.setEmail(customerDto.getEmail());
        }
        if (customerDto.getPhone() != null) {
            existingProduct.setPhone(customerDto.getPhone());
        }
        if (customerDto.getAddress() != null) {
            existingProduct.setAddress(customerDto.getAddress());
        }
        Customer updatedProduct = customerService.update(id, existingProduct);
        return ResponseEntity.ok(customerDtoMapper.toDto(updatedProduct));
    }
}
