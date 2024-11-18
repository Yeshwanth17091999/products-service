package com.example.productservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.productservice.model.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Long>{


}
