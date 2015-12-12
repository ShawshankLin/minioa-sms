/*
 */

package com.minioa2.project.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import org.springframework.expression.spel.ast.Assign;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



import java.util.*;

import javacommon.base.*;
import javacommon.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.minioa2.project.model.*;
import com.minioa2.project.dao.*;
import com.minioa2.project.service.*;
import com.minioa2.project.vo.query.*;

/**
 * @author jxx
 * @version 1.0
 * @since 1.0
 */


@Entity
@Table(name = "department")
public class Department extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Department";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "cid";
	
	public static final String ALIAS_CDATE = "cdate";
	
	public static final String ALIAS_MID = "mid";
	
	public static final String ALIAS_MDATE = "mdate";
	
	public static final String ALIAS_UUID = "uuid";
	
	public static final String ALIAS_ORG_ID = "orgId";
	
	public static final String ALIAS_PARENT_ID = "parentId";
	
	public static final String ALIAS_DEPA_NAME = "depaName";
	
	public static final String ALIAS_DEPA_DESC = "depaDesc";
	
	public static final String ALIAS_SEQUENCE = "sequence";
	
	
	//date formats
	public static final String FORMAT_CDATE = DATE_FORMAT;
	public static final String FORMAT_MDATE = DATE_FORMAT;
	

	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: ID_ 
     */ 	
	
	private java.lang.Integer id;
    /**
     * cid       db_column: CID_ 
     */ 	
	
	private java.lang.Integer cid;
    /**
     * cdate       db_column: CDATE_ 
     */ 	
	
	private java.util.Date cdate;
    /**
     * mid       db_column: MID_ 
     */ 	
	
	private java.lang.Integer mid;
    /**
     * mdate       db_column: MDATE_ 
     */ 	
	
	private java.util.Date mdate;
    /**
     * uuid       db_column: UUID_ 
     */ 	
	@Length(max=45)
	private java.lang.String uuid;
    /**
     * orgId       db_column: orgId 
     */ 	
	
	private java.lang.Integer orgId;
    /**
     * parentId       db_column: parentId 
     */ 	
	
	private java.lang.Integer parentId;
    /**
     * depaName       db_column: depaName 
     */ 	
	@Length(max=100)
	private java.lang.String depaName;
    /**
     * depaDesc       db_column: depaDesc 
     */ 	
	@Length(max=100)
	private java.lang.String depaDesc;
    /**
     * sequence       db_column: sequence 
     */ 	
	
	private java.lang.Integer sequence;
	//columns END


	public Department(){
	}

	public Department(
		java.lang.Integer id
	){
		this.id = id;
	}

	

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	@Id @GeneratedValue(generator="custom-id")
	@GenericGenerator(name="custom-id", strategy = "native")
	@Column(name = "ID_", unique = true, nullable = false, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getId() {
		return this.id;
	}
	
	@Column(name = "CID_", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getCid() {
		return this.cid;
	}
	
	public void setCid(java.lang.Integer value) {
		this.cid = value;
	}
	
	@Transient
	public String getCdateString() {
		return DateConvertUtils.format(getCdate(), FORMAT_CDATE);
	}
	public void setCdateString(String value) {
		setCdate(DateConvertUtils.parse(value, FORMAT_CDATE,java.util.Date.class));
	}
	
	@Column(name = "CDATE_", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public java.util.Date getCdate() {
		return this.cdate;
	}
	
	public void setCdate(java.util.Date value) {
		this.cdate = value;
	}
	
	@Column(name = "MID_", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMid() {
		return this.mid;
	}
	
	public void setMid(java.lang.Integer value) {
		this.mid = value;
	}
	
	@Transient
	public String getMdateString() {
		return DateConvertUtils.format(getMdate(), FORMAT_MDATE);
	}
	public void setMdateString(String value) {
		setMdate(DateConvertUtils.parse(value, FORMAT_MDATE,java.util.Date.class));
	}
	
	@Column(name = "MDATE_", unique = false, nullable = true, insertable = true, updatable = true, length = 0)
	public java.util.Date getMdate() {
		return this.mdate;
	}
	
	public void setMdate(java.util.Date value) {
		this.mdate = value;
	}
	
	@Column(name = "UUID_", unique = false, nullable = true, insertable = true, updatable = true, length = 45)
	public java.lang.String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(java.lang.String value) {
		this.uuid = value;
	}
	
	@Column(name = "orgId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	@Column(name = "parentId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	@Column(name = "depaName", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDepaName() {
		return this.depaName;
	}
	
	public void setDepaName(java.lang.String value) {
		this.depaName = value;
	}
	
	@Column(name = "depaDesc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDepaDesc() {
		return this.depaDesc;
	}
	
	public void setDepaDesc(java.lang.String value) {
		this.depaDesc = value;
	}
	
	@Column(name = "sequence", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getSequence() {
		return this.sequence;
	}
	
	public void setSequence(java.lang.Integer value) {
		this.sequence = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
	}
	
	private Set userDepaRelations = new HashSet(0);
	public void setUserDepaRelations(Set<UserDepaRelation> userDepaRelation){
		this.userDepaRelations = userDepaRelation;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "depaidModel")
	public Set<UserDepaRelation> getUserDepaRelations() {
		return userDepaRelations;
	}
	private User cidModel;
	public void setCidModel(User user){
		this.cidModel = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CID_",nullable = false, insertable = false, updatable = false) 
	})
	public User getCidModel() {
		return cidModel;
	}
	private User midModel;
	public void setMidModel(User user){
		this.midModel = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "MID_",nullable = false, insertable = false, updatable = false) 
	})
	public User getMidModel() {
		return midModel;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Mid",getMid())
			.append("Mdate",getMdate())
			.append("Uuid",getUuid())
			.append("OrgId",getOrgId())
			.append("ParentId",getParentId())
			.append("DepaName",getDepaName())
			.append("DepaDesc",getDepaDesc())
			.append("Sequence",getSequence())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Department == false) return false;
		if(this == obj) return true;
		Department other = (Department)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

