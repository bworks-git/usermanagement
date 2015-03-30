package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for UserPermission entities
 * 
 */

@Service("UserPermissionService")
@Transactional
public class UserPermissionServiceImpl implements UserPermissionService {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * DAO injected by Spring that manages UserPermission entities
	 * 
	 */
	@Autowired
	private UserPermissionDAO userPermissionDAO;

	/**
	 * Instantiates a new UserPermissionServiceImpl.
	 *
	 */
	public UserPermissionServiceImpl() {
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public UserPermission deleteUserPermissionPermission(Integer userpermission_userId, Integer userpermission_permissionId, Integer related_permission_id) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId, -1, -1);
		Permission related_permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		userpermission.setPermission(null);
		related_permission.getUserPermissions().remove(userpermission);
		userpermission = userPermissionDAO.store(userpermission);
		userPermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		permissionDAO.remove(related_permission);
		permissionDAO.flush();

		return userpermission;
	}

	/**
	 * Return a count of all UserPermission entity
	 * 
	 */
	@Transactional
	public Integer countUserPermissions() {
		return ((Long) userPermissionDAO.createQuerySingleResult("select count(*) from UserPermission o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@Transactional
	public UserPermission saveUserPermissionUser(Integer userId, Integer permissionId, User related_user) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userId, permissionId, -1, -1);
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

		userpermission.setUser(related_user);
		related_user.getUserPermissions().add(userpermission);
		userpermission = userPermissionDAO.store(userpermission);
		userPermissionDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return userpermission;
	}

	/**
	 * Load an existing UserPermission entity
	 * 
	 */
	@Transactional
	public Set<UserPermission> loadUserPermissions() {
		return userPermissionDAO.findAllUserPermissions();
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@Transactional
	public void deleteUserPermission(UserPermission userpermission) {
		userPermissionDAO.remove(userpermission);
		userPermissionDAO.flush();
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public UserPermission saveUserPermissionPermission(Integer userId, Integer permissionId, Permission related_permission) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userId, permissionId, -1, -1);
		Permission existingpermission = permissionDAO.findPermissionByPrimaryKey(related_permission.getId());

		// copy into the existing record to preserve existing relationships
		if (existingpermission != null) {
			existingpermission.setId(related_permission.getId());
			existingpermission.setPermId(related_permission.getPermId());
			existingpermission.setPermissionName(related_permission.getPermissionName());
			existingpermission.setModuleId(related_permission.getModuleId());
			existingpermission.setDescription(related_permission.getDescription());
			existingpermission.setStatus(related_permission.getStatus());
			existingpermission.setCreateDate(related_permission.getCreateDate());
			existingpermission.setModifiedDate(related_permission.getModifiedDate());
			existingpermission.setCreateBy(related_permission.getCreateBy());
			existingpermission.setModifiedBy(related_permission.getModifiedBy());
			related_permission = existingpermission;
		}

		userpermission.setPermission(related_permission);
		related_permission.getUserPermissions().add(userpermission);
		userpermission = userPermissionDAO.store(userpermission);
		userPermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		return userpermission;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@Transactional
	public UserPermission deleteUserPermissionUser(Integer userpermission_userId, Integer userpermission_permissionId, Integer related_user_userId) {
		UserPermission userpermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermission_userId, userpermission_permissionId, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		userpermission.setUser(null);
		related_user.getUserPermissions().remove(userpermission);
		userpermission = userPermissionDAO.store(userpermission);
		userPermissionDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return userpermission;
	}

	/**
	 */
	@Transactional
	public UserPermission findUserPermissionByPrimaryKey(Integer userId, Integer permissionId) {
		return userPermissionDAO.findUserPermissionByPrimaryKey(userId, permissionId);
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@Transactional
	public void saveUserPermission(UserPermission userpermission) {
		UserPermission existingUserPermission = userPermissionDAO.findUserPermissionByPrimaryKey(userpermission.getUserId(), userpermission.getPermissionId());

		if (existingUserPermission != null) {
			if (existingUserPermission != userpermission) {
				existingUserPermission.setUserId(userpermission.getUserId());
				existingUserPermission.setPermissionId(userpermission.getPermissionId());
				existingUserPermission.setCreateDate(userpermission.getCreateDate());
				existingUserPermission.setModifiedDate(userpermission.getModifiedDate());
				existingUserPermission.setCreateBy(userpermission.getCreateBy());
				existingUserPermission.setModifiedBy(userpermission.getModifiedBy());
				existingUserPermission.setPermissionType(userpermission.getPermissionType());
			}
			userpermission = userPermissionDAO.store(existingUserPermission);
		} else {
			userpermission = userPermissionDAO.store(userpermission);
		}
		userPermissionDAO.flush();
	}

	/**
	 * Return all UserPermission entity
	 * 
	 */
	@Transactional
	public List<UserPermission> findAllUserPermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<UserPermission>(userPermissionDAO.findAllUserPermissions(startResult, maxRows));
	}
}
