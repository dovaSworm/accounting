package com.rddesign.countonrd.repository;

import com.rddesign.countonrd.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dova
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
