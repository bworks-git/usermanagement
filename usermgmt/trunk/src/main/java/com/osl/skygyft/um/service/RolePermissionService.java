package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for RolePermission entities
 * 
 */
public interface RolePermissionService {

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	public void deleteRolePermission(RolePermission rolepermission);

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public RolePermission deleteRolePermissionPermission(Integer rolepermission_roleId, Integer rolepermission_permissionId, Integer related_permission_id);

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	public void saveRolePermission(RolePermission rolepermission_1);

	/**
	 * Delete an existing Role entity
	 * 
	 */
	public RolePermission deleteRolePermissionRole(Integer rolepermission_roleId_1, Integer rolepermission_permissionId_1, Integer related_role_id);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public RolePermission saveRolePermissionPermission(Integer roleId, Integer permissionId, Permission related_permission);

	/**
	 * Load an existing RolePermission entity
	 * 
	 */
	public Set<RolePermission> loadRolePermissions();

	/**
	 */
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId_1, Integer permissionId_1);

	/**
	 * Return a count of all RolePermission entity
	 * 
	 */
	public Integer countRolePermissions();

	/**
	 * Return all RolePermission entity
	 * 
	 */
	public List<RolePermission> findAllRolePermissions(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Role entity
	 * 
	 */
	public RolePermission saveRolePermissionRole(Integer roleId_2, Integer permissionId_2, Role related_role);
}