package com.example.productservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
	    return productRepository.findById(id)
                .orElseThrow();
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}



	
	
	
	
}
