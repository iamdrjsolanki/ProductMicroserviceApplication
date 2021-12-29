package com.inventoryservice.start.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
	
	private Long inventoryId;
	private Long productId;
	private Boolean stock;

}
