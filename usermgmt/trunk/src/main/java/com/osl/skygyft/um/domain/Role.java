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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
import com.osl.skygyft.um.service.IAuditLog;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRoles", query = "select myRole from Role myRole order by myRole.id desc"),
		@NamedQuery(name = "findRoleByCreateBy", query = "select myRole from Role myRole where myRole.create_by = ?1"),
		@NamedQuery(name = "findRoleByCreateByContaining", query = "select myRole from Role myRole where myRole.create_by like ?1"),
		@NamedQuery(name = "findRoleByCreateDate", query = "select myRole from Role myRole where myRole.create_date = ?1"),
		@NamedQuery(name = "findRoleByDescription", query = "select myRole from Role myRole where myRole.description = ?1"),
		@NamedQuery(name = "findRoleByDescriptionContaining", query = "select myRole from Role myRole where myRole.description like ?1"),
		@NamedQuery(name = "findRoleById", query = "select myRole from Role myRole where myRole.id = ?1"),
		@NamedQuery(name = "findRoleByModifiedBy", query = "select myRole from Role myRole where myRole.modified_by = ?1"),
		@NamedQuery(name = "findRoleByModifiedByContaining", query = "select myRole from Role myRole where myRole.modified_by like ?1"),
		@NamedQuery(name = "findRoleByModifiedDate", query = "select myRole from Role myRole where myRole.modified_date = ?1"),
		@NamedQuery(name = "findRoleByModuleId", query = "select myRole from Role myRole where myRole.module_id = ?1"),
		@NamedQuery(name = "findRoleByPermissionSet", query = "select myRole from Role myRole where myRole.permissions = ?1"),
		@NamedQuery(name = "findRoleByPermissionSetContaining", query = "select myRole from Role myRole where myRole.permissions like ?1"),
		@NamedQuery(name = "findRoleByPrimaryKey", query = "select myRole from Role myRole where myRole.id = ?1"),
		@NamedQuery(name = "findRoleByRoleId", query = "select myRole from Role myRole where myRole.roleId = ?1"),
		@NamedQuery(name = "findRoleByRoleName", query = "select myRole from Role myRole where myRole.role_name = ?1"),
		@NamedQuery(name = "findRoleByRoleNameContaining", query = "select myRole from Role myRole where myRole.role_name like ?1"),
		@NamedQuery(name = "findRoleByStatus", query = "select myRole from Role myRole where myRole.status = ?1") })
@Table(name = "roles")
@SQLDelete(sql="UPDATE roles SET date_deletion=CURRENT_DATE WHERE id=? ")
@Where(clause="date_deletion IS NULL ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "Role")
@XmlRootElement(namespace = "um/com/osl/skygyft/um/domain")
public class Role implements Serializable, IAuditLog {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "role_id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer roleId;
	/**
	 */

	@Column(name = "role_name", length = 200, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String role_name;
	/**
	 */

	@Column(name = "permission_set", length = 2000, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String permissions;
	/**
	 */

	@Column(name = "module_id", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer module_id;
	/**
	 */

	@Column(name = "status", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean status;
	/**
	 */

	@Column(name = "description", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar create_date;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar modified_date;
	/**
	 */

	@Column(name = "create_by", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String create_by;
	/**
	 */

	@Column(name = "modified_by", nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String modified_by;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_permissions", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "permission_id") })
	private Set<Permission> permissionSet;
	/**
	 */
//	@OneToMany(mappedBy = "role", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@XmlElement(name = "", namespace = "")
//	java.util.Set<com.osl.skygyft.um.domain.RolePermission> rolePermissions;
	/**
	 */
	@OneToMany(mappedBy = "role", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.UserRole> userRoles;

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
	public void setRole_name(String roleName) {
		this.role_name = roleName;
	}

	/**
	 */
	public String getRole_name() {
		return this.role_name;
	}

	/**
	 */
	public void setPermissions(String permissionSet) {
		this.permissions = permissionSet;
	}

	/**
	 */
	public String getPermissions() {
		return this.permissions;
	}

	/**
	 */
	public void setModule_id(Integer moduleId) {
		this.module_id = moduleId;
	}

	/**
	 */
	public Integer getModule_id() {
		return this.module_id;
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
	public void setCreate_date(Calendar createDate) {
		this.create_date = createDate;
	}

	/**
	 */
	public Calendar getCreate_date() {
		return this.create_date;
	}

	/**
	 */
	public void setModified_date(Calendar modifiedDate) {
		this.modified_date = modifiedDate;
	}

	/**
	 */
	public Calendar getModified_date() {
		return this.modified_date;
	}

	/**
	 */
	public void setCreate_by(String createBy) {
		this.create_by = createBy;
	}

	/**
	 */
	public String getCreate_by() {
		return this.create_by;
	}

	/**
	 */
	public void setModified_by(String modifiedBy) {
		this.modified_by = modifiedBy;
	}

	/**
	 */
	public String getModified_by() {
		return this.modified_by;
	}

//	/**
//	 */
//	public void setRolePermissions(Set<RolePermission> rolePermissions) {
//		this.rolePermissions = rolePermissions;
//	}

	/**
	 */
//	@JsonIgnore
//	public Set<RolePermission> getRolePermissions() {
//		if (rolePermissions == null) {
//			rolePermissions = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.RolePermission>();
//		}
//		return rolePermissions;
//	}

	/**
	 */
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 */
	@JsonIgnore
	public Set<UserRole> getUserRoles() {
		if (userRoles == null) {
			userRoles = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserRole>();
		}
		return userRoles;
	}

	public Set<Permission> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<Permission> permissionSet) {
		this.permissionSet = permissionSet;
	}

	/**
	 */
	public Role() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Role that) {
		setId(that.getId());
		setRoleId(that.getRoleId());
		setRole_name(that.getRole_name());
		setPermissions(that.getPermissions());
		setModule_id(that.getModule_id());
		setStatus(that.getStatus());
		setDescription(that.getDescription());
		setCreate_date(that.getCreate_date());
		setModified_date(that.getModified_date());
		setCreate_by(that.getCreate_by());
		setModified_by(that.getModified_by());
//		setRolePermissions(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.RolePermission>(that.getRolePermissions()));
//		setUserRoles(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserRole>(that.getUserRoles()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("roleId=[").append(roleId).append("] ");
		buffer.append("roleName=[").append(role_name).append("] ");
		buffer.append("permissionSet=[").append(permissions).append("] ");
		buffer.append("moduleId=[").append(module_id).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("createDate=[").append(create_date).append("] ");
		buffer.append("modifiedDate=[").append(modified_date).append("] ");
		buffer.append("createBy=[").append(create_by).append("] ");
		buffer.append("modifiedBy=[").append(modified_by).append("] ");

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
		if (!(obj instanceof Role))
			return false;
		Role equalCheck = (Role) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}

	@Override
	public Long getEntityId() {
		return Long.valueOf(String.valueOf(id));
	}

	@Override
	public String getLogDetail() {
		return "";
	}

}
