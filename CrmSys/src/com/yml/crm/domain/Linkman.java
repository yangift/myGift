package com.yml.crm.domain;
/**
 * Linkman entity. @author MyEclipse Persistence Tools
 */

public class Linkman implements java.io.Serializable {

	// Fields

	private Integer linId;
	private Customer customer;
	private String linName;
	private String linSex;
	private String linTelephone;
	private String linPost;
	private String linMobile;
	private String linMemo;

	// Constructors

	/** default constructor */
	public Linkman() {
	}

	/** full constructor */
	public Linkman(Customer customer, String linName, String linSex,
			String linTelephone, String linPost, String linMobile,
			String linMemo) {
		this.customer = customer;
		this.linName = linName;
		this.linSex = linSex;
		this.linTelephone = linTelephone;
		this.linPost = linPost;
		this.linMobile = linMobile;
		this.linMemo = linMemo;
	}

	// Property accessors

	public Integer getLinId() {
		return this.linId;
	}

	public void setLinId(Integer linId) {
		this.linId = linId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getLinName() {
		return this.linName;
	}

	public void setLinName(String linName) {
		this.linName = linName;
	}

	public String getLinSex() {
		return this.linSex;
	}

	public void setLinSex(String linSex) {
		this.linSex = linSex;
	}

	public String getLinTelephone() {
		return this.linTelephone;
	}

	public void setLinTelephone(String linTelephone) {
		this.linTelephone = linTelephone;
	}

	public String getLinPost() {
		return this.linPost;
	}

	public void setLinPost(String linPost) {
		this.linPost = linPost;
	}

	public String getLinMobile() {
		return this.linMobile;
	}

	public void setLinMobile(String linMobile) {
		this.linMobile = linMobile;
	}

	public String getLinMemo() {
		return this.linMemo;
	}

	public void setLinMemo(String linMemo) {
		this.linMemo = linMemo;
	}

}