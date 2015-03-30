package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.UmParameterDAO;

import com.osl.skygyft.um.domain.UmParameter;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for UmParameter entities
 * 
 */

@Service("UmParameterService")
@Transactional
public class UmParameterServiceImpl implements UmParameterService {

	/**
	 * DAO injected by Spring that manages UmParameter entities
	 * 
	 */
	@Autowired
	private UmParameterDAO umParameterDAO;

	/**
	 * Instantiates a new UmParameterServiceImpl.
	 *
	 */
	public UmParameterServiceImpl() {
	}

	/**
	 * Return a count of all UmParameter entity
	 * 
	 */
	@Transactional
	public Integer countUmParameters() {
		return ((Long) umParameterDAO.createQuerySingleResult("select count(o) from UmParameter o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing UmParameter entity
	 * 
	 */
	@Transactional
	public Set<UmParameter> loadUmParameters() {
		return umParameterDAO.findAllUmParameters();
	}

	/**
	 */
	@Transactional
	public UmParameter findUmParameterByPrimaryKey(Integer id) {
		return umParameterDAO.findUmParameterByPrimaryKey(id);
	}

	/**
	 * Save an existing UmParameter entity
	 * 
	 */
	@Transactional
	public void saveUmParameter(UmParameter umparameter) {
		UmParameter existingUmParameter = umParameterDAO.findUmParameterByPrimaryKey(umparameter.getId());

		if (existingUmParameter != null) {
			if (existingUmParameter != umparameter) {
				existingUmParameter.setId(umparameter.getId());
				existingUmParameter.setParamKey(umparameter.getParamKey());
				existingUmParameter.setParamName(umparameter.getParamName());
				existingUmParameter.setParamValue(umparameter.getParamValue());
				existingUmParameter.setParamType(umparameter.getParamType());
				existingUmParameter.setCreateDate(umparameter.getCreateDate());
				existingUmParameter.setModifiedDate(umparameter.getModifiedDate());
				existingUmParameter.setCreateBy(umparameter.getCreateBy());
				existingUmParameter.setModifiedBy(umparameter.getModifiedBy());
			}
			umparameter = umParameterDAO.store(existingUmParameter);
		} else {
			umparameter = umParameterDAO.store(umparameter);
		}
		umParameterDAO.flush();
	}

	/**
	 * Return all UmParameter entity
	 * 
	 */
	@Transactional
	public List<UmParameter> findAllUmParameters(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<UmParameter>(umParameterDAO.findAllUmParameters(startResult, maxRows));
	}

	/**
	 * Delete an existing UmParameter entity
	 * 
	 */
	@Transactional
	public void deleteUmParameter(UmParameter umparameter) {
		umParameterDAO.remove(umparameter);
		umParameterDAO.flush();
	}
}
