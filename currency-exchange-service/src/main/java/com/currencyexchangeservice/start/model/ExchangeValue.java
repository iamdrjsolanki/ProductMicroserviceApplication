package com.currencyexchangeservice.start.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {
	
	private Long currExchId;
	private Currencies from;
	private Currencies to;
	private Integer exchVal;

}
