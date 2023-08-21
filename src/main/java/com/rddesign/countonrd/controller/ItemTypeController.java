package com.rddesign.countonrd.controller;

import com.rddesign.countonrd.entity.ItemType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rddesign.countonrd.service.ItemTypeService;

/**
 *
 * @author Dova
 */
@RestController
public class ItemTypeController {
	@Autowired private ItemTypeService itService;
	@PostMapping("/item_types")
	public ItemType saveGroup(
			@RequestBody ItemType it) {
		return itService.saveItemType(it);
	}

	@GetMapping("/item_types")
	public List<ItemType> getItemTypes() {
		return itService.getItemTypes();
	}

	// Update operation
	@PutMapping("/item_types/{id}")
	public ItemType updateItemType(@RequestBody ItemType it,
			@PathVariable("id") Long itId) {
		return itService.updateItemType(
				it, itId);
	}

	// Delete operation
	@DeleteMapping("/item_types/{id}")
	public String deleteItemTypeById(@PathVariable("id") Long itId) {
		itService.deleteItemType(
				itId);
		return "Deleted Successfully";
	}
}
