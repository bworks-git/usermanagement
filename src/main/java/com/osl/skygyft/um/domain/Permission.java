package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllPermissions", query = "select myPermission from Permission myPermission"),
		@NamedQuery(name = "findPermissionByCreateBy", query = "select myPermission from Permission myPermission where myPermission.createBy = ?1"),
		@NamedQuery(name = "findPermissionByCreateByContaining", query = "select myPermission from Permission myPermission where myPermission.createBy like ?1"),
		@NamedQuery(name = "findPermissionByCreateDate", query = "select myPermission from Permission myPermission where myPermission.createDate = ?1"),
		@NamedQuery(name = "findPermissionByDescription", query = "select myPermission from Permission myPermission where myPermission.description = ?1"),
		@NamedQuery(name = "findPermissionByDescriptionContaining", query = "select myPermission from Permission myPermission where myPermission.description like ?1"),
		@NamedQuery(name = "findPermissionById", query = "select myPermission from Permission myPermission where myPermission.id = ?1"),
		@NamedQuery(name = "findPermissionByModifiedBy", query = "select myPermission from Permission myPermission where myPermission.modifiedBy = ?1"),
		@NamedQuery(name = "findPermissionByModifiedByContaining", query = "select myPermission from Permission myPermission where myPermission.modifiedBy like ?1"),
		@NamedQuery(name = "findPermissionByModifiedDate", query = "select myPermission from Permission myPermission where myPermission.modifiedDate = ?1"),
		@NamedQuery(name = "findPermissionByModuleId", query = "select myPermission from Permission myPermission where myPermission.moduleId = ?1"),
		@NamedQuery(name = "findPermissionByPermId", query = "select myPermission from Permission myPermission where myPermission.permId = ?1"),
		@NamedQuery(name = "findPermissionByPermissionName", query = "select myPermission from Permission myPermission where myPermission.permissionName = ?1"),
		@NamedQuery(name = "findPermissionByPermissionNameContaining", query = "select myPermission from Permission myPermission where myPermission.permissionName like ?1"),
		@NamedQuery(name = "findPermissionByPrimaryKey", query = "select myPermission from Permission myPermission where myPermission.id = ?1"),
		@NamedQuery(name = "findPermissionByStatus", query = "select myPermission from Permission myPermission where myPermission.status = ?1") })
@Table(name = "permissions")
@SQLDelete(sql="UPDATE permissions SET date_deletion=CURRENT_DATE WHERE id=? ")
@Where(clause="date_deletion IS NULL ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "Permission")
@XmlRootElement(namespace = "um/com/osl/skygyft/um/domain")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "perm_id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer permId;
	/**
	 */

	@Column(name = "permission_name", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String permissionName;
	/**
	 */

	@Column(name = "module_id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer moduleId;
	/**
	 */

	@Column(name = "description", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */

	@Column(name = "status", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean status;
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
	@OneToMany(mappedBy = "permission", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.UserPermission> userPermissions;
	/**
	 */
	@OneToMany(mappedBy = "permission", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.RolePermission> rolePermissions;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setPermId(Integer permId) {
		this.permId = permId;
	}

	/**
	 */
	public Integer getPermId() {
		return this.permId;
	}

	/**
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 */
	public String getPermissionName() {
		return this.permissionName;
	}

	/**
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 */
	public Integer getModuleId() {
		return this.moduleId;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 */
	public Boolean getStatus() {
		return this.status;
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
	public void setUserPermissions(Set<UserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}

	/**
	 */
	@JsonIgnore
	public Set<UserPermission> getUserPermissions() {
		if (userPermissions == null) {
			userPermissions = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserPermission>();
		}
		return userPermissions;
	}

	/**
	 */
	public void setRolePermissions(Set<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	/**
	 */
	@JsonIgnore
	public Set<RolePermission> getRolePermissions() {
		if (rolePermissions == null) {
			rolePermissions = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.RolePermission>();
		}
		return rolePermissions;
	}

	/**
	 */
	public Permission() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Permission that) {
		setId(that.getId());
		setPermId(that.getPermId());
		setPermissionName(that.getPermissionName());
		setModuleId(that.getModuleId());
		setDescription(that.getDescription());
		setStatus(that.getStatus());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setUserPermissions(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserPermission>(that.getUserPermissions()));
		setRolePermissions(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.RolePermission>(that.getRolePermissions()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("permId=[").append(permId).append("] ");
		buffer.append("permissionName=[").append(permissionName).append("] ");
		buffer.append("moduleId=[").append(moduleId).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("status=[").append(status).append("] ");
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
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Permission))
			return false;
		Permission equalCheck = (Permission) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
