package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUsers", query = "select myUser from User myUser order by myUser.userId desc"),
		@NamedQuery(name = "findUserByCreateBy", query = "select myUser from User myUser where myUser.createBy = ?1"),
		@NamedQuery(name = "findUserByCreateByContaining", query = "select myUser from User myUser where myUser.createBy like ?1"),
		@NamedQuery(name = "findUserByCreateDate", query = "select myUser from User myUser where myUser.createDate = ?1"),
		@NamedQuery(name = "findUserByEMail", query = "select myUser from User myUser where myUser.email = ?1"),
		@NamedQuery(name = "findUserByEMailContaining", query = "select myUser from User myUser where myUser.email like ?1"),
		@NamedQuery(name = "findUserByEmail1", query = "select myUser from User myUser where myUser.email1 = ?1"),
		@NamedQuery(name = "findUserByEmail1Containing", query = "select myUser from User myUser where myUser.email1 like ?1"),
		@NamedQuery(name = "findUserByEmail2", query = "select myUser from User myUser where myUser.email2 = ?1"),
		@NamedQuery(name = "findUserByEmail2Containing", query = "select myUser from User myUser where myUser.email2 like ?1"),
		@NamedQuery(name = "findUserByEntityId", query = "select myUser from User myUser where myUser.entityId = ?1"),
		@NamedQuery(name = "findUserByFavouriteAgents", query = "select myUser from User myUser where myUser.favouriteAgents = ?1"),
		@NamedQuery(name = "findUserByFavouriteAgentsContaining", query = "select myUser from User myUser where myUser.favouriteAgents like ?1"),
		@NamedQuery(name = "findUserByFavouriteIps", query = "select myUser from User myUser where myUser.favouriteIps = ?1"),
		@NamedQuery(name = "findUserByFavouriteIpsContaining", query = "select myUser from User myUser where myUser.favouriteIps like ?1"),
		@NamedQuery(name = "findUserByFirstName", query = "select myUser from User myUser where myUser.first_name = ?1"),
		@NamedQuery(name = "findUserByFirstNameContaining", query = "select myUser from User myUser where myUser.first_name like ?1"),
		@NamedQuery(name = "findUserByHashStatus", query = "select myUser from User myUser where myUser.hashStatus = ?1"),
		@NamedQuery(name = "findUserByLastName", query = "select myUser from User myUser where myUser.last_name = ?1"),
		@NamedQuery(name = "findUserByLastNameContaining", query = "select myUser from User myUser where myUser.last_name like ?1"),
		@NamedQuery(name = "findUserByLoginId", query = "select myUser from User myUser where myUser.loginId = ?1"),
		@NamedQuery(name = "findUserByLoginId1", query = "select myUser from User myUser where myUser.loginId1 = ?1"),
		@NamedQuery(name = "findUserByLoginId1Containing", query = "select myUser from User myUser where myUser.loginId1 like ?1"),
		@NamedQuery(name = "findUserByLoginId2", query = "select myUser from User myUser where myUser.loginId2 = ?1"),
		@NamedQuery(name = "findUserByLoginId2Containing", query = "select myUser from User myUser where myUser.loginId2 like ?1"),
		@NamedQuery(name = "findUserByLoginId3", query = "select myUser from User myUser where myUser.loginId3 = ?1"),
		@NamedQuery(name = "findUserByLoginId3Containing", query = "select myUser from User myUser where myUser.loginId3 like ?1"),
		@NamedQuery(name = "findUserByLoginId4", query = "select myUser from User myUser where myUser.loginId4 = ?1"),
		@NamedQuery(name = "findUserByLoginId4Containing", query = "select myUser from User myUser where myUser.loginId4 like ?1"),
		@NamedQuery(name = "findUserByLoginId5", query = "select myUser from User myUser where myUser.loginId5 = ?1"),
		@NamedQuery(name = "findUserByLoginId5Containing", query = "select myUser from User myUser where myUser.loginId5 like ?1"),
		@NamedQuery(name = "findUserByLoginIdContaining", query = "select myUser from User myUser where myUser.loginId like ?1"),
		@NamedQuery(name = "findUserByLoginToken", query = "select myUser from User myUser where myUser.loginToken = ?1"),
		@NamedQuery(name = "findUserByLoginTokenContaining", query = "select myUser from User myUser where myUser.loginToken like ?1"),
		@NamedQuery(name = "findUserByLoginType", query = "select myUser from User myUser where myUser.loginType = ?1"),
		@NamedQuery(name = "findUserByLoginTypeContaining", query = "select myUser from User myUser where myUser.loginType like ?1"),
		@NamedQuery(name = "findUserByMobCountryPrefix", query = "select myUser from User myUser where myUser.mob_country_prefix = ?1"),
		@NamedQuery(name = "findUserByMobCountryPrefixContaining", query = "select myUser from User myUser where myUser.mob_country_prefix like ?1"),
		@NamedQuery(name = "findUserByMobile", query = "select myUser from User myUser where myUser.mobile = ?1"),
		@NamedQuery(name = "findUserByMobile1", query = "select myUser from User myUser where myUser.mobile1 = ?1"),
		@NamedQuery(name = "findUserByMobile1Containing", query = "select myUser from User myUser where myUser.mobile1 like ?1"),
		@NamedQuery(name = "findUserByMobile2", query = "select myUser from User myUser where myUser.mobile2 = ?1"),
		@NamedQuery(name = "findUserByMobile2Containing", query = "select myUser from User myUser where myUser.mobile2 like ?1"),
		@NamedQuery(name = "findUserByMobileContaining", query = "select myUser from User myUser where myUser.mobile like ?1"),
		@NamedQuery(name = "findUserByModifiedBy", query = "select myUser from User myUser where myUser.modifiedBy = ?1"),
		@NamedQuery(name = "findUserByModifiedByContaining", query = "select myUser from User myUser where myUser.modifiedBy like ?1"),
		@NamedQuery(name = "findUserByModifiedDate", query = "select myUser from User myUser where myUser.modifiedDate = ?1"),
		@NamedQuery(name = "findUserByPassword", query = "select myUser from User myUser where myUser.password = ?1"),
		@NamedQuery(name = "findUserByPasswordContaining", query = "select myUser from User myUser where myUser.password like ?1"),
		@NamedQuery(name = "findUserByPermissionNegative", query = "select myUser from User myUser where myUser.permissionNegative = ?1"),
		@NamedQuery(name = "findUserByPermissionNegativeContaining", query = "select myUser from User myUser where myUser.permissionNegative like ?1"),
		@NamedQuery(name = "findUserByPermissionPositive", query = "select myUser from User myUser where myUser.permissionPositive = ?1"),
		@NamedQuery(name = "findUserByPermissionPositiveContaining", query = "select myUser from User myUser where myUser.permissionPositive like ?1"),
		@NamedQuery(name = "findUserByPrimaryKey", query = "select myUser from User myUser where myUser.userId = ?1"),
		@NamedQuery(name = "findUserByPrimaryLogin", query = "select myUser from User myUser where myUser.primaryLogin = ?1"),
		@NamedQuery(name = "findUserByPrimaryLoginContaining", query = "select myUser from User myUser where myUser.primaryLogin like ?1"),
		@NamedQuery(name = "findUserByStatus", query = "select myUser from User myUser where myUser.status = ?1"),
		@NamedQuery(name = "findUserByToken", query = "select myUser from User myUser where myUser.token = ?1"),
		@NamedQuery(name = "findUserByTokenContaining", query = "select myUser from User myUser where myUser.token like ?1"),
		@NamedQuery(name = "findUserByUserEntityType", query = "select myUser from User myUser where myUser.userEntityType = ?1"),
		@NamedQuery(name = "findUserByUserId", query = "select myUser from User myUser where myUser.userId = ?1"),
		@NamedQuery(name = "findUserByUserRole", query = "select myUser from User myUser where myUser.userRole = ?1"),
		@NamedQuery(name = "findUserByUserRoleContaining", query = "select myUser from User myUser where myUser.userRole like ?1"),
		@NamedQuery(name = "findUserByUserType", query = "select myUser from User myUser where myUser.userType = ?1") })
