package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.EntryAndCalculation;
import com.rddesign.countonrd.repository.EntryAndCalculationRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class EntryAndCalculationServiceImpl implements EntryAndCalculationService {

	@Autowired
	private EntryAndCalculationRepository entryRep;

	@Override
	public EntryAndCalculation saveEntryAndCalculation(EntryAndCalculation entry) {
		return entryRep.save(entry);
	}

	@Override
	public List<EntryAndCalculation> getEntryAndCalculations() {
		return (List<EntryAndCalculation>) entryRep.findAll();
	}

	@Override
	public EntryAndCalculation updateEntryAndCalculation(EntryAndCalculation entry, Long id) {
		EntryAndCalculation entryDb = (EntryAndCalculation) entryRep.findById(id).get();
		if (Objects.nonNull(entry.getName()) && !"".equalsIgnoreCase(entry.getName())) {
			entryDb.setName(entry.getName());
		}
		if (Objects.nonNull(entry.getCurrency()) && !Objects.equals(entry.getCurrency(), entryDb.getCurrency())) {
			entryDb.setCurrency(entry.getCurrency());
		}
		if (Objects.nonNull(entry.getSeller()) && !Objects.equals(entry.getSeller(), entryDb.getSeller())) {
			entryDb.setSeller(entry.getSeller());
		}

		if (Objects.nonNull(entry.getTotal()) && entry.getTotal().subtract(entryDb.getTotal()) != BigDecimal.ZERO) {
			entryDb.setTotal(entry.getTotal());
		}
		if (Objects.nonNull(entry.getDate()) && !Objects.equals(entry.getDate(), entryDb.getDate())) {
			entryDb.setDate(entry.getDate());
		}
		return entryRep.save(entryDb);
	}

	@Override
	public void deleteEntryAndCalculation(Long id) {
		entryRep.deleteById(id);
	}
}
