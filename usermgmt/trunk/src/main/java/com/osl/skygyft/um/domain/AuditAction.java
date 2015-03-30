package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAuditActions", query = "select myAuditAction from AuditAction myAuditAction"),
		@NamedQuery(name = "findAuditActionByAction", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.action = ?1"),
		@NamedQuery(name = "findAuditActionByActionContaining", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.action like ?1"),
		@NamedQuery(name = "findAuditActionByCreateBy", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.createBy = ?1"),
		@NamedQuery(name = "findAuditActionByCreateByContaining", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.createBy like ?1"),
		@NamedQuery(name = "findAuditActionByCreateDate", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.createDate = ?1"),
		@NamedQuery(name = "findAuditActionById", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.id = ?1"),
		@NamedQuery(name = "findAuditActionByModifiedBy", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.modifiedBy = ?1"),
		@NamedQuery(name = "findAuditActionByModifiedByContaining", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.modifiedBy like ?1"),
		@NamedQuery(name = "findAuditActionByModifiedDate", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.modifiedDate = ?1"),
		@NamedQuery(name = "findAuditActionByPrimaryKey", query = "select myAuditAction from AuditAction myAuditAction where myAuditAction.id = ?1") })
@Table(name = "audit_action")
@SQLDelete(sql="UPDATE audit_action SET date_deletion=CURRENT_DATE WHERE id=? ")
@Where(clause="date_deletion IS NULL ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "AuditAction")
@XmlRootElement(namespace = "um/com/osl/skygyft/um/domain")
public class AuditAction implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "action", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String action;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar modifiedDate;
	/**
	 */

	@Column(name = "create_by", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String createBy;
	/**
	 */

	@Column(name = "modified_by", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String modifiedBy;

	/**
	 */
	@OneToMany(mappedBy = "auditAction", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.osl.skygyft.um.domain.AuditTrial> auditTrials;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 */
	public String getAction() {
		return this.action;
	}

	/**
	 */
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	/**
	 */
	public Calendar getCreateDate() {
		return this.createDate;
	}

	/**
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 */
	public Calendar getModifiedDate() {
		return this.modifiedDate;
	}

	/**
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 */
	public String getCreateBy() {
		return this.createBy;
	}

	/**
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 */
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	/**
	 */
	public void setAuditTrials(Set<AuditTrial> auditTrials) {
		this.auditTrials = auditTrials;
	}

	/**
	 */
	@JsonIgnore
	public Set<AuditTrial> getAuditTrials() {
		if (auditTrials == null) {
			auditTrials = new java.util.LinkedHashSet<com.osl.skygyft.um.domain.AuditTrial>();
		}
		return auditTrials;
	}

	/**
	 */
	public AuditAction() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AuditAction that) {
		setId(that.getId());
		setAction(that.getAction());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
		setAuditTrials(new java.util.LinkedHashSet<com.osl.skygyft.um.domain.AuditTrial>(that.getAuditTrials()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("action=[").append(action).append("] ");
		buffer.append("createDate=[").append(createDate).append("] ");
		buffer.append("modifiedDate=[").append(modifiedDate).append("] ");
		buffer.append("createBy=[").append(createBy).append("] ");
		buffer.append("modifiedBy=[").append(modifiedBy).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AuditAction))
			return false;
		AuditAction equalCheck = (AuditAction) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
