package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserPermission;

import com.osl.skygyft.um.service.PermissionService;

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
 * Spring Rest controller that handles CRUD requests for Permission entities
 * 
 */

@Controller("PermissionRestController")
public class PermissionRestController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages RolePermission entities
	 * 
	 */
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	/**
	 * DAO injected by Spring that manages UserPermission entities
	 * 
	 */
	@Autowired
	private UserPermissionDAO userPermissionDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Permission entities
	 * 
	 */
	@Autowired
	private PermissionService permissionService;

	/**
	 * Show all Permission entities
	 * 
	 */
	@RequestMapping(value = "/Permission", method = RequestMethod.GET)
	@ResponseBody
	public List<Permission> listPermissions() {
		return new java.util.ArrayList<Permission>(permissionService.loadPermissions());
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/rolePermissions", method = RequestMethod.POST)
	@ResponseBody
	public RolePermission newPermissionRolePermissions(@PathVariable Integer permission_id, @RequestBody RolePermission rolepermission) {
		permissionService.savePermissionRolePermissions(permission_id, rolepermission);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission.getRoleId(), rolepermission.getPermissionId());
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/rolePermissions", method = RequestMethod.PUT)
	@ResponseBody
	public RolePermission savePermissionRolePermissions(@PathVariable Integer permission_id, @RequestBody RolePermission rolepermissions) {
		permissionService.savePermissionRolePermissions(permission_id, rolepermissions);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions.getRoleId(), rolepermissions.getPermissionId());
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission", method = RequestMethod.PUT)
	@ResponseBody
	public Permission savePermission(@RequestBody Permission permission) {
		permissionService.savePermission(permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermission(@PathVariable Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id);
		permissionService.deletePermission(permission);
	}

	/**
	 * Show all UserPermission entities by Permission
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/userPermissions", method = RequestMethod.GET)
	@ResponseBody
	public List<UserPermission> getPermissionUserPermissions(@PathVariable Integer permission_id) {
		return new java.util.ArrayList<UserPermission>(permissionDAO.findPermissionByPrimaryKey(permission_id).getUserPermissions());
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/rolePermissions/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermissionRolePermissions(@PathVariable Integer permission_id, @PathVariable Integer related_rolepermissions_roleId, @PathVariable Integer related_rolepermissions_permissionId) {
		permissionService.deletePermissionRolePermissions(permission_id, related_rolepermissions_roleId, related_rolepermissions_permissionId);
	}

	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/userPermissions", method = RequestMethod.POST)
	@ResponseBody
	public UserPermission newPermissionUserPermissions(@PathVariable Integer permission_id, @RequestBody UserPermission userpermission) {
		permissionService.savePermissionUserPermissions(permission_id, userpermission);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermission.getUserId(), userpermission.getPermissionId());
	}

	/**
	 * Select an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadPermission(@PathVariable Integer permission_id) {
		return permissionDAO.findPermissionByPrimaryKey(permission_id);
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
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/userPermissions", method = RequestMethod.PUT)
	@ResponseBody
	public UserPermission savePermissionUserPermissions(@PathVariable Integer permission_id, @RequestBody UserPermission userpermissions) {
		permissionService.savePermissionUserPermissions(permission_id, userpermissions);
		return userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions.getUserId(), userpermissions.getPermissionId());
	}

	/**
	 * View an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/rolePermissions/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public RolePermission loadPermissionRolePermissions(@PathVariable Integer permission_id, @PathVariable Integer related_rolepermissions_roleId, @PathVariable Integer related_rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId, -1, -1);

		return rolepermission;
	}

	/**
	 * Show all RolePermission entities by Permission
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/rolePermissions", method = RequestMethod.GET)
	@ResponseBody
	public List<RolePermission> getPermissionRolePermissions(@PathVariable Integer permission_id) {
		return new java.util.ArrayList<RolePermission>(permissionDAO.findPermissionByPrimaryKey(permission_id).getRolePermissions());
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/Permission", method = RequestMethod.POST)
	@ResponseBody
	public Permission newPermission(@RequestBody Permission permission) {
		permissionService.savePermission(permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/userPermissions/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deletePermissionUserPermissions(@PathVariable Integer permission_id, @PathVariable Integer related_userpermissions_userId, @PathVariable Integer related_userpermissions_permissionId) {
		permissionService.deletePermissionUserPermissions(permission_id, related_userpermissions_userId, related_userpermissions_permissionId);
	}

	/**
	 * View an existing UserPermission entity
	 * 
	 */
	@RequestMapping(value = "/Permission/{permission_id}/userPermissions/{userpermission_userId}/{userpermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public UserPermission loadPermissionUserPermissions(@PathVariable Integer permission_id, @PathVariable Integer related_userpermissions_userId, @PathVariable Integer related_userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId, -1, -1);

		return userpermission;
	}
}