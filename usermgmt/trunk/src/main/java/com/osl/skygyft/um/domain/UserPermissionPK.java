package com.osl.skygyft.um.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;

/**
 */
public class UserPermissionPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public UserPermissionPK() {
	}

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer userId;
	/**
	 */

	@Column(name = "permission_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	public Integer permissionId;

	/**
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
		return this.userId;
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
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		result = (int) (prime * result + ((permissionId == null) ? 0 : permissionId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserPermissionPK))
			return false;
		UserPermissionPK equalCheck = (UserPermissionPK) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		if ((permissionId == null && equalCheck.permissionId != null) || (permissionId != null && equalCheck.permissionId == null))
			return false;
		if (permissionId != null && !permissionId.equals(equalCheck.permissionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UserPermissionPK");
		sb.append(" userId: ").append(getUserId());
		sb.append(" permissionId: ").append(getPermissionId());
		return sb.toString();
	}
}
