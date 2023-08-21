package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Currency;
import com.rddesign.countonrd.repository.CurrencyRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currRep;
	
	@Override
	public Currency saveCurrency(Currency curr) {
		System.out.println("CURR " + curr);
		return currRep.save(curr);
	}

	@Override
	public List<Currency> getCurrencys() {
		return (List<Currency>) currRep.findAll();
	}

	@Override
	public Currency updateCurrency(Currency curr, Long id) {
		Currency currDb = (Currency) currRep.findById(id).get();
		if(Objects.nonNull(curr.getName()) && !"".equalsIgnoreCase(curr.getName())) {
			currDb.setName(curr.getName());
		}
		if(Objects.nonNull(curr.getExchRate()) && curr.getExchRate().subtract(currDb.getExchRate()) != BigDecimal.ZERO) {
			currDb.setExchRate(curr.getExchRate());
		}

		return currRep.save(currDb);
	}

	@Override
	public void deleteCurrency(Long id) {
		currRep.deleteById(id);
	}

}
