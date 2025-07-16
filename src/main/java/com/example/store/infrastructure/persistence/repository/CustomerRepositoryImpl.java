package com.example.store.infrastructure.persistence.repository;

import com.example.store.domain.model.Customer;
import com.example.store.infrastructure.persistence.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.example.store.domain.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {
    private final  JpaCustomerRepository jpaCustomerRepository;
    private final CustomerMapper mapper;


    @Override
    public Optional<Customer> findById(UUID id) {
        return jpaCustomerRepository.findById(id).map(mapper::toModel);
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Customer save(Customer customer) {
        return mapper.toModel(jpaCustomerRepository.save(mapper.toEntity(customer)));
    }

    @Override
    public void delete(UUID id) {
        jpaCustomerRepository.deleteById(id);
    }
}
