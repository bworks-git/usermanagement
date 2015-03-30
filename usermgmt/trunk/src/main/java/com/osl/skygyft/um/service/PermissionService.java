package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserPermission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */
public interface PermissionService {

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	public Permission savePermissionRolePermissions(Integer id, RolePermission related_rolepermissions);

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	public Integer countPermissions();

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public void deletePermission(Permission permission);

	/**
	 * Load an existing Permission entity
	 * 
	 */
	public Set<Permission> loadPermissions();

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	public Permission savePermissionUserPermissions(Integer id_1, UserPermission related_userpermissions);

	/**
	 */
	public Permission findPermissionByPrimaryKey(Integer id_2);

	/**
	 * Return all Permission entity
	 * 
	 */
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	public Permission deletePermissionUserPermissions(Integer permission_id, Integer related_userpermissions_userId, Integer related_userpermissions_permissionId);

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	public Permission deletePermissionRolePermissions(Integer permission_id_1, Integer related_rolepermissions_roleId, Integer related_rolepermissions_permissionId);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public void savePermission(Permission permission_1);
}