package com.yml.crm.domain;
import java.util.HashSet;
import java.util.Set;

/**
 * ServeType entity. @author MyEclipse Persistence Tools
 */

public class ServeType implements java.io.Serializable {

	// Fields

	private Integer seId;
	private String seName;
	private Set serves = new HashSet(0);

	// Constructors

	/** default constructor */
	public ServeType() {
	}

	/** full constructor */
	public ServeType(String seName, Set serves) {
		this.seName = seName;
		this.serves = serves;
	}

	// Property accessors

	public Integer getSeId() {
		return this.seId;
	}

	public void setSeId(Integer seId) {
		this.seId = seId;
	}

	public String getSeName() {
		return this.seName;
	}

	public void setSeName(String seName) {
		this.seName = seName;
	}

	public Set getServes() {
		return this.serves;
	}

	public void setServes(Set serves) {
		this.serves = serves;
	}

}