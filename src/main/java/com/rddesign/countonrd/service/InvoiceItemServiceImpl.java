package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.InvoiceItem;
import com.rddesign.countonrd.repository.InvoiceItemRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class InvoiceItemServiceImpl implements InvoiceItemService {

	@Autowired
	private InvoiceItemRepository invRep;

	@Override
	public InvoiceItem saveInvoiceItem(InvoiceItem inv) {
		return invRep.save(inv);
	}

	@Override
	public List<InvoiceItem> getInvoiceItems() {
		return (List<InvoiceItem>) invRep.findAll();
	}

	@Override
	public InvoiceItem updateInvoiceItem(InvoiceItem inv, Long id) {
		InvoiceItem invDb = (InvoiceItem) invRep.findById(id).get();
		if (Objects.nonNull(inv.getItem()) && !Objects.equals(inv.getItem(), invDb.getItem())) {
			invDb.setItem(inv.getItem());
		}
		if (Objects.nonNull(inv.getInvoice()) && !Objects.equals(inv.getInvoice(), inv.getInvoice())) {
			invDb.setInvoice(inv.getInvoice());
		}
		if (Objects.nonNull(inv.getTax()) && !Objects.equals(inv.getTax(), invDb.getTax())) {
			invDb.setTax(inv.getTax());
		}
		if (Objects.nonNull(inv.getDiscount()) && inv.getDiscount().subtract(invDb.getDiscount()) != BigDecimal.ZERO) {
			invDb.setDiscount(inv.getDiscount());
		}
		if (Objects.nonNull(inv.getTotal()) && inv.getTotal().subtract(invDb.getTotal()) != BigDecimal.ZERO) {
			invDb.setTotal(inv.getTotal());
		}
		if (Objects.nonNull(inv.getPrice()) && inv.getPrice().subtract(invDb.getPrice()) != BigDecimal.ZERO) {
			invDb.setPrice(inv.getPrice());
		}
		if (Objects.nonNull(inv.getQuantity()) && !Objects.equals(inv.getQuantity(), invDb.getQuantity())) {
			invDb.setQuantity(inv.getQuantity());
		}
		return invRep.save(invDb);
	}

	@Override
	public void deleteInvoiceItem(Long id) {
		invRep.deleteById(id);
	}
}
