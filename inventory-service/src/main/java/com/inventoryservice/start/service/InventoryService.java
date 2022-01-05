package com.inventoryservice.start.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inventoryservice.start.exception.InventoryNotFoundException;
import com.inventoryservice.start.model.Inventory;
import com.inventoryservice.start.repository.InventoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class InventoryService {
	
	private final InventoryRepository inventoryRepo;
	
	public List<Inventory> getAllInventory() {
		return inventoryRepo.findAll();
	}

	public Inventory addInventory(Inventory inventory) {
		return inventoryRepo.save(inventory);
	}
	
	public Inventory getInventoryInfo(Long productId) throws InventoryNotFoundException {
		Optional<Inventory> inventory = inventoryRepo.findByProductId(productId);
		if(!inventory.isPresent())
			throw new InventoryNotFoundException("Inventory not found for product Id: " + productId);
		return inventory.get();
	}

}
