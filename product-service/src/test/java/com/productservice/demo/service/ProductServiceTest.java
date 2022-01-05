package com.productservice.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.productservice.start.exception.ProductNotFoundException;
import com.productservice.start.model.ProductInfo;
import com.productservice.start.repository.ProductRepository;
import com.productservice.start.service.ProductService;

public class ProductServiceTest {
	
	@Autowired
	public ProductService productService;
	
	@Autowired
	public ProductRepository productRepo;
	
	@BeforeEach
	void setUp() {
		Optional<ProductInfo> product = Optional.of(ProductInfo.builder()
														.productId(1L)
														.productName("iPhone")
														.productDesc("smartphone")
														.build());
		Mockito.when(productRepo.findById(1L)).thenReturn(product);
	}
	
	@Test
	public void whenValidProductInfo_thenProductShouldFound() throws ProductNotFoundException {
		Long productId = 1L;
		ProductInfo found = productService.getProductInfo(productId);
		assertThat(productId).usingRecursiveComparison().isEqualTo(found.getProductId());
	}
	
	@Test
	@DisplayName("Get data based on invalid product Id")
	@Disabled
	public void whenInValidProductInfo_thenProductShouldNotFound() throws ProductNotFoundException {
		Long productId = 1006L;
		ProductInfo found = productService.getProductInfo(productId);
		assertThat(productId).usingRecursiveComparison().isNotEqualTo(found.getProductId());
	}

}
