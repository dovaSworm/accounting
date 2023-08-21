package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Currency;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface CurrencyService {
	Currency saveCurrency(Currency curr);

	List<Currency> getCurrencys();

	Currency updateCurrency(Currency curr, Long id);

	void deleteCurrency(Long id);
}
