package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.Permission;

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
 * DAO to manage Permission entities.
 * 
 */
@Repository("PermissionDAO")
@Transactional
public class PermissionDAOImpl extends AbstractJpaDao<Permission> implements
		PermissionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Permission.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new PermissionDAOImpl
	 *
	 */
	public PermissionDAOImpl() {
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
	 * JPQL Query - findPermissionByDescription
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByDescription(String description) throws DataAccessException {

		return findPermissionByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByPermissionNameContaining
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByPermissionNameContaining(String permissionName) throws DataAccessException {

		return findPermissionByPermissionNameContaining(permissionName, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByPermissionNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByPermissionNameContaining(String permissionName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByPermissionNameContaining", startResult, maxRows, permissionName);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByStatus
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByStatus(Boolean status) throws DataAccessException {

		return findPermissionByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findPermissionByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByCreateDate
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findPermissionByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByModuleId
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByModuleId(Integer moduleId) throws DataAccessException {

		return findPermissionByModuleId(moduleId, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByModuleId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByModuleId(Integer moduleId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByModuleId", startResult, maxRows, moduleId);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByModifiedBy
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByModifiedBy(String modifiedBy) throws DataAccessException {

		return findPermissionByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByPermId
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByPermId(Integer permId) throws DataAccessException {

		return findPermissionByPermId(permId, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByPermId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByPermId(Integer permId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByPermId", startResult, maxRows, permId);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionById
	 *
	 */
	@Transactional
	public Permission findPermissionById(Integer id) throws DataAccessException {

		return findPermissionById(id, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionById
	 *
	 */

	@Transactional
	public Permission findPermissionById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPermissionById", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.Permission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPermissionByModifiedDate
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findPermissionByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */
	@Transactional
	public Set<Permission> findAllPermissions() throws DataAccessException {

		return findAllPermissions(-1, -1);
	}

	/**
	 * JPQL Query - findAllPermissions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findAllPermissions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllPermissions", startResult, maxRows);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByCreateByContaining
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByCreateByContaining(String createBy) throws DataAccessException {

		return findPermissionByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */
	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id) throws DataAccessException {

		return findPermissionByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByPrimaryKey
	 *
	 */

	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findPermissionByPrimaryKey", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.Permission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findPermissionByCreateBy
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByCreateBy(String createBy) throws DataAccessException {

		return findPermissionByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByPermissionName
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByPermissionName(String permissionName) throws DataAccessException {

		return findPermissionByPermissionName(permissionName, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByPermissionName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByPermissionName(String permissionName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByPermissionName", startResult, maxRows, permissionName);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * JPQL Query - findPermissionByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Permission> findPermissionByDescriptionContaining(String description) throws DataAccessException {

		return findPermissionByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findPermissionByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Permission> findPermissionByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findPermissionByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Permission>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Permission entity) {
		return true;
	}
}
