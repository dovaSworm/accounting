package com.rddesign.countonrd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "items")
public class Item implements Serializable {
	
	@Column(name = "id")
	private @Id
	@GeneratedValue
	Long id;
	
	@Column(name = "name")
	private String name;
	@JoinColumn(name="item_type", referencedColumnName="id")
	@ManyToOne
	private ItemType itemType;
	@JoinColumn(name="seller", referencedColumnName="id")
	@ManyToOne
	private Company seller;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "mes_unit")
	private String mesUnit;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "sellers_name")
	private String sellersName;

	@Column(name = "sellers_code")
	private String sellersCode;
		
	@Column(name = "tax")
	private int tax;
		
	@Column(name = "stock")
	private double stock;
		
	@Column(name = "buying_price")
	private BigDecimal buyingPrice;
		
	@Column(name = "selling_price")
	private BigDecimal sellingPrice;
	
	@Transient
	private List<InvoiceItem> invItemList = new ArrayList<>();
	@Transient
	private List<EntryItem> entryItemList = new ArrayList<>();

	public Item(Long id, String name, ItemType itemType, Company seller, String code, String mesUnit, String description, String sellersName, String sellersCode, int tax, double stock, BigDecimal buyingPrice, BigDecimal sellingPrice) {
		this.id = id;
		this.name = name;
		this.itemType = itemType;
		this.seller = seller;
		this.code = code;
		this.mesUnit = mesUnit;
		this.description = description;
		this.sellersName = sellersName;
		this.sellersCode = sellersCode;
		this.tax = tax;
		this.stock = stock;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
	}
	
	public Item(){};
	public Item(Long id){this.id=id;};

	public Long getId() {
		return id;
	}

	public List<InvoiceItem> getInvItemList() {
		return invItemList;
	}

	public void setInvItemList(List<InvoiceItem> invItemList) {
		this.invItemList = invItemList;
	}

	public List<EntryItem> getEntryItemList() {
		return entryItemList;
	}

	public void setEntryItemList(List<EntryItem> entryItemList) {
		this.entryItemList = entryItemList;
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

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public Company getSeller() {
		return seller;
	}

	public void setSeller(Company seller) {
		this.seller = seller;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMesUnit() {
		return mesUnit;
	}

	public void setMesUnit(String mesUnit) {
		this.mesUnit = mesUnit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSellersName() {
		return sellersName;
	}

	public void setSellersName(String sellersName) {
		this.sellersName = sellersName;
	}

	public String getSellersCode() {
		return sellersCode;
	}

	public void setSellersCode(String sellersCode) {
		this.sellersCode = sellersCode;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	public BigDecimal getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(BigDecimal buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		hash = 79 * hash + Objects.hashCode(this.name);
		hash = 79 * hash + Objects.hashCode(this.itemType);
		hash = 79 * hash + Objects.hashCode(this.code);
		hash = 79 * hash + Objects.hashCode(this.sellersName);
		hash = 79 * hash + Objects.hashCode(this.sellersCode);
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
		final Item other = (Item) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		if (!Objects.equals(this.sellersName, other.sellersName)) {
			return false;
		}
		if (!Objects.equals(this.sellersCode, other.sellersCode)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.itemType, other.itemType)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Item{" + "id=" + id + ", name=" + name + ", itemType=" + itemType + ", seller=" + seller + ", code=" + code + ", mesUnit=" + mesUnit + ", description=" + description + ", sellersName=" + sellersName + ", sellersCode=" + sellersCode + ", tax=" + tax + ", stock=" + stock + ", buyingPrice=" + buyingPrice + ", sellingPrice=" + sellingPrice + '}';
	}
	
}
