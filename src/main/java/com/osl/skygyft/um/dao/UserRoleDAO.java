package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UserRole;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage UserRole entities.
 * 
 */
public interface UserRoleDAO extends JpaDao<UserRole> {

	/**
	 * JPQL Query - findUserRoleByCreateByContaining
	 *
	 */
	public Set<UserRole> findUserRoleByCreateByContaining(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByCreateByContaining
	 *
	 */
	public Set<UserRole> findUserRoleByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedByContaining
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedByContaining(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedByContaining
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedDate
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedDate
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedBy
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedBy(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByModifiedBy
	 *
	 */
	public Set<UserRole> findUserRoleByModifiedBy(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByRoleId
	 *
	 */
	public Set<UserRole> findUserRoleByRoleId(Integer roleId) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByRoleId
	 *
	 */
	public Set<UserRole> findUserRoleByRoleId(Integer roleId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByCreateDate
	 *
	 */
	public Set<UserRole> findUserRoleByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByCreateDate
	 *
	 */
	public Set<UserRole> findUserRoleByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByPrimaryKey
	 *
	 */
	public UserRole findUserRoleByPrimaryKey(Integer userId, Integer roleId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByPrimaryKey
	 *
	 */
	public UserRole findUserRoleByPrimaryKey(Integer userId, Integer roleId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByUserId
	 *
	 */
	public Set<UserRole> findUserRoleByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByUserId
	 *
	 */
	public Set<UserRole> findUserRoleByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserRoles
	 *
	 */
	public Set<UserRole> findAllUserRoles() throws DataAccessException;

	/**
	 * JPQL Query - findAllUserRoles
	 *
	 */
	public Set<UserRole> findAllUserRoles(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByCreateBy
	 *
	 */
	public Set<UserRole> findUserRoleByCreateBy(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserRoleByCreateBy
	 *
	 */
	public Set<UserRole> findUserRoleByCreateBy(String createBy_1, int startResult, int maxRows) throws DataAccessException;

}