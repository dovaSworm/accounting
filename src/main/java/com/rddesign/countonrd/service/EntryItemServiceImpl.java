package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.EntryItem;
import com.rddesign.countonrd.repository.EntryItemRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class EntryItemServiceImpl implements EntryItemService {

	@Autowired
	private EntryItemRepository eiRep;

	@Override
	public EntryItem saveEntryItem(EntryItem ei) {
		return eiRep.save(ei);
	}

	@Override
	public List<EntryItem> getEntryItems() {
		return (List<EntryItem>) eiRep.findAll();
	}

	@Override
	public EntryItem updateEntryItem(EntryItem entryItem, Long id) {
		EntryItem entryItemDb = (EntryItem) eiRep.findById(id).get();
		if (Objects.nonNull(entryItem.getItem()) && !Objects.equals(entryItem.getItem(), entryItemDb.getItem())) {
			entryItemDb.setItem(entryItem.getItem());
		}
		if (Objects.nonNull(entryItem.getEntry()) && !Objects.equals(entryItem.getEntry(), entryItem.getEntry())) {
			entryItemDb.setEntry(entryItem.getEntry());
		}
		if (Objects.nonNull(entryItem.getBuyingHome()) && !Objects.equals(entryItem.getBuyingHome(), entryItemDb.getBuyingHome())) {
			entryItemDb.setBuyingHome(entryItem.getBuyingHome());
		}
		if (Objects.nonNull(entryItem.getBuyingFrn()) && entryItem.getBuyingFrn().subtract(entryItem.getBuyingFrn()) != BigDecimal.ZERO) {
			entryItemDb.setBuyingFrn(entryItem.getBuyingFrn());
		}
			if (Objects.nonNull(entryItem.getSellingHome()) && !Objects.equals(entryItem.getSellingHome(), entryItemDb.getSellingHome())) {
			entryItemDb.setSellingHome(entryItem.getSellingHome());
		}
		if (Objects.nonNull(entryItem.getSellingFrn()) && entryItem.getSellingFrn().subtract(entryItem.getSellingFrn()) != BigDecimal.ZERO) {
			entryItemDb.setSellingFrn(entryItem.getSellingFrn());
		}
		if (Objects.nonNull(entryItem.getTotal()) && entryItem.getTotal().subtract(entryItemDb.getTotal()) != BigDecimal.ZERO) {
			entryItemDb.setTotal(entryItem.getTotal());
		}
		if (Objects.nonNull(entryItem.getExchRate()) && entryItem.getExchRate().subtract(entryItemDb.getExchRate()) != BigDecimal.ZERO) {
			entryItemDb.setExchRate(entryItem.getExchRate());
		}
		if (Objects.nonNull(entryItem.getQuantity()) && !Objects.equals(entryItem.getQuantity(), entryItemDb.getQuantity())) {
			entryItemDb.setQuantity(entryItem.getQuantity());
		}
		return eiRep.save(entryItemDb);
	}

	@Override
	public void deleteEntryItem(Long id) {
		eiRep.deleteById(id);
	}
}
