package com.yml.crm.domain;
/**
 * RoleRightId entity. @author MyEclipse Persistence Tools
 */

public class RoleRightId implements java.io.Serializable {

	// Fields

	private Integer rtRolId;
	private String rtRigCode;

	// Constructors

	/** default constructor */
	public RoleRightId() {
	}

	/** full constructor */
	public RoleRightId(Integer rtRolId, String rtRigCode) {
		this.rtRolId = rtRolId;
		this.rtRigCode = rtRigCode;
	}

	// Property accessors

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RoleRightId))
			return false;
		RoleRightId castOther = (RoleRightId) other;

		return ((this.getRtRolId() == castOther.getRtRolId()) || (this
				.getRtRolId() != null
				&& castOther.getRtRolId() != null && this.getRtRolId().equals(
				castOther.getRtRolId())))
				&& ((this.getRtRigCode() == castOther.getRtRigCode()) || (this
						.getRtRigCode() != null
						&& castOther.getRtRigCode() != null && this
						.getRtRigCode().equals(castOther.getRtRigCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRtRolId() == null ? 0 : this.getRtRolId().hashCode());
		result = 37 * result
				+ (getRtRigCode() == null ? 0 : this.getRtRigCode().hashCode());
		return result;
	}

}