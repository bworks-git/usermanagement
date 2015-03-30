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
@IdClass(com.osl.skygyft.um.domain.RolePermissionPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRolePermissions", query = "select myRolePermission from RolePermission myRolePermission"),
		@NamedQuery(name = "findRolePermissionByCreateBy", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.createBy = ?1"),
		@NamedQuery(name = "findRolePermissionByCreateByContaining", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.createBy like ?1"),
		@NamedQuery(name = "findRolePermissionByCreateDate", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.createDate = ?1"),
		@NamedQuery(name = "findRolePermissionByModifiedBy", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.modifiedBy = ?1"),
		@NamedQuery(name = "findRolePermissionByModifiedByContaining", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.modifiedBy like ?1"),
		@NamedQuery(name = "findRolePermissionByModifiedDate", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.modifiedDate = ?1"),
		@NamedQuery(name = "findRolePermissionByPermissionId", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.permissionId = ?1"),
		@NamedQuery(name = "findRolePermissionByPrimaryKey", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.roleId = ?1 and myRolePermission.permissionId = ?2"),
		@NamedQuery(name = "findRolePermissionByRoleId", query = "select myRolePermission from RolePermission myRolePermission where myRolePermission.roleId = ?1") })
@Table(name = "role_permissions")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "RolePermission")
public class RolePermission implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer roleId;
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
	@Column(name = "create_date", nullable = false)
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

	@Column(name = "create_by", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String createBy;
	/**
	 */

	@Column(name = "modified_by", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String modifiedBy;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "permission_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Permission permission;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Role role;

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
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 */
	@JsonIgnore
	public Role getRole() {
		return role;
	}

	/**
	 */
	public RolePermission() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(RolePermission that) {
		setRoleId(that.getRoleId());
		setPermissionId(that.getPermissionId());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setPermission(that.getPermission());
		setRole(that.getRole());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("roleId=[").append(roleId).append("] ");
		buffer.append("permissionId=[").append(permissionId).append("] ");
		buffer.append("createDate=[").append(createDate).append("] ");
		buffer.append("modifiedDate=[").append(modifiedDate).append("] ");
		buffer.append("createBy=[").append(createBy).append("] ");
		buffer.append("modifiedBy=[").append(modifiedBy).append("] ");

		return buffer.toString();
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
		if (!(obj instanceof RolePermission))
			return false;
		RolePermission equalCheck = (RolePermission) obj;
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
}
