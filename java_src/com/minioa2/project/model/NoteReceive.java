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
@Table(name = "note_receive")
public class NoteReceive extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "短信接收";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "发件人";
	
	public static final String ALIAS_CDATE = "创建日期";
	
	public static final String ALIAS_MID = "mid";
	
	public static final String ALIAS_MDATE = "mdate";
	
	public static final String ALIAS_UUID = "uuid";
	
	public static final String ALIAS_RECIPIENT = "收件人";
	
	public static final String ALIAS_SUBJECT = "标题";
	
	public static final String ALIAS_MESSAGE = "内容";
	
	public static final String ALIAS_NOTESTATUS = "状态";
	
	public static final String ALIAS_SENDLIST = "sendlist";
	
	public static final String ALIAS_SENDID = "sendid";
	
	public static final String ALIAS_FROMID = "fromid";
	
	public static final String ALIAS_MSG_TXT = "纯文本";
	
	public static final String ALIAS_TYPE = "type";
	
	public static final String ALIAS_URL = "url";
	
	
	//date formats
	public static final String FORMAT_CDATE = DATE_TIME_FORMAT;
	public static final String FORMAT_MDATE = DATE_TIME_FORMAT;
	

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
     * recipient       db_column: recipient 
     */ 	
	@Length(max=65535)
	private java.lang.String recipient;
    /**
     * subject       db_column: subject 
     */ 	
	@Length(max=200)
	private java.lang.String subject;
    /**
     * message       db_column: message 
     */ 	
	@Length(max=65535)
	private java.lang.String message;
    /**
     * notestatus       db_column: notestatus 
     */ 	
	@Length(max=32)
	private java.lang.String notestatus;
    /**
     * sendlist       db_column: sendlist 
     */ 	
	@Length(max=2048)
	private java.lang.String sendlist;
    /**
     * sendid       db_column: sendid 
     */ 	
	@Length(max=32)
	private java.lang.String sendid;
	/**
     * fromid       db_column: fromid 
     */ 	
	
	private java.lang.Integer fromid;
    /**
     * msgTxt       db_column: msg_txt 
     */ 	
	@Length(max=65535)
	private java.lang.String msgTxt;
    /**
     * type       db_column: type 
     */ 	
	
	private java.lang.Integer type;
    /**
     * url       db_column: url 
     */ 	
	@Length(max=2048)
	private java.lang.String url;
	//columns END


	public NoteReceive(){
	}

	public NoteReceive(
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
	
	@Column(name = "recipient", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getRecipient() {
		return this.recipient;
	}
	
	public void setRecipient(java.lang.String value) {
		this.recipient = value;
	}
	
	@Column(name = "subject", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getSubject() {
		return this.subject;
	}
	
	public void setSubject(java.lang.String value) {
		this.subject = value;
	}
	
	@Column(name = "message", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getMessage() {
		return this.message;
	}
	
	public void setMessage(java.lang.String value) {
		this.message = value;
	}
	
	@Column(name = "notestatus", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getNotestatus() {
		return this.notestatus;
	}
	
	public void setNotestatus(java.lang.String value) {
		this.notestatus = value;
	}
	
	@Column(name = "sendlist", unique = false, nullable = true, insertable = true, updatable = true, length = 2048)
	public java.lang.String getSendlist() {
		return this.sendlist;
	}
	
	public void setSendlist(java.lang.String value) {
		this.sendlist = value;
	}
	
	@Column(name = "sendid", unique = false, nullable = true, insertable = true, updatable = true, length = 32)
	public java.lang.String getSendid() {
		return this.sendid;
	}
	
	public void setSendid(java.lang.String value) {
		this.sendid = value;
	}
	
	@Column(name = "fromid", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getFromid() {
		return this.fromid;
	}
	
	public void setFromid(java.lang.Integer value) {
		this.fromid = value;
	}
	
	@Column(name = "msg_txt", unique = false, nullable = true, insertable = true, updatable = true, length = 65535)
	public java.lang.String getMsgTxt() {
		return this.msgTxt;
	}
	
	public void setMsgTxt(java.lang.String value) {
		this.msgTxt = value;
	}
	
	@Column(name = "type", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	@Column(name = "url", unique = false, nullable = true, insertable = true, updatable = true, length = 2048)
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
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

	private NoteSend fromidModel;
	public void setFromidModel(NoteSend noteSend){
		this.fromidModel = noteSend;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "fromid",nullable = false, insertable = false, updatable = false) 
	})
	public NoteSend getFromidModel() {
		return fromidModel;
	}
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Mid",getMid())
			.append("Mdate",getMdate())
			.append("Uuid",getUuid())
			.append("Recipient",getRecipient())
			.append("Subject",getSubject())
			.append("Message",getMessage())
			.append("Notestatus",getNotestatus())
			.append("Sendlist",getSendlist())
			.append("Sendid",getSendid())
			.append("MsgTxt",getMsgTxt())
			.append("Type",getType())
			.append("Url",getUrl())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof NoteReceive == false) return false;
		if(this == obj) return true;
		NoteReceive other = (NoteReceive)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

