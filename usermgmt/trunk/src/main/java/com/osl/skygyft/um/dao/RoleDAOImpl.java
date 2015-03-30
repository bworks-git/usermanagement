package com.osl.skygyft.um.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.osl.skygyft.um.domain.Role;
import com.osl.skygyft.um.domain.User;

/**
 * DAO to manage Role entities.
 * 
 */
@Repository("RoleDAO")
@Transactional
public class RoleDAOImpl extends AbstractJpaDao<Role> implements RoleDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Role.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RoleDAOImpl
	 *
	 */
	public RoleDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findAllRoles
	 *
	 */
	@Transactional
	public List<Role> findAllRoles() throws DataAccessException {
		List<Role> roles = null;
		//return findAllRoles(-1, -1);
		Session session = entityManager.unwrap(Session.class);
		org.hibernate.Query query = session.createSQLQuery("select * from roles r order by r.role_id desc");
//		query.setFirstResult(startPosition);
//		query.setMaxResults(maxResult);
		List<Object[]> vos = query.list();
		if(vos!=null && vos.size()>0){
			roles = new ArrayList<Role>();
			  for(Object[] values : vos){
			   Role role = new Role();
			   role.setRoleId((Integer)values[0]);
			   role.setRole_name((String)values[2]);
			   role.setPermissions((String)values[3]);
			   if(values[4] != null) role.setModule_id(Integer.parseInt((Short)values[4]+""));
			   boolean status = (Boolean) (values[5] != null ? (Byte)values[5]!=0 : 0);
			   role.setStatus(status);
			   role.setDescription((String)values[6]);
			   role.setCreate_date((Calendar)values[7]);
			   role.setModified_date((Calendar)values[8]);
			   role.setCreate_by((String)values[9]);
			   role.setModified_by((String)values[10]);
			   roles.add(role);
			  }
		}		
		return roles;
	}

	/**
	 * JPQL Query - findAllRoles
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findAllRoles(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRoles", startResult, maxRows);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByCreateBy
	 *
	 */
	@Transactional
	public Set<Role> findRoleByCreateBy(String createBy) throws DataAccessException {

		return findRoleByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByCreateDate
	 *
	 */
	@Transactional
	public Set<Role> findRoleByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findRoleByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByPermissionSetContaining
	 *
	 */
	@Transactional
	public Set<Role> findRoleByPermissionSetContaining(String permissionSet) throws DataAccessException {

		return findRoleByPermissionSetContaining(permissionSet, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByPermissionSetContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByPermissionSetContaining(String permissionSet, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByPermissionSetContaining", startResult, maxRows, permissionSet);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByCreateByContaining
	 *
	 */
	@Transactional
	public Set<Role> findRoleByCreateByContaining(String createBy) throws DataAccessException {

		return findRoleByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByPermissionSet
	 *
	 */
	@Transactional
	public Set<Role> findRoleByPermissionSet(String permissionSet) throws DataAccessException {

		return findRoleByPermissionSet(permissionSet, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByPermissionSet
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByPermissionSet(String permissionSet, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByPermissionSet", startResult, maxRows, permissionSet);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByModifiedDate
	 *
	 */
	@Transactional
	public Set<Role> findRoleByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findRoleByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByModifiedBy
	 *
	 */
	@Transactional
	public Set<Role> findRoleByModifiedBy(String modifiedBy) throws DataAccessException {

		return findRoleByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleById
	 *
	 */
	@Transactional
	public Role findRoleById(Integer id) throws DataAccessException {

		return findRoleById(id, -1, -1);
	}

	/**
	 * JPQL Query - findRoleById
	 *
	 */

	@Transactional
	public Role findRoleById(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRoleById", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.Role) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRoleByStatus
	 *
	 */
	@Transactional
	public Set<Role> findRoleByStatus(Boolean status) throws DataAccessException {

		return findRoleByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByModuleId
	 *
	 */
	@Transactional
	public Set<Role> findRoleByModuleId(Integer moduleId) throws DataAccessException {

		return findRoleByModuleId(moduleId, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByModuleId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByModuleId(Integer moduleId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByModuleId", startResult, maxRows, moduleId);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByDescription
	 *
	 */
	@Transactional
	public Set<Role> findRoleByDescription(String description) throws DataAccessException {

		return findRoleByDescription(description, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByDescription(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByDescription", startResult, maxRows, description);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<Role> findRoleByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findRoleByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByRoleNameContaining
	 *
	 */
	@Transactional
	public Set<Role> findRoleByRoleNameContaining(String roleName) throws DataAccessException {

		return findRoleByRoleNameContaining(roleName, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByRoleNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByRoleNameContaining(String roleName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByRoleNameContaining", startResult, maxRows, roleName);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByRoleName
	 *
	 */
	@Transactional
	public Set<Role> findRoleByRoleName(String roleName) throws DataAccessException {

		return findRoleByRoleName(roleName, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByRoleName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByRoleName(String roleName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByRoleName", startResult, maxRows, roleName);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Role> findRoleByDescriptionContaining(String description) throws DataAccessException {

		return findRoleByDescriptionContaining(description, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByDescriptionContaining", startResult, maxRows, description);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByRoleId
	 *
	 */
	@Transactional
	public Set<Role> findRoleByRoleId(Integer roleId) throws DataAccessException {

		return findRoleByRoleId(roleId, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByRoleId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Role> findRoleByRoleId(Integer roleId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRoleByRoleId", startResult, maxRows, roleId);
		return new LinkedHashSet<Role>(query.getResultList());
	}

	/**
	 * JPQL Query - findRoleByPrimaryKey
	 *
	 */
	@Transactional
	public Role findRoleByPrimaryKey(Integer id) throws DataAccessException {

		return findRoleByPrimaryKey(id, -1, -1);
	}

	/**
	 * JPQL Query - findRoleByPrimaryKey
	 *
	 */

	@Transactional
	public Role findRoleByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRoleByPrimaryKey", startResult, maxRows, id);
			return (com.osl.skygyft.um.domain.Role) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Role entity) {
		return true;
	}
}
