package com.rddesign.countonrd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dova
 */
@Entity
@Table(name = "entries")
public class EntryAndCalculation implements Serializable {

	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date")
	private LocalDate date;

	@JoinColumn(name = "seller", referencedColumnName = "id")
	@ManyToOne
	private Company seller;
	
	@Transient
	private List<EntryItem> entryItemList = new ArrayList<>();

	@JoinColumn(name = "currency", referencedColumnName = "id")
	@ManyToOne
	private Currency currency;

	@Column(name = "total")
	private BigDecimal total;

	public EntryAndCalculation() {
	}

	public EntryAndCalculation(Long id, String name, LocalDate date, Company seller, Currency currency, BigDecimal total) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.seller = seller;
		this.currency = currency;
		this.total = total;
	}

	public EntryAndCalculation(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Company getSeller() {
		return seller;
	}

	public void setSeller(Company seller) {
		this.seller = seller;
	}

	public List<EntryItem> getEntryItemList() {
		return entryItemList;
	}

	public void setEntryItemList(List<EntryItem> entryItemList) {
		this.entryItemList = entryItemList;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		hash = 79 * hash + Objects.hashCode(this.date);
		hash = 79 * hash + Objects.hashCode(this.seller);
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
		final EntryAndCalculation other = (EntryAndCalculation) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "EntryAndCalculation{" + "id=" + id + ", name=" + name + ", date=" + date + ", seller=" + seller + ", entryItemList=" + entryItemList + ", currency=" + currency + ", total=" + total + '}';
	}

}
