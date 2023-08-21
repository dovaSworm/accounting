package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rddesign.countonrd.entity.Currency;
import com.rddesign.countonrd.service.CurrencyService;
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
public class CurrencyController {
	
	@Autowired
	private CurrencyService currService;

	@PostMapping("/currencies")
	public Currency saveGroup(
			@RequestBody Object curr) {
		Currency currency = new ObjectMapper().convertValue(curr, Currency.class);
		return currService.saveCurrency(currency);
	}

	@GetMapping("/currencies")
	public List<Currency> getCurrencys() {
		return currService.getCurrencys();
	}

	// Update operation
	@PutMapping("/currencies/{id}")
	public Currency updateCurrency(@RequestBody Currency curr,
			@PathVariable("id") Long currId) {
		return currService.updateCurrency(
				curr, currId);
	}

	// Delete operation
	@DeleteMapping("/currencies/{id}")
	public String deleteCurrencyById(@PathVariable("id") Long currId) {
		currService.deleteCurrency(
				currId);
		return "Deleted Successfully";
	}
}
