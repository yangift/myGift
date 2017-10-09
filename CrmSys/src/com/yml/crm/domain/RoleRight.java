package com.yml.crm.domain;
/**
 * RoleRight entity. @author MyEclipse Persistence Tools
 */

public class RoleRight implements java.io.Serializable {

	// Fields

	private Integer rtId;
	private Integer rtRolId;
	private String rtRigCode;

	// Constructors

	/** default constructor */
	public RoleRight() {
	}

	/** full constructor */
	public RoleRight(Integer rtRolId, String rtRigCode) {
		this.rtRolId = rtRolId;
		this.rtRigCode = rtRigCode;
	}

	// Property accessors

	public Integer getRtId() {
		return this.rtId;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public Integer getRtRolId() {
		return this.rtRolId;
	}

	public void setRtRolId(Integer rtRolId) {
		this.rtRolId = rtRolId;
	}

	public String getRtRigCode() {
		return this.rtRigCode;
	}

	public void setRtRigCode(String rtRigCode) {
		this.rtRigCode = rtRigCode;
	}

}