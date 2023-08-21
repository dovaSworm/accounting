package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rddesign.countonrd.CountonrdApplication;
import com.rddesign.countonrd.entity.InvoiceItem;
import com.rddesign.countonrd.service.InvoiceItemService;
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
public class InvoiceItemController {

	private static final Logger LOG = LogManager.getLogger(EntryAndCalculationController.class.getName());
	@Autowired
	private InvoiceItemService invService;

	@PostMapping("/invoice_items")
	public InvoiceItem saveInvoiceItem(
			@RequestBody Object ob) {
		InvoiceItem inv = new ObjectMapper()
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
				.registerModule(new JavaTimeModule())
				.convertValue(ob, InvoiceItem.class);
		return invService.saveInvoiceItem(inv);
	}

	@GetMapping("/invoice_items")
	public List<InvoiceItem> getInvoiceItems() {
		LOG.error("GET InvoiceItemController {}", invService.getInvoiceItems());
		return invService.getInvoiceItems();
	}

	// Update operation
	@PutMapping("/invoice_items/{id}")
	public InvoiceItem updateInvoiceItem(@RequestBody InvoiceItem inv,
			@PathVariable("id") Long invId) {
		return invService.updateInvoiceItem(
				inv, invId);
	}

	// Delete operation
	@DeleteMapping("/invoice_items/{id}")
	public String deleteInvoiceItemById(@PathVariable("id") Long invId) {
		invService.deleteInvoiceItem(
				invId);
		return "Deleted Successfully";
	}
}
