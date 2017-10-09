package com.yml.crm.domain;

import java.sql.Timestamp;

/**
 * Assort entity. @author MyEclipse Persistence Tools
 */

public class Assort implements java.io.Serializable {

	// Fields

	private Integer assId;
	private Customer customer;
	private Timestamp assDate;
	private String assPalce;
	private String assResume;
	private String assDetail;
	private String assMemo;

	// Constructors

	/** default constructor */
	public Assort() {
	}

	/** full constructor */
	public Assort(Customer customer, Timestamp assDate, String assPalce,
			String assResume, String assDetail, String assMemo) {
		this.customer = customer;
		this.assDate = assDate;
		this.assPalce = assPalce;
		this.assResume = assResume;
		this.assDetail = assDetail;
		this.assMemo = assMemo;
	}

	// Property accessors

	public Integer getAssId() {
		return this.assId;
	}

	public void setAssId(Integer assId) {
		this.assId = assId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getAssDate() {
		return this.assDate;
	}

	public void setAssDate(Timestamp assDate) {
		this.assDate = assDate;
	}

	public String getAssPalce() {
		return this.assPalce;
	}

	public void setAssPalce(String assPalce) {
		this.assPalce = assPalce;
	}

	public String getAssResume() {
		return this.assResume;
	}

	public void setAssResume(String assResume) {
		this.assResume = assResume;
	}

	public String getAssDetail() {
		return this.assDetail;
	}

	public void setAssDetail(String assDetail) {
		this.assDetail = assDetail;
	}

	public String getAssMemo() {
		return this.assMemo;
	}

	public void setAssMemo(String assMemo) {
		this.assMemo = assMemo;
	}

}