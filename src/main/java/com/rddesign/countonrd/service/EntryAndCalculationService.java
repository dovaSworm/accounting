package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.EntryAndCalculation;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface EntryAndCalculationService {

	EntryAndCalculation saveEntryAndCalculation(EntryAndCalculation entry);

	List<EntryAndCalculation> getEntryAndCalculations();

	EntryAndCalculation updateEntryAndCalculation(EntryAndCalculation entry, Long id);

	void deleteEntryAndCalculation(Long id);
}
