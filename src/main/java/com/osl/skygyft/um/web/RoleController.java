package com.osl.skygyft.um.web;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osl.skygyft.um.constants.ApplicationConstants;
import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;
import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserRole;
import com.osl.skygyft.um.service.PermissionService;
import com.osl.skygyft.um.service.RoleService;
import com.osl.skygyft.um.utils.ResponseUtils;
import com.osl.skygyft.um.vo.Response;

/**
 * Spring MVC controller that handles CRUD requests for Role entities
 * 
 */

@Controller("RoleController")
public class RoleController {

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
	
	@Autowired
	private PermissionService permissionService;
	
	/**
	 * Show all Role entities
	 * 
	 */
	@RequestMapping("/roles")
	public String listRoles(ModelMap map) {
		List<Role> roles = roleService.findAllRoles(-1,-1);
		map.put("roles", roles);
		return "roles";
	}
	
	@RequestMapping("/addRole")
	public String addRole(ModelMap model,@ModelAttribute Role role,
			HttpSession session) {
		role.setStatus(true);
		model.addAttribute("roleForm",role);
		Map<Integer,String> permissionMap = getPermissionMap(permissionService.findAllPermissions(-1, -1));
		model.addAttribute("permissionMap",permissionMap);
		ResponseUtils.buildResponseObject(ApplicationConstants.OP_TYPE_ADD,model, session);
		return "addRole";
	}
	

	private Map<Integer, String> getPermissionMap(List<Permission> permissionList) {
		Map<Integer,String> permissionMap = new HashMap<Integer,String>();
		for(Permission permission : permissionList){
			permissionMap.put(permission.getId(), permission.getPermissionName());
		}
		return permissionMap;
	}
	
	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editRole")
	public String editRole(ModelMap model,@ModelAttribute Role role,
			@RequestParam(required=false) Integer id,
			HttpSession session) {
		Response response = ResponseUtils.buildResponseObject(ApplicationConstants.OP_TYPE_EDIT,model, session);
		if((StringUtils.isBlank(response.getStatus()) || StringUtils.equals(ApplicationConstants.SUCCESS,response.getStatus()))
				&& (id != null || role.getId() != null)){
			if(id == null){
				id = role.getId();
			}
			role = roleDAO.findRoleByPrimaryKey(id);
		}
		Map<Integer,String> permissionMap = getPermissionMap(permissionService.findAllPermissions(-1, -1));
		model.addAttribute("permissionMap",permissionMap);
		model.addAttribute("roleForm",role);
		return "addRole";
	}
	

	/**
	 * create or update Role entity
	 * 
	 */
	@RequestMapping(value="/saveRole", method = RequestMethod.POST)
	public String saveRole(ModelMap map,@ModelAttribute Role role,
			HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam String operationType) {
		String status = ApplicationConstants.SUCCESS;
		String message = "Role"+ ApplicationConstants.MESSAGE_MAP.get(operationType);
		try{
			roleService.saveRole(role);
		}
		/*catch(PersistenceException | ConstraintViolationException constraintViolationException){
			status = ApplicationConstants.ERROR;
			message = "Role Name already exists";
			constraintViolationException.printStackTrace();
		}*/
		catch(Exception e){
			status = ApplicationConstants.ERROR;
			message = ApplicationConstants.SERVER_ERROR_MSG;
			e.printStackTrace();
		}
		if(!StringUtils.equals(status, ApplicationConstants.SUCCESS) || 
				StringUtils.equals(operationType, ApplicationConstants.OP_TYPE_EDIT)){
			redirectAttributes.addFlashAttribute("role", role);
		}
		session.setAttribute(ApplicationConstants.STATUS, status);
		session.setAttribute(ApplicationConstants.MESSAGE, message);
		return "redirect:"+operationType.toLowerCase()+"Role";
	}
	
	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deleteRole")
	public @ResponseBody Response deletePermission(@RequestParam Integer id) {
		Response response = ResponseUtils.getSuccessResponse("roles");
		Role role =  null;
		try{
		role = roleDAO.findRoleByPrimaryKey(id);
		roleService.deleteRole(role);
		}
		catch(PersistenceException persistenceException){
			persistenceException.printStackTrace();
			response = ResponseUtils.getFailureResponse("Cannot delete "+role.getRole_name()+", Since it is mapped with some user(s)");
		}
		return response;
	}
	/**
	 * View an existing UserRole entity
	 * 
	 */
	@RequestMapping("/selectRoleUserRoles")
	public ModelAndView selectRoleUserRoles(@RequestParam Integer role_id, @RequestParam Integer userroles_userId, @RequestParam Integer userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userroles_userId, userroles_roleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("userrole", userrole);
		mav.setViewName("role/userroles/viewUserRoles.jsp");

		return mav;
	}

	/**
	 * Edit an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/editRoleRolePermissions")
	public ModelAndView editRoleRolePermissions(@RequestParam Integer role_id, @RequestParam Integer rolepermissions_roleId, @RequestParam Integer rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions_roleId, rolepermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("role/rolepermissions/editRolePermissions.jsp");

		return mav;
	}

	/**
	 * Show all UserRole entities by Role
	 * 
	 */
	@RequestMapping("/listRoleUserRoles")
	public ModelAndView listRoleUserRoles(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(idKey));
		mav.setViewName("role/userroles/listUserRoles.jsp");

