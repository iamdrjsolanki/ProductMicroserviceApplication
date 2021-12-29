package com.pricingservice.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pricingservice.start.model.ExchangeValue;
import com.pricingservice.start.model.Price;
import com.pricingservice.start.service.PriceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/price")
@AllArgsConstructor
public class PriceController {
	
	private final PriceService priceServ;
	private RestTemplate restTemp;
	
	@GetMapping("/details/{productId}")
	public Price getPriceDetails(@PathVariable Long productId) {
		Price price = priceServ.getPriceInfo(productId);
		ExchangeValue exchVal = restTemp.getForObject("http://localhost:8004/currency-exchange-service/api/currency/exchange"+
														"/from/USD/to/INR", ExchangeValue.class);
		return new Price(price.getPriceId(), price.getProductId(), price.getOriginalPrice(), 
							Math.multiplyExact(exchVal.getExchVal(), price.getDiscountedPrice()));
	}

}