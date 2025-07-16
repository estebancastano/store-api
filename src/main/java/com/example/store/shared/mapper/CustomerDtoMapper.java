package com.example.store.shared.mapper;

import com.example.store.domain.model.Customer;
import com.example.store.domain.model.Product;
import com.example.store.shared.dto.CustomerDto;
import com.example.store.shared.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper {
    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setAddress(customer.getAddress());
        return customerDto;
    }

    public Customer toModel(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getEmail(),
                customerDto.getPhone(),
                customerDto.getAddress()
        );
    }
}
