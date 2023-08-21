package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.ItemType;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface ItemTypeService {

	ItemType saveItemType(ItemType it);

	List<ItemType> getItemTypes();

	ItemType updateItemType(ItemType it, Long id);

	void deleteItemType(Long id);
}
