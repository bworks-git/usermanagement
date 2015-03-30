package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;
import com.osl.skygyft.um.dao.UserPermissionDAO;
import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.RolePermission;
import com.osl.skygyft.um.domain.UserPermission;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Permission entities
 * 
 */

@Service("PermissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages RolePermission entities
	 * 
	 */
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	/**
	 * DAO injected by Spring that manages UserPermission entities
	 * 
	 */
	@Autowired
	private UserPermissionDAO userPermissionDAO;

	/**
	 * Instantiates a new PermissionServiceImpl.
	 *
	 */
	public PermissionServiceImpl() {
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@Transactional
	public Permission savePermissionRolePermissions(Integer id, RolePermission related_rolepermissions) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
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

		related_rolepermissions.setPermission(permission);
		permission.getRolePermissions().add(related_rolepermissions);
		related_rolepermissions = rolePermissionDAO.store(related_rolepermissions);
		rolePermissionDAO.flush();

		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		return permission;
	}

	/**
	 * Return a count of all Permission entity
	 * 
	 */
	@Transactional
	public Integer countPermissions() {
		return ((Long) permissionDAO.createQuerySingleResult("select count(o) from Permission o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public void deletePermission(Permission permission) {
		permissionDAO.remove(permission);
		permissionDAO.flush();
	}

	/**
	 * Load an existing Permission entity
	 * 
	 */
	@Transactional
	public Set<Permission> loadPermissions() {
		return permissionDAO.findAllPermissions();
	}

	/**
	 * Save an existing UserPermission entity
	 * 
	 */
	@Transactional
	public Permission savePermissionUserPermissions(Integer id, UserPermission related_userpermissions) {
		Permission permission = permissionDAO.findPermissionByPrimaryKey(id, -1, -1);
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

		related_userpermissions.setPermission(permission);
		permission.getUserPermissions().add(related_userpermissions);
		related_userpermissions = userPermissionDAO.store(related_userpermissions);
		userPermissionDAO.flush();

		permission = permissionDAO.store(permission);
		permissionDAO.flush();

		return permission;
	}

	/**
	 */
	@Transactional
	public Permission findPermissionByPrimaryKey(Integer id) {
		return permissionDAO.findPermissionByPrimaryKey(id);
	}

	/**
	 * Return all Permission entity
	 * 
	 */
	@Transactional
	public List<Permission> findAllPermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Permission>(permissionDAO.findAllPermissions(startResult, maxRows));
	}

	/**
	 * Delete an existing UserPermission entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionUserPermissions(Integer permission_id, Integer related_userpermissions_userId, Integer related_userpermissions_permissionId) {
		UserPermission related_userpermissions = userPermissionDAO.findUserPermissionByPrimaryKey(related_userpermissions_userId, related_userpermissions_permissionId, -1, -1);

		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		related_userpermissions.setPermission(null);
		permission.getUserPermissions().remove(related_userpermissions);

		userPermissionDAO.remove(related_userpermissions);
		userPermissionDAO.flush();

		return permission;
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@Transactional
	public Permission deletePermissionRolePermissions(Integer permission_id, Integer related_rolepermissions_roleId, Integer related_rolepermissions_permissionId) {
		RolePermission related_rolepermissions = rolePermissionDAO.findRolePermissionByPrimaryKey(related_rolepermissions_roleId, related_rolepermissions_permissionId, -1, -1);

		Permission permission = permissionDAO.findPermissionByPrimaryKey(permission_id, -1, -1);

		related_rolepermissions.setPermission(null);
		permission.getRolePermissions().remove(related_rolepermissions);

		rolePermissionDAO.remove(related_rolepermissions);
		rolePermissionDAO.flush();

		return permission;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public void savePermission(Permission permission) {
		Permission existingPermission = null;
		
		if(permission.getId() != null){
			existingPermission = permissionDAO.findPermissionByPrimaryKey(permission.getId());
		}

		if (existingPermission != null) {
			if (existingPermission != permission) {
				existingPermission.setId(permission.getId());
				existingPermission.setPermId(permission.getPermId());
				existingPermission.setPermissionName(permission.getPermissionName());
				existingPermission.setModuleId(permission.getModuleId());
				existingPermission.setDescription(permission.getDescription());
				existingPermission.setStatus(permission.getStatus());
//				existingPermission.setCreateDate(permission.getCreateDate());
				existingPermission.setModifiedDate(Calendar.getInstance());
//				existingPermission.setCreateBy(permission.getCreateBy());
				existingPermission.setModifiedBy("Logged In User");
			}
			permission = permissionDAO.store(existingPermission);
		} else {
			permission.setCreateBy("System");
			permission.setCreateDate(Calendar.getInstance());
			permission.setModifiedDate(Calendar.getInstance());
			permission.setModifiedBy("System");
			System.out.println("************** Role Id : "+permission.getId());
			permission = permissionDAO.store(permission);
		}
		permissionDAO.flush();
	}
}
