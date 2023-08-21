package com.rddesign.countonrd.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Dova
 */
@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;

	@Column(name = "inv_num")
	private String invNum;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "date")
	private LocalDate date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "pay_deadline")
	private LocalDate payDeadline;
	
	@JoinColumn(name = "inv_type", referencedColumnName = "id")
	@ManyToOne
	private InvoiceType invoiceType;
	
	@JoinColumn(name = "seller", referencedColumnName = "id")
	@ManyToOne
	private Company seller;
	
	@JoinColumn(name = "buyer", referencedColumnName = "id")
	@ManyToOne
	private Company buyer;
	
	@JoinColumn(name = "currency", referencedColumnName = "id")
	@ManyToOne
	private Currency currency;
	
	@Transient
	private List<InvoiceItem> itemList = new ArrayList<>();

	@Column(name = "letters")
	private String letters;

	@Column(name = "notes")
	private String notes;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "total")
	private BigDecimal total;

	@Column(name = "payed")
	private BigDecimal payed;
		
	@Column(name = "due")
	private BigDecimal due;

	public Invoice(Long id, String invNum, LocalDate date, LocalDate payDeadline, InvoiceType inoviceType, Company seller, Company buyer, Currency currency, String letters, String notes, BigDecimal discount, BigDecimal total, BigDecimal payed, BigDecimal due) {
		this.id = id;
		this.invNum = invNum;
		this.date = date;
		this.payDeadline = payDeadline;
		this.invoiceType = inoviceType;
		this.seller = seller;
		this.buyer = buyer;
		this.currency = currency;
		this.letters = letters;
		this.notes = notes;
		this.discount = discount;
		this.total = total;
		this.payed = payed;
		this.due = due;
	}


	public Invoice(Long id) {
		this.id = id;
	}

	public Invoice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvNum() {
		return invNum;
	}

	public void setInvNum(String invNum) {
		this.invNum = invNum;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getPayDeadline() {
		return payDeadline;
	}

	public void setPayDeadline(LocalDate payDeadline) {
		this.payDeadline = payDeadline;
	}

	public InvoiceType getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(InvoiceType inoviceType) {
		this.invoiceType = inoviceType;
	}

	public Company getSeller() {
		return seller;
	}

	public void setSeller(Company seller) {
		this.seller = seller;
	}

	public Company getBuyer() {
		return buyer;
	}

	public void setBuyer(Company buyer) {
		this.buyer = buyer;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public BigDecimal getPayed() {
		return payed;
	}

	public void setPayed(BigDecimal payed) {
		this.payed = payed;
	}

	public BigDecimal getDue() {
		return due;
	}

	public void setDue(BigDecimal due) {
		this.due = due;
	}

	public List<InvoiceItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InvoiceItem> itemList) {
		this.itemList = itemList;
	}
	

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 53 * hash + Objects.hashCode(this.id);
		hash = 53 * hash + Objects.hashCode(this.invNum);
		hash = 53 * hash + Objects.hashCode(this.date);
		hash = 53 * hash + Objects.hashCode(this.invoiceType);
		hash = 53 * hash + Objects.hashCode(this.seller);
		hash = 53 * hash + Objects.hashCode(this.buyer);
		hash = 53 * hash + Objects.hashCode(this.total);
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
		final Invoice other = (Invoice) obj;
		if (!Objects.equals(this.invNum, other.invNum)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.date, other.date)) {
			return false;
		}
		if (!Objects.equals(this.payDeadline, other.payDeadline)) {
			return false;
		}
		if (!Objects.equals(this.invoiceType, other.invoiceType)) {
			return false;
		}
		if (!Objects.equals(this.seller, other.seller)) {
			return false;
		}
		if (!Objects.equals(this.buyer, other.buyer)) {
			return false;
		}
		if (!Objects.equals(this.total, other.total)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Invoice{" + "id=" + id + ", invNum=" + invNum + ", date=" + date + ", payDeadline=" + payDeadline + ", inoviceType=" + invoiceType + ", seller=" + seller + ", buyer=" + buyer + ", currency=" + currency + ", itemList=" + itemList + ", letters=" + letters + ", notes=" + notes + ", discount=" + discount + ", total=" + total + ", payed=" + payed + ", due=" + due + '}';
	}

		
}
