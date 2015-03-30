package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.Permission;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Permission entities.
 * 
 */
public interface PermissionDAO extends JpaDao<Permission> {

	/**
	 * JPQL Query - findPermissionByDescription
	 *
	 */
	public Set<Permission> findPermissionByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByDescription
	 *
	 */
	public Set<Permission> findPermissionByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermissionNameContaining
	 *
	 */
	public Set<Permission> findPermissionByPermissionNameContaining(String permissionName) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermissionNameContaining
	 *
	 */
	public Set<Permission> findPermissionByPermissionNameContaining(String permissionName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByStatus
	 *
	 */
	public Set<Permission> findPermissionByStatus(Boolean status) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByStatus
	 *
	 */
	public Set<Permission> findPermissionByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedByContaining
	 *
	 */
	public Set<Permission> findPermissionByModifiedByContaining(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedByContaining
	 *
	 */
	public Set<Permission> findPermissionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateDate
	 *
	 */
	public Set<Permission> findPermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateDate
	 *
	 */
	public Set<Permission> findPermissionByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModuleId
	 *
	 */
	public Set<Permission> findPermissionByModuleId(Integer moduleId) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModuleId
	 *
	 */
	public Set<Permission> findPermissionByModuleId(Integer moduleId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedBy
	 *
	 */
	public Set<Permission> findPermissionByModifiedBy(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedBy
	 *
	 */
	public Set<Permission> findPermissionByModifiedBy(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermId
	 *
	 */
	public Set<Permission> findPermissionByPermId(Integer permId) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermId
	 *
	 */
	public Set<Permission> findPermissionByPermId(Integer permId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	public Permission findPermissionById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	public Permission findPermissionById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedDate
	 *
	 */
	public Set<Permission> findPermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByModifiedDate
	 *
	 */
	public Set<Permission> findPermissionByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	public Set<Permission> findAllPermissions() throws DataAccessException;

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	public Set<Permission> findAllPermissions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateByContaining
	 *
	 */
	public Set<Permission> findPermissionByCreateByContaining(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateByContaining
	 *
	 */
	public Set<Permission> findPermissionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	public Permission findPermissionByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	public Permission findPermissionByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateBy
	 *
	 */
	public Set<Permission> findPermissionByCreateBy(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByCreateBy
	 *
	 */
	public Set<Permission> findPermissionByCreateBy(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermissionName
	 *
	 */
	public Set<Permission> findPermissionByPermissionName(String permissionName_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByPermissionName
	 *
	 */
	public Set<Permission> findPermissionByPermissionName(String permissionName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByDescriptionContaining
	 *
	 */
	public Set<Permission> findPermissionByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findPermissionByDescriptionContaining
	 *
	 */
	public Set<Permission> findPermissionByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

}