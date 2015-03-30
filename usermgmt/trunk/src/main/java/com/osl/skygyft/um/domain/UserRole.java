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
@IdClass(com.osl.skygyft.um.domain.UserRolePK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUserRoles", query = "select myUserRole from UserRole myUserRole"),
		@NamedQuery(name = "findUserRoleByCreateBy", query = "select myUserRole from UserRole myUserRole where myUserRole.createBy = ?1"),
		@NamedQuery(name = "findUserRoleByCreateByContaining", query = "select myUserRole from UserRole myUserRole where myUserRole.createBy like ?1"),
		@NamedQuery(name = "findUserRoleByCreateDate", query = "select myUserRole from UserRole myUserRole where myUserRole.createDate = ?1"),
		@NamedQuery(name = "findUserRoleByModifiedBy", query = "select myUserRole from UserRole myUserRole where myUserRole.modifiedBy = ?1"),
		@NamedQuery(name = "findUserRoleByModifiedByContaining", query = "select myUserRole from UserRole myUserRole where myUserRole.modifiedBy like ?1"),
		@NamedQuery(name = "findUserRoleByModifiedDate", query = "select myUserRole from UserRole myUserRole where myUserRole.modifiedDate = ?1"),
		@NamedQuery(name = "findUserRoleByPrimaryKey", query = "select myUserRole from UserRole myUserRole where myUserRole.userId = ?1 and myUserRole.roleId = ?2"),
		@NamedQuery(name = "findUserRoleByRoleId", query = "select myUserRole from UserRole myUserRole where myUserRole.roleId = ?1"),
		@NamedQuery(name = "findUserRoleByUserId", query = "select myUserRole from UserRole myUserRole where myUserRole.userId = ?1") })
@Table(name = "user_roles")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "UserRole")
public class UserRole implements Serializable {
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

	@Column(name = "role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer roleId;
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
	@Column(name = "modified_date", nullable = false)
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	User user;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Role role;

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
	public UserRole() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserRole that) {
		setUserId(that.getUserId());
		setRoleId(that.getRoleId());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setUser(that.getUser());
		setRole(that.getRole());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("roleId=[").append(roleId).append("] ");
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
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		result = (int) (prime * result + ((roleId == null) ? 0 : roleId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserRole))
			return false;
		UserRole equalCheck = (UserRole) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		if ((roleId == null && equalCheck.roleId != null) || (roleId != null && equalCheck.roleId == null))
			return false;
		if (roleId != null && !roleId.equals(equalCheck.roleId))
			return false;
		return true;
	}
}
