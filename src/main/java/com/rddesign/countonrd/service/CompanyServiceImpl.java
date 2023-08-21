package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Company;
import com.rddesign.countonrd.repository.CompanyRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRep;

	@Override
	public Company saveCompany(Company company) {
		return companyRep.save(company);
	}

	@Override
	public List<Company> getCompanys() {
		return (List<Company>) companyRep.findAll();
	}

	@Override
	public Company updateCompany(Company company, Long id) {
		Company companyDb = (Company) companyRep.findById(id).get();
		if (Objects.nonNull(company.getName()) && !"".equalsIgnoreCase(company.getName())) {
			companyDb.setName(company.getName());
		}
//		if (Objects.nonNull(company.getAdresa()) && !"".equalsIgnoreCase(company.getAdresa())) {
//			companyDb.setAdresa(company.getAdresa());
//		}
		if (Objects.nonNull(company.getCity()) && !"".equalsIgnoreCase(company.getCity())) {
			companyDb.setCity(company.getCity());
		}
		if (Objects.nonNull(company.getZip()) && company.getZip()!= companyDb.getZip()) {
			companyDb.setZip(company.getZip());
		}
		if (Objects.nonNull(company.getMb()) && !"".equalsIgnoreCase(company.getMb())) {
			companyDb.setMb(company.getMb());
		}
		if (Objects.nonNull(company.getPib()) && !"".equalsIgnoreCase(company.getPib())) {
			companyDb.setPib(company.getPib());
		}
		if (Objects.nonNull(company.getEmail()) && !"".equalsIgnoreCase(company.getEmail())) {
			companyDb.setEmail(company.getEmail());
		}
		if (Objects.nonNull(company.getContact()) && !"".equalsIgnoreCase(company.getContact())) {
			companyDb.setContact(company.getContact());
		}
		if (Objects.nonNull(company.getPhone()) && !"".equalsIgnoreCase(company.getPhone())) {
			companyDb.setPhone(company.getPhone());
		}
		if (Objects.nonNull(company.getBank()) && !"".equalsIgnoreCase(company.getBank())) {
			companyDb.setBank(company.getBank());
		}
		if (Objects.nonNull(company.getAccountNum()) && !"".equalsIgnoreCase(company.getAccountNum())) {
			companyDb.setAccountNum(company.getAccountNum());
		}
		return companyRep.save(companyDb);
	}

	@Override
	public void deleteCompany(Long id) {
		companyRep.deleteById(id);
	}

}