		return mav;
	}

	/**
	 * Create a new UserRole entity
	 * 
	 */
	@RequestMapping("/newRoleUserRoles")
	public ModelAndView newRoleUserRoles(@RequestParam Integer role_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("userrole", new UserRole());
		mav.addObject("newFlag", true);
		mav.setViewName("role/userroles/editUserRoles.jsp");

		return mav;
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping("/newRoleRolePermissions")
	public ModelAndView newRoleRolePermissions(@RequestParam Integer role_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("rolepermission", new RolePermission());
		mav.addObject("newFlag", true);
		mav.setViewName("role/rolepermissions/editRolePermissions.jsp");

		return mav;
	}

	/**
	 * Select the child UserRole entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRoleUserRoles")
	public ModelAndView confirmDeleteRoleUserRoles(@RequestParam Integer role_id, @RequestParam Integer related_userroles_userId, @RequestParam Integer related_userroles_roleId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userrole", userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId));
		mav.addObject("role_id", role_id);
		mav.setViewName("role/userroles/deleteUserRoles.jsp");

		return mav;
	}

	/**
	 * Select the Role entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRole")
	public ModelAndView confirmDeleteRole(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(idKey));
		mav.setViewName("role/deleteRole.jsp");

		return mav;
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@RequestMapping("/deleteRoleUserRoles")
	public ModelAndView deleteRoleUserRoles(@RequestParam Integer role_id, @RequestParam Integer related_userroles_userId, @RequestParam Integer related_userroles_roleId) {
		ModelAndView mav = new ModelAndView();

		Role role = roleService.deleteRoleUserRoles(role_id, related_userroles_userId, related_userroles_roleId);

		mav.addObject("role_id", role_id);
		mav.addObject("role", role);
		mav.setViewName("role/viewRole.jsp");

		return mav;
	}

	/**
	 * Select an existing Role entity
	 * 
	 */
	@RequestMapping("/selectRole")
	public ModelAndView selectRole(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(idKey));
		mav.setViewName("role/viewRole.jsp");

		return mav;
	}


	/**
	 */
	@RequestMapping("/roleController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@RequestMapping("/saveRoleUserRoles")
	public ModelAndView saveRoleUserRoles(@RequestParam Integer role_id, @ModelAttribute UserRole userroles) {
		Role parent_role = roleService.saveRoleUserRoles(role_id, userroles);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("role", parent_role);
		mav.setViewName("role/viewRole.jsp");

		return mav;
	}

	/**
	 * View an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/selectRoleRolePermissions")
	public ModelAndView selectRoleRolePermissions(@RequestParam Integer role_id, @RequestParam Integer rolepermissions_roleId, @RequestParam Integer rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions_roleId, rolepermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("role/rolepermissions/viewRolePermissions.jsp");

		return mav;
	}

	/**
	 * Edit an existing UserRole entity
	 * 
	 */
	@RequestMapping("/editRoleUserRoles")
	public ModelAndView editRoleUserRoles(@RequestParam Integer role_id, @RequestParam Integer userroles_userId, @RequestParam Integer userroles_roleId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userroles_userId, userroles_roleId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("userrole", userrole);
		mav.setViewName("role/userroles/editUserRoles.jsp");

		return mav;
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/deleteRoleRolePermissions")
	public ModelAndView deleteRoleRolePermissions(@RequestParam Integer role_id, @RequestParam Integer related_rolepermissions_roleId, @RequestParam Integer related_rolepermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		Role role = roleService.deleteRoleRolePermissions(role_id, related_rolepermissions_roleId, related_rolepermissions_permissionId);

		mav.addObject("role_id", role_id);
		mav.addObject("role", role);
		mav.setViewName("role/viewRole.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Role entities
	 * 
	 */
	public String indexRole() {
		return "redirect:/indexRole";
	}

	/**
	 * Select the child RolePermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRoleRolePermissions")
	public ModelAndView confirmDeleteRoleRolePermissions(@RequestParam Integer role_id, @RequestParam Integer related_rolepermissions_roleId, @RequestParam Integer related_rolepermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId));
		mav.addObject("role_id", role_id);
		mav.setViewName("role/rolepermissions/deleteRolePermissions.jsp");

		return mav;
	}

	/**
	 * Create a new Role entity
	 * 
	 */
	@RequestMapping("/newRole")
	public ModelAndView newRole() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", new Role());
		mav.addObject("newFlag", true);
		mav.setViewName("role/editRole.jsp");

		return mav;
	}

	/**
	 * Show all RolePermission entities by Role
	 * 
	 */
	@RequestMapping("/listRoleRolePermissions")
	public ModelAndView listRoleRolePermissions(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("role", roleDAO.findRoleByPrimaryKey(idKey));
		mav.setViewName("role/rolepermissions/listRolePermissions.jsp");

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
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/saveRoleRolePermissions")
	public ModelAndView saveRoleRolePermissions(@RequestParam Integer role_id, @ModelAttribute RolePermission rolepermissions) {
		Role parent_role = roleService.saveRoleRolePermissions(role_id, rolepermissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("role_id", role_id);
		mav.addObject("role", parent_role);
		mav.setViewName("role/viewRole.jsp");

		return mav;
	}
}