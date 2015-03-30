package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserRole;

import com.osl.skygyft.um.service.UserRoleService;

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
 * Spring Rest controller that handles CRUD requests for UserRole entities
 * 
 */

@Controller("UserRoleRestController")
public class UserRoleRestController {

	/**
	 * DAO injected by Spring that manages Role entities
	 * 
	 */
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * DAO injected by Spring that manages UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * Select an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}", method = RequestMethod.GET)
	@ResponseBody
	public UserRole loadUserRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId) {
		return userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId);
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId);
		userRoleService.deleteUserRole(userrole);
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/role/{role_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserRoleRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @PathVariable Integer related_role_id) {
		userRoleService.deleteUserRoleRole(userrole_userId, userrole_roleId, related_role_id);
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/role", method = RequestMethod.PUT)
	@ResponseBody
	public Role saveUserRoleRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @RequestBody Role role) {
		userRoleService.saveUserRoleRole(userrole_userId, userrole_roleId, role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * Show all UserRole entities
	 * 
	 */
	@RequestMapping(value = "/UserRole", method = RequestMethod.GET)
	@ResponseBody
	public List<UserRole> listUserRoles() {
		return new java.util.ArrayList<UserRole>(userRoleService.loadUserRoles());
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/UserRole", method = RequestMethod.PUT)
	@ResponseBody
	public UserRole saveUserRole(@RequestBody UserRole userrole) {
		userRoleService.saveUserRole(userrole);
		return userRoleDAO.findUserRoleByPrimaryKey(userrole.getUserId(), userrole.getRoleId());
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/user", method = RequestMethod.PUT)
	@ResponseBody
	public User saveUserRoleUser(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @RequestBody User user) {
		userRoleService.saveUserRoleUser(userrole_userId, userrole_roleId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * Get Role entity by UserRole
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/role", method = RequestMethod.GET)
	@ResponseBody
	public Role getUserRoleRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId) {
		return userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId).getRole();
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/user", method = RequestMethod.POST)
	@ResponseBody
	public User newUserRoleUser(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @RequestBody User user) {
		userRoleService.saveUserRoleUser(userrole_userId, userrole_roleId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * View an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/role/{role_id}", method = RequestMethod.GET)
	@ResponseBody
	public Role loadUserRoleRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @PathVariable Integer related_role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(related_role_id, -1, -1);

		return role;
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/role", method = RequestMethod.POST)
	@ResponseBody
	public Role newUserRoleRole(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @RequestBody Role role) {
		userRoleService.saveUserRoleRole(userrole_userId, userrole_roleId, role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/user/{user_userId}", method = RequestMethod.GET)
	@ResponseBody
	public User loadUserRoleUser(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @PathVariable Integer related_user_userId) {
		User user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		return user;
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
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/user/{user_userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserRoleUser(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId, @PathVariable Integer related_user_userId) {
		userRoleService.deleteUserRoleUser(userrole_userId, userrole_roleId, related_user_userId);
	}

	/**
	 * Get User entity by UserRole
	 * 
	 */
	@RequestMapping(value = "/UserRole/{userrole_userId}/{userrole_roleId}/user", method = RequestMethod.GET)
	@ResponseBody
	public User getUserRoleUser(@PathVariable Integer userrole_userId, @PathVariable Integer userrole_roleId) {
		return userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId).getUser();
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping(value = "/UserRole", method = RequestMethod.POST)
	@ResponseBody
	public UserRole newUserRole(@RequestBody UserRole userrole) {
		userRoleService.saveUserRole(userrole);
		return userRoleDAO.findUserRoleByPrimaryKey(userrole.getUserId(), userrole.getRoleId());
	}
}