@Table(name = "users")
@SQLDelete(sql="UPDATE users SET date_deletion=CURRENT_DATE WHERE user_id=? ")
@Where(clause="date_deletion IS NULL ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "User")
@XmlRootElement(namespace = "um/com/osl/skygyft/um/domain")
public class User implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "login_id", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId;
	/**
	 */

	@Column(name = "password", length = 100, nullable = true)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "first_name", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String first_name;
	/**
	 */

	@Column(name = "last_name", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String last_name;
	/**
	 */

	@Column(name = "e_mail", length = 200)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "mob_country_prefix", length = 6)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mob_country_prefix;
	/**
	 */

	@Column(name = "mobile", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mobile;
	/**
	 */

	@Column(name = "user_type", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean userType;
	/**
	 */

	@Column(name = "user_entity_type")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean userEntityType;
	/**
	 */

	@Column(name = "entity_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer entityId;
	/**
	 */

	@Column(name = "user_role", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String userRole;
	/**
	 */

	@Column(name = "permission_negative", length = 1000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String permissionNegative;
	/**
	 */

	@Column(name = "permission_positive", length = 1000)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String permissionPositive;
	/**
	 */

	@Column(name = "status", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean status;
	/**
	 */

	@Column(name = "token", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String token;
	/**
	 */

	@Column(name = "login_token", length = 500)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginToken;
	/**
	 */

	@Column(name = "hash_status")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean hashStatus;
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

	@Column(name = "login_id1", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId1;
	/**
	 */

	@Column(name = "login_id2", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId2;
	/**
	 */

	@Column(name = "login_id3", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId3;
	/**
	 */

	@Column(name = "login_id4", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId4;
	/**
	 */

	@Column(name = "login_id5", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginId5;
	/**
	 */

	@Column(name = "email1", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email1;
	/**
	 */

	@Column(name = "email2", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email2;
	/**
	 */

	@Column(name = "mobile1", length = 14)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mobile1;
	/**
	 */

	@Column(name = "mobile2", length = 14)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String mobile2;
	/**
	 */

	@Column(name = "login_type", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String loginType;
	/**
	 */

	@Column(name = "primary_login", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String primaryLogin;
	/**
	 */

	@Column(name = "favourite_ips", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String favouriteIps;
	/**
	 */

	@Column(name = "favourite_agents", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String favouriteAgents;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id", updatable = false, insertable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", updatable = false, insertable = false) })
	Set<Role> roleSet;
	
	@Transient
	List<Permission> positivePermissions;

	@Transient
	List<Permission> negativePermissions;
	
	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.UserRole> userRoles;
	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.UserPermission> userPermissions;
	/**
	 */
	@OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.AuditTrial> auditTrials;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob_country_prefix() {
		return mob_country_prefix;
	}

	public void setMob_country_prefix(String mob_country_prefix) {
		this.mob_country_prefix = mob_country_prefix;
	}

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
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 */
	public String getLoginId() {
		return this.loginId;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}


	/**
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 */
	public void setUserType(Boolean userType) {
		this.userType = userType;
	}

	/**
	 */
	public Boolean getUserType() {
		return this.userType;
	}

	/**
	 */
	public void setUserEntityType(Boolean userEntityType) {
		this.userEntityType = userEntityType;
	}

	/**
	 */
	public Boolean getUserEntityType() {
		return this.userEntityType;
	}

	/**
	 */
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	/**
	 */
	public Integer getEntityId() {
		return this.entityId;
	}

	/**
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 */
	public String getUserRole() {
		return this.userRole;
	}

	/**
	 */
	public void setPermissionNegative(String permissionNegative) {
		this.permissionNegative = permissionNegative;
	}

	/**
	 */
	public String getPermissionNegative() {
		return this.permissionNegative;
	}

	/**
	 */
	public void setPermissionPositive(String permissionPositive) {
		this.permissionPositive = permissionPositive;
	}

	/**
	 */
	public String getPermissionPositive() {
		return this.permissionPositive;
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
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 */
	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	/**
	 */
	public String getLoginToken() {
		return this.loginToken;
	}

	/**
	 */
	public void setHashStatus(Boolean hashStatus) {
		this.hashStatus = hashStatus;
	}

	/**
	 */
	public Boolean getHashStatus() {
		return this.hashStatus;
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
	public void setLoginId1(String loginId1) {
		this.loginId1 = loginId1;
	}

	/**
	 */
	public String getLoginId1() {
		return this.loginId1;
	}

	/**
	 */
	public void setLoginId2(String loginId2) {
		this.loginId2 = loginId2;
	}

	/**
	 */
	public String getLoginId2() {
		return this.loginId2;
	}

	/**
	 */
	public void setLoginId3(String loginId3) {
		this.loginId3 = loginId3;
	}

	/**
	 */
	public String getLoginId3() {
		return this.loginId3;
	}

	/**
	 */
	public void setLoginId4(String loginId4) {
		this.loginId4 = loginId4;
	}

	/**
	 */
	public String getLoginId4() {
		return this.loginId4;
	}

	/**
	 */
	public void setLoginId5(String loginId5) {
		this.loginId5 = loginId5;
	}

	/**
	 */
	public String getLoginId5() {
		return this.loginId5;
	}

	/**
	 */
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	/**
	 */
	public String getEmail1() {
		return this.email1;
	}

	/**
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 */
	public String getEmail2() {
		return this.email2;
	}

	/**
	 */
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	/**
	 */
	public String getMobile1() {
		return this.mobile1;
	}

	/**
	 */
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	/**
	 */
	public String getMobile2() {
		return this.mobile2;
	}

	/**
	 */
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 */
	public String getLoginType() {
		return this.loginType;
	}

	/**
	 */
	public void setPrimaryLogin(String primaryLogin) {
		this.primaryLogin = primaryLogin;
	}

	/**
	 */
	public String getPrimaryLogin() {
		return this.primaryLogin;
	}

	/**
	 */
	public void setFavouriteIps(String favouriteIps) {
		this.favouriteIps = favouriteIps;
	}

	/**
	 */
	public String getFavouriteIps() {
		return this.favouriteIps;
	}

	/**
	 */
	public void setFavouriteAgents(String favouriteAgents) {
		this.favouriteAgents = favouriteAgents;
	}

	/**
	 */
	public String getFavouriteAgents() {
		return this.favouriteAgents;
	}

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
	public void setAuditTrials(Set<AuditTrial> auditTrials) {
		this.auditTrials = auditTrials;
	}

	/**
	 */
	@JsonIgnore
	public Set<AuditTrial> getAuditTrials() {
		if (auditTrials == null) {
			auditTrials = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.AuditTrial>();
		}
		return auditTrials;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	/**
	 */
	public User() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(User that) {
		setUserId(that.getUserId());
		setLoginId(that.getLoginId());
		setPassword(that.getPassword());
		setFirst_name(that.getFirst_name());
		setLast_name(that.getLast_name());
		setEmail(that.getEmail());
		setMob_country_prefix(that.getMob_country_prefix());
		setMobile(that.getMobile());
		setUserType(that.getUserType());
		setUserEntityType(that.getUserEntityType());
		setEntityId(that.getEntityId());
		setUserRole(that.getUserRole());
		setPermissionNegative(that.getPermissionNegative());
		setPermissionPositive(that.getPermissionPositive());
		setStatus(that.getStatus());
		setToken(that.getToken());
		setLoginToken(that.getLoginToken());
		setHashStatus(that.getHashStatus());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setLoginId1(that.getLoginId1());
		setLoginId2(that.getLoginId2());
		setLoginId3(that.getLoginId3());
		setLoginId4(that.getLoginId4());
		setLoginId5(that.getLoginId5());
		setEmail1(that.getEmail1());
		setEmail2(that.getEmail2());
		setMobile1(that.getMobile1());
		setMobile2(that.getMobile2());
		setLoginType(that.getLoginType());
		setPrimaryLogin(that.getPrimaryLogin());
		setFavouriteIps(that.getFavouriteIps());
		setFavouriteAgents(that.getFavouriteAgents());
		setUserRoles(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserRole>(that.getUserRoles()));
		setUserPermissions(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.UserPermission>(that.getUserPermissions()));
		setAuditTrials(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.AuditTrial>(that.getAuditTrials()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("loginId=[").append(loginId).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("first_name=[").append(first_name).append("] ");
		buffer.append("last_name=[").append(last_name).append("] ");
		buffer.append("EMail=[").append(email).append("] ");
		buffer.append("mobCountryPrefix=[").append(mob_country_prefix).append("] ");
		buffer.append("mobile=[").append(mobile).append("] ");
		buffer.append("userType=[").append(userType).append("] ");
		buffer.append("userEntityType=[").append(userEntityType).append("] ");
		buffer.append("entityId=[").append(entityId).append("] ");
		buffer.append("userRole=[").append(userRole).append("] ");
		buffer.append("permissionNegative=[").append(permissionNegative).append("] ");
		buffer.append("permissionPositive=[").append(permissionPositive).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("token=[").append(token).append("] ");
		buffer.append("loginToken=[").append(loginToken).append("] ");
		buffer.append("hashStatus=[").append(hashStatus).append("] ");
		buffer.append("createDate=[").append(createDate).append("] ");
		buffer.append("modifiedDate=[").append(modifiedDate).append("] ");
		buffer.append("createBy=[").append(createBy).append("] ");
		buffer.append("modifiedBy=[").append(modifiedBy).append("] ");
		buffer.append("loginId1=[").append(loginId1).append("] ");
		buffer.append("loginId2=[").append(loginId2).append("] ");
		buffer.append("loginId3=[").append(loginId3).append("] ");
		buffer.append("loginId4=[").append(loginId4).append("] ");
		buffer.append("loginId5=[").append(loginId5).append("] ");
		buffer.append("email1=[").append(email1).append("] ");
		buffer.append("email2=[").append(email2).append("] ");
		buffer.append("mobile1=[").append(mobile1).append("] ");
		buffer.append("mobile2=[").append(mobile2).append("] ");
		buffer.append("loginType=[").append(loginType).append("] ");
		buffer.append("primaryLogin=[").append(primaryLogin).append("] ");
		buffer.append("favouriteIps=[").append(favouriteIps).append("] ");
		buffer.append("favouriteAgents=[").append(favouriteAgents).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof User))
			return false;
		User equalCheck = (User) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		return true;
	}

	public List<Permission> getPositivePermissions() {
		return positivePermissions;
	}

	public void setPositivePermissions(List<Permission> positivePermissions) {
		this.positivePermissions = positivePermissions;
	}

	public List<Permission> getNegativePermissions() {
		return negativePermissions;
	}

	public void setNegativePermissions(List<Permission> negativePermissions) {
		this.negativePermissions = negativePermissions;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return loginId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
