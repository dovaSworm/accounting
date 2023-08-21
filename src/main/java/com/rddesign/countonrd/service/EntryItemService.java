package com.rddesign.countonrd.service;

import com.rddesign.countonrd.entity.EntryItem;
import java.util.List;

/**
 *
 * @author Dova
 */
public interface EntryItemService {

	EntryItem saveEntryItem(EntryItem ei);

	List<EntryItem> getEntryItems();

	EntryItem updateEntryItem(EntryItem ei, Long id);

	void deleteEntryItem(Long id);
}
