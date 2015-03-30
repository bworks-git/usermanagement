package com.osl.skygyft.um.service;

import com.osl.skygyft.um.dao.AuditActionDAO;
import com.osl.skygyft.um.dao.AuditTrialDAO;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for AuditAction entities
 * 
 */

@Service("AuditActionService")
@Transactional
public class AuditActionServiceImpl implements AuditActionService {

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
	 * Instantiates a new AuditActionServiceImpl.
	 *
	 */
	public AuditActionServiceImpl() {
	}

	/**
	 * Load an existing AuditAction entity
	 * 
	 */
	@Transactional
	public Set<AuditAction> loadAuditActions() {
		return auditActionDAO.findAllAuditActions();
	}

	/**
	 * Return all AuditAction entity
	 * 
	 */
	@Transactional
	public List<AuditAction> findAllAuditActions(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<AuditAction>(auditActionDAO.findAllAuditActions(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public AuditAction findAuditActionByPrimaryKey(Integer id) {
		return auditActionDAO.findAuditActionByPrimaryKey(id);
	}

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public AuditAction deleteAuditActionAuditTrials(Integer auditaction_id, Integer related_audittrials_auditId) {
		AuditTrial related_audittrials = auditTrialDAO.findAuditTrialByPrimaryKey(related_audittrials_auditId, -1, -1);

		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(auditaction_id, -1, -1);

		related_audittrials.setAuditAction(null);
		auditaction.getAuditTrials().remove(related_audittrials);

		auditTrialDAO.remove(related_audittrials);
		auditTrialDAO.flush();

		return auditaction;
	}

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	@Transactional
	public void saveAuditAction(AuditAction auditaction) {
		AuditAction existingAuditAction = auditActionDAO.findAuditActionByPrimaryKey(auditaction.getId());

		if (existingAuditAction != null) {
			if (existingAuditAction != auditaction) {
				existingAuditAction.setId(auditaction.getId());
				existingAuditAction.setAction(auditaction.getAction());
				existingAuditAction.setCreateDate(auditaction.getCreateDate());
				existingAuditAction.setModifiedDate(auditaction.getModifiedDate());
				existingAuditAction.setCreateBy(auditaction.getCreateBy());
				existingAuditAction.setModifiedBy(auditaction.getModifiedBy());
			}
			auditaction = auditActionDAO.store(existingAuditAction);
		} else {
			auditaction = auditActionDAO.store(auditaction);
		}
		auditActionDAO.flush();
	}

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	@Transactional
	public void deleteAuditAction(AuditAction auditaction) {
		auditActionDAO.remove(auditaction);
		auditActionDAO.flush();
	}

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	@Transactional
	public AuditAction saveAuditActionAuditTrials(Integer id, AuditTrial related_audittrials) {
		AuditAction auditaction = auditActionDAO.findAuditActionByPrimaryKey(id, -1, -1);
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
		}

		related_audittrials.setAuditAction(auditaction);
		auditaction.getAuditTrials().add(related_audittrials);
		related_audittrials = auditTrialDAO.store(related_audittrials);
		auditTrialDAO.flush();

		auditaction = auditActionDAO.store(auditaction);
		auditActionDAO.flush();

		return auditaction;
	}

	/**
	 * Return a count of all AuditAction entity
	 * 
	 */
	@Transactional
	public Integer countAuditActions() {
		return ((Long) auditActionDAO.createQuerySingleResult("select count(o) from AuditAction o").getSingleResult()).intValue();
	}
}
