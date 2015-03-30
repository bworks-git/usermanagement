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

import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;
import com.osl.skygyft.um.dao.UserRoleDAO;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;
import com.osl.skygyft.um.domain.UserPermission;
import com.osl.skygyft.um.domain.UserRole;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * DAO injected by Spring that manages AuditTrial entities
	 * 
	 */
	@Autowired
	private AuditTrialDAO auditTrialDAO;

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
	 * DAO injected by Spring that manages UserRole entities
	 * 
	 */
	@Autowired
	private UserRoleDAO userRoleDAO;

	/**
	 * Instantiates a new UserServiceImpl.
	 *
	 */
	public UserServiceImpl() {
	}

	/**
	 * Delete an existing UserRole entity
	 * 
	 */
	@Transactional
	public User deleteUserUserRoles(Integer user_userId, Integer related_userroles_userId, Integer related_userroles_roleId) {
		UserRole related_userroles = userRoleDAO.findUserRoleByPrimaryKey(related_userroles_userId, related_userroles_roleId, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		related_userroles.setUser(null);
		user.getUserRoles().remove(related_userroles);

		userRoleDAO.remove(related_userroles);
		userRoleDAO.flush();

		return user;
	}

	/**
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer userId) {
		return userDAO.findUserByPrimaryKey(userId);
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public User saveUserAuditTrials(Integer userId, AuditTrial related_audittrials) {
		User user = userDAO.findUserByPrimaryKey(userId, -1, -1);
		AuditTrial existingauditTrials = auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials.getAuditId());

		// copy into the existing record to preserve existing relationships
		if (existingauditTrials != null) {
			existingauditTrials.setAuditId(related_audittrials.getAuditId());
			existingauditTrials.setIpAddress(related_audittrials.getIpAddress());
			existingauditTrials.setUserAgent(related_audittrials.getUserAgent());
			existingauditTrials.setKeyword(related_audittrials.getKeyword());
			existingauditTrials.setDescription(related_audittrials.getDescription());
			existingauditTrials.setDateAdded(related_audittrials.getDateAdded());
			existingauditTrials.setSuccesFailureFlag(related_audittrials.getSuccesFailureFlag());
			existingauditTrials.setUserTypeFlag(related_audittrials.getUserTypeFlag());
			related_audittrials = existingauditTrials;
		} else {
			related_audittrials = auditTrialDAO.store(related_audittrials);
			auditTrialDAO.flush();
		}

		related_audittrials.setUser(user);
		user.getAuditTrials().add(related_audittrials);
		related_audittrials = auditTrialDAO.store(related_audittrials);
		auditTrialDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@Transactional
	public void deleteUser(User user) {
		userDAO.remove(user);
		userDAO.flush();
	}

	/**
	 * Load an existing User entity
	 * 
	 */
	@Transactional
	public List<User> loadUsers() {
		return userDAO.findAllUsers();
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@Transactional
	public User deleteUserUserPermissions(Integer user_userId, Integer related_userpermissions_userId, Integer related_userpermissions_permissionId) {
		UserPermission related_userpermissions = userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		related_userpermissions.setUser(null);
		user.getUserPermissions().remove(related_userpermissions);

		userPermissionDAO.remove(related_userpermissions);
		userPermissionDAO.flush();

		return user;
	}

	/**
	 * Save an existing UserRole entity
	 * 
	 */
	@Transactional
	public User saveUserUserRoles(Integer userId, UserRole related_userroles) {
		User user = userDAO.findUserByPrimaryKey(userId, -1, -1);
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

		related_userroles.setUser(user);
		user.getUserRoles().add(related_userroles);
		related_userroles = userRoleDAO.store(related_userroles);
		userRoleDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@Transactional
	public User saveUserUserPermissions(Integer userId, UserPermission related_userpermissions) {
		User user = userDAO.findUserByPrimaryKey(userId, -1, -1);
		UserPermission existinguserPermissions = userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions.getUserId(), related_userpermissions.getPermissionId());

		// copy into the existing record to preserve existing relationships
		if (existinguserPermissions != null) {
			existinguserPermissions.setUserId(related_userpermissions.getUserId());
			existinguserPermissions.setPermissionId(related_userpermissions.getPermissionId());
			existinguserPermissions.setCreateDate(related_userpermissions.getCreateDate());
			existinguserPermissions.setModifiedDate(related_userpermissions.getModifiedDate());
			existinguserPermissions.setCreateBy(related_userpermissions.getCreateBy());
			existinguserPermissions.setModifiedBy(related_userpermissions.getModifiedBy());
			existinguserPermissions.setPermissionType(related_userpermissions.getPermissionType());
			related_userpermissions = existinguserPermissions;
		}

		related_userpermissions.setUser(user);
		user.getUserPermissions().add(related_userpermissions);
		related_userpermissions = userPermissionDAO.store(related_userpermissions);
		userPermissionDAO.flush();

		user = userDAO.store(user);
		userDAO.flush();

		return user;
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public User deleteUserAuditTrials(Integer user_userId, Integer related_audittrials_auditId) {
		AuditTrial related_audittrials = auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId, -1, -1);

		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);

		related_audittrials.setUser(null);
		user.getAuditTrials().remove(related_audittrials);

		auditTrialDAO.remove(related_audittrials);
		auditTrialDAO.flush();

		return user;
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@Transactional
	public void saveUser(User user) {
		User existingUser = userDAO.findUserByPrimaryKey(user.getUserId());

		if (existingUser != null) {
			if (existingUser != user) {
				existingUser.setUserId(user.getUserId());
				existingUser.setLoginId(user.getLoginId());
				existingUser.setPassword(user.getPassword());
				existingUser.setFirst_name(user.getFirst_name());
				existingUser.setLast_name(user.getLast_name());
				existingUser.setEmail(user.getEmail());
				existingUser.setMob_country_prefix(user.getMob_country_prefix());
				existingUser.setMobile(user.getMobile());
				existingUser.setUserType(user.getUserType());
				existingUser.setUserEntityType(user.getUserEntityType());
				existingUser.setEntityId(user.getEntityId());
				existingUser.setUserRole(user.getUserRole());
				existingUser.setPermissionNegative(user.getPermissionNegative());
				existingUser.setPermissionPositive(user.getPermissionPositive());
				existingUser.setStatus(user.getStatus());
				existingUser.setToken(user.getToken());
				existingUser.setLoginToken(user.getLoginToken());
				existingUser.setHashStatus(user.getHashStatus());
				existingUser.setCreateDate(user.getCreateDate());
				existingUser.setModifiedDate(user.getModifiedDate());
				existingUser.setCreateBy(user.getCreateBy());
				existingUser.setModifiedBy(user.getModifiedBy());
				existingUser.setLoginId1(user.getLoginId1());
				existingUser.setLoginId2(user.getLoginId2());
				existingUser.setLoginId3(user.getLoginId3());
				existingUser.setLoginId4(user.getLoginId4());
				existingUser.setLoginId5(user.getLoginId5());
				existingUser.setEmail1(user.getEmail1());
				existingUser.setEmail2(user.getEmail2());
				existingUser.setMobile1(user.getMobile1());
				existingUser.setMobile2(user.getMobile2());
				existingUser.setLoginType(user.getLoginType());
				existingUser.setPrimaryLogin(user.getPrimaryLogin());
				existingUser.setFavouriteIps(user.getFavouriteIps());
				existingUser.setFavouriteAgents(user.getFavouriteAgents());
			}
			existingUser.setRoleSet(getRoleSet(user.getUserRole()));
			user = userDAO.store(existingUser);
		} else {
			user.setUserType(true);
			user.setCreateBy("System");
			user.setCreateDate(Calendar.getInstance());
			user.setModifiedDate(Calendar.getInstance());
			user.setModifiedBy("System");
			user.setRoleSet(getRoleSet(user.getUserRole()));
			user = userDAO.store(user);
		}
		userDAO.flush();
	}
	

	private Set<Role> getRoleSet(String roles) {
		Set<Role> roleSet = null;
		if(StringUtils.isNotBlank(roles)){
			roleSet = new HashSet<Role>();
			String[] roleArr = StringUtils.split(roles,",");
			for(int i=0; i<roleArr.length;i++){
				if(NumberUtils.isNumber(roleArr[i])){
					Role role = new Role();
					role.setId(Integer.parseInt(roleArr[i]));
					roleSet.add(role);
				}
			}
		}
		return roleSet;
	}
	/**
	 * Return all User entity
	 * 
	 */
	@Transactional
	public List<User> findAllUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<User>(userDAO.findAllUsers(startResult, maxRows));
	}
	
	/**
	 * Return a count of all User entity
	 * 
	 */
	@Transactional
	public Integer countUsers() {
		return ((Long) userDAO.createQuerySingleResult("select count(o) from User o").getSingleResult()).intValue();
	}


	@Override
	public List<User> findUsersForSearch(int startResult, Integer maxRows,
			String searchParameter) {
		return userDAO.findUsersForSearch(startResult, maxRows, searchParameter);
	}
	
	/**
	 * Return a count of user search
	 * 
	 */
	@Override
	public Integer countForSearch(String searchParam) {
		return userDAO.countForSearch(searchParam);
	}

	@Override
	public User getByLogin(String login) {
		Set<User> set = userDAO.findUserByLoginId(login);
		if(set != null && set.size() > 0)
			return set.iterator().next();
		return null;
	}
}
