package com.osl.skygyft.um.service;

import com.osl.skygyft.um.domain.AuditAction;
import com.osl.skygyft.um.domain.AuditTrial;

import java.util.List;
import java.util.Set;

/**
 * Spring service that handles CRUD requests for AuditAction entities
 * 
 */
public interface AuditActionService {

	/**
	 * Load an existing AuditAction entity
	 * 
	 */
	public Set<AuditAction> loadAuditActions();

	/**
	 * Return all AuditAction entity
	 * 
	 */
	public List<AuditAction> findAllAuditActions(Integer startResult, Integer maxRows);

	/**
	 */
	public AuditAction findAuditActionByPrimaryKey(Integer id);

	/**
	 * Delete an existing AuditTrial entity
	 * 
	 */
	public AuditAction deleteAuditActionAuditTrials(Integer auditaction_id, Integer related_audittrials_auditId);

	/**
	 * Save an existing AuditAction entity
	 * 
	 */
	public void saveAuditAction(AuditAction auditaction);

	/**
	 * Delete an existing AuditAction entity
	 * 
	 */
	public void deleteAuditAction(AuditAction auditaction_1);

	/**
	 * Save an existing AuditTrial entity
	 * 
	 */
	public AuditAction saveAuditActionAuditTrials(Integer id_1, AuditTrial related_audittrials);

	/**
	 * Return a count of all AuditAction entity
	 * 
	 */
	public Integer countAuditActions();
}