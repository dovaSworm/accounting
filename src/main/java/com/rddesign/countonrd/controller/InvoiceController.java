package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rddesign.countonrd.entity.Invoice;
import com.rddesign.countonrd.service.InvoiceService;
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
public class InvoiceController {

	@Autowired
	private InvoiceService invService;

	@PostMapping("/invoices")
	public Invoice saveInvoice(
			@RequestBody Object ob) {
		Invoice inv = new ObjectMapper()
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
				.registerModule(new JavaTimeModule())
				.convertValue(ob, Invoice.class);
		return invService.saveInvoice(inv);
	}

	@GetMapping("/invoices")
	public List<Invoice> getInvoices() {
		return invService.getInvoices();
	}

	// Update operation
	@PutMapping("/invoices/{id}")
	public Invoice updateInvoice(@RequestBody Invoice inv,
			@PathVariable("id") Long invId) {
		return invService.updateInvoice(
				inv, invId);
	}

	// Delete operation
	@DeleteMapping("/invoices/{id}")
	public String deleteInvoiceById(@PathVariable("id") Long invId) {
		invService.deleteInvoice(
				invId);
		return "Deleted Successfully";
	}
}
