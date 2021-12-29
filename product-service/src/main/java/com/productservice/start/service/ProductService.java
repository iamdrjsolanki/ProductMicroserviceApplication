package com.productservice.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.productservice.start.model.ProductInfo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	public ProductInfo getProductInfo(Long productId) {
		populateProductList();
		
		for(ProductInfo p : productList) {
			if(productId.equals(p.getProductId()))
				return p;
		}
		
		return null;
	}

	private void populateProductList() {
		productList.add(new ProductInfo(1001L, "iPhone", "phone"));
		productList.add(new ProductInfo(1002L, "Samsung", "phone"));
		productList.add(new ProductInfo(1003L, "Nokia", "phone"));
		productList.add(new ProductInfo(1004L, "Google", "phone"));
		productList.add(new ProductInfo(1005L, "Oneplus", "phone"));
	}

}
