package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;

import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;
import com.osl.skygyft.um.domain.UserRole;

import com.osl.skygyft.um.service.UserService;

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
 * Spring Rest controller that handles CRUD requests for User entities
 * 
 */

@Controller("UserRestController")
public class UserRestController {

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
	 * DAO injected by Spring that manages UserPermission entities
	 * 
	 */
	@Autowired
	private UserPermissionDAO userPermissionDAO;

	/**
	 * DAO injected by Spring that manages UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for User entities
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userRoles", method = RequestMethod.PUT)
	@ResponseBody
	public UserRole saveUserUserRoles(@PathVariable Integer user_userId, @RequestBody UserRole userroles) {
		userService.saveUserUserRoles(user_userId, userroles);
		return userRoleDAO.findUserRoleByPrimaryKey(userroles.getUserId(), userroles.getRoleId());
	}

	/**
	 * Show all AuditTrial entities by User
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/auditTrials", method = RequestMethod.GET)
	@ResponseBody
	public List<AuditTrial> getUserAuditTrials(@PathVariable Integer user_userId) {
		return new java.util.ArrayList<AuditTrial>(userDAO.findUserByPrimaryKey(user_userId).getAuditTrials());
	}

	/**
	 * Show all UserRole entities by User
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userRoles", method = RequestMethod.GET)
	@ResponseBody
	public List<UserRole> getUserUserRoles(@PathVariable Integer user_userId) {
		return new java.util.ArrayList<UserRole>(userDAO.findUserByPrimaryKey(user_userId).getUserRoles());
	}

	/**
	 * View an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userPermissions/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public UserPermission loadUserUserPermissions(@PathVariable Integer user_userId, @PathVariable Integer related_userpermissions_userId, @PathVariable Integer related_userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId, -1, -1);

		return userpermission;
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userPermissions", method = RequestMethod.PUT)
	@ResponseBody
	public UserPermission saveUserUserPermissions(@PathVariable Integer user_userId, @RequestBody UserPermission userpermissions) {
		userService.saveUserUserPermissions(user_userId, userpermissions);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions.getUserId(), userpermissions.getPermissionId());
	}

	/**
	 * Show all UserPermission entities by User
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userPermissions", method = RequestMethod.GET)
	@ResponseBody
	public List<UserPermission> getUserUserPermissions(@PathVariable Integer user_userId) {
		return new java.util.ArrayList<UserPermission>(userDAO.findUserByPrimaryKey(user_userId).getUserPermissions());
	}

	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userPermissions", method = RequestMethod.POST)
	@ResponseBody
	public UserPermission newUserUserPermissions(@PathVariable Integer user_userId, @RequestBody UserPermission userpermission) {
		userService.saveUserUserPermissions(user_userId, userpermission);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission.getUserId(), userpermission.getPermissionId());
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userRoles", method = RequestMethod.POST)
	@ResponseBody
	public UserRole newUserUserRoles(@PathVariable Integer user_userId, @RequestBody UserRole userrole) {
		userService.saveUserUserRoles(user_userId, userrole);
		return userRoleDAO.findUserRoleByPrimaryKey(userrole.getUserId(), userrole.getRoleId());
	}

	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/auditTrials", method = RequestMethod.POST)
	@ResponseBody
	public AuditTrial newUserAuditTrials(@PathVariable Integer user_userId, @RequestBody AuditTrial audittrial) {
		userService.saveUserAuditTrials(user_userId, audittrial);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrial.getAuditId());
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping(value = "/User", method = RequestMethod.PUT)
	@ResponseBody
	public User saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId);
		userService.deleteUser(user);
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
	 * Show all User entities
	 * 
	 */
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listUsers() {
		return new java.util.ArrayList<User>(userService.loadUsers());
	}

	/**
	 * View an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/auditTrials/{audittrial_auditId}", method = RequestMethod.GET)
	@ResponseBody
	public AuditTrial loadUserAuditTrials(@PathVariable Integer user_userId, @PathVariable Integer related_audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId, -1, -1);

		return audittrial;
	}

	/**
	 * Select an existing User entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}", method = RequestMethod.GET)
	@ResponseBody
	public User loadUser(@PathVariable Integer user_userId) {
		return userDAO.findUserByPrimaryKey(user_userId);
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/auditTrials", method = RequestMethod.PUT)
	@ResponseBody
	public AuditTrial saveUserAuditTrials(@PathVariable Integer user_userId, @RequestBody AuditTrial audittrials) {
		userService.saveUserAuditTrials(user_userId, audittrials);
		return auditTrialDAO.findAuditTrialByPrimaryKey(audittrials.getAuditId());
	}

	/**
	 * View an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userRoles/{userrole_userId}/{userrole_roleId}", method = RequestMethod.GET)
	@ResponseBody
	public UserRole loadUserUserRoles(@PathVariable Integer user_userId, @PathVariable Integer related_userroles_userId, @PathVariable Integer related_userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId, -1, -1);

		return userrole;
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping(value = "/User", method = RequestMethod.POST)
	@ResponseBody
	public User newUser(@RequestBody User user) {
		userService.saveUser(user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userPermissions/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserUserPermissions(@PathVariable Integer user_userId, @PathVariable Integer related_userpermissions_userId, @PathVariable Integer related_userpermissions_permissionId) {
		userService.deleteUserUserPermissions(user_userId, related_userpermissions_userId, related_userpermissions_permissionId);
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/auditTrials/{audittrial_auditId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserAuditTrials(@PathVariable Integer user_userId, @PathVariable Integer related_audittrials_auditId) {
		userService.deleteUserAuditTrials(user_userId, related_audittrials_auditId);
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/User/{user_userId}/userRoles/{userrole_userId}/{userrole_roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserUserRoles(@PathVariable Integer user_userId, @PathVariable Integer related_userroles_userId, @PathVariable Integer related_userroles_roleId) {
		userService.deleteUserUserRoles(user_userId, related_userroles_userId, related_userroles_roleId);
	}
}