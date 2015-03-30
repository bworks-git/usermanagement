package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.PermissionDAO;
import com.osl.skygyft.um.dao.RoleDAO;
import com.osl.skygyft.um.dao.RolePermissionDAO;

import com.osl.skygyft.um.domain.Permission;
import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.RolePermission;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for RolePermission entities
 * 
 */

@Service("RolePermissionService")
@Transactional
public class RolePermissionServiceImpl implements RolePermissionService {

	/**
	 * DAO injected by Spring that manages Permission entities
	 * 
	 */
	@Autowired
	private PermissionDAO permissionDAO;

	/**
	 * DAO injected by Spring that manages Role entities
	 * 
	 */
	@Autowired
	private RoleDAO roleDAO;

	/**
	 * DAO injected by Spring that manages RolePermission entities
	 * 
	 */
	@Autowired
	private RolePermissionDAO rolePermissionDAO;

	/**
	 * Instantiates a new RolePermissionServiceImpl.
	 *
	 */
	public RolePermissionServiceImpl() {
	}

	/**
	 * Delete an existing RolePermission entity
	 * 
	 */
	@Transactional
	public void deleteRolePermission(RolePermission rolepermission) {
		rolePermissionDAO.remove(rolepermission);
		rolePermissionDAO.flush();
	}

	/**
	 * Delete an existing Permission entity
	 * 
	 */
	@Transactional
	public RolePermission deleteRolePermissionPermission(Integer rolepermission_roleId, Integer rolepermission_permissionId, Integer related_permission_id) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId, -1, -1);
		Permission related_permission = permissionDAO.findPermissionByPrimaryKey(related_permission_id, -1, -1);

		rolepermission.setPermission(null);
		related_permission.getRolePermissions().remove(rolepermission);
		rolepermission = rolePermissionDAO.store(rolepermission);
		rolePermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		permissionDAO.remove(related_permission);
		permissionDAO.flush();

		return rolepermission;
	}

	/**
	 * Save an existing RolePermission entity
	 * 
	 */
	@Transactional
	public void saveRolePermission(RolePermission rolepermission) {
		RolePermission existingRolePermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission.getRoleId(), rolepermission.getPermissionId());

		if (existingRolePermission != null) {
			if (existingRolePermission != rolepermission) {
				existingRolePermission.setRoleId(rolepermission.getRoleId());
				existingRolePermission.setPermissionId(rolepermission.getPermissionId());
				existingRolePermission.setCreateDate(rolepermission.getCreateDate());
				existingRolePermission.setModifiedDate(rolepermission.getModifiedDate());
				existingRolePermission.setCreateBy(rolepermission.getCreateBy());
				existingRolePermission.setModifiedBy(rolepermission.getModifiedBy());
			}
			rolepermission = rolePermissionDAO.store(existingRolePermission);
		} else {
			rolepermission = rolePermissionDAO.store(rolepermission);
		}
		rolePermissionDAO.flush();
	}

	/**
	 * Delete an existing Role entity
	 * 
	 */
	@Transactional
	public RolePermission deleteRolePermissionRole(Integer rolepermission_roleId, Integer rolepermission_permissionId, Integer related_role_id) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(rolepermission_roleId, rolepermission_permissionId, -1, -1);
		Role related_role = roleDAO.findRoleByPrimaryKey(related_role_id, -1, -1);

		rolepermission.setRole(null);
//		related_role.getRolePermissions().remove(rolepermission);
		rolepermission = rolePermissionDAO.store(rolepermission);
		rolePermissionDAO.flush();

		related_role = roleDAO.store(related_role);
		roleDAO.flush();

		roleDAO.remove(related_role);
		roleDAO.flush();

		return rolepermission;
	}

	/**
	 * Save an existing Permission entity
	 * 
	 */
	@Transactional
	public RolePermission saveRolePermissionPermission(Integer roleId, Integer permissionId, Permission related_permission) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(roleId, permissionId, -1, -1);
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

		rolepermission.setPermission(related_permission);
		related_permission.getRolePermissions().add(rolepermission);
		rolepermission = rolePermissionDAO.store(rolepermission);
		rolePermissionDAO.flush();

		related_permission = permissionDAO.store(related_permission);
		permissionDAO.flush();

		return rolepermission;
	}

	/**
	 * Load an existing RolePermission entity
	 * 
	 */
	@Transactional
	public Set<RolePermission> loadRolePermissions() {
		return rolePermissionDAO.findAllRolePermissions();
	}

	/**
	 */
	@Transactional
	public RolePermission findRolePermissionByPrimaryKey(Integer roleId, Integer permissionId) {
		return rolePermissionDAO.findRolePermissionByPrimaryKey(roleId, permissionId);
	}

	/**
	 * Return a count of all RolePermission entity
	 * 
	 */
	@Transactional
	public Integer countRolePermissions() {
		return ((Long) rolePermissionDAO.createQuerySingleResult("select count(*) from RolePermission o").getSingleResult()).intValue();
	}

	/**
	 * Return all RolePermission entity
	 * 
	 */
	@Transactional
	public List<RolePermission> findAllRolePermissions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<RolePermission>(rolePermissionDAO.findAllRolePermissions(startResult, maxRows));
	}

	/**
	 * Save an existing Role entity
	 * 
	 */
	@Transactional
	public RolePermission saveRolePermissionRole(Integer roleId, Integer permissionId, Role related_role) {
		RolePermission rolepermission = rolePermissionDAO.findRolePermissionByPrimaryKey(roleId, permissionId, -1, -1);
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

		rolepermission.setRole(related_role);
//		related_role.getRolePermissions().add(rolepermission);
		rolepermission = rolePermissionDAO.store(rolepermission);
		rolePermissionDAO.flush();

		related_role = roleDAO.store(related_role);
		roleDAO.flush();

		return rolepermission;
	}
}
