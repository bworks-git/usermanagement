package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;

import com.osl.skygyft.um.service.AuditActionService;

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
 * Spring Rest controller that handles CRUD requests for AuditAction entities
 * 
 */

@Controller("AuditActionRestController")
public class AuditActionRestController {

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
	 * Service injected by Spring that provides CRUD operations for AuditAction entities
	 * 
	 */
	@Autowired
	private AuditActionService auditActionService;

	/**
	 * Show all AuditTrial entities by AuditAction
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}/auditTrials", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditTrial> getAuditActionAuditTrials(@PathVariable Integer auditaction_id) {
		return new java.util.ArrayList<AuditTrial>(auditActionDAO.findAuditActionByPrimaryKey(auditaction_id).getAuditTrials());
	}

	/**
	 * Create a new AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction", method = RequestMethod.POST)
	@ResponseBody
	public AuditAction newAuditAction(@RequestBody AuditAction auditaction) {
		auditActionService.saveAuditAction(auditaction);
		return auditActionDAO.findAuditActionByPrimaryKey(auditaction.getId());
	}

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAuditAction(@PathVariable Integer auditaction_id) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(auditaction_id);
		auditActionService.deleteAuditAction(auditaction);
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}/auditTrials", method = RequestMethod.PUT)
	@ResponseBody
	public AuditTrial saveAuditActionAuditTrials(@PathVariable Integer auditaction_id, @RequestBody AuditTrial audittrials) {
		auditActionService.saveAuditActionAuditTrials(auditaction_id, audittrials);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrials.getAuditId());
	}

	/**
	 * Show all AuditAction entities
	 * 
	 */
	@RequestMapping(value = "/AuditAction", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditAction> listAuditActions() {
		return new java.util.ArrayList<AuditAction>(auditActionService.loadAuditActions());
	}

	/**
	 * Select an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}", method = RequestMethod.GET)
	@ResponseBody
	public AuditAction loadAuditAction(@PathVariable Integer auditaction_id) {
		return auditActionDAO.findAuditActionByPrimaryKey(auditaction_id);
	}

	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}/auditTrials", method = RequestMethod.POST)
	@ResponseBody
	public AuditTrial newAuditActionAuditTrials(@PathVariable Integer auditaction_id, @RequestBody AuditTrial audittrial) {
		auditActionService.saveAuditActionAuditTrials(auditaction_id, audittrial);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial.getAuditId());
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
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}/auditTrials/{audittrial_auditId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteAuditActionAuditTrials(@PathVariable Integer auditaction_id, @PathVariable Integer related_audittrials_auditId) {
		auditActionService.deleteAuditActionAuditTrials(auditaction_id, related_audittrials_auditId);
	}

	/**
	 * View an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction/{auditaction_id}/auditTrials/{audittrial_auditId}", method = RequestMethod.GET)
	@ResponseBody
	public AuditTrial loadAuditActionAuditTrials(@PathVariable Integer auditaction_id, @PathVariable Integer related_audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId, -1, -1);

		return audittrial;
	}

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	@RequestMapping(value = "/AuditAction", method = RequestMethod.PUT)
	@ResponseBody
	public AuditAction saveAuditAction(@RequestBody AuditAction auditaction) {
		auditActionService.saveAuditAction(auditaction);
		return auditActionDAO.findAuditActionByPrimaryKey(auditaction.getId());
	}
}