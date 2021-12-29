package com.productservice.start.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.productservice.start.model.Inventory;
import com.productservice.start.model.Price;
import com.productservice.start.model.Product;
import com.productservice.start.model.ProductInfo;
import com.productservice.start.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {
	
	private final ProductService productServ;
	
	@Autowired
	private RestTemplate restTemp;
	
	@GetMapping("/details/{productId}")
	public Product getProductDetails(@PathVariable Long productId) {
		
		ProductInfo productInfo = productServ.getProductInfo(productId);
		
		Price price = restTemp.getForObject("http://localhost:8002/pricing-service/api/price/details/" + productId, Price.class);
		
		Inventory inventory = restTemp.getForObject("http://localhost:8003/inventory-service/api/inventory/details/" 
											+ productId, Inventory.class);
		
		return new Product(productInfo.getProductId(), productInfo.getProductName(), productInfo.getProductDesc(), 
							price.getDiscountedPrice(), inventory.getStock());
	}

}
