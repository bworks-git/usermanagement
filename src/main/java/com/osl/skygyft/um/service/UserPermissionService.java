package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for UserPermission entities
 * 
 */
public interface UserPermissionService {

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	public UserPermission deleteUserPermissionPermission(Integer userpermission_userId, Integer userpermission_permissionId, Integer related_permission_id);

	/**
	 * Return a count of all UserPermission entity
	 * 
	 */
	public Integer countUserPermissions();

	/**
	 * Save an existing User entity
	 * 
	 */
	public UserPermission saveUserPermissionUser(Integer userId, Integer permissionId, User related_user);

	/**
	 * Load an existing UserPermission entity
	 * 
	 */
	public Set<UserPermission> loadUserPermissions();

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	public void deleteUserPermission(UserPermission userpermission);

	/**
	 * Save an existing Permission entity
	 * 
	 */
	public UserPermission saveUserPermissionPermission(Integer userId_1, Integer permissionId_1, Permission related_permission);

	/**
	 * Delete an existing User entity
	 * 
	 */
	public UserPermission deleteUserPermissionUser(Integer userpermission_userId_1, Integer userpermission_permissionId_1, Integer related_user_userId);

	/**
	 */
	public UserPermission findUserPermissionByPrimaryKey(Integer userId_2, Integer permissionId_2);

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	public void saveUserPermission(UserPermission userpermission_1);

	/**
	 * Return all UserPermission entity
	 * 
	 */
	public List<UserPermission> findAllUserPermissions(Integer startResult, Integer maxRows);
}