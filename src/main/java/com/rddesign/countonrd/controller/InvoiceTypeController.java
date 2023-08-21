package com.rddesign.countonrd.controller;

import com.rddesign.countonrd.entity.InvoiceType;
import com.rddesign.countonrd.service.InvoiceTypeService;
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
public class InvoiceTypeController {

	@Autowired
	private InvoiceTypeService itService;

	@PostMapping("/invoice_types")
	public InvoiceType saveGroup(
			@RequestBody InvoiceType it) {
		return itService.saveInvoiceType(it);
	}

	@GetMapping("/invoice_types")
	public List<InvoiceType> getInvoiceTypes() {
		return itService.getInvoiceTypes();
	}

	// Update operation
	@PutMapping("/invoice_types/{id}")
	public InvoiceType updateInvoiceType(@RequestBody InvoiceType it,
			@PathVariable("id") Long itId) {
		return itService.updateInvoiceType(
				it, itId);
	}

	// Delete operation
	@DeleteMapping("/invoice_types/{id}")
	public String deleteInvoiceTypeById(@PathVariable("id") Long itId) {
		itService.deleteInvoiceType(
				itId);
		return "Deleted Successfully";
	}
}
