package com.yml.crm.domain;
import java.sql.Timestamp;

/**
 * Serve entity. @author MyEclipse Persistence Tools
 */

public class Serve implements java.io.Serializable {

	// Fields

	private Integer serId;
	private ServeType serveType;
	private Customer customer;
	private String serCreater;
	private Timestamp serCreaterDate;
	private String serServiceRequest;
	private String serAllotName;
	private Timestamp serAllotDate;
	private String serHandle;
	private String serHandler;
	private String serResult;
	private Long serSatisfcing;
	private String serResume;
	private Long serState;

	// Constructors

	/** default constructor */
	public Serve() {
	}

	/** full constructor */
	public Serve(ServeType serveType, Customer customer, String serCreater,
			Timestamp serCreaterDate, String serServiceRequest,
			String serAllotName, Timestamp serAllotDate, String serHandle,
			String serHandler, String serResult, Long serSatisfcing,
			String serResume, Long serState) {
		this.serveType = serveType;
		this.customer = customer;
		this.serCreater = serCreater;
		this.serCreaterDate = serCreaterDate;
		this.serServiceRequest = serServiceRequest;
		this.serAllotName = serAllotName;
		this.serAllotDate = serAllotDate;
		this.serHandle = serHandle;
		this.serHandler = serHandler;
		this.serResult = serResult;
		this.serSatisfcing = serSatisfcing;
		this.serResume = serResume;
		this.serState = serState;
	}

	// Property accessors

	public Integer getSerId() {
		return this.serId;
	}

	public void setSerId(Integer serId) {
		this.serId = serId;
	}

	public ServeType getServeType() {
		return this.serveType;
	}

	public void setServeType(ServeType serveType) {
		this.serveType = serveType;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getSerCreater() {
		return this.serCreater;
	}

	public void setSerCreater(String serCreater) {
		this.serCreater = serCreater;
	}

	public Timestamp getSerCreaterDate() {
		return this.serCreaterDate;
	}

	public void setSerCreaterDate(Timestamp serCreaterDate) {
		this.serCreaterDate = serCreaterDate;
	}

	public String getSerServiceRequest() {
		return this.serServiceRequest;
	}

	public void setSerServiceRequest(String serServiceRequest) {
		this.serServiceRequest = serServiceRequest;
	}

	public String getSerAllotName() {
		return this.serAllotName;
	}

	public void setSerAllotName(String serAllotName) {
		this.serAllotName = serAllotName;
	}

	public Timestamp getSerAllotDate() {
		return this.serAllotDate;
	}

	public void setSerAllotDate(Timestamp serAllotDate) {
		this.serAllotDate = serAllotDate;
	}

	public String getSerHandle() {
		return this.serHandle;
	}

	public void setSerHandle(String serHandle) {
		this.serHandle = serHandle;
	}

	public String getSerHandler() {
		return this.serHandler;
	}

	public void setSerHandler(String serHandler) {
		this.serHandler = serHandler;
	}

	public String getSerResult() {
		return this.serResult;
	}

	public void setSerResult(String serResult) {
		this.serResult = serResult;
	}

	public Long getSerSatisfcing() {
		return this.serSatisfcing;
	}

	public void setSerSatisfcing(Long serSatisfcing) {
		this.serSatisfcing = serSatisfcing;
	}

	public String getSerResume() {
		return this.serResume;
	}

	public void setSerResume(String serResume) {
		this.serResume = serResume;
	}

	public Long getSerState() {
		return this.serState;
	}

	public void setSerState(Long serState) {
		this.serState = serState;
	}

}