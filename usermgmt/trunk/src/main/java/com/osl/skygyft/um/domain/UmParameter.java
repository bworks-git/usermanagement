package com.osl.skygyft.um.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUmParameters", query = "select myUmParameter from UmParameter myUmParameter"),
		@NamedQuery(name = "findUmParameterByCreateBy", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.createBy = ?1"),
		@NamedQuery(name = "findUmParameterByCreateByContaining", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.createBy like ?1"),
		@NamedQuery(name = "findUmParameterByCreateDate", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.createDate = ?1"),
		@NamedQuery(name = "findUmParameterById", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.id = ?1"),
		@NamedQuery(name = "findUmParameterByModifiedBy", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.modifiedBy = ?1"),
		@NamedQuery(name = "findUmParameterByModifiedByContaining", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.modifiedBy like ?1"),
		@NamedQuery(name = "findUmParameterByModifiedDate", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.modifiedDate = ?1"),
		@NamedQuery(name = "findUmParameterByParamKey", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramKey = ?1"),
		@NamedQuery(name = "findUmParameterByParamKeyContaining", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramKey like ?1"),
		@NamedQuery(name = "findUmParameterByParamName", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramName = ?1"),
		@NamedQuery(name = "findUmParameterByParamNameContaining", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramName like ?1"),
		@NamedQuery(name = "findUmParameterByParamType", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramType = ?1"),
		@NamedQuery(name = "findUmParameterByParamValue", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramValue = ?1"),
		@NamedQuery(name = "findUmParameterByParamValueContaining", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.paramValue like ?1"),
		@NamedQuery(name = "findUmParameterByPrimaryKey", query = "select myUmParameter from UmParameter myUmParameter where myUmParameter.id = ?1") })
@Table(name = "um_parameters")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "um/com/osl/skygyft/um/domain", name = "UmParameter")
public class UmParameter implements Serializable {
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

	@Column(name = "param_key", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paramKey;
	/**
	 */

	@Column(name = "param_name", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paramName;
	/**
	 */

	@Column(name = "param_value", length = 1000, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String paramValue;
	/**
	 */

	@Column(name = "param_type", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer paramType;
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
	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}

	/**
	 */
	public String getParamKey() {
		return this.paramKey;
	}

	/**
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 */
	public String getParamName() {
		return this.paramName;
	}

	/**
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	/**
	 */
	public String getParamValue() {
		return this.paramValue;
	}

	/**
	 */
	public void setParamType(Integer paramType) {
		this.paramType = paramType;
	}

	/**
	 */
	public Integer getParamType() {
		return this.paramType;
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
	public UmParameter() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UmParameter that) {
		setId(that.getId());
		setParamKey(that.getParamKey());
		setParamName(that.getParamName());
		setParamValue(that.getParamValue());
		setParamType(that.getParamType());
		setCreateDate(that.getCreateDate());
		setModifiedDate(that.getModifiedDate());
		setCreateBy(that.getCreateBy());
		setModifiedBy(that.getModifiedBy());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("paramKey=[").append(paramKey).append("] ");
		buffer.append("paramName=[").append(paramName).append("] ");
		buffer.append("paramValue=[").append(paramValue).append("] ");
		buffer.append("paramType=[").append(paramType).append("] ");
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
		if (!(obj instanceof UmParameter))
			return false;
		UmParameter equalCheck = (UmParameter) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
