package com.osl.skygyft.um.web;

import java.util.List;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.service.AuditTrialService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for AuditTrial entities
 * 
 */

@Controller("AuditTrialController")
public class AuditTrialController {

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
	 * Show all User entities by AuditTrial
	 * 
	 */
	@RequestMapping("/auditTrial")
	public String auditTrials(ModelMap map) {
		List<AuditTrial> trails = auditTrialService.findAllAuditTrials(-1,-1);
		map.put("trails", trails);
		return "audit-trails";
	}

	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editAuditTrialUser")
	public ModelAndView editAuditTrialUser(@RequestParam Integer audittrial_auditId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("user", user);
		mav.setViewName("audittrial/user/editUser.jsp");

		return mav;
	}

	/**
	 * Select the child AuditAction entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuditTrialAuditAction")
	public ModelAndView confirmDeleteAuditTrialAuditAction(@RequestParam Integer audittrial_auditId, @RequestParam Integer related_auditaction_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("auditaction", auditActionDAO.findAuditActionByPrimaryKey(related_auditaction_id));
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.setViewName("audittrial/auditaction/deleteAuditAction.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newAuditTrialUser")
	public ModelAndView newAuditTrialUser(@RequestParam Integer audittrial_auditId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("audittrial/user/editUser.jsp");

		return mav;
	}

	/**
	 * Entry point to show all AuditTrial entities
	 * 
	 */
	public String indexAuditTrial() {
		return "redirect:/indexAuditTrial";
	}

	/**
	 * View an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/selectAuditTrialAuditAction")
	public ModelAndView selectAuditTrialAuditAction(@RequestParam Integer audittrial_auditId, @RequestParam Integer auditaction_id) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(auditaction_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("auditaction", auditaction);
		mav.setViewName("audittrial/auditaction/viewAuditAction.jsp");

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
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping("/deleteAuditTrialUser")
	public ModelAndView deleteAuditTrialUser(@RequestParam Integer audittrial_auditId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		AuditTrial audittrial = auditTrialService.deleteAuditTrialUser(audittrial_auditId, related_user_userId);

		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("audittrial/viewAuditTrial.jsp");

		return mav;
	}

	/**
	 * Select the AuditTrial entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuditTrial")
	public ModelAndView confirmDeleteAuditTrial(@RequestParam Integer auditIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(auditIdKey));
		mav.setViewName("audittrial/deleteAuditTrial.jsp");

		return mav;
	}

	/**
	 * Show all AuditTrial entities
	 * 
	 */
	@RequestMapping("/indexAuditTrial")
	public ModelAndView listAuditTrials() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrials", auditTrialService.loadAuditTrials());

		mav.setViewName("audittrial/listAuditTrials.jsp");

		return mav;
	}

	/**
	 * Create a new AuditAction entity
	 * 
	 */
	@RequestMapping("/newAuditTrialAuditAction")
	public ModelAndView newAuditTrialAuditAction(@RequestParam Integer audittrial_auditId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("auditaction", new AuditAction());
		mav.addObject("newFlag", true);
		mav.setViewName("audittrial/auditaction/editAuditAction.jsp");

		return mav;
	}

	/**
	 * Edit an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/editAuditTrial")
	public ModelAndView editAuditTrial(@RequestParam Integer auditIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(auditIdKey));
		mav.setViewName("audittrial/editAuditTrial.jsp");

		return mav;
	}

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/deleteAuditTrialAuditAction")
	public ModelAndView deleteAuditTrialAuditAction(@RequestParam Integer audittrial_auditId, @RequestParam Integer related_auditaction_id) {
		ModelAndView mav = new ModelAndView();

		AuditTrial audittrial = auditTrialService.deleteAuditTrialAuditAction(audittrial_auditId, related_auditaction_id);

		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("audittrial/viewAuditTrial.jsp");

		return mav;
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/saveAuditTrial")
	public String saveAuditTrial(@ModelAttribute AuditTrial audittrial) {
		auditTrialService.saveAuditTrial(audittrial);
		return "forward:/indexAuditTrial";
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveAuditTrialUser")
	public ModelAndView saveAuditTrialUser(@RequestParam Integer audittrial_auditId, @ModelAttribute User user) {
		AuditTrial parent_audittrial = auditTrialService.saveAuditTrialUser(audittrial_auditId, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("audittrial", parent_audittrial);
		mav.setViewName("audittrial/viewAuditTrial.jsp");

		return mav;
	}

	/**
	 * Edit an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/editAuditTrialAuditAction")
	public ModelAndView editAuditTrialAuditAction(@RequestParam Integer audittrial_auditId, @RequestParam Integer auditaction_id) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(auditaction_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("auditaction", auditaction);
		mav.setViewName("audittrial/auditaction/editAuditAction.jsp");

		return mav;
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/deleteAuditTrial")
	public String deleteAuditTrial(@RequestParam Integer auditIdKey) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(auditIdKey);
		auditTrialService.deleteAuditTrial(audittrial);
		return "forward:/indexAuditTrial";
	}

	/**
	 */
	@RequestMapping("/audittrialController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	@RequestMapping("/saveAuditTrialAuditAction")
	public ModelAndView saveAuditTrialAuditAction(@RequestParam Integer audittrial_auditId, @ModelAttribute AuditAction auditaction) {
		AuditTrial parent_audittrial = auditTrialService.saveAuditTrialAuditAction(audittrial_auditId, auditaction);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("audittrial", parent_audittrial);
		mav.setViewName("audittrial/viewAuditTrial.jsp");

		return mav;
	}

	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	@RequestMapping("/newAuditTrial")
	public ModelAndView newAuditTrial() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", new AuditTrial());
		mav.addObject("newFlag", true);
		mav.setViewName("audittrial/editAuditTrial.jsp");

		return mav;
	}

	/**
	 * Show all AuditAction entities by AuditTrial
	 * 
	 */
	@RequestMapping("/listAuditTrialAuditAction")
	public ModelAndView listAuditTrialAuditAction(@RequestParam Integer auditIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(auditIdKey));
		mav.setViewName("audittrial/auditaction/listAuditAction.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping("/selectAuditTrialUser")
	public ModelAndView selectAuditTrialUser(@RequestParam Integer audittrial_auditId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.addObject("user", user);
		mav.setViewName("audittrial/user/viewUser.jsp");

		return mav;
	}

	/**
	 * Select an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/selectAuditTrial")
	public ModelAndView selectAuditTrial(@RequestParam Integer auditIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(auditIdKey));
		mav.setViewName("audittrial/viewAuditTrial.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAuditTrialUser")
	public ModelAndView confirmDeleteAuditTrialUser(@RequestParam Integer audittrial_auditId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_userId));
		mav.addObject("audittrial_auditId", audittrial_auditId);
		mav.setViewName("audittrial/user/deleteUser.jsp");

		return mav;
	}
}