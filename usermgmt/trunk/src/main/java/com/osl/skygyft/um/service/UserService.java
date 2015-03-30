package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;
import com.osl.skygyft.um.domain.UserRole;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 */
public interface UserService {

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	public User deleteUserUserRoles(Integer user_userId, Integer related_userroles_userId, Integer related_userroles_roleId);

	/**
	 */
	public User findUserByPrimaryKey(Integer userId);

	/**
	 * Return a count of all User entity
	 * 
	 */
	public Integer countUsers();

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	public User saveUserAuditTrials(Integer userId_1, AuditTrial related_audittrials);

	/**
	 * Delete an existing User entity
	 * 
	 */
	public void deleteUser(User user);

	/**
	 * Return all User entity
	 * 
	 */
	public List<User> findAllUsers(Integer startResult, Integer maxRows);

	/**
	 * Load an existing User entity
	 * 
	 */
	public List<User> loadUsers();

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	public User deleteUserUserPermissions(Integer user_userId_1, Integer related_userpermissions_userId, Integer related_userpermissions_permissionId);

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	public User saveUserUserRoles(Integer userId_2, UserRole related_userroles);

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	public User saveUserUserPermissions(Integer userId_3, UserPermission related_userpermissions);

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	public User deleteUserAuditTrials(Integer user_userId_2, Integer related_audittrials_auditId);

	/**
	 * Save an existing User entity
	 * 
	 */
	public void saveUser(User user_1);

	public List<User> findUsersForSearch(int i, Integer pageDisplayLength,
			String searchParameter);

	public Integer countForSearch(String searchParameter);

	public User getByLogin(String login);
}