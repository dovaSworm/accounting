package com.rddesign.countonrd.entity;

import java.io.Serializable;
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
@Table(name = "invoice_types")
public class InvoiceType implements Serializable {

	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;
	@Column(name = "name")
	private String name;

	public InvoiceType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public InvoiceType() {
	}
	
	public InvoiceType(Long id) {
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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 89 * hash + Objects.hashCode(this.id);
		hash = 89 * hash + Objects.hashCode(this.name);
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
		final InvoiceType other = (InvoiceType) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceType{" + "id=" + id + ", name=" + name + '}';
	}
	
	
}
