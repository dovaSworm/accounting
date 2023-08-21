package com.rddesign.countonrd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Dova
 */
@Entity
@Table(name = "invoice_items")
public class InvoiceItem implements Serializable {
	
	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;
	
	@JoinColumn(name="item_id", referencedColumnName="id")
	@ManyToOne
	private Item item;
	
	@JoinColumn(name="invoice_id", referencedColumnName="id")
	@ManyToOne
	private Invoice invoice;
	
	@Column(name = "tax")
	private int tax;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "total")
	private BigDecimal total;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "quantity")
	private double quantity;

	public InvoiceItem(Long id, Item item, Invoice invoice, int tax, BigDecimal discount, BigDecimal total, BigDecimal price, double quantity) {
		this.id = id;
		this.item = item;
		this.invoice = invoice;
		this.tax = tax;
		this.discount = discount;
		this.total = total;
		this.price = price;
		this.quantity = quantity;
	}

	public InvoiceItem(Long id) {
		this.id = id;
	}

	public InvoiceItem() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.id);
		hash = 97 * hash + Objects.hashCode(this.invoice);
		hash = 97 * hash + Objects.hashCode(this.total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final InvoiceItem other = (InvoiceItem) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}
	
}
