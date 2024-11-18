package com.example.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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



	public ResponseEntity<Product> updateStock(Long id, int newStockQuantity) {
        // Fetch the product by ID
        Optional<Product> productOptional = productRepository.findById(id);

        // Check if the product exists
        if (productOptional.isPresent()) {
            // Get the product
            Product product = productOptional.get();

            // Update the stock quantity
            product.setStockQuantity(newStockQuantity);

            // Save the updated product back to the repository
            Product updatedProduct = productRepository.save(product);

            // Return the updated product with an OK status
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            // Return a NOT FOUND status if the product doesn't exist
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

	



	
	
	
	
}
