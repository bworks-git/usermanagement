package com.osl.skygyft.um.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.skyway.spring.util.dao.AbstractJpaDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.osl.skygyft.um.domain.User;

/**
 * DAO to manage User entities.
 * 
 */
@Repository("UserDAO")
@Transactional
public class UserDAOImpl extends AbstractJpaDao<User> implements UserDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { User.class }));

	/**
	 * EntityManager injected by Spring for persistence unit omsdb
	 *
	 */
	@PersistenceContext(unitName = "mysql2")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UserDAOImpl
	 *
	 */
	public UserDAOImpl() {
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
	 * JPQL Query - findUserByMobile1
	 *
	 */
	@Transactional
	public Set<User> findUserByMobile1(String mobile1) throws DataAccessException {

		return findUserByMobile1(mobile1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobile1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobile1(String mobile1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobile1", startResult, maxRows, mobile1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmail1Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByEmail1Containing(String email1) throws DataAccessException {

		return findUserByEmail1Containing(email1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail1Containing(String email1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail1Containing", startResult, maxRows, email1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId2
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId2(String loginId2) throws DataAccessException {

		return findUserByLoginId2(loginId2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId2(String loginId2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId2", startResult, maxRows, loginId2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */
	@Transactional
	public User findUserByUserId(Integer userId) throws DataAccessException {

		return findUserByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */

	@Transactional
	public User findUserByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserByUserId", startResult, maxRows, userId);
			return (com.osl.skygyft.um.domain.User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserByUserRole
	 *
	 */
	@Transactional
	public Set<User> findUserByUserRole(String userRole) throws DataAccessException {

		return findUserByUserRole(userRole, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUserRole
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUserRole(String userRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUserRole", startResult, maxRows, userRole);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUserRoleContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByUserRoleContaining(String userRole) throws DataAccessException {

		return findUserByUserRoleContaining(userRole, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUserRoleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUserRoleContaining(String userRole, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUserRoleContaining", startResult, maxRows, userRole);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginTypeContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginTypeContaining(String loginType) throws DataAccessException {

		return findUserByLoginTypeContaining(loginType, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginTypeContaining(String loginType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginTypeContaining", startResult, maxRows, loginType);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEMail
	 *
	 */
	@Transactional
	public Set<User> findUserByEMail(String EMail) throws DataAccessException {

		return findUserByEMail(EMail, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEMail
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEMail(String EMail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEMail", startResult, maxRows, EMail);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFavouriteAgents
	 *
	 */
	@Transactional
	public Set<User> findUserByFavouriteAgents(String favouriteAgents) throws DataAccessException {

		return findUserByFavouriteAgents(favouriteAgents, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFavouriteAgents
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFavouriteAgents(String favouriteAgents, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFavouriteAgents", startResult, maxRows, favouriteAgents);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginIdContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginIdContaining(String loginId) throws DataAccessException {

		return findUserByLoginIdContaining(loginId, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginIdContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginIdContaining(String loginId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginIdContaining", startResult, maxRows, loginId);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByTokenContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByTokenContaining(String token) throws DataAccessException {

		return findUserByTokenContaining(token, -1, -1);
	}

	/**
	 * JPQL Query - findUserByTokenContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByTokenContaining(String token, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByTokenContaining", startResult, maxRows, token);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer userId) throws DataAccessException {

		return findUserByPrimaryKey(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */

	@Transactional
	public User findUserByPrimaryKey(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUserByPrimaryKey", startResult, maxRows, userId);
			return (com.osl.skygyft.um.domain.User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUserByLoginId1Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId1Containing(String loginId1) throws DataAccessException {

		return findUserByLoginId1Containing(loginId1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId1Containing(String loginId1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId1Containing", startResult, maxRows, loginId1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByCreateDate
	 *
	 */
	@Transactional
	public Set<User> findUserByCreateDate(java.util.Calendar createDate) throws DataAccessException {

		return findUserByCreateDate(createDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserByCreateDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByCreateDate(java.util.Calendar createDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByCreateDate", startResult, maxRows, createDate);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLastNameContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByLastNameContaining(String lastName) throws DataAccessException {

		return findUserByLastNameContaining(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLastNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLastNameContaining(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLastNameContaining", startResult, maxRows, lastName);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByToken
	 *
	 */
	@Transactional
	public Set<User> findUserByToken(String token) throws DataAccessException {

		return findUserByToken(token, -1, -1);
	}

	/**
	 * JPQL Query - findUserByToken
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByToken(String token, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByToken", startResult, maxRows, token);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId5
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId5(String loginId5) throws DataAccessException {

		return findUserByLoginId5(loginId5, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId5
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId5(String loginId5, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId5", startResult, maxRows, loginId5);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId3Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId3Containing(String loginId3) throws DataAccessException {

		return findUserByLoginId3Containing(loginId3, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId3Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId3Containing(String loginId3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId3Containing", startResult, maxRows, loginId3);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByModifiedBy
	 *
	 */
	@Transactional
	public Set<User> findUserByModifiedBy(String modifiedBy) throws DataAccessException {

		return findUserByModifiedBy(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserByModifiedBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByModifiedBy", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByPasswordContaining(String password) throws DataAccessException {

		return findUserByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobile2Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByMobile2Containing(String mobile2) throws DataAccessException {

		return findUserByMobile2Containing(mobile2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobile2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobile2Containing(String mobile2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobile2Containing", startResult, maxRows, mobile2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	@Transactional
	public Set<User> findUserByPassword(String password) throws DataAccessException {

		return findUserByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPassword", startResult, maxRows, password);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobCountryPrefix
	 *
	 */
	@Transactional
	public Set<User> findUserByMobCountryPrefix(String mobCountryPrefix) throws DataAccessException {

		return findUserByMobCountryPrefix(mobCountryPrefix, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobCountryPrefix
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobCountryPrefix(String mobCountryPrefix, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobCountryPrefix", startResult, maxRows, mobCountryPrefix);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId1
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId1(String loginId1) throws DataAccessException {

		return findUserByLoginId1(loginId1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId1(String loginId1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId1", startResult, maxRows, loginId1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPrimaryLoginContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByPrimaryLoginContaining(String primaryLogin) throws DataAccessException {

		return findUserByPrimaryLoginContaining(primaryLogin, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPrimaryLoginContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPrimaryLoginContaining(String primaryLogin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPrimaryLoginContaining", startResult, maxRows, primaryLogin);
		return new LinkedHashSet<User>(query.getResultList());
	}
	
	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	@Transactional
	public List<User> findAllUsers() throws DataAccessException {
		Session session = entityManager.unwrap(Session.class);
		List<User> users = null;
				Criteria criteria = session.createCriteria(User.class);
				criteria.addOrder(Order.desc("createDate") );
//				criteria.setMaxResults(10);
//				criteria.setFirstResult(0);
				users = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
//		String hql = "FROM User u order by u.userId desc";
//		Query query = (Query) session.createQuery(hql);
//		int pageSize = 10;
//		 
//		ScrollableResults resultScroll = query.scroll(ScrollMode.FORWARD_ONLY);
//		resultScroll.first();
//		resultScroll.scroll(0);
//		List<Foo> fooPage = Lists.newArrayList();
//		int i = 0;
//		while (pageSize > i++) {
//		    fooPage.add((Foo) resultScroll.get(0));
//		    if (!resultScroll.next())
//		        break;
//		}

		return users;
	}

	

	/**
	 * JPQL Query - findAllUsers
	 *
	 */

//	@SuppressWarnings("unchecked")
//	@Transactional
//	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException {
//		Query query = createNamedQuery("findAllUsers", startResult, maxRows);
//		return new LinkedHashSet<User>(query.getResultList());
//	}

	/**
	 * JPQL Query - findUserByEmail1
	 *
	 */
	@Transactional
	public Set<User> findUserByEmail1(String email1) throws DataAccessException {

		return findUserByEmail1(email1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail1
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail1(String email1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail1", startResult, maxRows, email1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLastName
	 *
	 */
	@Transactional
	public Set<User> findUserByLastName(String lastName) throws DataAccessException {

		return findUserByLastName(lastName, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLastName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLastName(String lastName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLastName", startResult, maxRows, lastName);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobile
	 *
	 */
	@Transactional
	public Set<User> findUserByMobile(String mobile) throws DataAccessException {

		return findUserByMobile(mobile, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobile
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobile(String mobile, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobile", startResult, maxRows, mobile);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId5Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId5Containing(String loginId5) throws DataAccessException {

		return findUserByLoginId5Containing(loginId5, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId5Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId5Containing(String loginId5, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId5Containing", startResult, maxRows, loginId5);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobileContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByMobileContaining(String mobile) throws DataAccessException {

		return findUserByMobileContaining(mobile, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobileContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobileContaining(String mobile, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobileContaining", startResult, maxRows, mobile);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId2Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId2Containing(String loginId2) throws DataAccessException {

		return findUserByLoginId2Containing(loginId2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId2Containing(String loginId2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId2Containing", startResult, maxRows, loginId2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByCreateByContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByCreateByContaining(String createBy) throws DataAccessException {

		return findUserByCreateByContaining(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserByCreateByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByCreateByContaining", startResult, maxRows, createBy);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFavouriteAgentsContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByFavouriteAgentsContaining(String favouriteAgents) throws DataAccessException {

		return findUserByFavouriteAgentsContaining(favouriteAgents, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFavouriteAgentsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFavouriteAgentsContaining(String favouriteAgents, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFavouriteAgentsContaining", startResult, maxRows, favouriteAgents);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPermissionNegative
	 *
	 */
	@Transactional
	public Set<User> findUserByPermissionNegative(String permissionNegative) throws DataAccessException {

		return findUserByPermissionNegative(permissionNegative, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPermissionNegative
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPermissionNegative(String permissionNegative, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPermissionNegative", startResult, maxRows, permissionNegative);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId4
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId4(String loginId4) throws DataAccessException {

		return findUserByLoginId4(loginId4, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId4
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId4(String loginId4, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId4", startResult, maxRows, loginId4);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobCountryPrefixContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByMobCountryPrefixContaining(String mobCountryPrefix) throws DataAccessException {

		return findUserByMobCountryPrefixContaining(mobCountryPrefix, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobCountryPrefixContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobCountryPrefixContaining(String mobCountryPrefix, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobCountryPrefixContaining", startResult, maxRows, mobCountryPrefix);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginType
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginType(String loginType) throws DataAccessException {

		return findUserByLoginType(loginType, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginType(String loginType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginType", startResult, maxRows, loginType);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFirstNameContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByFirstNameContaining(String firstName) throws DataAccessException {

		return findUserByFirstNameContaining(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFirstNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFirstNameContaining(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFirstNameContaining", startResult, maxRows, firstName);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByStatus
	 *
	 */
	@Transactional
	public Set<User> findUserByStatus(Boolean status) throws DataAccessException {

		return findUserByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findUserByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByStatus", startResult, maxRows, status);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId3
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId3(String loginId3) throws DataAccessException {

		return findUserByLoginId3(loginId3, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId3
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId3(String loginId3, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId3", startResult, maxRows, loginId3);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobile2
	 *
	 */
	@Transactional
	public Set<User> findUserByMobile2(String mobile2) throws DataAccessException {

		return findUserByMobile2(mobile2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobile2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobile2(String mobile2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobile2", startResult, maxRows, mobile2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByCreateBy
	 *
	 */
	@Transactional
	public Set<User> findUserByCreateBy(String createBy) throws DataAccessException {

		return findUserByCreateBy(createBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserByCreateBy
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByCreateBy(String createBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByCreateBy", startResult, maxRows, createBy);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPermissionPositive
	 *
	 */
	@Transactional
	public Set<User> findUserByPermissionPositive(String permissionPositive) throws DataAccessException {

		return findUserByPermissionPositive(permissionPositive, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPermissionPositive
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPermissionPositive(String permissionPositive, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPermissionPositive", startResult, maxRows, permissionPositive);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByHashStatus
	 *
	 */
	@Transactional
	public Set<User> findUserByHashStatus(Boolean hashStatus) throws DataAccessException {

		return findUserByHashStatus(hashStatus, -1, -1);
	}

	/**
	 * JPQL Query - findUserByHashStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByHashStatus(Boolean hashStatus, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByHashStatus", startResult, maxRows, hashStatus);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByModifiedDate
	 *
	 */
	@Transactional
	public Set<User> findUserByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException {

		return findUserByModifiedDate(modifiedDate, -1, -1);
	}

	/**
	 * JPQL Query - findUserByModifiedDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByModifiedDate(java.util.Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByModifiedDate", startResult, maxRows, modifiedDate);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEntityId
	 *
	 */
	@Transactional
	public Set<User> findUserByEntityId(Integer entityId) throws DataAccessException {

		return findUserByEntityId(entityId, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEntityId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEntityId(Integer entityId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEntityId", startResult, maxRows, entityId);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByModifiedByContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByModifiedByContaining(String modifiedBy) throws DataAccessException {

		return findUserByModifiedByContaining(modifiedBy, -1, -1);
	}

	/**
	 * JPQL Query - findUserByModifiedByContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByModifiedByContaining(String modifiedBy, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByModifiedByContaining", startResult, maxRows, modifiedBy);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFirstName
	 *
	 */
	@Transactional
	public Set<User> findUserByFirstName(String firstName) throws DataAccessException {

		return findUserByFirstName(firstName, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFirstName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFirstName(String firstName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFirstName", startResult, maxRows, firstName);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmail2
	 *
	 */
	@Transactional
	public Set<User> findUserByEmail2(String email2) throws DataAccessException {

		return findUserByEmail2(email2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail2
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail2(String email2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail2", startResult, maxRows, email2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUserType
	 *
	 */
	@Transactional
	public Set<User> findUserByUserType(Boolean userType) throws DataAccessException {

		return findUserByUserType(userType, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUserType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUserType(Boolean userType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUserType", startResult, maxRows, userType);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByMobile1Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByMobile1Containing(String mobile1) throws DataAccessException {

		return findUserByMobile1Containing(mobile1, -1, -1);
	}

	/**
	 * JPQL Query - findUserByMobile1Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByMobile1Containing(String mobile1, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByMobile1Containing", startResult, maxRows, mobile1);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId(String loginId) throws DataAccessException {

		return findUserByLoginId(loginId, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId(String loginId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId", startResult, maxRows, loginId);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPrimaryLogin
	 *
	 */
	@Transactional
	public Set<User> findUserByPrimaryLogin(String primaryLogin) throws DataAccessException {

		return findUserByPrimaryLogin(primaryLogin, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPrimaryLogin
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPrimaryLogin(String primaryLogin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPrimaryLogin", startResult, maxRows, primaryLogin);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFavouriteIpsContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByFavouriteIpsContaining(String favouriteIps) throws DataAccessException {

		return findUserByFavouriteIpsContaining(favouriteIps, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFavouriteIpsContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFavouriteIpsContaining(String favouriteIps, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFavouriteIpsContaining", startResult, maxRows, favouriteIps);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEMailContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByEMailContaining(String EMail) throws DataAccessException {

		return findUserByEMailContaining(EMail, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEMailContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEMailContaining(String EMail, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEMailContaining", startResult, maxRows, EMail);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginToken
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginToken(String loginToken) throws DataAccessException {

		return findUserByLoginToken(loginToken, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginToken
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginToken(String loginToken, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginToken", startResult, maxRows, loginToken);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPermissionPositiveContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByPermissionPositiveContaining(String permissionPositive) throws DataAccessException {

		return findUserByPermissionPositiveContaining(permissionPositive, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPermissionPositiveContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPermissionPositiveContaining(String permissionPositive, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPermissionPositiveContaining", startResult, maxRows, permissionPositive);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginId4Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginId4Containing(String loginId4) throws DataAccessException {

		return findUserByLoginId4Containing(loginId4, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginId4Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginId4Containing(String loginId4, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginId4Containing", startResult, maxRows, loginId4);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByEmail2Containing
	 *
	 */
	@Transactional
	public Set<User> findUserByEmail2Containing(String email2) throws DataAccessException {

		return findUserByEmail2Containing(email2, -1, -1);
	}

	/**
	 * JPQL Query - findUserByEmail2Containing
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByEmail2Containing(String email2, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByEmail2Containing", startResult, maxRows, email2);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByLoginTokenContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByLoginTokenContaining(String loginToken) throws DataAccessException {

		return findUserByLoginTokenContaining(loginToken, -1, -1);
	}

	/**
	 * JPQL Query - findUserByLoginTokenContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByLoginTokenContaining(String loginToken, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByLoginTokenContaining", startResult, maxRows, loginToken);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByUserEntityType
	 *
	 */
	@Transactional
	public Set<User> findUserByUserEntityType(Boolean userEntityType) throws DataAccessException {

		return findUserByUserEntityType(userEntityType, -1, -1);
	}

	/**
	 * JPQL Query - findUserByUserEntityType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByUserEntityType(Boolean userEntityType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByUserEntityType", startResult, maxRows, userEntityType);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByFavouriteIps
	 *
	 */
	@Transactional
	public Set<User> findUserByFavouriteIps(String favouriteIps) throws DataAccessException {

		return findUserByFavouriteIps(favouriteIps, -1, -1);
	}

	/**
	 * JPQL Query - findUserByFavouriteIps
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByFavouriteIps(String favouriteIps, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByFavouriteIps", startResult, maxRows, favouriteIps);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * JPQL Query - findUserByPermissionNegativeContaining
	 *
	 */
	@Transactional
	public Set<User> findUserByPermissionNegativeContaining(String permissionNegative) throws DataAccessException {

		return findUserByPermissionNegativeContaining(permissionNegative, -1, -1);
	}

	/**
	 * JPQL Query - findUserByPermissionNegativeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<User> findUserByPermissionNegativeContaining(String permissionNegative, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUserByPermissionNegativeContaining", startResult, maxRows, permissionNegative);
		return new LinkedHashSet<User>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(User entity) {
		return true;
	}
	
	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	public List<User> findAllUsers(int startPosition, int maxResult) throws DataAccessException {
		List<User> users = null;
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.desc("userId") );
		criteria.setMaxResults(maxResult);
		criteria.setFirstResult(startPosition);
		users = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//				SQLQuery query = session.createSQLQuery("select * from Users myUser order by myUser.user_Id desc");
////						createNamedQuery("findAllUsers", User.class);
//				query.setFirstResult(startPosition);
//				query.setMaxResults(maxResult);
//				List<Object[]> vos = query.list();
//				if(vos!=null && vos.size()>0){
//					users = new ArrayList<User>();
//					  for(Object[] values : vos){
//					   User user = new User();
//					   user.setFirst_name((String)values[3]);
//					   user.setLast_name((String)values[4]);
//					   user.setEmail((String)values[5]);
//					   user.setMobile((String)values[7]);
//					   users.add(user);
//					  }
//				}		
		return users;
	}

//	@Override
//	public Integer createQuerySingleResult(String query) {
//		Integer count = 0;
//		Session session = entityManager.unwrap(Session.class);
//		SQLQuery sqlQuery = session.createSQLQuery(query);
//		Object returnVal = sqlQuery.uniqueResult();
//		if(returnVal != null){
//			BigInteger countBI = (BigInteger) returnVal;
//			count = countBI.intValue();
//		}
//		return count;
//	}
	
	@Override
	public Integer countForSearch(String searchParameter) {
		Integer count = 0;
		Session session = entityManager.unwrap(Session.class);
		searchParameter ="%"+searchParameter+"%";
		org.hibernate.Query sqlQuery = session.createSQLQuery("select count(user_id) from Users myUser where "
				+ "UPPER(first_name) like ? or UPPER(last_name) like ? or UPPER(e_mail) like ? or UPPER(mobile) like ?")
				.setString(0,StringUtils.upperCase(searchParameter))
				.setString(1,StringUtils.upperCase(searchParameter))
				.setString(2,StringUtils.upperCase(searchParameter))
				.setString(3,StringUtils.upperCase(searchParameter));
		Object returnVal = sqlQuery.uniqueResult();
		if(returnVal != null){
			BigInteger countBI = (BigInteger) returnVal;
			count = countBI.intValue();
		}
		return count;
	}
	
	@Override
	public List<User> findUsersForSearch(int startResult,
			Integer maxRows, String searchParameter) {
		List<User> users = null;
		Session session = entityManager.unwrap(Session.class);
		searchParameter ="%"+searchParameter+"%";
		
		org.hibernate.Query query = session.createSQLQuery("select * from Users myUser where "
				+ "UPPER(first_name) like ? or UPPER(last_name) like ? or UPPER(e_mail) like ? or UPPER(mobile) like ?  order by myUser.user_Id desc")
				.setString(0,StringUtils.upperCase(searchParameter))
				.setString(1,StringUtils.upperCase(searchParameter))
				.setString(2,StringUtils.upperCase(searchParameter))
				.setString(3,StringUtils.upperCase(searchParameter));
		//		createNamedQuery("findAllUsers", User.class);
		query.setFirstResult(startResult);
		query.setMaxResults(maxRows);
		List<Object[]> vos = query.list();
		if(vos!=null && vos.size()>0){
			users = new ArrayList<User>();
			for(Object[] values : vos){
				User user = new User();
				user.setFirst_name((String)values[3]);
				user.setLast_name((String)values[4]);
				user.setEmail((String)values[5]);
				user.setMobile((String)values[7]);
				users.add(user);
			}
		}
		return users;		
	}
}
