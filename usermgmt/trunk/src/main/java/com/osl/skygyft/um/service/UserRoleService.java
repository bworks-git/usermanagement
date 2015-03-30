package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for UserRole entities
 * 
 */
public interface UserRoleService {

	/**
	 * Return all UserRole entity
	 * 
	 */
	public List<UserRole> findAllUserRoles(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all UserRole entity
	 * 
	 */
	public Integer countUserRoles();

	/**
	 * Delete an existing User entity
	 * 
	 */
	public UserRole deleteUserRoleUser(Integer userrole_userId, Integer userrole_roleId, Integer related_user_userId);

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	public void saveUserRole(UserRole userrole);

	/**
	 * Save an existing Role entity
	 * 
	 */
	public UserRole saveUserRoleRole(Integer userId, Integer roleId, Role related_role);

	/**
	 */
	public UserRole findUserRoleByPrimaryKey(Integer userId_1, Integer roleId_1);

	/**
	 * Load an existing UserRole entity
	 * 
	 */
	public Set<UserRole> loadUserRoles();

	/**
	 * Save an existing User entity
	 * 
	 */
	public UserRole saveUserRoleUser(Integer userId_2, Integer roleId_2, User related_user);

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	public void deleteUserRole(UserRole userrole_1);

	/**
	 * Delete an existing Role entity
	 * 
	 */
	public UserRole deleteUserRoleRole(Integer userrole_userId_1, Integer userrole_roleId_1, Integer related_role_id);
}