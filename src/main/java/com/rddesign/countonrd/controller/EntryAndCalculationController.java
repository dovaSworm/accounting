package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rddesign.countonrd.CountonrdApplication;
import com.rddesign.countonrd.entity.EntryAndCalculation;
import com.rddesign.countonrd.service.EntryAndCalculationService;
import java.text.SimpleDateFormat;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class EntryAndCalculationController {
	
	private static final Logger LOG = LogManager.getLogger(EntryAndCalculationController.class.getName());
	@Autowired
	private EntryAndCalculationService entryService;

	@PostMapping("/entries")
	public EntryAndCalculation saveEntryAndCalculation(
			@RequestBody Object ob) {
		EntryAndCalculation entry = new ObjectMapper()
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
				.registerModule(new JavaTimeModule())
				.convertValue(ob, EntryAndCalculation.class);
		return entryService.saveEntryAndCalculation(entry);
	}

	@GetMapping("/entries")
	public List<EntryAndCalculation> getEntryAndCalculations() {
		LOG.debug("GET EntryAndCalculationController {}", entryService.getEntryAndCalculations());
		return entryService.getEntryAndCalculations();
	}

	@PutMapping("/entries/{id}")
	public EntryAndCalculation updateEntryAndCalculation(@RequestBody EntryAndCalculation entry,
			@PathVariable("id") Long entryId) {
		return entryService.updateEntryAndCalculation(
				entry, entryId);
	}

	// Delete operation
	@DeleteMapping("/entries/{id}")
	public String deleteEntryAndCalculationById(@PathVariable("id") Long entryId) {
		entryService.deleteEntryAndCalculation(
				entryId);
		return "Deleted Successfully";
	}
}
