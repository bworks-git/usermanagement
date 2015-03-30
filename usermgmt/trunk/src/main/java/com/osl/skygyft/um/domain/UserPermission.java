package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */
@IdClass(com.osl.skygyft.um.domain.UserPermissionPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUserPermissions", query = "select myUserPermission from UserPermission myUserPermission"),
		@NamedQuery(name = "findUserPermissionByCreateBy", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.createBy = ?1"),
		@NamedQuery(name = "findUserPermissionByCreateByContaining", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.createBy like ?1"),
		@NamedQuery(name = "findUserPermissionByCreateDate", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.createDate = ?1"),
		@NamedQuery(name = "findUserPermissionByModifiedBy", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.modifiedBy = ?1"),
		@NamedQuery(name = "findUserPermissionByModifiedByContaining", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.modifiedBy like ?1"),
		@NamedQuery(name = "findUserPermissionByModifiedDate", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.modifiedDate = ?1"),
		@NamedQuery(name = "findUserPermissionByPermissionId", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.permissionId = ?1"),
		@NamedQuery(name = "findUserPermissionByPermissionType", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.permissionType = ?1"),
		@NamedQuery(name = "findUserPermissionByPrimaryKey", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.userId = ?1 and myUserPermission.permissionId = ?2"),
		@NamedQuery(name = "findUserPermissionByUserId", query = "select myUserPermission from UserPermission myUserPermission where myUserPermission.userId = ?1") })
@Table(name = "user_permissions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "UserPermission")
public class UserPermission implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "permission_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer permissionId;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar modifiedDate;
	/**
	 */

	@Column(name = "create_by", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String createBy;
	/**
	 */

	@Column(name = "modified_by", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String modifiedBy;
	/**
	 */

	@Column(name = "permission_type", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean permissionType;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Permission permission;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	User user;

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
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	/**
	 */
	public Calendar getCreateDate() {
		return this.createDate;
	}

	/**
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 */
	public Calendar getModifiedDate() {
		return this.modifiedDate;
	}

	/**
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 */
	public String getCreateBy() {
		return this.createBy;
	}

	/**
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 */
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	/**
	 */
	public void setPermissionType(Boolean permissionType) {
		this.permissionType = permissionType;
	}

	/**
	 */
	public Boolean getPermissionType() {
		return this.permissionType;
	}

	/**
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	/**
	 */
	@JsonIgnore
	public Permission getPermission() {
		return permission;
	}

	/**
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 */
	@JsonIgnore
	public User getUser() {
		return user;
	}

	/**
	 */
	public UserPermission() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserPermission that) {
		setUserId(that.getUserId());
		setPermissionId(that.getPermissionId());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setPermissionType(that.getPermissionType());
		setPermission(that.getPermission());
		setUser(that.getUser());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("permissionId=[").append(permissionId).append("] ");
		buffer.append("createDate=[").append(createDate).append("] ");
		buffer.append("modifiedDate=[").append(modifiedDate).append("] ");
		buffer.append("createBy=[").append(createBy).append("] ");
		buffer.append("modifiedBy=[").append(modifiedBy).append("] ");
		buffer.append("permissionType=[").append(permissionType).append("] ");

		return buffer.toString();
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
		if (!(obj instanceof UserPermission))
			return false;
		UserPermission equalCheck = (UserPermission) obj;
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
}
