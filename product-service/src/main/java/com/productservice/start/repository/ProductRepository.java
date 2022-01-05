package com.productservice.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productservice.start.model.ProductInfo;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long> {

}
