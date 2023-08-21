package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Item;
import com.rddesign.countonrd.entity.Item;
import com.rddesign.countonrd.repository.ItemRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Dova
 */
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRep;

	@Override
	public Item saveItem(Item item) {
		return itemRep.save(item);
	}

	@Override
	public List<Item> getItems() {
		return (List<Item>) itemRep.findAll();
	}

	@Override
	public Item updateItem(Item item, Long id) {
		Item itemDb = (Item) itemRep.findById(id).get();
		if (Objects.nonNull(item.getName()) && !"".equalsIgnoreCase(item.getName())) {
			itemDb.setName(item.getName());
		}
		if (Objects.nonNull(item.getCode()) && !"".equalsIgnoreCase(item.getCode())) {
			itemDb.setCode(item.getCode());
		}
		if (Objects.nonNull(item.getDescription()) && !"".equalsIgnoreCase(item.getDescription())) {
			itemDb.setDescription(item.getDescription());
		}
		if (Objects.nonNull(item.getMesUnit()) && !"".equalsIgnoreCase(item.getMesUnit())) {
			itemDb.setMesUnit(item.getMesUnit());
		}
		if (Objects.nonNull(item.getSellersName()) && !"".equalsIgnoreCase(item.getSellersName())) {
			itemDb.setSellersName(item.getSellersName());
		}
		if (Objects.nonNull(item.getSellersCode()) && !"".equalsIgnoreCase(item.getSellersCode())) {
			itemDb.setSellersCode(item.getSellersCode());
		}
		if (Objects.nonNull(item.getBuyingPrice()) && item.getBuyingPrice().subtract(itemDb.getBuyingPrice()) != BigDecimal.ZERO) {
			itemDb.setBuyingPrice(item.getBuyingPrice());
		}
		if (Objects.nonNull(item.getSellingPrice()) && item.getSellingPrice().subtract(itemDb.getSellingPrice()) != BigDecimal.ZERO) {
			itemDb.setSellingPrice(item.getSellingPrice());
		}
		if (Objects.nonNull(item.getStock()) && item.getStock() - itemDb.getStock() != Double.valueOf("0")) {
			itemDb.setStock(item.getStock());
		}
		if (Objects.nonNull(item.getTax()) && item.getTax() - itemDb.getTax() != 0) {
			itemDb.setTax(item.getTax());
		}
		if (Objects.nonNull(item.getItemType())) {
			itemDb.setItemType(item.getItemType());
		}
		if (Objects.nonNull(item.getSeller())) {
			itemDb.setSeller(item.getSeller());
		}
		return itemRep.save(itemDb);
	}

	@Override
	public void deleteItem(Long id) {
		itemRep.deleteById(id);
	}

}
