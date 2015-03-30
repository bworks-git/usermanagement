package com.osl.skygyft.um.dao;

import com.osl.skygyft.um.domain.User;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.skyway.spring.util.dao.JpaDao;
import org.springframework.dao.DataAccessException;

/**
 * DAO to manage User entities.
 * 
 */
public interface UserDAO extends JpaDao<User> {
	
	/**
	 * JPQL Query - findUserByMobile1
	 *
	 */
	public Set<User> findUserByMobile1(String mobile1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile1
	 *
	 */
	public Set<User> findUserByMobile1(String mobile1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail1Containing
	 *
	 */
	public Set<User> findUserByEmail1Containing(String email1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail1Containing
	 *
	 */
	public Set<User> findUserByEmail1Containing(String email1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId2
	 *
	 */
	public Set<User> findUserByLoginId2(String loginId2) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId2
	 *
	 */
	public Set<User> findUserByLoginId2(String loginId2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */
	public User findUserByUserId(Integer userId) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */
	public User findUserByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserRole
	 *
	 */
	public Set<User> findUserByUserRole(String userRole) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserRole
	 *
	 */
	public Set<User> findUserByUserRole(String userRole, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserRoleContaining
	 *
	 */
	public Set<User> findUserByUserRoleContaining(String userRole_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserRoleContaining
	 *
	 */
	public Set<User> findUserByUserRoleContaining(String userRole_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginTypeContaining
	 *
	 */
	public Set<User> findUserByLoginTypeContaining(String loginType) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginTypeContaining
	 *
	 */
	public Set<User> findUserByLoginTypeContaining(String loginType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEMail
	 *
	 */
	public Set<User> findUserByEMail(String EMail) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEMail
	 *
	 */
	public Set<User> findUserByEMail(String EMail, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteAgents
	 *
	 */
	public Set<User> findUserByFavouriteAgents(String favouriteAgents) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteAgents
	 *
	 */
	public Set<User> findUserByFavouriteAgents(String favouriteAgents, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginIdContaining
	 *
	 */
	public Set<User> findUserByLoginIdContaining(String loginId) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginIdContaining
	 *
	 */
	public Set<User> findUserByLoginIdContaining(String loginId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByTokenContaining
	 *
	 */
	public Set<User> findUserByTokenContaining(String token) throws DataAccessException;

	/**
	 * JPQL Query - findUserByTokenContaining
	 *
	 */
	public Set<User> findUserByTokenContaining(String token, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId1Containing
	 *
	 */
	public Set<User> findUserByLoginId1Containing(String loginId1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId1Containing
	 *
	 */
	public Set<User> findUserByLoginId1Containing(String loginId1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateDate
	 *
	 */
	public Set<User> findUserByCreateDate(java.util.Calendar createDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateDate
	 *
	 */
	public Set<User> findUserByCreateDate(Calendar createDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLastNameContaining
	 *
	 */
	public Set<User> findUserByLastNameContaining(String lastName) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLastNameContaining
	 *
	 */
	public Set<User> findUserByLastNameContaining(String lastName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByToken
	 *
	 */
	public Set<User> findUserByToken(String token_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByToken
	 *
	 */
	public Set<User> findUserByToken(String token_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId5
	 *
	 */
	public Set<User> findUserByLoginId5(String loginId5) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId5
	 *
	 */
	public Set<User> findUserByLoginId5(String loginId5, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId3Containing
	 *
	 */
	public Set<User> findUserByLoginId3Containing(String loginId3) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId3Containing
	 *
	 */
	public Set<User> findUserByLoginId3Containing(String loginId3, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedBy
	 *
	 */
	public Set<User> findUserByModifiedBy(String modifiedBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedBy
	 *
	 */
	public Set<User> findUserByModifiedBy(String modifiedBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile2Containing
	 *
	 */
	public Set<User> findUserByMobile2Containing(String mobile2) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile2Containing
	 *
	 */
	public Set<User> findUserByMobile2Containing(String mobile2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobCountryPrefix
	 *
	 */
	public Set<User> findUserByMobCountryPrefix(String mobCountryPrefix) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobCountryPrefix
	 *
	 */
	public Set<User> findUserByMobCountryPrefix(String mobCountryPrefix, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId1
	 *
	 */
	public Set<User> findUserByLoginId1(String loginId1_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId1
	 *
	 */
	public Set<User> findUserByLoginId1(String loginId1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryLoginContaining
	 *
	 */
	public Set<User> findUserByPrimaryLoginContaining(String primaryLogin) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryLoginContaining
	 *
	 */
	public Set<User> findUserByPrimaryLoginContaining(String primaryLogin, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public List<User> findAllUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public List<User> findAllUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail1
	 *
	 */
	public Set<User> findUserByEmail1(String email1_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail1
	 *
	 */
	public Set<User> findUserByEmail1(String email1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLastName
	 *
	 */
	public Set<User> findUserByLastName(String lastName_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLastName
	 *
	 */
	public Set<User> findUserByLastName(String lastName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile
	 *
	 */
	public Set<User> findUserByMobile(String mobile) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile
	 *
	 */
	public Set<User> findUserByMobile(String mobile, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId5Containing
	 *
	 */
	public Set<User> findUserByLoginId5Containing(String loginId5_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId5Containing
	 *
	 */
	public Set<User> findUserByLoginId5Containing(String loginId5_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobileContaining
	 *
	 */
	public Set<User> findUserByMobileContaining(String mobile_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobileContaining
	 *
	 */
	public Set<User> findUserByMobileContaining(String mobile_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId2Containing
	 *
	 */
	public Set<User> findUserByLoginId2Containing(String loginId2_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId2Containing
	 *
	 */
	public Set<User> findUserByLoginId2Containing(String loginId2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateByContaining
	 *
	 */
	public Set<User> findUserByCreateByContaining(String createBy) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateByContaining
	 *
	 */
	public Set<User> findUserByCreateByContaining(String createBy, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteAgentsContaining
	 *
	 */
	public Set<User> findUserByFavouriteAgentsContaining(String favouriteAgents_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteAgentsContaining
	 *
	 */
	public Set<User> findUserByFavouriteAgentsContaining(String favouriteAgents_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionNegative
	 *
	 */
	public Set<User> findUserByPermissionNegative(String permissionNegative) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionNegative
	 *
	 */
	public Set<User> findUserByPermissionNegative(String permissionNegative, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId4
	 *
	 */
	public Set<User> findUserByLoginId4(String loginId4) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId4
	 *
	 */
	public Set<User> findUserByLoginId4(String loginId4, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobCountryPrefixContaining
	 *
	 */
	public Set<User> findUserByMobCountryPrefixContaining(String mobCountryPrefix_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobCountryPrefixContaining
	 *
	 */
	public Set<User> findUserByMobCountryPrefixContaining(String mobCountryPrefix_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginType
	 *
	 */
	public Set<User> findUserByLoginType(String loginType_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginType
	 *
	 */
	public Set<User> findUserByLoginType(String loginType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFirstNameContaining
	 *
	 */
	public Set<User> findUserByFirstNameContaining(String firstName) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFirstNameContaining
	 *
	 */
	public Set<User> findUserByFirstNameContaining(String firstName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByStatus
	 *
	 */
	public Set<User> findUserByStatus(Boolean status) throws DataAccessException;

	/**
	 * JPQL Query - findUserByStatus
	 *
	 */
	public Set<User> findUserByStatus(Boolean status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId3
	 *
	 */
	public Set<User> findUserByLoginId3(String loginId3_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId3
	 *
	 */
	public Set<User> findUserByLoginId3(String loginId3_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile2
	 *
	 */
	public Set<User> findUserByMobile2(String mobile2_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile2
	 *
	 */
	public Set<User> findUserByMobile2(String mobile2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateBy
	 *
	 */
	public Set<User> findUserByCreateBy(String createBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByCreateBy
	 *
	 */
	public Set<User> findUserByCreateBy(String createBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionPositive
	 *
	 */
	public Set<User> findUserByPermissionPositive(String permissionPositive) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionPositive
	 *
	 */
	public Set<User> findUserByPermissionPositive(String permissionPositive, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByHashStatus
	 *
	 */
	public Set<User> findUserByHashStatus(Boolean hashStatus) throws DataAccessException;

	/**
	 * JPQL Query - findUserByHashStatus
	 *
	 */
	public Set<User> findUserByHashStatus(Boolean hashStatus, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedDate
	 *
	 */
	public Set<User> findUserByModifiedDate(java.util.Calendar modifiedDate) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedDate
	 *
	 */
	public Set<User> findUserByModifiedDate(Calendar modifiedDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEntityId
	 *
	 */
	public Set<User> findUserByEntityId(Integer entityId) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEntityId
	 *
	 */
	public Set<User> findUserByEntityId(Integer entityId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedByContaining
	 *
	 */
	public Set<User> findUserByModifiedByContaining(String modifiedBy_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByModifiedByContaining
	 *
	 */
	public Set<User> findUserByModifiedByContaining(String modifiedBy_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFirstName
	 *
	 */
	public Set<User> findUserByFirstName(String firstName_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFirstName
	 *
	 */
	public Set<User> findUserByFirstName(String firstName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail2
	 *
	 */
	public Set<User> findUserByEmail2(String email2) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail2
	 *
	 */
	public Set<User> findUserByEmail2(String email2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserType
	 *
	 */
	public Set<User> findUserByUserType(Boolean userType) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserType
	 *
	 */
	public Set<User> findUserByUserType(Boolean userType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile1Containing
	 *
	 */
	public Set<User> findUserByMobile1Containing(String mobile1_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByMobile1Containing
	 *
	 */
	public Set<User> findUserByMobile1Containing(String mobile1_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId
	 *
	 */
	public Set<User> findUserByLoginId(String loginId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId
	 *
	 */
	public Set<User> findUserByLoginId(String loginId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryLogin
	 *
	 */
	public Set<User> findUserByPrimaryLogin(String primaryLogin_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryLogin
	 *
	 */
	public Set<User> findUserByPrimaryLogin(String primaryLogin_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteIpsContaining
	 *
	 */
	public Set<User> findUserByFavouriteIpsContaining(String favouriteIps) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteIpsContaining
	 *
	 */
	public Set<User> findUserByFavouriteIpsContaining(String favouriteIps, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEMailContaining
	 *
	 */
	public Set<User> findUserByEMailContaining(String EMail_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEMailContaining
	 *
	 */
	public Set<User> findUserByEMailContaining(String EMail_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginToken
	 *
	 */
	public Set<User> findUserByLoginToken(String loginToken) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginToken
	 *
	 */
	public Set<User> findUserByLoginToken(String loginToken, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionPositiveContaining
	 *
	 */
	public Set<User> findUserByPermissionPositiveContaining(String permissionPositive_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionPositiveContaining
	 *
	 */
	public Set<User> findUserByPermissionPositiveContaining(String permissionPositive_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId4Containing
	 *
	 */
	public Set<User> findUserByLoginId4Containing(String loginId4_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginId4Containing
	 *
	 */
	public Set<User> findUserByLoginId4Containing(String loginId4_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail2Containing
	 *
	 */
	public Set<User> findUserByEmail2Containing(String email2_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByEmail2Containing
	 *
	 */
	public Set<User> findUserByEmail2Containing(String email2_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginTokenContaining
	 *
	 */
	public Set<User> findUserByLoginTokenContaining(String loginToken_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByLoginTokenContaining
	 *
	 */
	public Set<User> findUserByLoginTokenContaining(String loginToken_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserEntityType
	 *
	 */
	public Set<User> findUserByUserEntityType(Boolean userEntityType) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserEntityType
	 *
	 */
	public Set<User> findUserByUserEntityType(Boolean userEntityType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteIps
	 *
	 */
	public Set<User> findUserByFavouriteIps(String favouriteIps_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByFavouriteIps
	 *
	 */
	public Set<User> findUserByFavouriteIps(String favouriteIps_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionNegativeContaining
	 *
	 */
	public Set<User> findUserByPermissionNegativeContaining(String permissionNegative_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPermissionNegativeContaining
	 *
	 */
	public Set<User> findUserByPermissionNegativeContaining(String permissionNegative_1, int startResult, int maxRows) throws DataAccessException;

	public EntityManager getEntityManager();
	List<User> findUsersForSearch(int startResult,Integer maxRows, String searchParameter);
	Integer countForSearch(String query);

}