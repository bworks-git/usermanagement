package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.AuditTrial;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage AuditTrial entities.
 * 
 */
@Repository("AuditTrialDAO")
@Transactional
public class AuditTrialDAOImpl extends AbstractJpaDao<AuditTrial> implements
		AuditTrialDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AuditTrial.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuditTrialDAOImpl
	 *
	 */
	public AuditTrialDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAuditTrialByKeyword
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByKeyword(String keyword) throws DataAccessException {

		return findAuditTrialByKeyword(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByKeyword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByKeyword(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByKeyword", startResult, maxRows, keyword);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByUserTypeFlag
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserTypeFlag(Boolean userTypeFlag) throws DataAccessException {

		return findAuditTrialByUserTypeFlag(userTypeFlag, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByUserTypeFlag
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserTypeFlag(Boolean userTypeFlag, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByUserTypeFlag", startResult, maxRows, userTypeFlag);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByUserAgentContaining
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserAgentContaining(String userAgent) throws DataAccessException {

		return findAuditTrialByUserAgentContaining(userAgent, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByUserAgentContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserAgentContaining(String userAgent, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByUserAgentContaining", startResult, maxRows, userAgent);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByIpAddress
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByIpAddress(String ipAddress) throws DataAccessException {

		return findAuditTrialByIpAddress(ipAddress, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByIpAddress
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByIpAddress(String ipAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByIpAddress", startResult, maxRows, ipAddress);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAuditTrials
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAllAuditTrials() throws DataAccessException {

		return findAllAuditTrials(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuditTrials
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAllAuditTrials(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuditTrials", startResult, maxRows);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByKeywordContaining
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByKeywordContaining(String keyword) throws DataAccessException {

		return findAuditTrialByKeywordContaining(keyword, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByKeywordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByKeywordContaining(String keyword, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByKeywordContaining", startResult, maxRows, keyword);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByAuditId
	 *
	 */
	@Transactional
	public AuditTrial findAuditTrialByAuditId(Integer auditId) throws DataAccessException {

		return findAuditTrialByAuditId(auditId, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByAuditId
	 *
	 */

	@Transactional
	public AuditTrial findAuditTrialByAuditId(Integer auditId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuditTrialByAuditId", startResult, maxRows, auditId);
			return (com.osl.skygyft.um.domain.AuditTrial) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuditTrialByDateAdded
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByDateAdded(java.util.Calendar dateAdded) throws DataAccessException {

		return findAuditTrialByDateAdded(dateAdded, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByDateAdded
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByDateAdded(java.util.Calendar dateAdded, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByDateAdded", startResult, maxRows, dateAdded);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByDescription
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByDescription(String description) throws DataAccessException {

		return findAuditTrialByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByDescription", startResult, maxRows, description);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialBySuccesFailureFlag
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialBySuccesFailureFlag(Boolean succesFailureFlag) throws DataAccessException {

		return findAuditTrialBySuccesFailureFlag(succesFailureFlag, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialBySuccesFailureFlag
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialBySuccesFailureFlag(Boolean succesFailureFlag, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialBySuccesFailureFlag", startResult, maxRows, succesFailureFlag);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByDescriptionContaining(String description) throws DataAccessException {

		return findAuditTrialByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByUserAgent
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserAgent(String userAgent) throws DataAccessException {

		return findAuditTrialByUserAgent(userAgent, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByUserAgent
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByUserAgent(String userAgent, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByUserAgent", startResult, maxRows, userAgent);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditTrialByPrimaryKey
	 *
	 */
	@Transactional
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId) throws DataAccessException {

		return findAuditTrialByPrimaryKey(auditId, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByPrimaryKey
	 *
	 */

	@Transactional
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuditTrialByPrimaryKey", startResult, maxRows, auditId);
			return (com.osl.skygyft.um.domain.AuditTrial) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuditTrialByIpAddressContaining
	 *
	 */
	@Transactional
	public Set<AuditTrial> findAuditTrialByIpAddressContaining(String ipAddress) throws DataAccessException {

		return findAuditTrialByIpAddressContaining(ipAddress, -1, -1);
	}

	/**
	 * JPQL Query - findAuditTrialByIpAddressContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditTrial> findAuditTrialByIpAddressContaining(String ipAddress, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditTrialByIpAddressContaining", startResult, maxRows, ipAddress);
		return new LinkedHashSet<AuditTrial>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AuditTrial entity) {
		return true;
	}
}
