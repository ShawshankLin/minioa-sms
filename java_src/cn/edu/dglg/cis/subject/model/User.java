/*
 */

package cn.edu.dglg.cis.subject.model;

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
import cn.edu.dglg.cis.subject.dao.*;
import cn.edu.dglg.cis.subject.model.*;
import cn.edu.dglg.cis.subject.service.*;
import cn.edu.dglg.cis.subject.vo.query.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

/**
 * @author jxx
 * @version 1.0
 * @since 1.0
 */


@Entity
@Table(name = "user")
public class User extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "用户";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "操作人ID";
	
	public static final String ALIAS_CDATE = "操作日期";
	
	public static final String ALIAS_MID = "mid";
	
	public static final String ALIAS_MDATE = "mdate";
	
	public static final String ALIAS_UUID = "uuid";
	
	public static final String ALIAS_USER_NAME = "用户名";
	
	public static final String ALIAS_DEPA_ID = "depaId";
	
	public static final String ALIAS_JOB_ID = "jobId";
	
	public static final String ALIAS_EMAIL = "电子邮件";
	
	public static final String ALIAS_PASSWORD = "密码";
	
	public static final String ALIAS_PHONE = "电话";
	
	public static final String ALIAS_MOBILE_PHONE = "手机号码";
	
	public static final String ALIAS_GENDER = "性别";
	
	public static final String ALIAS_DISPLAY_NAME = "显示名称";
	
	public static final String ALIAS_IS_LOCK = "是否锁定";
	
	public static final String ALIAS_JOB_ID2 = "jobId2";
	
	public static final String ALIAS_NOTE_SEND_NUM = "noteSendNum";
	
	public static final String ALIAS_MAIL_SEND_NUM = "mailSendNum";
	
	public static final String ALIAS_STATUS = "状态";
	
	public static final String ALIAS_CLIENTID = "clientid";
	
	
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
     * userName       db_column: userName 
     */ 	
	@Length(max=100)
	private java.lang.String userName;
    /**
     * depaId       db_column: depaId 
     */ 	
	
	private java.lang.Integer depaId;
    /**
     * jobId       db_column: jobId 
     */ 	
	@Length(max=45)
	private java.lang.String jobId;
    /**
     * email       db_column: email 
     */ 	
	@Email @Length(max=100)
	private java.lang.String email;
    /**
     * password       db_column: password 
     */ 	
	@Length(max=300)
	private java.lang.String password;
    /**
     * phone       db_column: phone 
     */ 	
	@Length(max=100)
	private java.lang.String phone;
    /**
     * mobilePhone       db_column: mobilePhone 
     */ 	
	@Length(max=100)
	private java.lang.String mobilePhone;
    /**
     * gender       db_column: gender 
     */ 	
	@Length(max=1)
	private java.lang.String gender;
    /**
     * displayName       db_column: displayName 
     */ 	
	@Length(max=100)
	private java.lang.String displayName;
    /**
     * isLock       db_column: isLock 
     */ 	
	@Length(max=1)
	private java.lang.String isLock;
    /**
     * jobId2       db_column: jobId2 
     */ 	
	
	private java.lang.Integer jobId2;
    /**
     * noteSendNum       db_column: noteSendNum 
     */ 	
	
	private java.lang.Integer noteSendNum;
    /**
     * mailSendNum       db_column: mailSendNum 
     */ 	
	@Email
	private java.lang.Integer mailSendNum;
    /**
     * status       db_column: status 
     */ 	
	
	private java.lang.Integer status;
    /**
     * clientid       db_column: clientid 
     */ 	
	@Length(max=50)
	private java.lang.String clientid;
	//columns END


	public User(){
	}

	public User(
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
	
	@Column(name = "userName", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	@Column(name = "depaId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getDepaId() {
		return this.depaId;
	}
	
	public void setDepaId(java.lang.Integer value) {
		this.depaId = value;
	}
	
	@Column(name = "jobId", unique = false, nullable = true, insertable = true, updatable = true, length = 45)
	public java.lang.String getJobId() {
		return this.jobId;
	}
	
	public void setJobId(java.lang.String value) {
		this.jobId = value;
	}
	
	@Column(name = "email", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	@Column(name = "password", unique = false, nullable = true, insertable = true, updatable = true, length = 300)
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	@Column(name = "phone", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	@Column(name = "mobilePhone", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getMobilePhone() {
		return this.mobilePhone;
	}
	
	public void setMobilePhone(java.lang.String value) {
		this.mobilePhone = value;
	}
	
	@Column(name = "gender", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.String getGender() {
		return this.gender;
	}
	
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	@Column(name = "displayName", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getDisplayName() {
		return this.displayName;
	}
	
	public void setDisplayName(java.lang.String value) {
		this.displayName = value;
	}
	
	@Column(name = "isLock", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public java.lang.String getIsLock() {
		return this.isLock;
	}
	
	public void setIsLock(java.lang.String value) {
		this.isLock = value;
	}
	
	@Column(name = "jobId2", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getJobId2() {
		return this.jobId2;
	}
	
	public void setJobId2(java.lang.Integer value) {
		this.jobId2 = value;
	}
	
	@Column(name = "noteSendNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getNoteSendNum() {
		return this.noteSendNum;
	}
	
	public void setNoteSendNum(java.lang.Integer value) {
		this.noteSendNum = value;
	}
	
	@Column(name = "mailSendNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMailSendNum() {
		return this.mailSendNum;
	}
	
	public void setMailSendNum(java.lang.Integer value) {
		this.mailSendNum = value;
	}
	
	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	@Column(name = "clientid", unique = false, nullable = true, insertable = true, updatable = true, length = 50)
	public java.lang.String getClientid() {
		return this.clientid;
	}
	
	public void setClientid(java.lang.String value) {
		this.clientid = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
	}
	
	private Set mailSends = new HashSet(0);
	public void setMailSends(Set<MailSend> mailSend){
		this.mailSends = mailSend;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cidModel")
	public Set<MailSend> getMailSends() {
		return mailSends;
	}
	private Set userDepaRelations = new HashSet(0);
	public void setUserDepaRelations(Set<UserDepaRelation> userDepaRelation){
		this.userDepaRelations = userDepaRelation;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "useridModel")
	public Set<UserDepaRelation> getUserDepaRelations() {
		return userDepaRelations;
	}
	private Set mailReceives = new HashSet(0);
	public void setMailReceives(Set<MailReceive> mailReceive){
		this.mailReceives = mailReceive;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cidModel")
	public Set<MailReceive> getMailReceives() {
		return mailReceives;
	}
	private Set departments = new HashSet(0);
	public void setDepartments(Set<Department> department){
		this.departments = department;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cidModel")
	public Set<Department> getDepartments() {
		return departments;
	}
	private Set roleUserRelations = new HashSet(0);
	public void setRoleUserRelations(Set<RoleUserRelation> roleUserRelation){
		this.roleUserRelations = roleUserRelation;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "userIdModel")
	public Set<RoleUserRelation> getRoleUserRelations() {
		return roleUserRelations;
	}
	private Set noteReceives = new HashSet(0);
	public void setNoteReceives(Set<NoteReceive> noteReceive){
		this.noteReceives = noteReceive;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "midModel")
	public Set<NoteReceive> getNoteReceives() {
		return noteReceives;
	}
	private Set noteSends = new HashSet(0);
	public void setNoteSends(Set<NoteSend> noteSend){
		this.noteSends = noteSend;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "midModel")
	public Set<NoteSend> getNoteSends() {
		return noteSends;
	}
	private Set logs = new HashSet(0);
	public void setLogs(Set<Log> log){
		this.logs = log;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cidModel")
	public Set<Log> getLogs() {
		return logs;
	}
	private Set mailAttachments = new HashSet(0);
	public void setMailAttachments(Set<MailAttachment> mailAttachment){
		this.mailAttachments = mailAttachment;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cidModel")
	public Set<MailAttachment> getMailAttachments() {
		return mailAttachments;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Mid",getMid())
			.append("Mdate",getMdate())
			.append("Uuid",getUuid())
			.append("UserName",getUserName())
			.append("DepaId",getDepaId())
			.append("JobId",getJobId())
			.append("Email",getEmail())
			.append("Password",getPassword())
			.append("Phone",getPhone())
			.append("MobilePhone",getMobilePhone())
			.append("Gender",getGender())
			.append("DisplayName",getDisplayName())
			.append("IsLock",getIsLock())
			.append("JobId2",getJobId2())
			.append("NoteSendNum",getNoteSendNum())
			.append("MailSendNum",getMailSendNum())
			.append("Status",getStatus())
			.append("Clientid",getClientid())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

