package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.UmParameterDAO;

import com.osl.skygyft.um.domain.UmParameter;

import com.osl.skygyft.um.service.UmParameterService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring Rest controller that handles CRUD requests for UmParameter entities
 * 
 */

@Controller("UmParameterRestController")
public class UmParameterRestController {

	/**
	 * DAO injected by Spring that manages UmParameter entities
	 * 
	 */
	@Autowired
	private UmParameterDAO umParameterDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for UmParameter entities
	 * 
	 */
	@Autowired
	private UmParameterService umParameterService;

	/**
	 * Create a new UmParameter entity
	 * 
	 */
	@RequestMapping(value = "/UmParameter", method = RequestMethod.POST)
	@ResponseBody
	public UmParameter newUmParameter(@RequestBody UmParameter umparameter) {
		umParameterService.saveUmParameter(umparameter);
		return umParameterDAO.findUmParameterByPrimaryKey(umparameter.getId());
	}

	/**
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 * Save an existing UmParameter entity
	 * 
	 */
	@RequestMapping(value = "/UmParameter", method = RequestMethod.PUT)
	@ResponseBody
	public UmParameter saveUmParameter(@RequestBody UmParameter umparameter) {
		umParameterService.saveUmParameter(umparameter);
		return umParameterDAO.findUmParameterByPrimaryKey(umparameter.getId());
	}

	/**
	 * Delete an existing UmParameter entity
	 * 
	 */
	@RequestMapping(value = "/UmParameter/{umparameter_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUmParameter(@PathVariable Integer umparameter_id) {
		UmParameter umparameter = umParameterDAO.findUmParameterByPrimaryKey(umparameter_id);
		umParameterService.deleteUmParameter(umparameter);
	}

	/**
	 * Select an existing UmParameter entity
	 * 
	 */
	@RequestMapping(value = "/UmParameter/{umparameter_id}", method = RequestMethod.GET)
	@ResponseBody
	public UmParameter loadUmParameter(@PathVariable Integer umparameter_id) {
		return umParameterDAO.findUmParameterByPrimaryKey(umparameter_id);
	}

	/**
	 * Show all UmParameter entities
	 * 
	 */
	@RequestMapping(value = "/UmParameter", method = RequestMethod.GET)
	@ResponseBody
	public List<UmParameter> listUmParameters() {
		return new java.util.ArrayList<UmParameter>(umParameterService.loadUmParameters());
	}
}