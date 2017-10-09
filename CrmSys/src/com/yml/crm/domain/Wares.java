package com.yml.crm.domain;
import java.util.HashSet;
import java.util.Set;

/**
 * Wares entity. @author MyEclipse Persistence Tools
 */

public class Wares implements java.io.Serializable {

	// Fields

	private Integer warId;
	private String warName;
	private Double warPrice;
	private String warUnit;
	private String warType;
	private String warBatch;
	private String warMemo;
	private Set stocks = new HashSet(0);
	private Set ordersDetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public Wares() {
	}

	/** full constructor */
	public Wares(String warName, Double warPrice, String warUnit,
			String warType, String warBatch, String warMemo, Set stocks,
			Set ordersDetails) {
		this.warName = warName;
		this.warPrice = warPrice;
		this.warUnit = warUnit;
		this.warType = warType;
		this.warBatch = warBatch;
		this.warMemo = warMemo;
		this.stocks = stocks;
		this.ordersDetails = ordersDetails;
	}

	// Property accessors

	public Integer getWarId() {
		return this.warId;
	}

	public void setWarId(Integer warId) {
		this.warId = warId;
	}

	public String getWarName() {
		return this.warName;
	}

	public void setWarName(String warName) {
		this.warName = warName;
	}

	public Double getWarPrice() {
		return this.warPrice;
	}

	public void setWarPrice(Double warPrice) {
		this.warPrice = warPrice;
	}

	public String getWarUnit() {
		return this.warUnit;
	}

	public void setWarUnit(String warUnit) {
		this.warUnit = warUnit;
	}

	public String getWarType() {
		return this.warType;
	}

	public void setWarType(String warType) {
		this.warType = warType;
	}

	public String getWarBatch() {
		return this.warBatch;
	}

	public void setWarBatch(String warBatch) {
		this.warBatch = warBatch;
	}

	public String getWarMemo() {
		return this.warMemo;
	}

	public void setWarMemo(String warMemo) {
		this.warMemo = warMemo;
	}

	public Set getStocks() {
		return this.stocks;
	}

	public void setStocks(Set stocks) {
		this.stocks = stocks;
	}

	public Set getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(Set ordersDetails) {
		this.ordersDetails = ordersDetails;
	}

}