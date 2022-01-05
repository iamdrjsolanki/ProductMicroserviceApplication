package com.pricingservice.start.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pricingservice.start.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

	Optional<Price> findByProductId(Long productId);

}
