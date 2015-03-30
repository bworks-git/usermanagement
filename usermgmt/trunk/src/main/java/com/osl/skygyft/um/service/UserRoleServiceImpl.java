package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserRole;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for UserRole entities
 * 
 */

@Service("UserRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	/**
	 * DAO injected by Spring that manages Role entities
	 * 
	 */
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * DAO injected by Spring that manages UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Instantiates a new UserRoleServiceImpl.
	 *
	 */
	public UserRoleServiceImpl() {
	}

	/**
	 * Return all UserRole entity
	 * 
	 */
	@Transactional
	public List<UserRole> findAllUserRoles(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<UserRole>(userRoleDAO.findAllUserRoles(startResult, maxRows));
	}

	/**
	 * Return a count of all UserRole entity
	 * 
	 */
	@Transactional
	public Integer countUserRoles() {
		return ((Long) userRoleDAO.createQuerySingleResult("select count(*) from UserRole o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@Transactional
	public UserRole deleteUserRoleUser(Integer userrole_userId, Integer userrole_roleId, Integer related_user_userId) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		userrole.setUser(null);
		related_user.getUserRoles().remove(userrole);
		userrole = userRoleDAO.store(userrole);
		userRoleDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return userrole;
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@Transactional
	public void saveUserRole(UserRole userrole) {
		UserRole existingUserRole = userRoleDAO.findUserRoleByPrimaryKey(userrole.getUserId(), userrole.getRoleId());

		if (existingUserRole != null) {
			if (existingUserRole != userrole) {
				existingUserRole.setUserId(userrole.getUserId());
				existingUserRole.setRoleId(userrole.getRoleId());
				existingUserRole.setCreateDate(userrole.getCreateDate());
				existingUserRole.setModifiedDate(userrole.getModifiedDate());
				existingUserRole.setCreateBy(userrole.getCreateBy());
				existingUserRole.setModifiedBy(userrole.getModifiedBy());
			}
			userrole = userRoleDAO.store(existingUserRole);
		} else {
			userrole = userRoleDAO.store(userrole);
		}
		userRoleDAO.flush();
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@Transactional
	public UserRole saveUserRoleRole(Integer userId, Integer roleId, Role related_role) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userId, roleId, -1, -1);
		Role existingrole = roleDAO.findRoleByPrimaryKey(related_role.getId());

		// copy into the existing record to preserve existing relationships
		if (existingrole != null) {
			existingrole.setId(related_role.getId());
			existingrole.setRoleId(related_role.getRoleId());
			existingrole.setRole_name(related_role.getRole_name());
			existingrole.setPermissions(related_role.getPermissions());
			existingrole.setModule_id(related_role.getModule_id());
			existingrole.setStatus(related_role.getStatus());
			existingrole.setDescription(related_role.getDescription());
			existingrole.setCreate_date(related_role.getCreate_date());
			existingrole.setModified_date(related_role.getModified_date());
			existingrole.setCreate_by(related_role.getCreate_by());
			existingrole.setModified_by(related_role.getModified_by());
			related_role = existingrole;
		}

		userrole.setRole(related_role);
		related_role.getUserRoles().add(userrole);
		userrole = userRoleDAO.store(userrole);
		userRoleDAO.flush();

		related_role = roleDAO.store(related_role);
		roleDAO.flush();

		return userrole;
	}

	/**
	 */
	@Transactional
	public UserRole findUserRoleByPrimaryKey(Integer userId, Integer roleId) {
		return userRoleDAO.findUserRoleByPrimaryKey(userId, roleId);
	}

	/**
	 * Load an existing UserRole entity
	 * 
	 */
	@Transactional
	public Set<UserRole> loadUserRoles() {
		return userRoleDAO.findAllUserRoles();
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@Transactional
	public UserRole saveUserRoleUser(Integer userId, Integer roleId, User related_user) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userId, roleId, -1, -1);
		User existinguser = userDAO.findUserByPrimaryKey(related_user.getUserId());

		// copy into the existing record to preserve existing relationships
		if (existinguser != null) {
			existinguser.setUserId(related_user.getUserId());
			existinguser.setLoginId(related_user.getLoginId());
			existinguser.setPassword(related_user.getPassword());
			existinguser.setFirst_name(related_user.getFirst_name());
			existinguser.setLast_name(related_user.getLast_name());
			existinguser.setEmail(related_user.getEmail());
			existinguser.setMob_country_prefix(related_user.getMob_country_prefix());
			existinguser.setMobile(related_user.getMobile());
			existinguser.setUserType(related_user.getUserType());
			existinguser.setUserEntityType(related_user.getUserEntityType());
			existinguser.setEntityId(related_user.getEntityId());
			existinguser.setUserRole(related_user.getUserRole());
			existinguser.setPermissionNegative(related_user.getPermissionNegative());
			existinguser.setPermissionPositive(related_user.getPermissionPositive());
			existinguser.setStatus(related_user.getStatus());
			existinguser.setToken(related_user.getToken());
			existinguser.setLoginToken(related_user.getLoginToken());
			existinguser.setHashStatus(related_user.getHashStatus());
			existinguser.setCreateDate(related_user.getCreateDate());
			existinguser.setModifiedDate(related_user.getModifiedDate());
			existinguser.setCreateBy(related_user.getCreateBy());
			existinguser.setModifiedBy(related_user.getModifiedBy());
			existinguser.setLoginId1(related_user.getLoginId1());
			existinguser.setLoginId2(related_user.getLoginId2());
			existinguser.setLoginId3(related_user.getLoginId3());
			existinguser.setLoginId4(related_user.getLoginId4());
			existinguser.setLoginId5(related_user.getLoginId5());
			existinguser.setEmail1(related_user.getEmail1());
			existinguser.setEmail2(related_user.getEmail2());
			existinguser.setMobile1(related_user.getMobile1());
			existinguser.setMobile2(related_user.getMobile2());
			existinguser.setLoginType(related_user.getLoginType());
			existinguser.setPrimaryLogin(related_user.getPrimaryLogin());
			existinguser.setFavouriteIps(related_user.getFavouriteIps());
			existinguser.setFavouriteAgents(related_user.getFavouriteAgents());
			related_user = existinguser;
		}

		userrole.setUser(related_user);
		related_user.getUserRoles().add(userrole);
		userrole = userRoleDAO.store(userrole);
		userRoleDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return userrole;
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@Transactional
	public void deleteUserRole(UserRole userrole) {
		userRoleDAO.remove(userrole);
		userRoleDAO.flush();
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@Transactional
	public UserRole deleteUserRoleRole(Integer userrole_userId, Integer userrole_roleId, Integer related_role_id) {
		UserRole userrole = userRoleDAO.findUserRoleByPrimaryKey(userrole_userId, userrole_roleId, -1, -1);
		Role related_role = roleDAO.findRoleByPrimaryKey(related_role_id, -1, -1);

		userrole.setRole(null);
		related_role.getUserRoles().remove(userrole);
		userrole = userRoleDAO.store(userrole);
		userRoleDAO.flush();

		related_role = roleDAO.store(related_role);
		roleDAO.flush();

		roleDAO.remove(related_role);
		roleDAO.flush();

		return userrole;
	}
}
