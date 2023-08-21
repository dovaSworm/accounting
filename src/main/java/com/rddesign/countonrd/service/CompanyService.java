package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Company;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface CompanyService {

	Company saveCompany(Company company);

	List<Company> getCompanys();

	Company updateCompany(Company company, Long id);

	void deleteCompany(Long id);
}
