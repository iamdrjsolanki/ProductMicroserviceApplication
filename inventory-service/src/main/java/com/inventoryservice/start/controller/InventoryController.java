package com.inventoryservice.start.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryservice.start.exception.InventoryNotFoundException;
import com.inventoryservice.start.model.Inventory;
import com.inventoryservice.start.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@AllArgsConstructor
public class InventoryController {
	
	private final InventoryService inventoryServ;
	
	@GetMapping("/all")
	public List<Inventory> getAllInventory() {
		return inventoryServ.getAllInventory();
	}
	
	@PostMapping("/add")
	public Inventory addInventory(@RequestBody Inventory inventory) {
		return inventoryServ.addInventory(inventory);
	}
	
	@GetMapping("/details/{productId}")
	public Inventory getInventoryDetails(@PathVariable Long productId) throws InventoryNotFoundException {
		Inventory inventory = inventoryServ.getInventoryInfo(productId);
		return new Inventory(inventory.getInventoryId(), inventory.getProductId(), inventory.getStock());
	}

}
