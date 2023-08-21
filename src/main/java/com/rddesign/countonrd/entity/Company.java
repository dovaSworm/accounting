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
@Table(name = "companies")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "pib")
	private String pib;
	@Column(name = "mb")
	private String mb;
	@Column(name = "city")
	private String city;
	@Column(name = "adress")
	private String adress;
	@Column(name = "zip_code")
	private int zip;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "bank")
	private String bank;
	@Column(name = "account_num")
	private String accountNum;
	@Column(name = "contact")
	private String contact;

	public Company(Long id, String name, String pib, String mb, String city, String adress, int zip, String phone, String email, String bank, String accountNum, String contact) {
		this.id = id;
		this.name = name;
		this.pib = pib;
		this.mb = mb;
		this.city = city;
		this.adress = adress;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.bank = bank;
		this.accountNum = accountNum;
		this.contact = contact;
	}

	public Company() {
	}

	public Company(Long id) {
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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.id);
		hash = 89 * hash + Objects.hashCode(this.name);
		hash = 89 * hash + Objects.hashCode(this.pib);
		hash = 89 * hash + Objects.hashCode(this.mb);
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
		final Company other = (Company) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Company{" + "id=" + id + ", name=" + name + ", pib=" + pib + ", mb=" + mb + ", city=" + city + ", adress=" + adress + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", bank=" + bank + ", accountNum=" + accountNum + ", contact=" + contact + '}';
	}

}
