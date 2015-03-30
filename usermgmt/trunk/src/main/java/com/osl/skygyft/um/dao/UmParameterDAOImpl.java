package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UmParameter;

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
 * DAO to manage UmParameter entities.
 * 
 */
@Repository("UmParameterDAO")
@Transactional
public class UmParameterDAOImpl extends AbstractJpaDao<UmParameter> implements
		UmParameterDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { UmParameter.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UmParameterDAOImpl
	 *
	 */
	public UmParameterDAOImpl() {
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
	 * JPQL Query - findUmParameterByParamValueContaining
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamValueContaining(String paramValue) throws DataAccessException {

		return findUmParameterByParamValueContaining(paramValue, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamValueContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamValueContaining(String paramValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamValueContaining", startResult, maxRows, paramValue);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByParamValue
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamValue(String paramValue) throws DataAccessException {

		return findUmParameterByParamValue(paramValue, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamValue
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamValue(String paramValue, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamValue", startResult, maxRows, paramValue);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByParamKeyContaining
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamKeyContaining(String paramKey) throws DataAccessException {

		return findUmParameterByParamKeyContaining(paramKey, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamKeyContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamKeyContaining(String paramKey, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamKeyContaining", startResult, maxRows, paramKey);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findUmParameterByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByPrimaryKey
	 *
	 */
	@Transactional
	public UmParameter findUmParameterByPrimaryKey(Integer id) throws DataAccessException {

		return findUmParameterByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByPrimaryKey
	 *
	 */

	@Transactional
	public UmParameter findUmParameterByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUmParameterByPrimaryKey", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.UmParameter) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUmParameterByModifiedBy
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedBy(String modifiedBy) throws DataAccessException {

		return findUmParameterByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByModifiedDate
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findUmParameterByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByParamName
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamName(String paramName) throws DataAccessException {

		return findUmParameterByParamName(paramName, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamName(String paramName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamName", startResult, maxRows, paramName);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByParamType
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamType(Integer paramType) throws DataAccessException {

		return findUmParameterByParamType(paramType, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamType(Integer paramType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamType", startResult, maxRows, paramType);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByParamNameContaining
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamNameContaining(String paramName) throws DataAccessException {

		return findUmParameterByParamNameContaining(paramName, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamNameContaining(String paramName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamNameContaining", startResult, maxRows, paramName);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterById
	 *
	 */
	@Transactional
	public UmParameter findUmParameterById(Integer id) throws DataAccessException {

		return findUmParameterById(id, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterById
	 *
	 */

	@Transactional
	public UmParameter findUmParameterById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUmParameterById", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.UmParameter) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUmParameterByParamKey
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByParamKey(String paramKey) throws DataAccessException {

		return findUmParameterByParamKey(paramKey, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByParamKey
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByParamKey(String paramKey, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByParamKey", startResult, maxRows, paramKey);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUmParameters
	 *
	 */
	@Transactional
	public Set<UmParameter> findAllUmParameters() throws DataAccessException {

		return findAllUmParameters(-1, -1);
	}

	/**
	 * JPQL Query - findAllUmParameters
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findAllUmParameters(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUmParameters", startResult, maxRows);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByCreateBy
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByCreateBy(String createBy) throws DataAccessException {

		return findUmParameterByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByCreateDate
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findUmParameterByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * JPQL Query - findUmParameterByCreateByContaining
	 *
	 */
	@Transactional
	public Set<UmParameter> findUmParameterByCreateByContaining(String createBy) throws DataAccessException {

		return findUmParameterByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUmParameterByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<UmParameter> findUmParameterByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUmParameterByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<UmParameter>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(UmParameter entity) {
		return true;
	}
}
