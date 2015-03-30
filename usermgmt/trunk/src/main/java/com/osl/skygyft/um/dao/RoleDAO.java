package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.Role;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Role entities.
 * 
 */
public interface RoleDAO extends JpaDao<Role> {

	/**
	 * JPQL Query - findAllRoles
	 *
	 */
	public List<Role> findAllRoles() throws DataAccessException;

	/**
	 * JPQL Query - findAllRoles
	 *
	 */
	public Set<Role> findAllRoles(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateBy
	 *
	 */
	public Set<Role> findRoleByCreateBy(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateBy
	 *
	 */
	public Set<Role> findRoleByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateDate
	 *
	 */
	public Set<Role> findRoleByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateDate
	 *
	 */
	public Set<Role> findRoleByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPermissionSetContaining
	 *
	 */
	public Set<Role> findRoleByPermissionSetContaining(String permissionSet) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPermissionSetContaining
	 *
	 */
	public Set<Role> findRoleByPermissionSetContaining(String permissionSet, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateByContaining
	 *
	 */
	public Set<Role> findRoleByCreateByContaining(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByCreateByContaining
	 *
	 */
	public Set<Role> findRoleByCreateByContaining(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPermissionSet
	 *
	 */
	public Set<Role> findRoleByPermissionSet(String permissionSet_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPermissionSet
	 *
	 */
	public Set<Role> findRoleByPermissionSet(String permissionSet_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedDate
	 *
	 */
	public Set<Role> findRoleByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedDate
	 *
	 */
	public Set<Role> findRoleByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedBy
	 *
	 */
	public Set<Role> findRoleByModifiedBy(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedBy
	 *
	 */
	public Set<Role> findRoleByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleById
	 *
	 */
	public Role findRoleById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findRoleById
	 *
	 */
	public Role findRoleById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByStatus
	 *
	 */
	public Set<Role> findRoleByStatus(Boolean status) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByStatus
	 *
	 */
	public Set<Role> findRoleByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModuleId
	 *
	 */
	public Set<Role> findRoleByModuleId(Integer moduleId) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModuleId
	 *
	 */
	public Set<Role> findRoleByModuleId(Integer moduleId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByDescription
	 *
	 */
	public Set<Role> findRoleByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByDescription
	 *
	 */
	public Set<Role> findRoleByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedByContaining
	 *
	 */
	public Set<Role> findRoleByModifiedByContaining(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByModifiedByContaining
	 *
	 */
	public Set<Role> findRoleByModifiedByContaining(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleNameContaining
	 *
	 */
	public Set<Role> findRoleByRoleNameContaining(String roleName) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleNameContaining
	 *
	 */
	public Set<Role> findRoleByRoleNameContaining(String roleName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleName
	 *
	 */
	public Set<Role> findRoleByRoleName(String roleName_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleName
	 *
	 */
	public Set<Role> findRoleByRoleName(String roleName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByDescriptionContaining
	 *
	 */
	public Set<Role> findRoleByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByDescriptionContaining
	 *
	 */
	public Set<Role> findRoleByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleId
	 *
	 */
	public Set<Role> findRoleByRoleId(Integer roleId) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByRoleId
	 *
	 */
	public Set<Role> findRoleByRoleId(Integer roleId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPrimaryKey
	 *
	 */
	public Role findRoleByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findRoleByPrimaryKey
	 *
	 */
	public Role findRoleByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}