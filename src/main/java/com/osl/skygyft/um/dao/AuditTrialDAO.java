package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.AuditTrial;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage AuditTrial entities.
 * 
 */
public interface AuditTrialDAO extends JpaDao<AuditTrial> {

	/**
	 * JPQL Query - findAuditTrialByKeyword
	 *
	 */
	public Set<AuditTrial> findAuditTrialByKeyword(String keyword) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByKeyword
	 *
	 */
	public Set<AuditTrial> findAuditTrialByKeyword(String keyword, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserTypeFlag
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserTypeFlag(Boolean userTypeFlag) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserTypeFlag
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserTypeFlag(Boolean userTypeFlag, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserAgentContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserAgentContaining(String userAgent) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserAgentContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserAgentContaining(String userAgent, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByIpAddress
	 *
	 */
	public Set<AuditTrial> findAuditTrialByIpAddress(String ipAddress) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByIpAddress
	 *
	 */
	public Set<AuditTrial> findAuditTrialByIpAddress(String ipAddress, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuditTrials
	 *
	 */
	public Set<AuditTrial> findAllAuditTrials() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuditTrials
	 *
	 */
	public Set<AuditTrial> findAllAuditTrials(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByKeywordContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByKeywordContaining(String keyword_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByKeywordContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByKeywordContaining(String keyword_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByAuditId
	 *
	 */
	public AuditTrial findAuditTrialByAuditId(Integer auditId) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByAuditId
	 *
	 */
	public AuditTrial findAuditTrialByAuditId(Integer auditId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDateAdded
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDateAdded(java.util.Calendar dateAdded) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDateAdded
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDateAdded(Calendar dateAdded, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDescription
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDescription
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialBySuccesFailureFlag
	 *
	 */
	public Set<AuditTrial> findAuditTrialBySuccesFailureFlag(Boolean succesFailureFlag) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialBySuccesFailureFlag
	 *
	 */
	public Set<AuditTrial> findAuditTrialBySuccesFailureFlag(Boolean succesFailureFlag, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDescriptionContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByDescriptionContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserAgent
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserAgent(String userAgent_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByUserAgent
	 *
	 */
	public Set<AuditTrial> findAuditTrialByUserAgent(String userAgent_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByPrimaryKey
	 *
	 */
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByPrimaryKey
	 *
	 */
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByIpAddressContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByIpAddressContaining(String ipAddress_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuditTrialByIpAddressContaining
	 *
	 */
	public Set<AuditTrial> findAuditTrialByIpAddressContaining(String ipAddress_1, int startResult, int maxRows) throws DataAccessException;

}