package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rddesign.countonrd.entity.EntryItem;
import com.rddesign.countonrd.service.EntryItemService;
import java.text.SimpleDateFormat;
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
public class EntryItemController {

	@Autowired
	private EntryItemService eiService;

	@PostMapping("/entry_items")
	public EntryItem saveEntryItem(
			@RequestBody Object ob) {
		EntryItem entryItem = new ObjectMapper()
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
				.registerModule(new JavaTimeModule())
				.convertValue(ob, EntryItem.class);
		return eiService.saveEntryItem(entryItem);
	}

	@GetMapping("/entry_items")
	public List<EntryItem> getEntryItems() {
		return eiService.getEntryItems();
	}

	// Update operation
	@PutMapping("/entry_items/{id}")
	public EntryItem updateEntryItem(@RequestBody EntryItem entryItem,
			@PathVariable("id") Long id) {
		return eiService.updateEntryItem(
				entryItem, id);
	}

	// Delete operation
	@DeleteMapping("/entry_items/{id}")
	public String deleteEntryItemById(@PathVariable("id") Long id) {
		eiService.deleteEntryItem(
				id);
		return "Deleted Successfully";
	}
}
