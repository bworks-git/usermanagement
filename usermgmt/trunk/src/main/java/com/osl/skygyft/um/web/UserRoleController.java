package com.osl.skygyft.um.web;

import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserRole;

import com.osl.skygyft.um.service.UserRoleService;

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
 * Spring MVC controller that handles CRUD requests for UserRole entities
 * 
 */

@Controller("UserRoleController")
public class UserRoleController {

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
	 * View an existing Role entity
	 * 
	 */
	@RequestMapping("/selectUserRoleRole")
	public ModelAndView selectUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("role", role);
		mav.setViewName("userrole/role/viewRole.jsp");

		return mav;
	}

	/**
	 * Show all Role entities by UserRole
	 * 
	 */
	@RequestMapping("/listUserRoleRole")
	public ModelAndView listUserRoleRole(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey));
		mav.setViewName("userrole/role/listRole.jsp");

		return mav;
	}

	/**
	 * Show all User entities by UserRole
	 * 
	 */
	@RequestMapping("/listUserRoleUser")
	public ModelAndView listUserRoleUser(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey));
		mav.setViewName("userrole/user/listUser.jsp");

		return mav;
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveUserRoleUser")
	public ModelAndView saveUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @ModelAttribute User user) {
		UserRole parent_userrole = userRoleService.saveUserRoleUser(userrole_userId, userrole_roleId, user);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("userrole", parent_userrole);
		mav.setViewName("userrole/viewUserRole.jsp");

		return mav;
	}

	/**
	 * Select the UserRole entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserRole")
	public ModelAndView confirmDeleteUserRole(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey));
		mav.setViewName("userrole/deleteUserRole.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/userroleController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Entry point to show all UserRole entities
	 * 
	 */
	public String indexUserRole() {
		return "redirect:/indexUserRole";
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
	 * Edit an existing UserRole entity
	 * 
	 */
	@RequestMapping("/editUserRole")
	public ModelAndView editUserRole(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey));
		mav.setViewName("userrole/editUserRole.jsp");

		return mav;
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@RequestMapping("/deleteUserRoleRole")
	public ModelAndView deleteUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer related_role_id) {
		ModelAndView mav = new ModelAndView();

		UserRole userrole = userRoleService.deleteUserRoleRole(userrole_userId, userrole_roleId, related_role_id);

		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("userrole", userrole);
		mav.setViewName("userrole/viewUserRole.jsp");

		return mav;
	}

	/**
	 * Select an existing UserRole entity
	 * 
	 */
	@RequestMapping("/selectUserRole")
	public ModelAndView selectUserRole(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey));
		mav.setViewName("userrole/viewUserRole.jsp");

		return mav;
	}

	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editUserRoleUser")
	public ModelAndView editUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("user", user);
		mav.setViewName("userrole/user/editUser.jsp");

		return mav;
	}

	/**
	 * Edit an existing Role entity
	 * 
	 */
	@RequestMapping("/editUserRoleRole")
	public ModelAndView editUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer role_id) {
		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("role", role);
		mav.setViewName("userrole/role/editRole.jsp");

		return mav;
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@RequestMapping("/saveUserRoleRole")
	public ModelAndView saveUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @ModelAttribute Role role) {
		UserRole parent_userrole = userRoleService.saveUserRoleRole(userrole_userId, userrole_roleId, role);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("userrole", parent_userrole);
		mav.setViewName("userrole/viewUserRole.jsp");

		return mav;
	}

	/**
	 * View an existing User entity
	 * 
	 */
	@RequestMapping("/selectUserRoleUser")
	public ModelAndView selectUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer user_userId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("user", user);
		mav.setViewName("userrole/user/viewUser.jsp");

		return mav;
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping("/newUserRole")
	public ModelAndView newUserRole() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", new UserRole());
		mav.addObject("newFlag", true);
		mav.setViewName("userrole/editUserRole.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping("/deleteUserRole")
	public String deleteUserRole(@RequestParam Integer userIdKey, @RequestParam Integer roleIdKey) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userIdKey, roleIdKey);
		userRoleService.deleteUserRole(userrole);
		return "forward:/indexUserRole";
	}

	/**
	 * Select the child Role entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserRoleRole")
	public ModelAndView confirmDeleteUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer related_role_id) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(related_role_id));
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.setViewName("userrole/role/deleteRole.jsp");

		return mav;
	}

	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newUserRoleUser")
	public ModelAndView newUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("userrole/user/editUser.jsp");

		return mav;
	}

	/**
	 * Show all UserRole entities
	 * 
	 */
	@RequestMapping("/indexUserRole")
	public ModelAndView listUserRoles() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userroles", userRoleService.loadUserRoles());

		mav.setViewName("userrole/listUserRoles.jsp");

		return mav;
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping("/saveUserRole")
	public String saveUserRole(@ModelAttribute UserRole userrole) {
		userRoleService.saveUserRole(userrole);
		return "forward:/indexUserRole";
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping("/deleteUserRoleUser")
	public ModelAndView deleteUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		UserRole userrole = userRoleService.deleteUserRoleUser(userrole_userId, userrole_roleId, related_user_userId);

		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("userrole", userrole);
		mav.setViewName("userrole/viewUserRole.jsp");

		return mav;
	}

	/**
	 * Select the child User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserRoleUser")
	public ModelAndView confirmDeleteUserRoleUser(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId, @RequestParam Integer related_user_userId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(related_user_userId));
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.setViewName("userrole/user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping("/newUserRoleRole")
	public ModelAndView newUserRoleRole(@RequestParam Integer userrole_userId, @RequestParam Integer userrole_roleId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userrole_userId", userrole_userId);
		mav.addObject("userrole_roleId", userrole_roleId);
		mav.addObject("role", new Role());
		mav.addObject("newFlag", true);
		mav.setViewName("userrole/role/editRole.jsp");

		return mav;
	}
}