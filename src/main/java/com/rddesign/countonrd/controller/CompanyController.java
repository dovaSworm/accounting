package com.rddesign.countonrd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rddesign.countonrd.entity.Company;
import com.rddesign.countonrd.service.CompanyService;
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
public class CompanyController {
	@Autowired private CompanyService compService;
	@PostMapping("/companies")
	public Company saveGroup(
			@RequestBody Object comp) {
		Company company = new ObjectMapper().convertValue(comp, Company.class);
		return compService.saveCompany(company);
	}

	@GetMapping("/companies")
	public List<Company> getCompanys() {
		return compService.getCompanys();
	}

	// Update operation
	@PutMapping("/companies/{id}")
	public Company updateCompany(@RequestBody Company comp,
			@PathVariable("id") Long compId) {
		return compService.updateCompany(
				comp, compId);
	}

	// Delete operation
	@DeleteMapping("/companies/{id}")
	public String deleteCompanyById(@PathVariable("id") Long compId) {
		compService.deleteCompany(
				compId);
		return "Deleted Successfully";
	}
}
