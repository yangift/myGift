package com.yml.crm.domain;
import java.sql.Timestamp;

/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan implements java.io.Serializable {

	// Fields

	private Integer plaId;
	private Integer plaChcId;
	private String plaPlan;
	private Timestamp plaDate;
	private String plaResult;

	// Constructors

	/** default constructor */
	public Plan() {
	}

	/** full constructor */
	public Plan(Integer plaChcId, String plaPlan, Timestamp plaDate,
			String plaResult) {
		this.plaChcId = plaChcId;
		this.plaPlan = plaPlan;
		this.plaDate = plaDate;
		this.plaResult = plaResult;
	}

	// Property accessors

	public Integer getPlaId() {
		return this.plaId;
	}

	public void setPlaId(Integer plaId) {
		this.plaId = plaId;
	}

	public Integer getPlaChcId() {
		return this.plaChcId;
	}

	public void setPlaChcId(Integer plaChcId) {
		this.plaChcId = plaChcId;
	}

	public String getPlaPlan() {
		return this.plaPlan;
	}

	public void setPlaPlan(String plaPlan) {
		this.plaPlan = plaPlan;
	}

	public Timestamp getPlaDate() {
		return this.plaDate;
	}

	public void setPlaDate(Timestamp plaDate) {
		this.plaDate = plaDate;
	}

	public String getPlaResult() {
		return this.plaResult;
	}

	public void setPlaResult(String plaResult) {
		this.plaResult = plaResult;
	}

}