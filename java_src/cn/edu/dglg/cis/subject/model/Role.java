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
@Table(name = "role")
public class Role extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "角色";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "操作人ID";
	
	public static final String ALIAS_CDATE = "cdate";
	
	public static final String ALIAS_MID = "mid";
	
	public static final String ALIAS_MDATE = "mdate";
	
	public static final String ALIAS_UUID = "uuid";
	
	public static final String ALIAS_ROLE_NAME = "roleName";
	
	public static final String ALIAS_ROLE_DESC = "roleDesc";
	
	public static final String ALIAS_ROLE_MAIL_NUM = "roleMailNum";
	
	public static final String ALIAS_ROLE_NOTE_NUM = "roleNoteNum";
	
	public static final String ALIAS_PERSON_MAIL_NUM = "personMailNum";
	
	public static final String ALIAS_PERSON_NOTE_NUM = "personNoteNum";
	
	public static final String ALIAS_NOREADNUM = "noreadnum";
	
	public static final String ALIAS_MAILSIZE = "mailsize";
	
	
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
     * roleName       db_column: roleName 
     */ 	
	@Length(max=100)
	private java.lang.String roleName;
    /**
     * roleDesc       db_column: roleDesc 
     */ 	
	@Length(max=100)
	private java.lang.String roleDesc;
    /**
     * roleMailNum       db_column: roleMailNum 
     */ 	
	
	private java.lang.Integer roleMailNum;
    /**
     * roleNoteNum       db_column: roleNoteNum 
     */ 	
	
	private java.lang.Integer roleNoteNum;
    /**
     * personMailNum       db_column: personMailNum 
     */ 	
	
	private java.lang.Integer personMailNum;
    /**
     * personNoteNum       db_column: personNoteNum 
     */ 	
	
	private java.lang.Integer personNoteNum;
    /**
     * noreadnum       db_column: noreadnum 
     */ 	
	
	private java.lang.Integer noreadnum;
    /**
     * mailsize       db_column: mailsize 
     */ 	
	@Email
	private java.lang.Integer mailsize;
	//columns END


	public Role(){
	}

	public Role(
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
	
	@Column(name = "roleName", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
	
	@Column(name = "roleDesc", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public java.lang.String getRoleDesc() {
		return this.roleDesc;
	}
	
	public void setRoleDesc(java.lang.String value) {
		this.roleDesc = value;
	}
	
	@Column(name = "roleMailNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getRoleMailNum() {
		return this.roleMailNum;
	}
	
	public void setRoleMailNum(java.lang.Integer value) {
		this.roleMailNum = value;
	}
	
	@Column(name = "roleNoteNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getRoleNoteNum() {
		return this.roleNoteNum;
	}
	
	public void setRoleNoteNum(java.lang.Integer value) {
		this.roleNoteNum = value;
	}
	
	@Column(name = "personMailNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getPersonMailNum() {
		return this.personMailNum;
	}
	
	public void setPersonMailNum(java.lang.Integer value) {
		this.personMailNum = value;
	}
	
	@Column(name = "personNoteNum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getPersonNoteNum() {
		return this.personNoteNum;
	}
	
	public void setPersonNoteNum(java.lang.Integer value) {
		this.personNoteNum = value;
	}
	
	@Column(name = "noreadnum", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getNoreadnum() {
		return this.noreadnum;
	}
	
	public void setNoreadnum(java.lang.Integer value) {
		this.noreadnum = value;
	}
	
	@Column(name = "mailsize", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getMailsize() {
		return this.mailsize;
	}
	
	public void setMailsize(java.lang.Integer value) {
		this.mailsize = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
	}
	
	private Set roleUserRelations = new HashSet(0);
	public void setRoleUserRelations(Set<RoleUserRelation> roleUserRelation){
		this.roleUserRelations = roleUserRelation;
	}
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "roleIdModel")
	public Set<RoleUserRelation> getRoleUserRelations() {
		return roleUserRelations;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Mid",getMid())
			.append("Mdate",getMdate())
			.append("Uuid",getUuid())
			.append("RoleName",getRoleName())
			.append("RoleDesc",getRoleDesc())
			.append("RoleMailNum",getRoleMailNum())
			.append("RoleNoteNum",getRoleNoteNum())
			.append("PersonMailNum",getPersonMailNum())
			.append("PersonNoteNum",getPersonNoteNum())
			.append("Noreadnum",getNoreadnum())
			.append("Mailsize",getMailsize())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Role == false) return false;
		if(this == obj) return true;
		Role other = (Role)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

