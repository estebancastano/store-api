package com.example.store.application.usecase;

import com.example.store.domain.model.Customer;
import com.example.store.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(UUID id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void delete(UUID id) {
        customerRepository.delete(id);
    }

    public Customer update(UUID id, Customer customer) {
        Customer existingCustomer = getById(id);
        customer.setId(existingCustomer.getId());
        return customerRepository.save(customer);
    }
}
