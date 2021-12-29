package com.pricingservice.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pricingservice.start.model.Price;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PriceService {
	
	List<Price> priceList = new ArrayList<Price>();
	
	public Price getPriceInfo(Long productId) {
		populatePriceList();
		
		for(Price p : priceList) {
			if(productId.equals(p.getProductId()))
				return p;
		}
		
		return null;
	}

	private void populatePriceList() {
		priceList.add(new Price(101L, 1001L, 999, 899));
		priceList.add(new Price(102L, 1002L, 899, 799));
		priceList.add(new Price(103L, 1003L, 299, 199));
		priceList.add(new Price(104L, 1004L, 699, 599));
		priceList.add(new Price(105L, 1005L, 599, 499));
	}

}
