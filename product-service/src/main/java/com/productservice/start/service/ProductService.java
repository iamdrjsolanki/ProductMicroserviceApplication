package com.productservice.start.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.productservice.start.exception.ProductNotFoundException;
import com.productservice.start.model.ProductInfo;
import com.productservice.start.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class ProductService {
	
	private final ProductRepository productRepo;
	
	public List<ProductInfo> getAllProducts() {
		return productRepo.findAll();
	}
	
	public ProductInfo addProduct(ProductInfo product) {
		return productRepo.save(product);
	}
	
	public ProductInfo getProductInfo(Long productId) throws ProductNotFoundException {
		Optional<ProductInfo> productInfo = productRepo.findById(productId);
		if(!productInfo.isPresent())
			throw new ProductNotFoundException("Product not found for Id: " + productId);
		return productInfo.get();
	}

}
