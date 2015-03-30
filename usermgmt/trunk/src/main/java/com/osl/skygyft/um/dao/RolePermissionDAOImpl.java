package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.RolePermission;

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
 * DAO to manage RolePermission entities.
 * 
 */
@Repository("RolePermissionDAO")
@Transactional
public class RolePermissionDAOImpl extends AbstractJpaDao<RolePermission>
		implements RolePermissionDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { RolePermission.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RolePermissionDAOImpl
	 *
	 */
	public RolePermissionDAOImpl() {
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
	 * JPQL Query - findRolePermissionByPrimaryKey
	 *
	 */
	@Transactional
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId, Integer permissionId) throws DataAccessException {

		return findRolePermissionByPrimaryKey(roleId, permissionId, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByPrimaryKey
	 *
	 */

	@Transactional
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId, Integer permissionId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRolePermissionByPrimaryKey", startResult, maxRows, roleId, permissionId);
			return (com.osl.skygyft.um.domain.RolePermission) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRolePermissionByCreateByContaining
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateByContaining(String createBy) throws DataAccessException {

		return findRolePermissionByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllRolePermissions
	 *
	 */
	@Transactional
	public Set<RolePermission> findAllRolePermissions() throws DataAccessException {

		return findAllRolePermissions(-1, -1);
	}

	/**
	 * JPQL Query - findAllRolePermissions
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findAllRolePermissions(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRolePermissions", startResult, maxRows);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedDate
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findRolePermissionByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByRoleId
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByRoleId(Integer roleId) throws DataAccessException {

		return findRolePermissionByRoleId(roleId, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByRoleId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByRoleId(Integer roleId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByRoleId", startResult, maxRows, roleId);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByCreateBy
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateBy(String createBy) throws DataAccessException {

		return findRolePermissionByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByPermissionId
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByPermissionId(Integer permissionId) throws DataAccessException {

		return findRolePermissionByPermissionId(permissionId, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByPermissionId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByPermissionId(Integer permissionId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByPermissionId", startResult, maxRows, permissionId);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByCreateDate
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findRolePermissionByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedBy
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedBy(String modifiedBy) throws DataAccessException {

		return findRolePermissionByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findRolePermissionByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findRolePermissionByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<RolePermission> findRolePermissionByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRolePermissionByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<RolePermission>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(RolePermission entity) {
		return true;
	}
}
