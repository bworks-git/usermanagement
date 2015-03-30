package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;

import com.osl.skygyft.um.service.AuditTrialService;

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
 * Spring Rest controller that handles CRUD requests for AuditTrial entities
 * 
 */

@Controller("AuditTrialRestController")
public class AuditTrialRestController {

	/**
	 * DAO injected by Spring that manages AuditAction entities
	 * 
	 */
	@Autowired
	private AuditActionDAO auditActionDAO;

	/**
	 * DAO injected by Spring that manages AuditTrial entities
	 * 
	 */
	@Autowired
	private AuditTrialDAO auditTrialDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for AuditTrial entities
	 * 
	 */
	@Autowired
	private AuditTrialService auditTrialService;

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/auditAction/{auditaction_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAuditTrialAuditAction(@PathVariable Integer audittrial_auditId, @PathVariable Integer related_auditaction_id) {
		auditTrialService.deleteAuditTrialAuditAction(audittrial_auditId, related_auditaction_id);
	}

	/**
	 * Show all AuditTrial entities
	 * 
	 */
	@RequestMapping(value = "/AuditTrial", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditTrial> listAuditTrials() {
		return new java.util.ArrayList<AuditTrial>(auditTrialService.loadAuditTrials());
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/user", method = RequestMethod.PUT)
	@ResponseBody
	public User saveAuditTrialUser(@PathVariable Integer audittrial_auditId, @RequestBody User user) {
		auditTrialService.saveAuditTrialUser(audittrial_auditId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/user/{user_userId}", method = RequestMethod.GET)
	@ResponseBody
	public User loadAuditTrialUser(@PathVariable Integer audittrial_auditId, @PathVariable Integer related_user_userId) {
		User user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		return user;
	}

	/**
	 * Get User entity by AuditTrial
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/user", method = RequestMethod.GET)
	@ResponseBody
	public User getAuditTrialUser(@PathVariable Integer audittrial_auditId) {
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId).getUser();
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/user/{user_userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAuditTrialUser(@PathVariable Integer audittrial_auditId, @PathVariable Integer related_user_userId) {
		auditTrialService.deleteAuditTrialUser(audittrial_auditId, related_user_userId);
	}

	/**
	 * Get AuditAction entity by AuditTrial
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/auditAction", method = RequestMethod.GET)
	@ResponseBody
	public AuditAction getAuditTrialAuditAction(@PathVariable Integer audittrial_auditId) {
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId).getAuditAction();
	}

	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial", method = RequestMethod.POST)
	@ResponseBody
	public AuditTrial newAuditTrial(@RequestBody AuditTrial audittrial) {
		auditTrialService.saveAuditTrial(audittrial);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial.getAuditId());
	}

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/auditAction", method = RequestMethod.PUT)
	@ResponseBody
	public AuditAction saveAuditTrialAuditAction(@PathVariable Integer audittrial_auditId, @RequestBody AuditAction auditaction) {
		auditTrialService.saveAuditTrialAuditAction(audittrial_auditId, auditaction);
		return auditActionDAO.findAuditActionByPrimaryKey(auditaction.getId());
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/user", method = RequestMethod.POST)
	@ResponseBody
	public User newAuditTrialUser(@PathVariable Integer audittrial_auditId, @RequestBody User user) {
		auditTrialService.saveAuditTrialUser(audittrial_auditId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
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
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial", method = RequestMethod.PUT)
	@ResponseBody
	public AuditTrial saveAuditTrial(@RequestBody AuditTrial audittrial) {
		auditTrialService.saveAuditTrial(audittrial);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial.getAuditId());
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAuditTrial(@PathVariable Integer audittrial_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId);
		auditTrialService.deleteAuditTrial(audittrial);
	}

	/**
	 * Create a new AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/auditAction", method = RequestMethod.POST)
	@ResponseBody
	public AuditAction newAuditTrialAuditAction(@PathVariable Integer audittrial_auditId, @RequestBody AuditAction auditaction) {
		auditTrialService.saveAuditTrialAuditAction(audittrial_auditId, auditaction);
		return auditActionDAO.findAuditActionByPrimaryKey(auditaction.getId());
	}

	/**
	 * Select an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}", method = RequestMethod.GET)
	@ResponseBody
	public AuditTrial loadAuditTrial(@PathVariable Integer audittrial_auditId) {
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId);
	}

	/**
	 * View an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditTrial/{audittrial_auditId}/auditAction/{auditaction_id}", method = RequestMethod.GET)
	@ResponseBody
	public AuditAction loadAuditTrialAuditAction(@PathVariable Integer audittrial_auditId, @PathVariable Integer related_auditaction_id) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(related_auditaction_id, -1, -1);

		return auditaction;
	}
}