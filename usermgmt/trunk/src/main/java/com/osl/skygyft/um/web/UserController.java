package com.osl.skygyft.um.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;
import com.osl.skygyft.um.domain.UserRole;
import com.osl.skygyft.um.service.PermissionService;
import com.osl.skygyft.um.service.RoleService;
import com.osl.skygyft.um.service.UserService;
import com.osl.skygyft.um.utils.ResponseUtils;
import com.osl.skygyft.um.vo.Response;

/**
 * Spring MVC controller that handles CRUD requests for User entities
 * 
 */

@Controller("UserController")
public class UserController {

	private static final List<String> USER_AGENTS = new ArrayList<String>();
	
	static {
		USER_AGENTS.add("Mozilla Firefox");
		USER_AGENTS.add("Google Chrome");
		USER_AGENTS.add("Microsoft Internet Explorer");
		USER_AGENTS.add("Netscape Navigator");
		USER_AGENTS.add("Opera");
		USER_AGENTS.add("Safari");
	}

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
	
	@Autowired
	private PermissionService permissionService;

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
	
	@Autowired
	private RoleService roleService;
	/**
	 * Create a new AuditTrial entity
	 * 
	 */
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getHomePage(ModelMap model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		//model.put("users", userService.loadUsers());
		return "users";
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String getUsersPage(ModelMap model, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		//model.put("users", userService.loadUsers());
		return "users";
	}
	
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUserPage(Model model) {
		User user = new User();
		model.addAttribute("userForm", user);
		
		List<Role> roles = roleService.findAllRoles(-1, -1);
		model.addAttribute("roleMap", getRoleMap(roles));

		List<Permission> permissions = permissionService.findAllPermissions(-1, -1);
		model.addAttribute("permissions", permissions);
		
		model.addAttribute("userAgents", USER_AGENTS);
		return "addUser";
	}
	
	/**
	 * Save an existing User entity
	 * 
	 */
	@RequestMapping("/saveUser")
	@ResponseBody
	public String saveUser(HttpServletRequest req) {
		Map map = req.getParameterMap();
		
		User user = new User();

		user.setLoginId(req.getParameter("loginId"));
		user.setLoginId1(req.getParameter("loginId1"));
		user.setLoginId2(req.getParameter("loginId2"));
		user.setLoginId3(req.getParameter("loginId3"));
		user.setLoginId4(req.getParameter("loginId4"));
		user.setLoginId5(req.getParameter("loginId5"));
		
		user.setFirst_name(req.getParameter("first_name"));
		user.setLast_name(req.getParameter("last_name"));
		
		user.setEmail(req.getParameter("email"));
		user.setEmail1(req.getParameter("email1"));
		user.setEmail2(req.getParameter("email2"));
		
		user.setMobile(req.getParameter("mobile"));
		user.setMobile1(req.getParameter("mobile1"));
		user.setMobile2(req.getParameter("mobile2"));
		
		String[] favouriteIps = (String[]) map.get("favouriteIps[]");
		user.setFavouriteIps(StringUtils.join(favouriteIps, ','));
		
		String[] favouriteAgents = (String[]) map.get("favouriteAgents");
		user.setFavouriteAgents(StringUtils.join(favouriteAgents, ','));
		
		String[] permissionPositive = (String[]) map.get("posPermissions");
		user.setPermissionPositive(StringUtils.join(permissionPositive, ','));
		
		String[] permissionNegative = (String[]) map.get("negPermissions");
		user.setPermissionNegative(StringUtils.join(permissionNegative, ','));
		
		String[] roleIds = (String[]) map.get("userRole");
		user.setUserRole(StringUtils.join(roleIds, ','));
		
		user.setStatus(Boolean.valueOf(req.getParameter("status")));
		
		userService.saveUser(user);
		return "done";
	}

	/**
	 * Edit an existing User entity
	 * 
	 */
	@RequestMapping("/editUser")
	public ModelAndView editUser(@RequestParam Integer id) {
		ModelAndView mav = new ModelAndView();
		
		User user = userService.findUserByPrimaryKey(id);
		user.setPositivePermissions(positivePermissions(user));
		user.setNegativePermissions(negativePermissions(user));
		
		mav.addObject("userForm",user);
		mav.addObject("user", user);
		mav.addObject("roles", roleService.findAllRoles(-1, -1));
		mav.addObject("permissions", permissionService.findAllPermissions(-1, -1));
		mav.addObject("userAgents", USER_AGENTS);

		mav.setViewName("editUser");
		return mav;
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(HttpServletRequest req, @RequestParam Integer id) {
		Map map = req.getParameterMap();
		
		User user = userService.findUserByPrimaryKey(id);

		user.setLoginId(req.getParameter("loginId"));
		user.setLoginId1(req.getParameter("loginId1"));
		user.setLoginId2(req.getParameter("loginId2"));
		user.setLoginId3(req.getParameter("loginId3"));
		user.setLoginId4(req.getParameter("loginId4"));
		user.setLoginId5(req.getParameter("loginId5"));
		
		user.setFirst_name(req.getParameter("first_name"));
		user.setLast_name(req.getParameter("last_name"));
		
		user.setEmail(req.getParameter("email"));
		user.setEmail1(req.getParameter("email1"));
		user.setEmail2(req.getParameter("email2"));
		
		user.setMobile(req.getParameter("mobile"));
		user.setMobile1(req.getParameter("mobile1"));
		user.setMobile2(req.getParameter("mobile2"));
		
		String[] favouriteIps = (String[]) map.get("favouriteIps[]");
		user.setFavouriteIps(StringUtils.join(favouriteIps, ','));
		
		String[] favouriteAgents = (String[]) map.get("favouriteAgents");
		user.setFavouriteAgents(StringUtils.join(favouriteAgents, ','));
		
		String[] permissionPositive = (String[]) map.get("positivePermissions");
		user.setPermissionPositive(StringUtils.join(permissionPositive, ','));
		
		String[] permissionNegative = (String[]) map.get("negativePermissions");
		user.setPermissionNegative(StringUtils.join(permissionNegative, ','));
		
		String[] roleIds = (String[]) map.get("roleSet");
		user.setUserRole(StringUtils.join(roleIds, ','));

		user.setStatus(Boolean.valueOf(req.getParameter("status")));
		
		userService.saveUser(user);
		return "done";
	}

	private Map<Integer, String> getRoleMap(List<Role> roleList) {
		Map<Integer,String> roleMap = new HashMap<Integer,String>();
		for(Role role : roleList){
			roleMap.put(role.getId(), role.getRole_name());
		}
		return roleMap;
	}
	
	private List<Permission> negativePermissions(User user) {
		List<Permission> negPermissions = null;
		String concatIds = user.getPermissionNegative();
		if(StringUtils.isNotEmpty(concatIds)) {
			negPermissions = new ArrayList<Permission>();
			for(String permId : concatIds.split(",")) {
				Permission permission = permissionService.findPermissionByPrimaryKey(Integer.valueOf(permId));
				negPermissions.add(permission);
			}
		}
		return negPermissions;
	}

	private List<Permission> positivePermissions(User user) {
		List<Permission> posPermissions = null;
		String concatIds = user.getPermissionPositive();
		if(StringUtils.isNotEmpty(concatIds)) {
			posPermissions = new ArrayList<Permission>();
			for(String permId : concatIds.split(",")) {
				Permission permission = permissionService.findPermissionByPrimaryKey(Integer.valueOf(permId));
				posPermissions.add(permission);
			}
		}
		return posPermissions;
	}

	@RequestMapping("/newUserAuditTrials")
	public ModelAndView newUserAuditTrials(@RequestParam Integer user_userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("audittrial", new AuditTrial());
		mav.addObject("newFlag", true);
		mav.setViewName("user/audittrials/editAuditTrials.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping("/deleteUserUserRoles")
	public ModelAndView deleteUserUserRoles(@RequestParam Integer user_userId, @RequestParam Integer related_userroles_userId, @RequestParam Integer related_userroles_roleId) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserUserRoles(user_userId, related_userroles_userId, related_userroles_roleId);

		mav.addObject("user_userId", user_userId);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/saveUserUserPermissions")
	public ModelAndView saveUserUserPermissions(@RequestParam Integer user_userId, @ModelAttribute UserPermission userpermissions) {
		User parent_user = userService.saveUserUserPermissions(user_userId, userpermissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Select an existing User entity
	 * 
	 */
	@RequestMapping("/selectUser")
	public ModelAndView selectUser(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/viewUser.jsp");

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
	 * Edit an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/editUserUserPermissions")
	public ModelAndView editUserUserPermissions(@RequestParam Integer user_userId, @RequestParam Integer userpermissions_userId, @RequestParam Integer userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions_userId, userpermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("user/userpermissions/editUserPermissions.jsp");

		return mav;
	}

	/**
	 * View an existing UserRole entity
	 * 
	 */
	@RequestMapping("/selectUserUserRoles")
	public ModelAndView selectUserUserRoles(@RequestParam Integer user_userId, @RequestParam Integer userroles_userId, @RequestParam Integer userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userroles_userId, userroles_roleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userrole", userrole);
		mav.setViewName("user/userroles/viewUserRoles.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/deleteUserUserPermissions")
	public ModelAndView deleteUserUserPermissions(@RequestParam Integer user_userId, @RequestParam Integer related_userpermissions_userId, @RequestParam Integer related_userpermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserUserPermissions(user_userId, related_userpermissions_userId, related_userpermissions_permissionId);

		mav.addObject("user_userId", user_userId);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * View an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/selectUserAuditTrials")
	public ModelAndView selectUserAuditTrials(@RequestParam Integer user_userId, @RequestParam Integer audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrials_auditId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("user/audittrials/viewAuditTrials.jsp");

		return mav;
	}

	/**
	 * Entry point to show all User entities
	 * 
	 */
	public String indexUser() {
		return "redirect:/indexUser";
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping("/saveUserUserRoles")
	public ModelAndView saveUserUserRoles(@RequestParam Integer user_userId, @ModelAttribute UserRole userroles) {
		User parent_user = userService.saveUserUserRoles(user_userId, userroles);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@RequestMapping("/deleteUser")
	public String deleteUser(Model model, @RequestParam Integer id) {
		try{
			User user = userDAO.findUserByPrimaryKey(id);
			userService.deleteUser(user);
		}
		catch(PersistenceException persistenceException){
			persistenceException.printStackTrace();
			model.addAttribute("exception", "Cannot delete user with id " + id);
		}
		model.addAttribute("exception", "Cannot delete user with id " + id);
		return "redirect:users";
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/deleteUserAuditTrials")
	public ModelAndView deleteUserAuditTrials(@RequestParam Integer user_userId, @RequestParam Integer related_audittrials_auditId) {
		ModelAndView mav = new ModelAndView();

		User user = userService.deleteUserAuditTrials(user_userId, related_audittrials_auditId);

		mav.addObject("user_userId", user_userId);
		mav.addObject("user", user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}

	/**
	 * Show all UserPermission entities by User
	 * 
	 */
	@RequestMapping("/listUserUserPermissions")
	public ModelAndView listUserUserPermissions(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/userpermissions/listUserPermissions.jsp");

		return mav;
	}

	/**
	 * Edit an existing UserRole entity
	 * 
	 */
	@RequestMapping("/editUserUserRoles")
	public ModelAndView editUserUserRoles(@RequestParam Integer user_userId, @RequestParam Integer userroles_userId, @RequestParam Integer userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userroles_userId, userroles_roleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userrole", userrole);
		mav.setViewName("user/userroles/editUserRoles.jsp");

		return mav;
	}

	/**
	 * Edit an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/editUserAuditTrials")
	public ModelAndView editUserAuditTrials(@RequestParam Integer user_userId, @RequestParam Integer audittrials_auditId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrials_auditId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("audittrial", audittrial);
		mav.setViewName("user/audittrials/editAuditTrials.jsp");

		return mav;
	}

	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping("/newUserUserPermissions")
	public ModelAndView newUserUserPermissions(@RequestParam Integer user_userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userpermission", new UserPermission());
		mav.addObject("newFlag", true);
		mav.setViewName("user/userpermissions/editUserPermissions.jsp");

		return mav;
	}

	/**
	 * Show all AuditTrial entities by User
	 * 
	 */
	@RequestMapping("/listUserAuditTrials")
	public ModelAndView listUserAuditTrials(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/audittrials/listAuditTrials.jsp");

		return mav;
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping("/newUserUserRoles")
	public ModelAndView newUserUserRoles(@RequestParam Integer user_userId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userrole", new UserRole());
		mav.addObject("newFlag", true);
		mav.setViewName("user/userroles/editUserRoles.jsp");

		return mav;
	}

	/**
	 * Select the child AuditTrial entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserAuditTrials")
	public ModelAndView confirmDeleteUserAuditTrials(@RequestParam Integer user_userId, @RequestParam Integer related_audittrials_auditId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("audittrial", auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId));
		mav.addObject("user_userId", user_userId);
		mav.setViewName("user/audittrials/deleteAuditTrials.jsp");

		return mav;
	}

	/**
	 * Select the child UserRole entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserUserRoles")
	public ModelAndView confirmDeleteUserUserRoles(@RequestParam Integer user_userId, @RequestParam Integer related_userroles_userId, @RequestParam Integer related_userroles_roleId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId));
		mav.addObject("user_userId", user_userId);
		mav.setViewName("user/userroles/deleteUserRoles.jsp");

		return mav;
	}


	
	/**
	 * Create a new User entity
	 * 
	 */
	@RequestMapping("/newUser")
	public ModelAndView newUser() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", new User());
		mav.addObject("newFlag", true);
		mav.setViewName("user/editUser.jsp");

		return mav;
	}

	/**
	 * View an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/selectUserUserPermissions")
	public ModelAndView selectUserUserPermissions(@RequestParam Integer user_userId, @RequestParam Integer userpermissions_userId, @RequestParam Integer userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions_userId, userpermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("user/userpermissions/viewUserPermissions.jsp");

		return mav;
	}

	/**
	 * Select the User entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUser")
	public ModelAndView confirmDeleteUser(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/deleteUser.jsp");

		return mav;
	}

	/**
	 * Show all UserRole entities by User
	 * 
	 */
	@RequestMapping("/listUserUserRoles")
	public ModelAndView listUserUserRoles(@RequestParam Integer userIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("user", userDAO.findUserByPrimaryKey(userIdKey));
		mav.setViewName("user/userroles/listUserRoles.jsp");

		return mav;
	}

	/**
	 * Show all User entities
	 * 
	 */
	@RequestMapping("/indexUser")
	public ModelAndView listUsers() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("users", userService.findAllUsers(0, 10));

		mav.setViewName("user/listUsers.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/userController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the child UserPermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteUserUserPermissions")
	public ModelAndView confirmDeleteUserUserPermissions(@RequestParam Integer user_userId, @RequestParam Integer related_userpermissions_userId, @RequestParam Integer related_userpermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId));
		mav.addObject("user_userId", user_userId);
		mav.setViewName("user/userpermissions/deleteUserPermissions.jsp");

		return mav;
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@RequestMapping("/saveUserAuditTrials")
	public ModelAndView saveUserAuditTrials(@RequestParam Integer user_userId, @ModelAttribute AuditTrial audittrials) {
		User parent_user = userService.saveUserAuditTrials(user_userId, audittrials);

		ModelAndView mav = new ModelAndView();
		mav.addObject("user_userId", user_userId);
		mav.addObject("user", parent_user);
		mav.setViewName("user/viewUser.jsp");

		return mav;
	}
}