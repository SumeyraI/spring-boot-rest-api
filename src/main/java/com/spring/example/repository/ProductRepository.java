package com.spring.example.repository;

import com.spring.example.dto.ProductDto;
import com.spring.example.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    ProductDto findByName(String name);
}
