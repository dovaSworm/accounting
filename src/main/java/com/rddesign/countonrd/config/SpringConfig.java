package com.rddesign.countonrd.config;

import com.rddesign.countonrd.service.CompanyService;
import com.rddesign.countonrd.service.CompanyServiceImpl;
import com.rddesign.countonrd.service.CurrencyService;
import com.rddesign.countonrd.service.CurrencyServiceImpl;
import com.rddesign.countonrd.service.EntryAndCalculationService;
import com.rddesign.countonrd.service.EntryAndCalculationServiceImpl;
import com.rddesign.countonrd.service.EntryItemService;
import com.rddesign.countonrd.service.EntryItemServiceImpl;
import com.rddesign.countonrd.service.InvoiceItemService;
import com.rddesign.countonrd.service.InvoiceItemServiceImpl;
import com.rddesign.countonrd.service.InvoiceService;
import com.rddesign.countonrd.service.InvoiceServiceImpl;
import com.rddesign.countonrd.service.InvoiceTypeService;
import com.rddesign.countonrd.service.InvoiceTypeServiceImpl;
import com.rddesign.countonrd.service.ItemService;
import com.rddesign.countonrd.service.ItemServiceImpl;
import com.rddesign.countonrd.service.ItemTypeServiceImpl;
import com.rddesign.countonrd.service.UserService;
import com.rddesign.countonrd.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rddesign.countonrd.service.ItemTypeService;

/**
 *
 * @author Dova
 */
@Configuration
public class SpringConfig {

	@Bean
	public UserService UserService() {
		return new UserServiceImpl();
	}
	@Bean
	public ItemTypeService ItemTypeService() {
		return new ItemTypeServiceImpl();
	}
	@Bean
	public CurrencyService CurrencyService() {
		return new CurrencyServiceImpl();
	}
	
	@Bean
	public InvoiceTypeService InvoiceTypeService() {
		return new InvoiceTypeServiceImpl();
	}
	
	@Bean
	public CompanyService CompanyService() {
		return new CompanyServiceImpl();
	}
	
	@Bean
	public ItemService ItemService() {
		return new ItemServiceImpl();
	}
	
	@Bean
	public InvoiceService InvoiceService() {
		return new InvoiceServiceImpl();
	}
	
	@Bean
	public InvoiceItemService InvoiceItemService() {
		return new InvoiceItemServiceImpl();
	}
	
	@Bean
	public EntryAndCalculationService EntryAndCalculationService() {
		return new EntryAndCalculationServiceImpl();
	}
	
	@Bean
	public EntryItemService EntryItemService() {
		return new EntryItemServiceImpl();
	}
}
