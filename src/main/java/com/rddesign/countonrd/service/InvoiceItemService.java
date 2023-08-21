package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.InvoiceItem;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface InvoiceItemService {

	InvoiceItem saveInvoiceItem(InvoiceItem inv);

	List<InvoiceItem> getInvoiceItems();

	InvoiceItem updateInvoiceItem(InvoiceItem inv, Long id);

	void deleteInvoiceItem(Long id);
}
