package com.osl.skygyft.um.web;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;

import com.osl.skygyft.um.service.UserPermissionService;

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
 * Spring MVC controller that handles CRUD requests for UserPermission entities
 * 
 */

@Controller("UserPermissionController")
public class UserPermissionController {

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
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newUserPermissionPermission")
	public ModelAndView newUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("userpermission/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Select the UserPermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserPermission")
	public ModelAndView confirmDeleteUserPermission(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey));
		mav.setViewName("userpermission/deleteUserPermission.jsp");

		return mav;
	}

	/**
	 * Show all Permission entities by UserPermission
	 * 
	 */
	@RequestMapping("/listUserPermissionPermission")
	public ModelAndView listUserPermissionPermission(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey));
		mav.setViewName("userpermission/permission/listPermission.jsp");

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
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deleteUserPermissionPermission")
	public ModelAndView deleteUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		UserPermission userpermission = userPermissionService.deleteUserPermissionPermission(userpermission_userId, userpermission_permissionId, related_permission_id);

		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("userpermission/viewUserPermission.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserPermissionUser")
	public ModelAndView confirmDeleteUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_userId));
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.setViewName("userpermission/user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Show all User entities by UserPermission
	 * 
	 */
	@RequestMapping("/listUserPermissionUser")
	public ModelAndView listUserPermissionUser(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey));
		mav.setViewName("userpermission/user/listUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/deleteUserPermission")
	public String deleteUserPermission(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey);
		userPermissionService.deleteUserPermission(userpermission);
		return "forward:/indexUserPermission";
	}

	/**
	 */
	@RequestMapping("/userpermissionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@RequestMapping("/saveUserPermissionPermission")
	public ModelAndView saveUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @ModelAttribute Permission permission) {
		UserPermission parent_userpermission = userPermissionService.saveUserPermissionPermission(userpermission_userId, userpermission_permissionId, permission);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("userpermission", parent_userpermission);
		mav.setViewName("userpermission/viewUserPermission.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping("/selectUserPermissionUser")
	public ModelAndView selectUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("user", user);
		mav.setViewName("userpermission/user/viewUser.jsp");

		return mav;
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveUserPermissionUser")
	public ModelAndView saveUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @ModelAttribute User user) {
		UserPermission parent_userpermission = userPermissionService.saveUserPermissionUser(userpermission_userId, userpermission_permissionId, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("userpermission", parent_userpermission);
		mav.setViewName("userpermission/viewUserPermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editUserPermissionPermission")
	public ModelAndView editUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("permission", permission);
		mav.setViewName("userpermission/permission/editPermission.jsp");

		return mav;
	}

	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping("/newUserPermission")
	public ModelAndView newUserPermission() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", new UserPermission());
		mav.addObject("newFlag", true);
		mav.setViewName("userpermission/editUserPermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editUserPermissionUser")
	public ModelAndView editUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("user", user);
		mav.setViewName("userpermission/user/editUser.jsp");

		return mav;
	}

	/**
	 * View an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectUserPermissionPermission")
	public ModelAndView selectUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer permission_id) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("permission", permission);
		mav.setViewName("userpermission/permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Select the child Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserPermissionPermission")
	public ModelAndView confirmDeleteUserPermissionPermission(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer related_permission_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(related_permission_id));
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.setViewName("userpermission/permission/deletePermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/editUserPermission")
	public ModelAndView editUserPermission(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey));
		mav.setViewName("userpermission/editUserPermission.jsp");

		return mav;
	}

	/**
	 * Select an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/selectUserPermission")
	public ModelAndView selectUserPermission(@RequestParam Integer userIdKey, @RequestParam Integer permissionIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(userIdKey, permissionIdKey));
		mav.setViewName("userpermission/viewUserPermission.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newUserPermissionUser")
	public ModelAndView newUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("userpermission/user/editUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping("/deleteUserPermissionUser")
	public ModelAndView deleteUserPermissionUser(@RequestParam Integer userpermission_userId, @RequestParam Integer userpermission_permissionId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		UserPermission userpermission = userPermissionService.deleteUserPermissionUser(userpermission_userId, userpermission_permissionId, related_user_userId);

		mav.addObject("userpermission_userId", userpermission_userId);
		mav.addObject("userpermission_permissionId", userpermission_permissionId);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("userpermission/viewUserPermission.jsp");

		return mav;
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/saveUserPermission")
	public String saveUserPermission(@ModelAttribute UserPermission userpermission) {
		userPermissionService.saveUserPermission(userpermission);
		return "forward:/indexUserPermission";
	}

	/**
	 * Show all UserPermission entities
	 * 
	 */
	@RequestMapping("/indexUserPermission")
	public ModelAndView listUserPermissions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermissions", userPermissionService.loadUserPermissions());

		mav.setViewName("userpermission/listUserPermissions.jsp");

		return mav;
	}

	/**
	 * Entry point to show all UserPermission entities
	 * 
	 */
	public String indexUserPermission() {
		return "redirect:/indexUserPermission";
	}
}