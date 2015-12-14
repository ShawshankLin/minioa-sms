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
@Table(name = "role_user_relation")
public class RoleUserRelation extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "RoleUserRelation";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "cid";
	
	public static final String ALIAS_CDATE = "cdate";
	
	public static final String ALIAS_ROLE_ID = "roleId";
	
	public static final String ALIAS_USER_ID = "userId";
	
	
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
     * roleId       db_column: roleId 
     */ 	
	
	private java.lang.Integer roleId;
    /**
     * userId       db_column: userId 
     */ 	
	
	private java.lang.Integer userId;
	//columns END


	public RoleUserRelation(){
	}

	public RoleUserRelation(
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
	
	@Column(name = "roleId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	@Column(name = "userId", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
	}
	
	private Role roleIdModel;
	public void setRoleIdModel(Role role){
		this.roleIdModel = role;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "roleId",nullable = false, insertable = false, updatable = false) 
	})
	public Role getRoleIdModel() {
		return roleIdModel;
	}
	private User userIdModel;
	public void setUserIdModel(User user){
		this.userIdModel = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "userId",nullable = false, insertable = false, updatable = false) 
	})
	public User getUserIdModel() {
		return userIdModel;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("RoleId",getRoleId())
			.append("UserId",getUserId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RoleUserRelation == false) return false;
		if(this == obj) return true;
		RoleUserRelation other = (RoleUserRelation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

