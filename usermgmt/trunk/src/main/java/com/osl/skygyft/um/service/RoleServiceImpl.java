package com.osl.skygyft.um.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;
import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserRole;

/**
 * Spring service that handles CRUD requests for Role entities
 * 
 */

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

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
	
	@Autowired
	private PermissionService permissionService;

	/**
	 * Instantiates a new RoleServiceImpl.
	 *
	 */
	public RoleServiceImpl() {
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@Transactional
	public Role deleteRoleRolePermissions(Integer role_id, Integer related_rolepermissions_roleId, Integer related_rolepermissions_permissionId) {
		RolePermission related_rolepermissions = rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId, -1, -1);

		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		related_rolepermissions.setRole(null);
//		role.getRolePermissions().remove(related_rolepermissions);

		rolePermissionDAO.remove(related_rolepermissions);
		rolePermissionDAO.flush();

		return role;
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@Transactional
	public Role saveRoleRolePermissions(Integer id, RolePermission related_rolepermissions) {
		Role role = roleDAO.findRoleByPrimaryKey(id, -1, -1);
		RolePermission existingrolePermissions = rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions.getRoleId(), related_rolepermissions.getPermissionId());

		// copy into the existing record to preserve existing relationships
		if (existingrolePermissions != null) {
			existingrolePermissions.setRoleId(related_rolepermissions.getRoleId());
			existingrolePermissions.setPermissionId(related_rolepermissions.getPermissionId());
			existingrolePermissions.setCreateDate(related_rolepermissions.getCreateDate());
			existingrolePermissions.setModifiedDate(related_rolepermissions.getModifiedDate());
			existingrolePermissions.setCreateBy(related_rolepermissions.getCreateBy());
			existingrolePermissions.setModifiedBy(related_rolepermissions.getModifiedBy());
			related_rolepermissions = existingrolePermissions;
		}

		related_rolepermissions.setRole(role);
//		role.getRolePermissions().add(related_rolepermissions);
		related_rolepermissions = rolePermissionDAO.store(related_rolepermissions);
		rolePermissionDAO.flush();

		role = roleDAO.store(role);
		roleDAO.flush();

		return role;
	}

	/**
	 */
	@Transactional
	public Role findRoleByPrimaryKey(Integer id) {
		return roleDAO.findRoleByPrimaryKey(id);
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@Transactional
	public Role deleteRoleUserRoles(Integer role_id, Integer related_userroles_userId, Integer related_userroles_roleId) {
		UserRole related_userroles = userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId, -1, -1);

		Role role = roleDAO.findRoleByPrimaryKey(role_id, -1, -1);

		related_userroles.setRole(null);
		role.getUserRoles().remove(related_userroles);

		userRoleDAO.remove(related_userroles);
		userRoleDAO.flush();

		return role;
	}

	/**
	 * Return all Role entity
	 * 
	 */
	@Transactional
	public List<Role> findAllRoles(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Role>(roleDAO.findAllRoles(startResult, maxRows));
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@Transactional
	public void deleteRole(Role role) {
		roleDAO.remove(role);
		roleDAO.flush();
	}

	/**
	 * Return a count of all Role entity
	 * 
	 */
	@Transactional
	public Integer countRoles() {
		return ((Long) roleDAO.createQuerySingleResult("select count(o) from Role o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Role entity
	 * 
	 */
	@Transactional
	public List<Role> loadRoles() {
		return roleDAO.findAllRoles();
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@Transactional
	public Role saveRoleUserRoles(Integer id, UserRole related_userroles) {
		Role role = roleDAO.findRoleByPrimaryKey(id, -1, -1);
		UserRole existinguserRoles = userRoleDAO.findUserRoleByPrimaryKey(related_userroles.getUserId(), related_userroles.getRoleId());

		// copy into the existing record to preserve existing relationships
		if (existinguserRoles != null) {
			existinguserRoles.setUserId(related_userroles.getUserId());
			existinguserRoles.setRoleId(related_userroles.getRoleId());
			existinguserRoles.setCreateDate(related_userroles.getCreateDate());
			existinguserRoles.setModifiedDate(related_userroles.getModifiedDate());
			existinguserRoles.setCreateBy(related_userroles.getCreateBy());
			existinguserRoles.setModifiedBy(related_userroles.getModifiedBy());
			related_userroles = existinguserRoles;
		}

		related_userroles.setRole(role);
		role.getUserRoles().add(related_userroles);
		related_userroles = userRoleDAO.store(related_userroles);
		userRoleDAO.flush();

		role = roleDAO.store(role);
		roleDAO.flush();

		return role;
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@Transactional
	public void saveRole(Role role) {
		Role existingRole = null;
		if(role.getId() != null){
			existingRole = roleDAO.findRoleByPrimaryKey(role.getId());
		}
		if (existingRole != null) {
			if (existingRole != role) {
				existingRole.setModule_id(role.getId());
				existingRole.setId(role.getId());
				existingRole.setRoleId(role.getRoleId());
				existingRole.setRole_name(role.getRole_name());
				existingRole.setPermissions(role.getPermissions());
				existingRole.setPermissionSet(getPermissionSet(role.getPermissions()));
				existingRole.setModule_id(role.getModule_id());
				existingRole.setStatus(role.getStatus());
				existingRole.setDescription(role.getDescription());
				if(existingRole.getCreate_date() == null)
					existingRole.setCreate_date(Calendar.getInstance());
				existingRole.setModified_date(Calendar.getInstance());
				existingRole.setModified_by("logged_in_user");
			}
			role = roleDAO.store(existingRole);
		} else {
			role.setModule_id(1);
			role.setCreate_by("System");
			role.setCreate_date(Calendar.getInstance());
			role.setModified_date(Calendar.getInstance());
			role.setModified_by("System");
			role.setPermissionSet(getPermissionSet(role.getPermissions()));
			role = roleDAO.store(role);
			System.out.println("************** Role Id : "+role.getRoleId());
		}
		roleDAO.flush();
	}

	private Set<Permission> getPermissionSet(String permissions) {
		Set<Permission> permissionsSet = null;
		if(StringUtils.isNotBlank(permissions)){
			permissionsSet = new HashSet<Permission>();
			String[] permissionArr = StringUtils.split(permissions,",");
			for(int i=0; i<permissionArr.length;i++){
				if(NumberUtils.isNumber(permissionArr[i])){
					Permission permission = new Permission();
					permission.setId(Integer.parseInt(permissionArr[i]));
					permissionsSet.add(permission);
				}
			}
		}
		return permissionsSet;
	}
}
