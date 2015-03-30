package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;

import com.osl.skygyft.um.service.UserPermissionService;

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
 * Spring Rest controller that handles CRUD requests for UserPermission entities
 * 
 */

@Controller("UserPermissionRestController")
public class UserPermissionRestController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

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
	 * Service injected by Spring that provides CRUD operations for UserPermission entities
	 * 
	 */
	@Autowired
	private UserPermissionService userPermissionService;

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/user", method = RequestMethod.PUT)
	@ResponseBody
	public User saveUserPermissionUser(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @RequestBody User user) {
		userPermissionService.saveUserPermissionUser(userpermission_userId, userpermission_permissionId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/permission", method = RequestMethod.PUT)
	@ResponseBody
	public Permission saveUserPermissionPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @RequestBody Permission permission) {
		userPermissionService.saveUserPermissionPermission(userpermission_userId, userpermission_permissionId, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/permission/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserPermissionPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @PathVariable Integer related_permission_id) {
		userPermissionService.deleteUserPermissionPermission(userpermission_userId, userpermission_permissionId, related_permission_id);
	}

	/**
	 * Show all UserPermission entities
	 * 
	 */
	@RequestMapping(value = "/UserPermission", method = RequestMethod.GET)
	@ResponseBody
	public List<UserPermission> listUserPermissions() {
		return new java.util.ArrayList<UserPermission>(userPermissionService.loadUserPermissions());
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission", method = RequestMethod.PUT)
	@ResponseBody
	public UserPermission saveUserPermission(@RequestBody UserPermission userpermission) {
		userPermissionService.saveUserPermission(userpermission);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission.getUserId(), userpermission.getPermissionId());
	}

	/**
	 * Select an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public UserPermission loadUserPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId) {
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId);
	}

	/**
	 * Get User entity by UserPermission
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/user", method = RequestMethod.GET)
	@ResponseBody
	public User getUserPermissionUser(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId) {
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId).getUser();
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/permission/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadUserPermissionPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @PathVariable Integer related_permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		return permission;
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/user/{user_userId}", method = RequestMethod.GET)
	@ResponseBody
	public User loadUserPermissionUser(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @PathVariable Integer related_user_userId) {
		User user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		return user;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/user/{user_userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserPermissionUser(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @PathVariable Integer related_user_userId) {
		userPermissionService.deleteUserPermissionUser(userpermission_userId, userpermission_permissionId, related_user_userId);
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
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/permission", method = RequestMethod.POST)
	@ResponseBody
	public Permission newUserPermissionPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @RequestBody Permission permission) {
		userPermissionService.saveUserPermissionPermission(userpermission_userId, userpermission_permissionId, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/user", method = RequestMethod.POST)
	@ResponseBody
	public User newUserPermissionUser(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId, @RequestBody User user) {
		userPermissionService.saveUserPermissionUser(userpermission_userId, userpermission_permissionId, user);
		return userDAO.findUserByPrimaryKey(user.getUserId());
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUserPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId);
		userPermissionService.deleteUserPermission(userpermission);
	}

	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/UserPermission", method = RequestMethod.POST)
	@ResponseBody
	public UserPermission newUserPermission(@RequestBody UserPermission userpermission) {
		userPermissionService.saveUserPermission(userpermission);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission.getUserId(), userpermission.getPermissionId());
	}

	/**
	 * Get Permission entity by UserPermission
	 * 
	 */
	@RequestMapping(value = "/UserPermission/{userpermission_userId}/{userpermission_permissionId}/permission", method = RequestMethod.GET)
	@ResponseBody
	public Permission getUserPermissionPermission(@PathVariable Integer userpermission_userId, @PathVariable Integer userpermission_permissionId) {
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId).getPermission();
	}
}