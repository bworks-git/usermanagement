package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UserRole;

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
 * DAO to manage UserRole entities.
 * 
 */
@Repository("UserRoleDAO")
@Transactional
public class UserRoleDAOImpl extends AbstractJpaDao<UserRole> implements
		UserRoleDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { UserRole.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserRoleDAOImpl
	 *
	 */
	public UserRoleDAOImpl() {
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
	 * JPQL Query - findUserRoleByCreateByContaining
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByCreateByContaining(String createBy) throws DataAccessException {

		return findUserRoleByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findUserRoleByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByModifiedDate
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findUserRoleByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByModifiedBy
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByModifiedBy(String modifiedBy) throws DataAccessException {

		return findUserRoleByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByRoleId
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByRoleId(Integer roleId) throws DataAccessException {

		return findUserRoleByRoleId(roleId, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByRoleId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByRoleId(Integer roleId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByRoleId", startResult, maxRows, roleId);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByCreateDate
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findUserRoleByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByPrimaryKey
	 *
	 */
	@Transactional
	public UserRole findUserRoleByPrimaryKey(Integer userId, Integer roleId) throws DataAccessException {

		return findUserRoleByPrimaryKey(userId, roleId, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByPrimaryKey
	 *
	 */

	@Transactional
	public UserRole findUserRoleByPrimaryKey(Integer userId, Integer roleId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserRoleByPrimaryKey", startResult, maxRows, userId, roleId);
			return (com.osl.skygyft.um.domain.UserRole) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserRoleByUserId
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByUserId(Integer userId) throws DataAccessException {

		return findUserRoleByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByUserId", startResult, maxRows, userId);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUserRoles
	 *
	 */
	@Transactional
	public Set<UserRole> findAllUserRoles() throws DataAccessException {

		return findAllUserRoles(-1, -1);
	}

	/**
	 * JPQL Query - findAllUserRoles
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findAllUserRoles(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUserRoles", startResult, maxRows);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserRoleByCreateBy
	 *
	 */
	@Transactional
	public Set<UserRole> findUserRoleByCreateBy(String createBy) throws DataAccessException {

		return findUserRoleByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserRoleByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserRole> findUserRoleByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserRoleByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<UserRole>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(UserRole entity) {
		return true;
	}
}
