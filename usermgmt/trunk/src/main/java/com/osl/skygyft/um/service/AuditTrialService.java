package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;
import com.osl.skygyft.um.domain.User;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for AuditTrial entities
 * 
 */
public interface AuditTrialService {

	/**
	 * Return a count of all AuditTrial entity
	 * 
	 */
	public Integer countAuditTrials();

	/**
	 * Return all AuditTrial entity
	 * 
	 */
	public List<AuditTrial> findAllAuditTrials(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing User entity
	 * 
	 */
	public AuditTrial deleteAuditTrialUser(Integer audittrial_auditId, Integer related_user_userId);

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	public AuditTrial deleteAuditTrialAuditAction(Integer audittrial_auditId_1, Integer related_auditaction_id);

	/**
	 * Load an existing AuditTrial entity
	 * 
	 */
	public Set<AuditTrial> loadAuditTrials();

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	public void saveAuditTrial(AuditTrial audittrial);

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	public AuditTrial saveAuditTrialAuditAction(Integer auditId, AuditAction related_auditaction);

	/**
	 */
	public AuditTrial findAuditTrialByPrimaryKey(Integer auditId_1);

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	public void deleteAuditTrial(AuditTrial audittrial_1);

	/**
	 * Save an existing User entity
	 * 
	 */
	public AuditTrial saveAuditTrialUser(Integer auditId_2, User related_user);
}