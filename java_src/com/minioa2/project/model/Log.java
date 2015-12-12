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
@Table(name = "log")
public class Log extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "日志";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "操作人";
	
	public static final String ALIAS_CDATE = "操作日期";
	
	public static final String ALIAS_TAG = "标签";
	
	public static final String ALIAS_REF_ID = "refId";
	
	public static final String ALIAS_SUMMARY = "摘要";
	
	public static final String ALIAS_DETAILS = "details";
	
	public static final String ALIAS_IP = "ip";
	
	
	//date formats
	public static final String FORMAT_CDATE = DATE_FORMAT;
	

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
     * tag       db_column: tag 
     */ 	
	@Length(max=100)
	private java.lang.String tag;
    /**
     * refId       db_column: refId 
     */ 	
	
	private java.lang.Integer refId;
    /**
     * summary       db_column: summary 
     */ 	
	@Length(max=4000)
	private java.lang.String summary;
    /**
     * details       db_column: details 
     */ 	
	@Length(max=4000)
	private java.lang.String details;
    /**
     * ip       db_column: ip 
     */ 	
	@Length(max=45)
	private java.lang.String ip;
	//columns END


	public Log(){
	}

	public Log(
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
	
	@Column(name = "tag", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getTag() {
		return this.tag;
	}
	
	public void setTag(java.lang.String value) {
		this.tag = value;
	}
	
	@Column(name = "refId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getRefId() {
		return this.refId;
	}
	
	public void setRefId(java.lang.Integer value) {
		this.refId = value;
	}
	
	@Column(name = "summary", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getSummary() {
		return this.summary;
	}
	
	public void setSummary(java.lang.String value) {
		this.summary = value;
	}
	
	@Column(name = "details", unique = false, nullable = true, insertable = true, updatable = true, length = 4000)
	public java.lang.String getDetails() {
		return this.details;
	}
	
	public void setDetails(java.lang.String value) {
		this.details = value;
	}
	
	@Column(name = "ip", unique = false, nullable = true, insertable = true, updatable = true, length = 45)
	public java.lang.String getIp() {
		return this.ip;
	}
	
	public void setIp(java.lang.String value) {
		this.ip = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Tag",getTag())
			.append("RefId",getRefId())
			.append("Summary",getSummary())
			.append("Details",getDetails())
			.append("Ip",getIp())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Log == false) return false;
		if(this == obj) return true;
		Log other = (Log)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

