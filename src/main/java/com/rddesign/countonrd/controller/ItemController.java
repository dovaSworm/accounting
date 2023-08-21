package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rddesign.countonrd.entity.Item;
import com.rddesign.countonrd.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dova
 */
@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;

	@PostMapping("/items")
	public Item saveItem(
			@RequestBody Object item) {
		Item Item = new ObjectMapper().convertValue(item, Item.class);
		return itemService.saveItem(Item);
	}

	@GetMapping("/items")
	public List<Item> getItems() {
		return itemService.getItems();
	}

	// Update operation
	@PutMapping("/items/{id}")
	public Item updateItem(@RequestBody Item item,
			@PathVariable("id") Long itemId) {
		return itemService.updateItem(
				item, itemId);
	}

	// Delete operation
	@DeleteMapping("/items/{id}")
	public String deleteItemById(@PathVariable("id") Long itemId) {
		itemService.deleteItem(
				itemId);
		return "Deleted Successfully";
	}
}
