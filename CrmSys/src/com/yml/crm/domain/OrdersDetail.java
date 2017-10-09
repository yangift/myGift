package com.yml.crm.domain;
/**
 * OrdersDetail entity. @author MyEclipse Persistence Tools
 */

public class OrdersDetail implements java.io.Serializable {

	// Fields

	private Integer olId;
	private Orders orders;
	private Wares wares;
	private Double olPrice;
	private Long olCount;
	private String olUnit;

	// Constructors

	/** default constructor */
	public OrdersDetail() {
	}

	/** full constructor */
	public OrdersDetail(Orders orders, Wares wares, Double olPrice,
			Long olCount, String olUnit) {
		this.orders = orders;
		this.wares = wares;
		this.olPrice = olPrice;
		this.olCount = olCount;
		this.olUnit = olUnit;
	}

	// Property accessors

	public Integer getOlId() {
		return this.olId;
	}

	public void setOlId(Integer olId) {
		this.olId = olId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Wares getWares() {
		return this.wares;
	}

	public void setWares(Wares wares) {
		this.wares = wares;
	}

	public Double getOlPrice() {
		return this.olPrice;
	}

	public void setOlPrice(Double olPrice) {
		this.olPrice = olPrice;
	}

	public Long getOlCount() {
		return this.olCount;
	}

	public void setOlCount(Long olCount) {
		this.olCount = olCount;
	}

	public String getOlUnit() {
		return this.olUnit;
	}

	public void setOlUnit(String olUnit) {
		this.olUnit = olUnit;
	}

}