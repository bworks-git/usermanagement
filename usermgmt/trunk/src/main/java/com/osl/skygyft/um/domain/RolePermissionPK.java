package com.osl.skygyft.um.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;

/**
 */
public class RolePermissionPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public RolePermissionPK() {
	}

	/**
	 */

	@Column(name = "role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer roleId;
	/**
	 */

	@Column(name = "permission_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer permissionId;

	/**
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

	/**
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 */
	public Integer getPermissionId() {
		return this.permissionId;
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((roleId == null) ? 0 : roleId.hashCode()));
		result = (int) (prime * result + ((permissionId == null) ? 0 : permissionId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RolePermissionPK))
			return false;
		RolePermissionPK equalCheck = (RolePermissionPK) obj;
		if ((roleId == null && equalCheck.roleId != null) || (roleId != null && equalCheck.roleId == null))
			return false;
		if (roleId != null && !roleId.equals(equalCheck.roleId))
			return false;
		if ((permissionId == null && equalCheck.permissionId != null) || (permissionId != null && equalCheck.permissionId == null))
			return false;
		if (permissionId != null && !permissionId.equals(equalCheck.permissionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("RolePermissionPK");
		sb.append(" roleId: ").append(getRoleId());
		sb.append(" permissionId: ").append(getPermissionId());
		return sb.toString();
	}
}
