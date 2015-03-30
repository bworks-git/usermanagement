package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UserPermission;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage UserPermission entities.
 * 
 */
public interface UserPermissionDAO extends JpaDao<UserPermission> {

	/**
	 * JPQL Query - findUserPermissionByPermissionType
	 *
	 */
	public Set<UserPermission> findUserPermissionByPermissionType(Boolean permissionType) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByPermissionType
	 *
	 */
	public Set<UserPermission> findUserPermissionByPermissionType(Boolean permissionType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByPrimaryKey
	 *
	 */
	public UserPermission findUserPermissionByPrimaryKey(Integer userId, Integer permissionId) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByPrimaryKey
	 *
	 */
	public UserPermission findUserPermissionByPrimaryKey(Integer userId, Integer permissionId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateBy
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateBy(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateBy
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateDate
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateDate
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateByContaining
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateByContaining(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByCreateByContaining
	 *
	 */
	public Set<UserPermission> findUserPermissionByCreateByContaining(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedDate
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedDate
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByUserId
	 *
	 */
	public Set<UserPermission> findUserPermissionByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByUserId
	 *
	 */
	public Set<UserPermission> findUserPermissionByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedBy
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedBy(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedBy
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByPermissionId
	 *
	 */
	public Set<UserPermission> findUserPermissionByPermissionId(Integer permissionId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByPermissionId
	 *
	 */
	public Set<UserPermission> findUserPermissionByPermissionId(Integer permissionId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedByContaining
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedByContaining(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserPermissionByModifiedByContaining
	 *
	 */
	public Set<UserPermission> findUserPermissionByModifiedByContaining(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserPermissions
	 *
	 */
	public Set<UserPermission> findAllUserPermissions() throws DataAccessException;

	/**
	 * JPQL Query - findAllUserPermissions
	 *
	 */
	public Set<UserPermission> findAllUserPermissions(int startResult, int maxRows) throws DataAccessException;

}