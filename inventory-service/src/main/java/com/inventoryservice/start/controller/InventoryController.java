package com.inventoryservice.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryservice.start.model.Inventory;
import com.inventoryservice.start.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryServ;
	
	@GetMapping("/details/{productId}")
	public Inventory getInventoryDetails(@PathVariable Long productId) {
		Inventory inventory = inventoryServ.getInventoryInfo(productId);
		return new Inventory(inventory.getInventoryId(), inventory.getProductId(), inventory.getStock());
	}

}
