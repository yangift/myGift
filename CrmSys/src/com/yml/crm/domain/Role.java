package com.yml.crm.domain;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Role [rolId=" + rolId + ", rolName=" + rolName + ", consumers="
				+ consumers + "]";
	}

	private Integer rolId;
	private String rolName;
	private List<Consumer> consumers = new ArrayList<Consumer>();

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	
	// Property accessors

	public Integer getRolId() {
		return this.rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public List<Consumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<Consumer> consumers) {
		this.consumers = consumers;
	}


}