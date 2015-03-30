package com.osl.skygyft.um.web;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.osl.skygyft.um.constants.ApplicationConstants;
import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;
import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserPermission;
import com.osl.skygyft.um.service.PermissionService;
import com.osl.skygyft.um.utils.ResponseUtils;
import com.osl.skygyft.um.vo.Response;

/**
 * Spring MVC controller that handles CRUD requests for Permission entities
 * 
 */

@Controller("PermissionController")
public class PermissionController {

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
	@RequestMapping("/permissions")
	public ModelAndView listPermissions() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permissions", permissionService.loadPermissions());

		mav.setViewName("permissions");

		return mav;
	}

	@RequestMapping("/addPermission")
	public String addPermission(ModelMap model,@ModelAttribute Permission permission,
			HttpSession session) {
		permission.setStatus(true);
		model.addAttribute("permission",permission);
		ResponseUtils.buildResponseObject(ApplicationConstants.OP_TYPE_ADD,model, session);
		return "addPermission";
	}
	
	/**
	 * Edit an existing Permission entity
	 * 
	 */
	@RequestMapping("/editPermission")
	public String editPermission(ModelMap model,@ModelAttribute Permission permission,
			@RequestParam(required=false) Integer id,
			HttpSession session) {
		Response response = ResponseUtils.buildResponseObject(ApplicationConstants.OP_TYPE_EDIT,model, session);
		if((StringUtils.isBlank(response.getStatus()) || StringUtils.equals(ApplicationConstants.SUCCESS,response.getStatus()))
				&& (id != null || permission.getId() != null)){
			if(id == null){
				id = permission.getId();
			}
			permission = permissionDAO.findPermissionByPrimaryKey(id);
		}
		model.addAttribute("permission",permission);
		return "addPermission";
	}


	/**
	 * create or update Permission entity
	 * 
	 */
	@RequestMapping("/savePermission")
	public String savePermission(@ModelAttribute Permission permission,
			HttpSession session, RedirectAttributes redirectAttributes,
			@RequestParam String operationType) {
		String status = ApplicationConstants.SUCCESS;
		String message = "Permission"+ ApplicationConstants.MESSAGE_MAP.get(operationType);
		try{
			permissionService.savePermission(permission);
		}
		/*catch(PersistenceException | ConstraintViolationException constraintViolationException){
			status = ApplicationConstants.ERROR;
			message = "Permission Name already exists";
			constraintViolationException.printStackTrace();
		}*/
		catch(Exception e){
			status = ApplicationConstants.ERROR;
			message = ApplicationConstants.SERVER_ERROR_MSG;
			e.printStackTrace();
		}
		if(!StringUtils.equals(status, ApplicationConstants.SUCCESS) || 
				StringUtils.equals(operationType, ApplicationConstants.OP_TYPE_EDIT)){
			redirectAttributes.addFlashAttribute("permission", permission);
		}
		session.setAttribute(ApplicationConstants.STATUS, status);
		session.setAttribute(ApplicationConstants.MESSAGE, message);
		return "redirect:"+operationType.toLowerCase()+"Permission";
	}
	
	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@RequestMapping("/deletePermission")
	public @ResponseBody Response deletePermission(@RequestParam Integer id) {
		Response response = ResponseUtils.getSuccessResponse("permissions");
		Permission permission =  null;
		try{
		permission = permissionDAO.findPermissionByPrimaryKey(id);
		permissionService.deletePermission(permission);
		}
		catch(PersistenceException persistenceException){
			persistenceException.printStackTrace();
			response = ResponseUtils.getFailureResponse("Cannot delete "+permission.getPermissionName()+", Since it is mapped with some role(s)");
		}
		return response;
	}
	
	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/deletePermissionRolePermissions")
	public ModelAndView deletePermissionRolePermissions(@RequestParam Integer permission_id, @RequestParam Integer related_rolepermissions_roleId, @RequestParam Integer related_rolepermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		Permission permission = permissionService.deletePermissionRolePermissions(permission_id, related_rolepermissions_roleId, related_rolepermissions_permissionId);

		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/savePermissionUserPermissions")
	public ModelAndView savePermissionUserPermissions(@RequestParam Integer permission_id, @ModelAttribute UserPermission userpermissions) {
		Permission parent_permission = permissionService.savePermissionUserPermissions(permission_id, userpermissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", parent_permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Select the Permission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermission")
	public ModelAndView confirmDeletePermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/deletePermission.jsp");

		return mav;
	}

	/**
	 * Select the child UserPermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermissionUserPermissions")
	public ModelAndView confirmDeletePermissionUserPermissions(@RequestParam Integer permission_id, @RequestParam Integer related_userpermissions_userId, @RequestParam Integer related_userpermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("userpermission", userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId));
		mav.addObject("permission_id", permission_id);
		mav.setViewName("permission/userpermissions/deleteUserPermissions.jsp");

		return mav;
	}


	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/savePermissionRolePermissions")
	public ModelAndView savePermissionRolePermissions(@RequestParam Integer permission_id, @ModelAttribute RolePermission rolepermissions) {
		Permission parent_permission = permissionService.savePermissionRolePermissions(permission_id, rolepermissions);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", parent_permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * View an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/selectPermissionRolePermissions")
	public ModelAndView selectPermissionRolePermissions(@RequestParam Integer permission_id, @RequestParam Integer rolepermissions_roleId, @RequestParam Integer rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions_roleId, rolepermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("permission/rolepermissions/viewRolePermissions.jsp");

		return mav;
	}

	/**
	 * Show all UserPermission entities by Permission
	 * 
	 */
	@RequestMapping("/listPermissionUserPermissions")
	public ModelAndView listPermissionUserPermissions(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/userpermissions/listUserPermissions.jsp");

		return mav;
	}

	/**
	 * Edit an existing RolePermission entity
	 * 
	 */
	@RequestMapping("/editPermissionRolePermissions")
	public ModelAndView editPermissionRolePermissions(@RequestParam Integer permission_id, @RequestParam Integer rolepermissions_roleId, @RequestParam Integer rolepermissions_permissionId) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermissions_roleId, rolepermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("rolepermission", rolepermission);
		mav.setViewName("permission/rolepermissions/editRolePermissions.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Permission entities
	 * 
	 */
	public String indexPermission() {
		return "redirect:/indexPermission";
	}

	/**
	 * Create a new Permission entity
	 * 
	 */
	@RequestMapping("/newPermission")
	public ModelAndView newPermission() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", new Permission());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/editPermission.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/permissionController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/deletePermissionUserPermissions")
	public ModelAndView deletePermissionUserPermissions(@RequestParam Integer permission_id, @RequestParam Integer related_userpermissions_userId, @RequestParam Integer related_userpermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		Permission permission = permissionService.deletePermissionUserPermissions(permission_id, related_userpermissions_userId, related_userpermissions_permissionId);

		mav.addObject("permission_id", permission_id);
		mav.addObject("permission", permission);
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Edit an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/editPermissionUserPermissions")
	public ModelAndView editPermissionUserPermissions(@RequestParam Integer permission_id, @RequestParam Integer userpermissions_userId, @RequestParam Integer userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions_userId, userpermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("permission/userpermissions/editUserPermissions.jsp");

		return mav;
	}


	/**
	 * Create a new UserPermission entity
	 * 
	 */
	@RequestMapping("/newPermissionUserPermissions")
	public ModelAndView newPermissionUserPermissions(@RequestParam Integer permission_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("userpermission", new UserPermission());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/userpermissions/editUserPermissions.jsp");

		return mav;
	}

	/**
	 * View an existing UserPermission entity
	 * 
	 */
	@RequestMapping("/selectPermissionUserPermissions")
	public ModelAndView selectPermissionUserPermissions(@RequestParam Integer permission_id, @RequestParam Integer userpermissions_userId, @RequestParam Integer userpermissions_permissionId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermissions_userId, userpermissions_permissionId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("userpermission", userpermission);
		mav.setViewName("permission/userpermissions/viewUserPermissions.jsp");

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
	 * Select the child RolePermission entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeletePermissionRolePermissions")
	public ModelAndView confirmDeletePermissionRolePermissions(@RequestParam Integer permission_id, @RequestParam Integer related_rolepermissions_roleId, @RequestParam Integer related_rolepermissions_permissionId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("rolepermission", rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId));
		mav.addObject("permission_id", permission_id);
		mav.setViewName("permission/rolepermissions/deleteRolePermissions.jsp");

		return mav;
	}

	/**
	 * Show all RolePermission entities by Permission
	 * 
	 */
	@RequestMapping("/listPermissionRolePermissions")
	public ModelAndView listPermissionRolePermissions(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/rolepermissions/listRolePermissions.jsp");

		return mav;
	}

	/**
	 * Select an existing Permission entity
	 * 
	 */
	@RequestMapping("/selectPermission")
	public ModelAndView selectPermission(@RequestParam Integer idKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("permission", permissionDAO.findPermissionByPrimaryKey(idKey));
		mav.setViewName("permission/viewPermission.jsp");

		return mav;
	}

	/**
	 * Create a new RolePermission entity
	 * 
	 */
	@RequestMapping("/newPermissionRolePermissions")
	public ModelAndView newPermissionRolePermissions(@RequestParam Integer permission_id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("permission_id", permission_id);
		mav.addObject("rolepermission", new RolePermission());
		mav.addObject("newFlag", true);
		mav.setViewName("permission/rolepermissions/editRolePermissions.jsp");

		return mav;
	}
}