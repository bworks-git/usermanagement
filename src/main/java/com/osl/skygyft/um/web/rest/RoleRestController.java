package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserRole;

import com.osl.skygyft.um.service.RoleService;

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
 * Spring Rest controller that handles CRUD requests for Role entities
 * 
 */

@Controller("RoleRestController")
public class RoleRestController {

	/**
	 * DAO injected by Spring that manages Role entities
	 * 
	 */
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * DAO injected by Spring that manages RolePermission entities
	 * 
	 */
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	/**
	 * DAO injected by Spring that manages UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Role entities
	 * 
	 */
	@Autowired
	private RoleService roleService;

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/rolePermissions", method = RequestMethod.PUT)
	@ResponseBody
	public RolePermission saveRoleRolePermissions(@PathVariable Integer role_id, @RequestBody RolePermission rolepermissions) {
		roleService.saveRoleRolePermissions(role_id, rolepermissions);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions.getRoleId(), rolepermissions.getPermissionId());
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/userRoles", method = RequestMethod.POST)
	@ResponseBody
	public UserRole newRoleUserRoles(@PathVariable Integer role_id, @RequestBody UserRole userrole) {
		roleService.saveRoleUserRoles(role_id, userrole);
		return userRoleDAO.findUserRoleByPrimaryKey(userrole.getUserId(), userrole.getRoleId());
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
	 * Save an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/Role", method = RequestMethod.PUT)
	@ResponseBody
	public Role saveRole(@RequestBody Role role) {
		roleService.saveRole(role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * Show all Role entities
	 * 
	 */
	@RequestMapping(value = "/Role", method = RequestMethod.GET)
	@ResponseBody
	public List<Role> listRoles() {
		return new java.util.ArrayList<Role>(roleService.loadRoles());
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/rolePermissions/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRoleRolePermissions(@PathVariable Integer role_id, @PathVariable Integer related_rolepermissions_roleId, @PathVariable Integer related_rolepermissions_permissionId) {
		roleService.deleteRoleRolePermissions(role_id, related_rolepermissions_roleId, related_rolepermissions_permissionId);
	}

	/**
	 * View an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/userRoles/{userrole_userId}/{userrole_roleId}", method = RequestMethod.GET)
	@ResponseBody
	public UserRole loadRoleUserRoles(@PathVariable Integer role_id, @PathVariable Integer related_userroles_userId, @PathVariable Integer related_userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId, -1, -1);

		return userrole;
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/userRoles", method = RequestMethod.PUT)
	@ResponseBody
	public UserRole saveRoleUserRoles(@PathVariable Integer role_id, @RequestBody UserRole userroles) {
		roleService.saveRoleUserRoles(role_id, userroles);
		return userRoleDAO.findUserRoleByPrimaryKey(userroles.getUserId(), userroles.getRoleId());
	}

	/**
	 * View an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/rolePermissions/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public RolePermission loadRoleRolePermissions(@PathVariable Integer role_id, @PathVariable Integer related_rolepermissions_roleId, @PathVariable Integer related_rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId, -1, -1);

		return rolepermission;
	}

	/**
	 * Show all RolePermission entities by Role
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/rolePermissions", method = RequestMethod.GET)
	@ResponseBody
	public List<RolePermission> getRoleRolePermissions(@PathVariable Integer role_id) {
		return null;//new java.util.ArrayList<RolePermission>(roleDAO.findRoleByPrimaryKey(role_id).getRolePermissions());
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping(value = "/Role", method = RequestMethod.POST)
	@ResponseBody
	public Role newRole(@RequestBody Role role) {
		roleService.saveRole(role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * Select an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}", method = RequestMethod.GET)
	@ResponseBody
	public Role loadRole(@PathVariable Integer role_id) {
		return roleDAO.findRoleByPrimaryKey(role_id);
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/rolePermissions", method = RequestMethod.POST)
	@ResponseBody
	public RolePermission newRoleRolePermissions(@PathVariable Integer role_id, @RequestBody RolePermission rolepermission) {
		roleService.saveRoleRolePermissions(role_id, rolepermission);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission.getRoleId(), rolepermission.getPermissionId());
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRole(@PathVariable Integer role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(role_id);
		roleService.deleteRole(role);
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/userRoles/{userrole_userId}/{userrole_roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRoleUserRoles(@PathVariable Integer role_id, @PathVariable Integer related_userroles_userId, @PathVariable Integer related_userroles_roleId) {
		roleService.deleteRoleUserRoles(role_id, related_userroles_userId, related_userroles_roleId);
	}

	/**
	 * Show all UserRole entities by Role
	 * 
	 */
	@RequestMapping(value = "/Role/{role_id}/userRoles", method = RequestMethod.GET)
	@ResponseBody
	public List<UserRole> getRoleUserRoles(@PathVariable Integer role_id) {
		return new java.util.ArrayList<UserRole>(roleDAO.findRoleByPrimaryKey(role_id).getUserRoles());
	}
}