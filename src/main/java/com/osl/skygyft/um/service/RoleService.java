package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Role entities
 * 
 */
public interface RoleService {

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	public Role deleteRoleRolePermissions(Integer role_id, Integer related_rolepermissions_roleId, Integer related_rolepermissions_permissionId);

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	public Role saveRoleRolePermissions(Integer id, RolePermission related_rolepermissions);

	/**
	 */
	public Role findRoleByPrimaryKey(Integer id_1);

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	public Role deleteRoleUserRoles(Integer role_id_1, Integer related_userroles_userId, Integer related_userroles_roleId);

	/**
	 * Return all Role entity
	 * 
	 */
	public List<Role> findAllRoles(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Role entity
	 * 
	 */
	public void deleteRole(Role role);

	/**
	 * Return a count of all Role entity
	 * 
	 */
	public Integer countRoles();

	/**
	 * Load an existing Role entity
	 * 
	 */
	public List<Role> loadRoles();

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	public Role saveRoleUserRoles(Integer id_2, UserRole related_userroles);

	/**
	 * Save an existing Role entity
	 * 
	 */
	public void saveRole(Role role_1);
}