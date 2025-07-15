package com.example.store.config;

import com.example.store.infrastructure.persistence.repository.JpaProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackageClasses = JpaProductRepository.class)
public class DatabaseConfig {
}
