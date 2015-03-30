package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.RolePermission;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage RolePermission entities.
 * 
 */
public interface RolePermissionDAO extends JpaDao<RolePermission> {

	/**
	 * JPQL Query - findRolePermissionByPrimaryKey
	 *
	 */
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId, Integer permissionId) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByPrimaryKey
	 *
	 */
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId, Integer permissionId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateByContaining
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateByContaining(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateByContaining
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllRolePermissions
	 *
	 */
	public Set<RolePermission> findAllRolePermissions() throws DataAccessException;

	/**
	 * JPQL Query - findAllRolePermissions
	 *
	 */
	public Set<RolePermission> findAllRolePermissions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedDate
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedDate
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByRoleId
	 *
	 */
	public Set<RolePermission> findRolePermissionByRoleId(Integer roleId_1) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByRoleId
	 *
	 */
	public Set<RolePermission> findRolePermissionByRoleId(Integer roleId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateBy
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateBy(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateBy
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateBy(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByPermissionId
	 *
	 */
	public Set<RolePermission> findRolePermissionByPermissionId(Integer permissionId_1) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByPermissionId
	 *
	 */
	public Set<RolePermission> findRolePermissionByPermissionId(Integer permissionId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateDate
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByCreateDate
	 *
	 */
	public Set<RolePermission> findRolePermissionByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedBy
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedBy(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedBy
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedByContaining
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedByContaining(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findRolePermissionByModifiedByContaining
	 *
	 */
	public Set<RolePermission> findRolePermissionByModifiedByContaining(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

}