package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Invoice;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface InvoiceService {

	Invoice saveInvoice(Invoice inv);

	List<Invoice> getInvoices();

	Invoice updateInvoice(Invoice inv, Long id);

	void deleteInvoice(Long id);
}
