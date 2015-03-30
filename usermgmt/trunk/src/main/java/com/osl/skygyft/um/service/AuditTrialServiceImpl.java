package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;
import com.osl.skygyft.um.dao.UserDAO;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for AuditTrial entities
 * 
 */

@Service("AuditTrialService")
@Transactional
public class AuditTrialServiceImpl implements AuditTrialService {

	/**
	 * DAO injected by Spring that manages AuditAction entities
	 * 
	 */
	@Autowired
	private AuditActionDAO auditActionDAO;

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
	 * Instantiates a new AuditTrialServiceImpl.
	 *
	 */
	public AuditTrialServiceImpl() {
	}

	/**
	 * Return a count of all AuditTrial entity
	 * 
	 */
	@Transactional
	public Integer countAuditTrials() {
		return ((Long) auditTrialDAO.createQuerySingleResult("select count(o) from AuditTrial o").getSingleResult()).intValue();
	}

	/**
	 * Return all AuditTrial entity
	 * 
	 */
	@Transactional
	public List<AuditTrial> findAllAuditTrials(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<AuditTrial>(auditTrialDAO.findAllAuditTrials(startResult, maxRows));
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@Transactional
	public AuditTrial deleteAuditTrialUser(Integer audittrial_auditId, Integer related_user_userId) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId, -1, -1);
		User related_user = userDAO.findUserByPrimaryKey(related_user_userId, -1, -1);

		audittrial.setUser(null);
		related_user.getAuditTrials().remove(audittrial);
		audittrial = auditTrialDAO.store(audittrial);
		auditTrialDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		userDAO.remove(related_user);
		userDAO.flush();

		return audittrial;
	}

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@Transactional
	public AuditTrial deleteAuditTrialAuditAction(Integer audittrial_auditId, Integer related_auditaction_id) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrial_auditId, -1, -1);
		AuditAction related_auditaction = auditActionDAO.findAuditActionByPrimaryKey(related_auditaction_id, -1, -1);

		audittrial.setAuditAction(null);
		related_auditaction.getAuditTrials().remove(audittrial);
		audittrial = auditTrialDAO.store(audittrial);
		auditTrialDAO.flush();

		related_auditaction = auditActionDAO.store(related_auditaction);
		auditActionDAO.flush();

		auditActionDAO.remove(related_auditaction);
		auditActionDAO.flush();

		return audittrial;
	}

	/**
	 * Load an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public Set<AuditTrial> loadAuditTrials() {
		return auditTrialDAO.findAllAuditTrials();
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public void saveAuditTrial(AuditTrial audittrial) {
		AuditTrial existingAuditTrial = auditTrialDAO.findAuditTrialByPrimaryKey(audittrial.getAuditId());

		if (existingAuditTrial != null) {
			if (existingAuditTrial != audittrial) {
				existingAuditTrial.setAuditId(audittrial.getAuditId());
				existingAuditTrial.setIpAddress(audittrial.getIpAddress());
				existingAuditTrial.setUserAgent(audittrial.getUserAgent());
				existingAuditTrial.setKeyword(audittrial.getKeyword());
				existingAuditTrial.setDescription(audittrial.getDescription());
				existingAuditTrial.setDateAdded(audittrial.getDateAdded());
				existingAuditTrial.setSuccesFailureFlag(audittrial.getSuccesFailureFlag());
				existingAuditTrial.setUserTypeFlag(audittrial.getUserTypeFlag());
			}
			audittrial = auditTrialDAO.store(existingAuditTrial);
		} else {
			audittrial = auditTrialDAO.store(audittrial);
		}
		auditTrialDAO.flush();
	}

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	@Transactional
	public AuditTrial saveAuditTrialAuditAction(Integer auditId, AuditAction related_auditaction) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(auditId, -1, -1);
		AuditAction existingauditAction = auditActionDAO.findAuditActionByPrimaryKey(related_auditaction.getId());

		// copy into the existing record to preserve existing relationships
		if (existingauditAction != null) {
			existingauditAction.setId(related_auditaction.getId());
			existingauditAction.setAction(related_auditaction.getAction());
			existingauditAction.setCreateDate(related_auditaction.getCreateDate());
			existingauditAction.setModifiedDate(related_auditaction.getModifiedDate());
			existingauditAction.setCreateBy(related_auditaction.getCreateBy());
			existingauditAction.setModifiedBy(related_auditaction.getModifiedBy());
			related_auditaction = existingauditAction;
		}

		audittrial.setAuditAction(related_auditaction);
		related_auditaction.getAuditTrials().add(audittrial);
		audittrial = auditTrialDAO.store(audittrial);
		auditTrialDAO.flush();

		related_auditaction = auditActionDAO.store(related_auditaction);
		auditActionDAO.flush();

		return audittrial;
	}

	/**
	 */
	@Transactional
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId) {
		return auditTrialDAO.findAuditTrialByPrimaryKey(auditId);
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public void deleteAuditTrial(AuditTrial audittrial) {
		auditTrialDAO.remove(audittrial);
		auditTrialDAO.flush();
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@Transactional
	public AuditTrial saveAuditTrialUser(Integer auditId, User related_user) {
		AuditTrial audittrial = auditTrialDAO.findAuditTrialByPrimaryKey(auditId, -1, -1);
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
		} else {
			related_user = userDAO.store(related_user);
			userDAO.flush();
		}

		audittrial.setUser(related_user);
		related_user.getAuditTrials().add(audittrial);
		audittrial = auditTrialDAO.store(audittrial);
		auditTrialDAO.flush();

		related_user = userDAO.store(related_user);
		userDAO.flush();

		return audittrial;
	}
}
