package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.AuditAction;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AuditAction entities.
 * 
 */
public interface AuditActionDAO extends JpaDao<AuditAction> {

	/**
	 * JPQL Query - findAuditActionByCreateByContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateByContaining(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByCreateByContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByCreateDate
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByCreateDate
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByCreateBy
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateBy(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByCreateBy
	 *
	 */
	public Set<AuditAction> findAuditActionByCreateBy(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuditActions
	 *
	 */
	public Set<AuditAction> findAllAuditActions() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuditActions
	 *
	 */
	public Set<AuditAction> findAllAuditActions(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedDate
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedDate
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionById
	 *
	 */
	public AuditAction findAuditActionById(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionById
	 *
	 */
	public AuditAction findAuditActionById(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByAction
	 *
	 */
	public Set<AuditAction> findAuditActionByAction(String action) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByAction
	 *
	 */
	public Set<AuditAction> findAuditActionByAction(String action, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByActionContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByActionContaining(String action_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByActionContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByActionContaining(String action_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedByContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedByContaining(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedByContaining
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedBy
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedBy(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByModifiedBy
	 *
	 */
	public Set<AuditAction> findAuditActionByModifiedBy(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByPrimaryKey
	 *
	 */
	public AuditAction findAuditActionByPrimaryKey(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditActionByPrimaryKey
	 *
	 */
	public AuditAction findAuditActionByPrimaryKey(Integer id_1, int startResult, int maxRows) throws DataAccessException;

}