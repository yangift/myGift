package com.yml.crm.domain;
import java.sql.Timestamp;

/**
 * Lost entity. @author MyEclipse Persistence Tools
 */

public class Lost implements java.io.Serializable {

	// Fields

	private Integer losId;
	private String losCustomer;
	private String losManager;
	private Timestamp losLastOrder;
	private String losRespite;
	private Timestamp losDate;
	private String losReason;
	private Long losState;

	// Constructors

	/** default constructor */
	public Lost() {
	}

	/** full constructor */
	public Lost(String losCustomer, String losManager, Timestamp losLastOrder,
			String losRespite, Timestamp losDate, String losReason,
			Long losState) {
		this.losCustomer = losCustomer;
		this.losManager = losManager;
		this.losLastOrder = losLastOrder;
		this.losRespite = losRespite;
		this.losDate = losDate;
		this.losReason = losReason;
		this.losState = losState;
	}

	// Property accessors

	public Integer getLosId() {
		return this.losId;
	}

	public void setLosId(Integer losId) {
		this.losId = losId;
	}

	public String getLosCustomer() {
		return this.losCustomer;
	}

	public void setLosCustomer(String losCustomer) {
		this.losCustomer = losCustomer;
	}

	public String getLosManager() {
		return this.losManager;
	}

	public void setLosManager(String losManager) {
		this.losManager = losManager;
	}

	public Timestamp getLosLastOrder() {
		return this.losLastOrder;
	}

	public void setLosLastOrder(Timestamp losLastOrder) {
		this.losLastOrder = losLastOrder;
	}

	public String getLosRespite() {
		return this.losRespite;
	}

	public void setLosRespite(String losRespite) {
		this.losRespite = losRespite;
	}

	public Timestamp getLosDate() {
		return this.losDate;
	}

	public void setLosDate(Timestamp losDate) {
		this.losDate = losDate;
	}

	public String getLosReason() {
		return this.losReason;
	}

	public void setLosReason(String losReason) {
		this.losReason = losReason;
	}

	public Long getLosState() {
		return this.losState;
	}

	public void setLosState(Long losState) {
		this.losState = losState;
	}

}