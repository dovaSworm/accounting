package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.InvoiceType;
import com.rddesign.countonrd.repository.InvoiceTypeRepository;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class InvoiceTypeServiceImpl implements InvoiceTypeService {
		@Autowired
	private InvoiceTypeRepository itRep; 

	@Override
	public InvoiceType saveInvoiceType(InvoiceType it) {
		return itRep.save(it);
	}

	@Override
	public List<InvoiceType> getInvoiceTypes() {
		return (List<InvoiceType>) itRep.findAll();
	}

	@Override
	public InvoiceType updateInvoiceType(InvoiceType it, Long id) {
		InvoiceType itDb = (InvoiceType) itRep.findById(id).get();
		if(Objects.nonNull(it.getName()) && !"".equalsIgnoreCase(it.getName())) {
			itDb.setName(it.getName());
		}
		return itRep.save(itDb);
	}

	@Override
	public void deleteInvoiceType(Long id) {
		itRep.deleteById(id);
	}
}
