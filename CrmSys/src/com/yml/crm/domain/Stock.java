package com.yml.crm.domain;
/**
 * Stock entity. @author MyEclipse Persistence Tools
 */

public class Stock implements java.io.Serializable {

	// Fields

	private Integer stoId;
	private Wares wares;
	private Integer stoCount;
	private String stoDepot;
	private String stoStand;
	private String stoMemo;

	// Constructors

	/** default constructor */
	public Stock() {
	}

	/** full constructor */
	public Stock(Wares wares, Integer stoCount, String stoDepot,
			String stoStand, String stoMemo) {
		this.wares = wares;
		this.stoCount = stoCount;
		this.stoDepot = stoDepot;
		this.stoStand = stoStand;
		this.stoMemo = stoMemo;
	}

	// Property accessors

	public Integer getStoId() {
		return this.stoId;
	}

	public void setStoId(Integer stoId) {
		this.stoId = stoId;
	}

	public Wares getWares() {
		return this.wares;
	}

	public void setWares(Wares wares) {
		this.wares = wares;
	}

	public Integer getStoCount() {
		return this.stoCount;
	}

	public void setStoCount(Integer stoCount) {
		this.stoCount = stoCount;
	}

	public String getStoDepot() {
		return this.stoDepot;
	}

	public void setStoDepot(String stoDepot) {
		this.stoDepot = stoDepot;
	}

	public String getStoStand() {
		return this.stoStand;
	}

	public void setStoStand(String stoStand) {
		this.stoStand = stoStand;
	}

	public String getStoMemo() {
		return this.stoMemo;
	}

	public void setStoMemo(String stoMemo) {
		this.stoMemo = stoMemo;
	}

}