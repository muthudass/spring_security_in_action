package com.dass.SpringSecurityInAction.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private EncryptionAlgorithm algorithm;

	@OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private List<Authority> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EncryptionAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(EncryptionAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public int getId() {
		return id;
	}

}
