package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.UmParameter;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for UmParameter entities
 * 
 */
public interface UmParameterService {

	/**
	 * Return a count of all UmParameter entity
	 * 
	 */
	public Integer countUmParameters();

	/**
	 * Load an existing UmParameter entity
	 * 
	 */
	public Set<UmParameter> loadUmParameters();

	/**
	 */
	public UmParameter findUmParameterByPrimaryKey(Integer id);

	/**
	 * Save an existing UmParameter entity
	 * 
	 */
	public void saveUmParameter(UmParameter umparameter);

	/**
	 * Return all UmParameter entity
	 * 
	 */
	public List<UmParameter> findAllUmParameters(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing UmParameter entity
	 * 
	 */
	public void deleteUmParameter(UmParameter umparameter_1);
}