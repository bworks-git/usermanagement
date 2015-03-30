package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.UmParameter;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage UmParameter entities.
 * 
 */
public interface UmParameterDAO extends JpaDao<UmParameter> {

	/**
	 * JPQL Query - findUmParameterByParamValueContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamValueContaining(String paramValue) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamValueContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamValueContaining(String paramValue, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamValue
	 *
	 */
	public Set<UmParameter> findUmParameterByParamValue(String paramValue_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamValue
	 *
	 */
	public Set<UmParameter> findUmParameterByParamValue(String paramValue_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamKeyContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamKeyContaining(String paramKey) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamKeyContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamKeyContaining(String paramKey, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedByContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedByContaining(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedByContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByPrimaryKey
	 *
	 */
	public UmParameter findUmParameterByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByPrimaryKey
	 *
	 */
	public UmParameter findUmParameterByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedBy
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedBy(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedBy
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedBy(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedDate
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByModifiedDate
	 *
	 */
	public Set<UmParameter> findUmParameterByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamName
	 *
	 */
	public Set<UmParameter> findUmParameterByParamName(String paramName) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamName
	 *
	 */
	public Set<UmParameter> findUmParameterByParamName(String paramName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamType
	 *
	 */
	public Set<UmParameter> findUmParameterByParamType(Integer paramType) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamType
	 *
	 */
	public Set<UmParameter> findUmParameterByParamType(Integer paramType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamNameContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamNameContaining(String paramName_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamNameContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByParamNameContaining(String paramName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterById
	 *
	 */
	public UmParameter findUmParameterById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterById
	 *
	 */
	public UmParameter findUmParameterById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamKey
	 *
	 */
	public Set<UmParameter> findUmParameterByParamKey(String paramKey_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByParamKey
	 *
	 */
	public Set<UmParameter> findUmParameterByParamKey(String paramKey_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUmParameters
	 *
	 */
	public Set<UmParameter> findAllUmParameters() throws DataAccessException;

	/**
	 * JPQL Query - findAllUmParameters
	 *
	 */
	public Set<UmParameter> findAllUmParameters(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateBy
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateBy(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateBy
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateDate
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateDate
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateByContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateByContaining(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUmParameterByCreateByContaining
	 *
	 */
	public Set<UmParameter> findUmParameterByCreateByContaining(String createBy_1, int startResult, int maxRows) throws DataAccessException;

}