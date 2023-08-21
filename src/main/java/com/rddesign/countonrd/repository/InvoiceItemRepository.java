package com.rddesign.countonrd.repository;

import com.rddesign.countonrd.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dova
 */
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{

}
