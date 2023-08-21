package com.rddesign.countonrd.entity;

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
@Table(name = "entry_items")
public class EntryItem {
	
	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;

	@JoinColumn(name = "entry_id", referencedColumnName = "id")
	@ManyToOne
	private EntryAndCalculation entry;

	@JoinColumn(name = "item_id", referencedColumnName = "id")
	@ManyToOne
	private Item item;

	@Column(name = "quantity")
	private double quantity;

	@Column(name = "exch_rate")
	private BigDecimal exchRate;

	@Column(name = "buying_frn")
	private BigDecimal buyingFrn;

	@Column(name = "selling_frn")
	private BigDecimal sellingFrn;

	@Column(name = "buying_home")
	private BigDecimal buyingHome;

	@Column(name = "selling_home")
	private BigDecimal sellingHome;
	
	@Column(name = "total")
	private BigDecimal total;

	public EntryItem(Long id, EntryAndCalculation entry, Item item, double quantity, BigDecimal exchRate, BigDecimal buyingFrn, BigDecimal sellingFrn, BigDecimal buyingHome, BigDecimal sellingHome, BigDecimal total) {
		this.id = id;
		this.entry = entry;
		this.item = item;
		this.quantity = quantity;
		this.exchRate = exchRate;
		this.buyingFrn = buyingFrn;
		this.sellingFrn = sellingFrn;
		this.buyingHome = buyingHome;
		this.sellingHome = sellingHome;
		this.total = total;
	}

	public EntryItem() {
	}

	public EntryItem(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntryAndCalculation getEntry() {
		return entry;
	}

	public void setEntry(EntryAndCalculation entry) {
		this.entry = entry;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getExchRate() {
		return exchRate;
	}

	public void setExchRate(BigDecimal exchRate) {
		this.exchRate = exchRate;
	}

	public BigDecimal getBuyingFrn() {
		return buyingFrn;
	}

	public void setBuyingFrn(BigDecimal buyingFrn) {
		this.buyingFrn = buyingFrn;
	}

	public BigDecimal getSellingFrn() {
		return sellingFrn;
	}

	public void setSellingFrn(BigDecimal sellingFrn) {
		this.sellingFrn = sellingFrn;
	}

	public BigDecimal getBuyingHome() {
		return buyingHome;
	}

	public void setBuyingHome(BigDecimal buyingHome) {
		this.buyingHome = buyingHome;
	}

	public BigDecimal getSellingHome() {
		return sellingHome;
	}

	public void setSellingHome(BigDecimal sellingHome) {
		this.sellingHome = sellingHome;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + Objects.hashCode(this.id);
		hash = 97 * hash + Objects.hashCode(this.entry);
		hash = 97 * hash + Objects.hashCode(this.item);
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
		final EntryItem other = (EntryItem) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EntryItem{" + "id=" + id + ", entry=" + entry + ", item=" + item + ", quantity=" + quantity + ", exchRate=" + exchRate + ", buyingFrn=" + buyingFrn + ", sellingFrn=" + sellingFrn + ", buyingHome=" + buyingHome + ", sellingHome=" + sellingHome + ", total=" + total + '}';
	}
	
}
