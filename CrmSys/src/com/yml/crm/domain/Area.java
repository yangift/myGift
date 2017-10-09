package com.yml.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer areId;
	private String areName;
	private Set customers = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(String areName, Set customers) {
		this.areName = areName;
		this.customers = customers;
	}

	// Property accessors

	public Integer getAreId() {
		return this.areId;
	}

	public void setAreId(Integer areId) {
		this.areId = areId;
	}

	public String getAreName() {
		return this.areName;
	}

	public void setAreName(String areName) {
		this.areName = areName;
	}

	public Set getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set customers) {
		this.customers = customers;
	}

}