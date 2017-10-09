package com.yml.crm.domain;
import java.util.HashSet;
import java.util.Set;

/**
 * CustomerRank entity. @author MyEclipse Persistence Tools
 */

public class CustomerRank implements java.io.Serializable {

	// Fields

	private Integer ckId;
	private String ckName;
	private Set customers = new HashSet(0);

	// Constructors

	/** default constructor */
	public CustomerRank() {
	}

	/** full constructor */
	public CustomerRank(String ckName, Set customers) {
		this.ckName = ckName;
		this.customers = customers;
	}

	// Property accessors

	public Integer getCkId() {
		return this.ckId;
	}

	public void setCkId(Integer ckId) {
		this.ckId = ckId;
	}

	public String getCkName() {
		return this.ckName;
	}

	public void setCkName(String ckName) {
		this.ckName = ckName;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

}