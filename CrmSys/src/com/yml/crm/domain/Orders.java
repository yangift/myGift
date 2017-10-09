package com.yml.crm.domain;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {
	

	private Integer ordId;
	private Customer customer;
	private Timestamp ordDate;
	private Long ordState;
	private String ordAddress;
	private Double total;
	private List<OrdersDetail> ordersDetails = new ArrayList<OrdersDetail>();

	// Constructors

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Customer customer, Timestamp ordDate, Long ordState,
			String ordAddress, List<OrdersDetail> ordersDetails) {
		this.customer = customer;
		this.ordDate = ordDate;
		this.ordState = ordState;
		this.ordAddress = ordAddress;
		this.ordersDetails = ordersDetails;
	}

	// Property accessors

	public Integer getOrdId() {
		return this.ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Timestamp getOrdDate() {
		return this.ordDate;
	}

	public void setOrdDate(Timestamp ordDate) {
		this.ordDate = ordDate;
	}

	public Long getOrdState() {
		return this.ordState;
	}

	public void setOrdState(Long ordState) {
		this.ordState = ordState;
	}

	public String getOrdAddress() {
		return this.ordAddress;
	}

	public void setOrdAddress(String ordAddress) {
		this.ordAddress = ordAddress;
	}

	public List<OrdersDetail> getOrdersDetails() {
		return this.ordersDetails;
	}

	public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
		this.ordersDetails = ordersDetails;
	}
	public String toString() {
		return "Orders [ordId=" + ordId + ", customer=" + customer
				+ ", ordDate=" + ordDate + ", ordState=" + ordState
				+ ", ordAddress=" + ordAddress + ", total=" + total
				+ ", ordersDetails=" + ordersDetails + "]";
	}

}