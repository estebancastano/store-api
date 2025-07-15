package com.example.store.config;

import com.example.store.infrastructure.persistence.repository.JpaBrandRepository;
import com.example.store.infrastructure.persistence.repository.JpaCategoryRepository;
import com.example.store.infrastructure.persistence.repository.JpaProductRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {
    JpaProductRepository.class,
    JpaBrandRepository.class,
    JpaCategoryRepository.class
})
public class DatabaseConfig {
}
