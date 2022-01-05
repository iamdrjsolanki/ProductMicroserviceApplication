package com.pricingservice.start.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pricingservice.start.exception.PriceNotFoundException;
import com.pricingservice.start.model.Price;
import com.pricingservice.start.repository.PriceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceService {

	private final PriceRepository priceRepo;
	
	public List<Price> getAllPrices() {
		return priceRepo.findAll();
	}

	public Price addPrice(Price price) {
		return priceRepo.save(price);
	}
	
	public Price getPriceInfo(Long productId) throws PriceNotFoundException {
		Optional<Price> price = priceRepo.findByProductId(productId);
		if(!price.isPresent())
			throw new PriceNotFoundException("Price not found for product Id: " + productId);
		return price.get();
	}

}
