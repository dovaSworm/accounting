package com.rddesign.countonrd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dova
 */
@Entity
@Table(name = "currencies")
public class Currency implements Serializable {

	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "exch_rate")
	private BigDecimal exchRate;

	public Currency(Long id, String name, BigDecimal exchRate) {
		this.id = id;
		this.name = name;
		this.exchRate = exchRate;
	}

	public Currency() {
	}
	
	public Currency(Long id) {
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

	public BigDecimal getExchRate() {
		return exchRate;
	}

	public void setExchRate(BigDecimal exchRate) {
		this.exchRate = exchRate;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 61 * hash + Objects.hashCode(this.id);
		hash = 61 * hash + Objects.hashCode(this.name);
		hash = 61 * hash + Objects.hashCode(this.exchRate);
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
		final Currency other = (Currency) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Currency{" + "id=" + id + ", name=" + name + ", exchRate=" + exchRate + '}';
	}
	
}
