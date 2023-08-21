package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.ItemType;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import com.rddesign.countonrd.repository.ItemTypeRepository;

/**
 *
 * @author Dova
 */
public class ItemTypeServiceImpl implements ItemTypeService {
	
	@Autowired
	private ItemTypeRepository itRep; 

	@Override
	public ItemType saveItemType(ItemType it) {
		return itRep.save(it);
	}

	@Override
	public List<ItemType> getItemTypes() {
		return (List<ItemType>) itRep.findAll();
	}

	@Override
	public ItemType updateItemType(ItemType it, Long id) {
		ItemType itDb = (ItemType) itRep.findById(id).get();
		if(Objects.nonNull(it.getName()) && !"".equalsIgnoreCase(it.getName())) {
			itDb.setName(it.getName());
		}
		return itRep.save(itDb);
	}

	@Override
	public void deleteItemType(Long id) {
		itRep.deleteById(id);
	}

}
