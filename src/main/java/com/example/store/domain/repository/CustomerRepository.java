package com.example.store.domain.repository;

import com.example.store.domain.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findById(UUID id);
    List<Customer> findAll();
    Customer save(Customer customer);
    void delete(UUID id);
}
