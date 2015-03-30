package com.osl.skygyft.um.web;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;

import com.osl.skygyft.um.service.AuditActionService;

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
 * Spring MVC controller that handles CRUD requests for AuditAction entities
 * 
 */

@Controller("AuditActionController")
public class AuditActionController {

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
	 * Save an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/saveAuditAction")
	public String saveAuditAction(@ModelAttribute AuditAction auditaction) {
		auditActionService.saveAuditAction(auditaction);
		return "forward:/indexAuditAction";
	}

	/**
	 */
	@RequestMapping("/auditactionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/editAuditAction")
	public ModelAndView editAuditAction(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", auditActionDAO.findAuditActionByPrimaryKey(idKey));
		mav.setViewName("auditaction/editAuditAction.jsp");

		return mav;
	}

	/**
	 * Select the AuditAction entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuditAction")
	public ModelAndView confirmDeleteAuditAction(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", auditActionDAO.findAuditActionByPrimaryKey(idKey));
		mav.setViewName("auditaction/deleteAuditAction.jsp");

		return mav;
	}

	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	@RequestMapping("/newAuditActionAuditTrials")
	public ModelAndView newAuditActionAuditTrials(@RequestParam Integer auditaction_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("auditaction_id", auditaction_id);
		mav.addObject("audittrial", new AuditTrial());
		mav.addObject("newFlag", true);
		mav.setViewName("auditaction/audittrials/editAuditTrials.jsp");

		return mav;
	}

	/**
	 * Show all AuditAction entities
	 * 
	 */
	@RequestMapping("/indexAuditAction")
	public ModelAndView listAuditActions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditactions", auditActionService.loadAuditActions());

		mav.setViewName("auditaction/listAuditActions.jsp");

		return mav;
	}

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/deleteAuditAction")
	public String deleteAuditAction(@RequestParam Integer idKey) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(idKey);
		auditActionService.deleteAuditAction(auditaction);
		return "forward:/indexAuditAction";
	}

	/**
	 * View an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/selectAuditActionAuditTrials")
	public ModelAndView selectAuditActionAuditTrials(@RequestParam Integer auditaction_id, @RequestParam Integer audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrials_auditId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("auditaction_id", auditaction_id);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("auditaction/audittrials/viewAuditTrials.jsp");

		return mav;
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/deleteAuditActionAuditTrials")
	public ModelAndView deleteAuditActionAuditTrials(@RequestParam Integer auditaction_id, @RequestParam Integer related_audittrials_auditId) {
		ModelAndView mav = new ModelAndView();

		AuditAction auditaction = auditActionService.deleteAuditActionAuditTrials(auditaction_id, related_audittrials_auditId);

		mav.addObject("auditaction_id", auditaction_id);
		mav.addObject("auditaction", auditaction);
		mav.setViewName("auditaction/viewAuditAction.jsp");

		return mav;
	}

	/**
	 * Select the child AuditTrial entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuditActionAuditTrials")
	public ModelAndView confirmDeleteAuditActionAuditTrials(@RequestParam Integer auditaction_id, @RequestParam Integer related_audittrials_auditId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId));
		mav.addObject("auditaction_id", auditaction_id);
		mav.setViewName("auditaction/audittrials/deleteAuditTrials.jsp");

		return mav;
	}

	/**
	 * Entry point to show all AuditAction entities
	 * 
	 */
	public String indexAuditAction() {
		return "redirect:/indexAuditAction";
	}

	/**
	 * Edit an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/editAuditActionAuditTrials")
	public ModelAndView editAuditActionAuditTrials(@RequestParam Integer auditaction_id, @RequestParam Integer audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrials_auditId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("auditaction_id", auditaction_id);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("auditaction/audittrials/editAuditTrials.jsp");

		return mav;
	}

	/**
	 * Show all AuditTrial entities by AuditAction
	 * 
	 */
	@RequestMapping("/listAuditActionAuditTrials")
	public ModelAndView listAuditActionAuditTrials(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", auditActionDAO.findAuditActionByPrimaryKey(idKey));
		mav.setViewName("auditaction/audittrials/listAuditTrials.jsp");

		return mav;
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/saveAuditActionAuditTrials")
	public ModelAndView saveAuditActionAuditTrials(@RequestParam Integer auditaction_id, @ModelAttribute AuditTrial audittrials) {
		AuditAction parent_auditaction = auditActionService.saveAuditActionAuditTrials(auditaction_id, audittrials);

		ModelAndView mav = new ModelAndView();
		mav.addObject("auditaction_id", auditaction_id);
		mav.addObject("auditaction", parent_auditaction);
		mav.setViewName("auditaction/viewAuditAction.jsp");

		return mav;
	}

	/**
	 * Select an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/selectAuditAction")
	public ModelAndView selectAuditAction(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", auditActionDAO.findAuditActionByPrimaryKey(idKey));
		mav.setViewName("auditaction/viewAuditAction.jsp");

		return mav;
	}

	/**
	 * Create a new AuditAction entity
	 * 
	 */
	@RequestMapping("/newAuditAction")
	public ModelAndView newAuditAction() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", new AuditAction());
		mav.addObject("newFlag", true);
		mav.setViewName("auditaction/editAuditAction.jsp");

		return mav;
	}
}