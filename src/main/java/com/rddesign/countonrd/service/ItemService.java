package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.Item;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface ItemService {

	Item saveItem(Item item);

	List<Item> getItems();

	Item updateItem(Item item, Long id);

	void deleteItem(Long id);
}
