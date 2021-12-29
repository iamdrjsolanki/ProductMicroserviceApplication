package com.inventoryservice.start.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventoryservice.start.model.Inventory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryService {
	
	List<Inventory> inventoryList = new ArrayList<Inventory>();
	
	public Inventory getInventoryInfo(Long productId) {
		populateInventoryList();
		
		for(Inventory i : inventoryList) {
			if(productId.equals(i.getProductId()))
				return i;
		}
		
		return null;
	}

	private void populateInventoryList() {
		inventoryList.add(new Inventory(01L, 1001L, false));
		inventoryList.add(new Inventory(02L, 1002L, true));
		inventoryList.add(new Inventory(03L, 1003L, false));
		inventoryList.add(new Inventory(04L, 1004L, true));
		inventoryList.add(new Inventory(05L, 1005L, true));
	}

}
