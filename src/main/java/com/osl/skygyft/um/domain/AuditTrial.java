package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllAuditTrials", query = "select myAuditTrial from AuditTrial myAuditTrial"),
		@NamedQuery(name = "findAuditTrialByAuditId", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.auditId = ?1"),
		@NamedQuery(name = "findAuditTrialByDateAdded", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.dateAdded = ?1"),
		@NamedQuery(name = "findAuditTrialByDescription", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.description = ?1"),
		@NamedQuery(name = "findAuditTrialByDescriptionContaining", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.description like ?1"),
		@NamedQuery(name = "findAuditTrialByIpAddress", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.ipAddress = ?1"),
		@NamedQuery(name = "findAuditTrialByIpAddressContaining", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.ipAddress like ?1"),
		@NamedQuery(name = "findAuditTrialByKeyword", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.keyword = ?1"),
		@NamedQuery(name = "findAuditTrialByKeywordContaining", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.keyword like ?1"),
		@NamedQuery(name = "findAuditTrialByPrimaryKey", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.auditId = ?1"),
		@NamedQuery(name = "findAuditTrialBySuccesFailureFlag", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.succesFailureFlag = ?1"),
		@NamedQuery(name = "findAuditTrialByUserAgent", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.userAgent = ?1"),
		@NamedQuery(name = "findAuditTrialByUserAgentContaining", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.userAgent like ?1"),
		@NamedQuery(name = "findAuditTrialByUserTypeFlag", query = "select myAuditTrial from AuditTrial myAuditTrial where myAuditTrial.userTypeFlag = ?1") })
@Table(name = "audit_trial")
@SQLDelete(sql="UPDATE audit_trial SET date_deletion=CURRENT_DATE WHERE id=? ")
@Where(clause="date_deletion IS NULL ")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "AuditTrial")
public class AuditTrial implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "audit_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@GeneratedValue
	@XmlElement
	Integer auditId;
	/**
	 */

	@Column(name = "ip_address", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ipAddress;
	
	@Formula("SUBSTRING_INDEX(ip_address, '.', 1)")
	@Basic(fetch = FetchType.LAZY)
	String ipSegment1;
	
	@Formula("SUBSTRING_INDEX(SUBSTRING_INDEX(ip_address, '.', 2), '.' , -1)")
	@Basic(fetch = FetchType.LAZY)
	String ipSegment2;
	
	@Formula("SUBSTRING_INDEX(SUBSTRING_INDEX(ip_address, '.', - 2), '.', 1)")
	@Basic(fetch = FetchType.LAZY)
	String ipSegment3;
	
	@Formula("SUBSTRING_INDEX(ip_address, '.', -1)")
	@Basic(fetch = FetchType.LAZY)
	String ipSegment4;
	
	/**
	 */

	@Column(name = "user_agent", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String userAgent;
	/**
	 */

	@Column(name = "keyword")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String keyword;
	/**
	 */

	@Column(name = "description")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String description;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_added", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar dateAdded;
	/**
	 */

	@Column(name = "succes_failure_flag", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean succesFailureFlag;
	/**
	 */

	@Column(name = "user_type_flag")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean userTypeFlag;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id") })
	@XmlTransient
	User user;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "audit_action_id", referencedColumnName = "id", nullable = true) })
	@XmlTransient
	AuditAction auditAction;

	/**
	 */
	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	/**
	 */
	public Integer getAuditId() {
		return this.auditId;
	}

	/**
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 */
	public String getIpAddress() {
		return this.ipAddress;
	}

	/**
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 */
	public String getUserAgent() {
		return this.userAgent;
	}

	/**
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 */
	public String getKeyword() {
		return this.keyword;
	}

	/**
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 */
	public void setDateAdded(Calendar dateAdded) {
		this.dateAdded = dateAdded;
	}

	/**
	 */
	public Calendar getDateAdded() {
		return this.dateAdded;
	}

	/**
	 */
	public void setSuccesFailureFlag(Boolean succesFailureFlag) {
		this.succesFailureFlag = succesFailureFlag;
	}

	/**
	 */
	public Boolean getSuccesFailureFlag() {
		return this.succesFailureFlag;
	}

	/**
	 */
	public void setUserTypeFlag(Boolean userTypeFlag) {
		this.userTypeFlag = userTypeFlag;
	}

	/**
	 */
	public Boolean getUserTypeFlag() {
		return this.userTypeFlag;
	}

	/**
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 */
	@JsonIgnore
	public User getUser() {
		return user;
	}

	/**
	 */
	public void setAuditAction(AuditAction auditAction) {
		this.auditAction = auditAction;
	}

	/**
	 */
	@JsonIgnore
	public AuditAction getAuditAction() {
		return auditAction;
	}

	/**
	 */
	public AuditTrial() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(AuditTrial that) {
		setAuditId(that.getAuditId());
		setIpAddress(that.getIpAddress());
		setUserAgent(that.getUserAgent());
		setKeyword(that.getKeyword());
		setDescription(that.getDescription());
		setDateAdded(that.getDateAdded());
		setSuccesFailureFlag(that.getSuccesFailureFlag());
		setUserTypeFlag(that.getUserTypeFlag());
		setUser(that.getUser());
		setAuditAction(that.getAuditAction());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("auditId=[").append(auditId).append("] ");
		buffer.append("ipAddress=[").append(ipAddress).append("] ");
		buffer.append("userAgent=[").append(userAgent).append("] ");
		buffer.append("keyword=[").append(keyword).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("dateAdded=[").append(dateAdded).append("] ");
		buffer.append("succesFailureFlag=[").append(succesFailureFlag).append("] ");
		buffer.append("userTypeFlag=[").append(userTypeFlag).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((auditId == null) ? 0 : auditId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof AuditTrial))
			return false;
		AuditTrial equalCheck = (AuditTrial) obj;
		if ((auditId == null && equalCheck.auditId != null) || (auditId != null && equalCheck.auditId == null))
			return false;
		if (auditId != null && !auditId.equals(equalCheck.auditId))
			return false;
		return true;
	}

	public String getIpSegment1() {
		return ipSegment1;
	}

	public void setIpSegment1(String ipSegment1) {
		this.ipSegment1 = ipSegment1;
	}

	public String getIpSegment2() {
		return ipSegment2;
	}

	public void setIpSegment2(String ipSegment2) {
		this.ipSegment2 = ipSegment2;
	}

	public String getIpSegment3() {
		return ipSegment3;
	}

	public void setIpSegment3(String ipSegment3) {
		this.ipSegment3 = ipSegment3;
	}

	public String getIpSegment4() {
		return ipSegment4;
	}

	public void setIpSegment4(String ipSegment4) {
		this.ipSegment4 = ipSegment4;
	}
}
