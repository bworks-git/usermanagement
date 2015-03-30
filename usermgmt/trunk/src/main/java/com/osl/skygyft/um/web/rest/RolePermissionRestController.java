package com.osl.skygyft.um.web.rest;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;

import com.osl.skygyft.um.service.RolePermissionService;

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
 * Spring Rest controller that handles CRUD requests for RolePermission entities
 * 
 */

@Controller("RolePermissionRestController")
public class RolePermissionRestController {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

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
	 * Service injected by Spring that provides CRUD operations for RolePermission entities
	 * 
	 */
	@Autowired
	private RolePermissionService rolePermissionService;

	/**
	 * Show all RolePermission entities
	 * 
	 */
	@RequestMapping(value = "/RolePermission", method = RequestMethod.GET)
	@ResponseBody
	public List<RolePermission> listRolePermissions() {
		return new java.util.ArrayList<RolePermission>(rolePermissionService.loadRolePermissions());
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission", method = RequestMethod.POST)
	@ResponseBody
	public RolePermission newRolePermission(@RequestBody RolePermission rolepermission) {
		rolePermissionService.saveRolePermission(rolepermission);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission.getRoleId(), rolepermission.getPermissionId());
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/permission", method = RequestMethod.PUT)
	@ResponseBody
	public Permission saveRolePermissionPermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @RequestBody Permission permission) {
		rolePermissionService.saveRolePermissionPermission(rolepermission_roleId, rolepermission_permissionId, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Get Role entity by RolePermission
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/role", method = RequestMethod.GET)
	@ResponseBody
	public Role getRolePermissionRole(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId) {
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId).getRole();
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
	 * Delete an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/role/{role_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRolePermissionRole(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @PathVariable Integer related_role_id) {
		rolePermissionService.deleteRolePermissionRole(rolepermission_roleId, rolepermission_permissionId, related_role_id);
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/permission", method = RequestMethod.POST)
	@ResponseBody
	public Permission newRolePermissionPermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @RequestBody Permission permission) {
		rolePermissionService.saveRolePermissionPermission(rolepermission_roleId, rolepermission_permissionId, permission);
		return permissionDAO.findPermissionByPrimaryKey(permission.getId());
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRolePermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId);
		rolePermissionService.deleteRolePermission(rolepermission);
	}

	/**
	 * View an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/role/{role_id}", method = RequestMethod.GET)
	@ResponseBody
	public Role loadRolePermissionRole(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @PathVariable Integer related_role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(related_role_id, -1, -1);

		return role;
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/permission/{permission_id}", method = RequestMethod.GET)
	@ResponseBody
	public Permission loadRolePermissionPermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @PathVariable Integer related_permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		return permission;
	}

	/**
	 * Select an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}", method = RequestMethod.GET)
	@ResponseBody
	public RolePermission loadRolePermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId) {
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId);
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/role", method = RequestMethod.PUT)
	@ResponseBody
	public Role saveRolePermissionRole(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @RequestBody Role role) {
		rolePermissionService.saveRolePermissionRole(rolepermission_roleId, rolepermission_permissionId, role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/role", method = RequestMethod.POST)
	@ResponseBody
	public Role newRolePermissionRole(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @RequestBody Role role) {
		rolePermissionService.saveRolePermissionRole(rolepermission_roleId, rolepermission_permissionId, role);
		return roleDAO.findRoleByPrimaryKey(role.getId());
	}

	/**
	 * Get Permission entity by RolePermission
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/permission", method = RequestMethod.GET)
	@ResponseBody
	public Permission getRolePermissionPermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId) {
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId).getPermission();
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission", method = RequestMethod.PUT)
	@ResponseBody
	public RolePermission saveRolePermission(@RequestBody RolePermission rolepermission) {
		rolePermissionService.saveRolePermission(rolepermission);
		return rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission.getRoleId(), rolepermission.getPermissionId());
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping(value = "/RolePermission/{rolepermission_roleId}/{rolepermission_permissionId}/permission/{permission_id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRolePermissionPermission(@PathVariable Integer rolepermission_roleId, @PathVariable Integer rolepermission_permissionId, @PathVariable Integer related_permission_id) {
		rolePermissionService.deleteRolePermissionPermission(rolepermission_roleId, rolepermission_permissionId, related_permission_id);
	}
}