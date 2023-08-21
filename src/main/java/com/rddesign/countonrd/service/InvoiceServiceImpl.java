package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Invoice;
import com.rddesign.countonrd.repository.InvoiceRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invRep;

	@Override
	public Invoice saveInvoice(Invoice inv) {
		return invRep.save(inv);
	}

	@Override
	public List<Invoice> getInvoices() {
		return (List<Invoice>) invRep.findAll();
	}

	@Override
	public Invoice updateInvoice(Invoice inv, Long id) {
		Invoice invDb = (Invoice) invRep.findById(id).get();
		if (Objects.nonNull(inv.getInvNum()) && !"".equalsIgnoreCase(inv.getInvNum())) {
			invDb.setInvNum(inv.getInvNum());
		}
		if (Objects.nonNull(inv.getCurrency()) && !Objects.equals(inv.getCurrency(), invDb.getCurrency())) {
			invDb.setCurrency(inv.getCurrency());
		}
		if (Objects.nonNull(inv.getInvoiceType()) && !Objects.equals(inv.getInvoiceType(), inv.getInvoiceType())) {
			invDb.setInvoiceType(inv.getInvoiceType());
		}
		if (Objects.nonNull(inv.getSeller()) && !Objects.equals(inv.getSeller(), invDb.getSeller())) {
			invDb.setSeller(inv.getSeller());
		}
		if (Objects.nonNull(inv.getBuyer()) && !Objects.equals(inv.getBuyer(), invDb.getBuyer())) {
			invDb.setBuyer(inv.getBuyer());
		}
		if (Objects.nonNull(inv.getNotes()) && !"".equalsIgnoreCase(inv.getNotes())) {
			invDb.setNotes(inv.getNotes());
		}
		if (Objects.nonNull(inv.getLetters()) && !"".equalsIgnoreCase(inv.getLetters())) {
			invDb.setLetters(inv.getLetters());
		}
		if (Objects.nonNull(inv.getDiscount()) && inv.getDiscount().subtract(invDb.getDiscount()) != BigDecimal.ZERO) {
			invDb.setDiscount(inv.getDiscount());
		}
		if (Objects.nonNull(inv.getTotal()) && inv.getTotal().subtract(invDb.getTotal()) != BigDecimal.ZERO) {
			invDb.setTotal(inv.getTotal());
		}
		if (Objects.nonNull(inv.getPayed()) && inv.getPayed().subtract(invDb.getPayed()) != BigDecimal.ZERO) {
			invDb.setPayed(inv.getPayed());
		}
		if (Objects.nonNull(inv.getDue()) && inv.getDue().subtract(invDb.getDue()) != BigDecimal.ZERO) {
			invDb.setDue(inv.getDue());
		}
		if (Objects.nonNull(inv.getDate()) && !Objects.equals(inv.getDate(), invDb.getDate())) {
			invDb.setDate(inv.getDate());
		}
		if (Objects.nonNull(inv.getPayDeadline()) && !Objects.equals(inv.getPayDeadline(), invDb.getPayDeadline())) {
			invDb.setPayDeadline(inv.getPayDeadline());
		}
		return invRep.save(invDb);
	}

	@Override
	public void deleteInvoice(Long id) {
		invRep.deleteById(id);
	}
}
