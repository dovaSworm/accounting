package com.rddesign.countonrd.repository;

import com.rddesign.countonrd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dova
 */
public interface ItemRepository extends JpaRepository<Item, Long>{

}
