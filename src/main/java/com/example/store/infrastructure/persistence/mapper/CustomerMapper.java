package com.example.store.infrastructure.persistence.mapper;

import com.example.store.domain.model.Customer;
import com.example.store.infrastructure.persistence.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toModel(CustomerEntity entity) {
        return new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress()
        );
    }

    public CustomerEntity toEntity(Customer model) {

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(model.getId());
        customerEntity.setName(model.getName());
        customerEntity.setEmail(model.getEmail());
        customerEntity.setPhone(model.getPhone());
        customerEntity.setAddress(model.getAddress());
        return customerEntity;
    }
}
