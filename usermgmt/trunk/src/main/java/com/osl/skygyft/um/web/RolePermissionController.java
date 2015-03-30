package com.osl.skygyft.um.web;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;

import com.osl.skygyft.um.service.RolePermissionService;

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
 * Spring MVC controller that handles CRUD requests for RolePermission entities
 * 
 */

@Controller("RolePermissionController")
public class RolePermissionController {

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
	 * Select the RolePermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRolePermission")
	public ModelAndView confirmDeleteRolePermission(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey));
		mav.setViewName("rolepermission/deleteRolePermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editRolePermissionPermission")
	public ModelAndView editRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("permission", permission);
		mav.setViewName("rolepermission/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Entry point to show all RolePermission entities
	 * 
	 */
	public String indexRolePermission() {
		return "redirect:/indexRolePermission";
	}

	/**
	 * Select the child Role entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRolePermissionRole")
	public ModelAndView confirmDeleteRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer related_role_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(related_role_id));
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.setViewName("rolepermission/role/deleteRole.jsp");

		return mav;
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newRolePermissionPermission")
	public ModelAndView newRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("rolepermission/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/deleteRolePermission")
	public String deleteRolePermission(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey);
		rolePermissionService.deleteRolePermission(rolepermission);
		return "forward:/indexRolePermission";
	}

	/**
	 * Edit an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/editRolePermission")
	public ModelAndView editRolePermission(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey));
		mav.setViewName("rolepermission/editRolePermission.jsp");

		return mav;
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/saveRolePermission")
	public String saveRolePermission(@ModelAttribute RolePermission rolepermission) {
		rolePermissionService.saveRolePermission(rolepermission);
		return "forward:/indexRolePermission";
	}

	/**
	 */
	@RequestMapping("/rolepermissionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@RequestMapping("/deleteRolePermissionRole")
	public ModelAndView deleteRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer related_role_id) {
		ModelAndView mav = new ModelAndView();

		RolePermission rolepermission = rolePermissionService.deleteRolePermissionRole(rolepermission_roleId, rolepermission_permissionId, related_role_id);

		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("rolepermission/viewRolePermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing Role entity
	 * 
	 */
	@RequestMapping("/editRolePermissionRole")
	public ModelAndView editRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("role", role);
		mav.setViewName("rolepermission/role/editRole.jsp");

		return mav;
	}

	/**
	 * View an existing Role entity
	 * 
	 */
	@RequestMapping("/selectRolePermissionRole")
	public ModelAndView selectRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("role", role);
		mav.setViewName("rolepermission/role/viewRole.jsp");

		return mav;
	}

	/**
	 * Select the child Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRolePermissionPermission")
	public ModelAndView confirmDeleteRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(related_permission_id));
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.setViewName("rolepermission/permission/deletePermission.jsp");

		return mav;
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping("/newRolePermissionRole")
	public ModelAndView newRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("role", new Role());
		mav.addObject("newFlag", true);
		mav.setViewName("rolepermission/role/editRole.jsp");

		return mav;
	}

	/**
	 * Show all RolePermission entities
	 * 
	 */
	@RequestMapping("/indexRolePermission")
	public ModelAndView listRolePermissions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermissions", rolePermissionService.loadRolePermissions());

		mav.setViewName("rolepermission/listRolePermissions.jsp");

		return mav;
	}

	/**
	 * Show all Role entities by RolePermission
	 * 
	 */
	@RequestMapping("/listRolePermissionRole")
	public ModelAndView listRolePermissionRole(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey));
		mav.setViewName("rolepermission/role/listRole.jsp");

		return mav;
	}

	/**
	 * Select an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/selectRolePermission")
	public ModelAndView selectRolePermission(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey));
		mav.setViewName("rolepermission/viewRolePermission.jsp");

		return mav;
	}

	/**
	 * Show all Permission entities by RolePermission
	 * 
	 */
	@RequestMapping("/listRolePermissionPermission")
	public ModelAndView listRolePermissionPermission(@RequestParam Integer roleIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(roleIdKey, permissionIdKey));
		mav.setViewName("rolepermission/permission/listPermission.jsp");

		return mav;
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectRolePermissionPermission")
	public ModelAndView selectRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("permission", permission);
		mav.setViewName("rolepermission/permission/viewPermission.jsp");

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
	 * Save an existing Role entity
	 * 
	 */
	@RequestMapping("/saveRolePermissionRole")
	public ModelAndView saveRolePermissionRole(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @ModelAttribute Role role) {
		RolePermission parent_rolepermission = rolePermissionService.saveRolePermissionRole(rolepermission_roleId, rolepermission_permissionId, role);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("rolepermission", parent_rolepermission);
		mav.setViewName("rolepermission/viewRolePermission.jsp");

		return mav;
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping("/newRolePermission")
	public ModelAndView newRolePermission() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", new RolePermission());
		mav.addObject("newFlag", true);
		mav.setViewName("rolepermission/editRolePermission.jsp");

		return mav;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/saveRolePermissionPermission")
	public ModelAndView saveRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @ModelAttribute Permission permission) {
		RolePermission parent_rolepermission = rolePermissionService.saveRolePermissionPermission(rolepermission_roleId, rolepermission_permissionId, permission);

		ModelAndView mav = new ModelAndView();
		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("rolepermission", parent_rolepermission);
		mav.setViewName("rolepermission/viewRolePermission.jsp");

		return mav;
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deleteRolePermissionPermission")
	public ModelAndView deleteRolePermissionPermission(@RequestParam Integer rolepermission_roleId, @RequestParam Integer rolepermission_permissionId, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		RolePermission rolepermission = rolePermissionService.deleteRolePermissionPermission(rolepermission_roleId, rolepermission_permissionId, related_permission_id);

		mav.addObject("rolepermission_roleId", rolepermission_roleId);
		mav.addObject("rolepermission_permissionId", rolepermission_permissionId);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("rolepermission/viewRolePermission.jsp");

		return mav;
	}
}