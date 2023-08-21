package com.rddesign.countonrd.entity;

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
@Table(name="users")
public class User {
	@Column(name="id")
	private @Id @GeneratedValue Long id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="pass")
	private String pass;
	@Column(name="role")
	private String role;

	private User() {}

	public User(Long id, String name, String email, String pass, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 19 * hash + Objects.hashCode(this.id);
		hash = 19 * hash + Objects.hashCode(this.name);
		hash = 19 * hash + Objects.hashCode(this.email);
		hash = 19 * hash + Objects.hashCode(this.pass);
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
		final User other = (User) obj;
		if (!Objects.equals(this.name, other.name)) {
			return false;
		}
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		if (!Objects.equals(this.pass, other.pass)) {
			return false;
		}
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", role=" + role + '}';
	}
	
}
