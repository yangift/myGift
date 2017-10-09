package com.yml.crm.domain;
/**
 * Consumer entity. @author MyEclipse Persistence Tools
 */

public class Consumer implements java.io.Serializable {

	// Fields

	private Integer conId;
	private Role role;
	private String conName;
	private String conPassword;

	// Constructors

	/** default constructor */
	public Consumer() {
	}

	/** full constructor */
	public Consumer(Role role, String conName, String conPassword) {
		this.role = role;
		this.conName = conName;
		this.conPassword = conPassword;
	}

	// Property accessors

	public Integer getConId() {
		return this.conId;
	}

	public void setConId(Integer conId) {
		this.conId = conId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getConName() {
		return this.conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConPassword() {
		return this.conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}

}