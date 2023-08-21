package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.InvoiceType;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface InvoiceTypeService {

	InvoiceType saveInvoiceType(InvoiceType it);

	List<InvoiceType> getInvoiceTypes();

	InvoiceType updateInvoiceType(InvoiceType it, Long id);

	void deleteInvoiceType(Long id);
}
