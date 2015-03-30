package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UserPermission;

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
 * DAO to manage UserPermission entities.
 * 
 */
@Repository("UserPermissionDAO")
@Transactional
public class UserPermissionDAOImpl extends AbstractJpaDao<UserPermission>
		implements UserPermissionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { UserPermission.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserPermissionDAOImpl
	 *
	 */
	public UserPermissionDAOImpl() {
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
	 * JPQL Query - findUserPermissionByPermissionType
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByPermissionType(Boolean permissionType) throws DataAccessException {

		return findUserPermissionByPermissionType(permissionType, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByPermissionType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByPermissionType(Boolean permissionType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByPermissionType", startResult, maxRows, permissionType);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByPrimaryKey
	 *
	 */
	@Transactional
	public UserPermission findUserPermissionByPrimaryKey(Integer userId, Integer permissionId) throws DataAccessException {

		return findUserPermissionByPrimaryKey(userId, permissionId, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByPrimaryKey
	 *
	 */

	@Transactional
	public UserPermission findUserPermissionByPrimaryKey(Integer userId, Integer permissionId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserPermissionByPrimaryKey", startResult, maxRows, userId, permissionId);
			return (com.osl.skygyft.um.domain.UserPermission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserPermissionByCreateBy
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateBy(String createBy) throws DataAccessException {

		return findUserPermissionByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByCreateDate
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findUserPermissionByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByCreateByContaining
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateByContaining(String createBy) throws DataAccessException {

		return findUserPermissionByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedDate
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findUserPermissionByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByUserId
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByUserId(Integer userId) throws DataAccessException {

		return findUserPermissionByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByUserId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByUserId", startResult, maxRows, userId);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedBy
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedBy(String modifiedBy) throws DataAccessException {

		return findUserPermissionByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByPermissionId
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByPermissionId(Integer permissionId) throws DataAccessException {

		return findUserPermissionByPermissionId(permissionId, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByPermissionId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByPermissionId(Integer permissionId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByPermissionId", startResult, maxRows, permissionId);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findUserPermissionByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserPermissionByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findUserPermissionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserPermissionByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUserPermissions
	 *
	 */
	@Transactional
	public Set<UserPermission> findAllUserPermissions() throws DataAccessException {

		return findAllUserPermissions(-1, -1);
	}

	/**
	 * JPQL Query - findAllUserPermissions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UserPermission> findAllUserPermissions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUserPermissions", startResult, maxRows);
		return new LinkedHashSet<UserPermission>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(UserPermission entity) {
		return true;
	}
}
