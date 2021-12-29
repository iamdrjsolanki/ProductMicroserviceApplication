package com.currencyexchangeservice.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currencyexchangeservice.start.model.Currencies;
import com.currencyexchangeservice.start.model.ExchangeValue;

@RestController
@RequestMapping("/api/currency")
public class CurrencyExchangeController {
	
	@GetMapping("/exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable("from") Currencies from, @PathVariable("to") Currencies to) {
		
		ExchangeValue exchVal = null;
		
		if(Currencies.USD == from && Currencies.INR == to) {
			exchVal = new ExchangeValue(901L, from, to, 75);
		} else if(Currencies.USD == from && Currencies.YEN == to) {
			exchVal = new ExchangeValue(902L, from, to, 115);
		} else if(Currencies.USD == from && Currencies.GBP == to) {
			exchVal = new ExchangeValue(902L, from, to, 1);
		} else if(Currencies.USD == from && Currencies.AUD == to) {
			exchVal = new ExchangeValue(902L, from, to, 2);
		}
		
		return exchVal;
	}

}
