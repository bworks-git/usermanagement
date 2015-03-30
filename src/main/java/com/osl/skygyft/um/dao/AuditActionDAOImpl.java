package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.AuditAction;

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
 * DAO to manage AuditAction entities.
 * 
 */
@Repository("AuditActionDAO")
@Transactional
public class AuditActionDAOImpl extends AbstractJpaDao<AuditAction> implements
		AuditActionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { AuditAction.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AuditActionDAOImpl
	 *
	 */
	public AuditActionDAOImpl() {
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
	 * JPQL Query - findAuditActionByCreateByContaining
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByCreateByContaining(String createBy) throws DataAccessException {

		return findAuditActionByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByCreateDate
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findAuditActionByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByCreateBy
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByCreateBy(String createBy) throws DataAccessException {

		return findAuditActionByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllAuditActions
	 *
	 */
	@Transactional
	public Set<AuditAction> findAllAuditActions() throws DataAccessException {

		return findAllAuditActions(-1, -1);
	}

	/**
	 * JPQL Query - findAllAuditActions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAllAuditActions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAuditActions", startResult, maxRows);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByModifiedDate
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findAuditActionByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionById
	 *
	 */
	@Transactional
	public AuditAction findAuditActionById(Integer id) throws DataAccessException {

		return findAuditActionById(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionById
	 *
	 */

	@Transactional
	public AuditAction findAuditActionById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuditActionById", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.AuditAction) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAuditActionByAction
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByAction(String action) throws DataAccessException {

		return findAuditActionByAction(action, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByAction
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByAction(String action, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByAction", startResult, maxRows, action);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByActionContaining
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByActionContaining(String action) throws DataAccessException {

		return findAuditActionByActionContaining(action, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByActionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByActionContaining(String action, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByActionContaining", startResult, maxRows, action);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findAuditActionByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByModifiedBy
	 *
	 */
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedBy(String modifiedBy) throws DataAccessException {

		return findAuditActionByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<AuditAction> findAuditActionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAuditActionByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<AuditAction>(query.getResultList());
	}

	/**
	 * JPQL Query - findAuditActionByPrimaryKey
	 *
	 */
	@Transactional
	public AuditAction findAuditActionByPrimaryKey(Integer id) throws DataAccessException {

		return findAuditActionByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findAuditActionByPrimaryKey
	 *
	 */

	@Transactional
	public AuditAction findAuditActionByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAuditActionByPrimaryKey", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.AuditAction) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(AuditAction entity) {
		return true;
	}
}
