package com.osl.skygyft.um.web;

import com.osl.skygyft.um.dao.UmParameterDAO;

import com.osl.skygyft.um.domain.UmParameter;

import com.osl.skygyft.um.service.UmParameterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for UmParameter entities
 * 
 */

@Controller("UmParameterController")
public class UmParameterController {

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
	 * Select an existing UmParameter entity
	 * 
	 */
	@RequestMapping("/selectUmParameter")
	public ModelAndView selectUmParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("umparameter", umParameterDAO.findUmParameterByPrimaryKey(idKey));
		mav.setViewName("umparameter/viewUmParameter.jsp");

		return mav;
	}

	/**
	 * Show all UmParameter entities
	 * 
	 */
	@RequestMapping("/indexUmParameter")
	public ModelAndView listUmParameters() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("umparameters", umParameterService.loadUmParameters());

		mav.setViewName("umparameter/listUmParameters.jsp");

		return mav;
	}

	/**
	 * Save an existing UmParameter entity
	 * 
	 */
	@RequestMapping("/saveUmParameter")
	public String saveUmParameter(@ModelAttribute UmParameter umparameter) {
		umParameterService.saveUmParameter(umparameter);
		return "forward:/indexUmParameter";
	}

	/**
	 * Select the UmParameter entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUmParameter")
	public ModelAndView confirmDeleteUmParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("umparameter", umParameterDAO.findUmParameterByPrimaryKey(idKey));
		mav.setViewName("umparameter/deleteUmParameter.jsp");

		return mav;
	}

	/**
	 * Create a new UmParameter entity
	 * 
	 */
	@RequestMapping("/newUmParameter")
	public ModelAndView newUmParameter() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("umparameter", new UmParameter());
		mav.addObject("newFlag", true);
		mav.setViewName("umparameter/editUmParameter.jsp");

		return mav;
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
	 * Delete an existing UmParameter entity
	 * 
	 */
	@RequestMapping("/deleteUmParameter")
	public String deleteUmParameter(@RequestParam Integer idKey) {
		UmParameter umparameter = umParameterDAO.findUmParameterByPrimaryKey(idKey);
		umParameterService.deleteUmParameter(umparameter);
		return "forward:/indexUmParameter";
	}

	/**
	 * Edit an existing UmParameter entity
	 * 
	 */
	@RequestMapping("/editUmParameter")
	public ModelAndView editUmParameter(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("umparameter", umParameterDAO.findUmParameterByPrimaryKey(idKey));
		mav.setViewName("umparameter/editUmParameter.jsp");

		return mav;
	}

	/**
	 * Entry point to show all UmParameter entities
	 * 
	 */
	public String indexUmParameter() {
		return "redirect:/indexUmParameter";
	}

	/**
	 */
	@RequestMapping("/umparameterController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
}