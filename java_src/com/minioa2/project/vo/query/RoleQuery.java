/*
 */

package com.minioa2.project.vo.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

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


public class RoleQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** cid */
	private java.lang.Integer cid;
	/** cdate */
	private java.util.Date cdateBegin;
	private java.util.Date cdateEnd;
	/** mid */
	private java.lang.Integer mid;
	/** mdate */
	private java.util.Date mdateBegin;
	private java.util.Date mdateEnd;
	/** uuid */
	private java.lang.String uuid;
	/** roleName */
	private java.lang.String roleName;
	/** roleDesc */
	private java.lang.String roleDesc;
	/** roleMailNum */
	private java.lang.Integer roleMailNum;
	/** roleNoteNum */
	private java.lang.Integer roleNoteNum;
	/** personMailNum */
	private java.lang.Integer personMailNum;
	/** personNoteNum */
	private java.lang.Integer personNoteNum;
	/** noreadnum */
	private java.lang.Integer noreadnum;
	/** mailsize */
	private java.lang.Integer mailsize;

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getCid() {
		return this.cid;
	}
	
	public void setCid(java.lang.Integer value) {
		this.cid = value;
	}
	
	public java.util.Date getCdateBegin() {
		return this.cdateBegin;
	}
	
	public void setCdateBegin(java.util.Date value) {
		this.cdateBegin = value;
	}	
	
	public java.util.Date getCdateEnd() {
		return this.cdateEnd;
	}
	
	public void setCdateEnd(java.util.Date value) {
		this.cdateEnd = value;
	}
	
	public java.lang.Integer getMid() {
		return this.mid;
	}
	
	public void setMid(java.lang.Integer value) {
		this.mid = value;
	}
	
	public java.util.Date getMdateBegin() {
		return this.mdateBegin;
	}
	
	public void setMdateBegin(java.util.Date value) {
		this.mdateBegin = value;
	}	
	
	public java.util.Date getMdateEnd() {
		return this.mdateEnd;
	}
	
	public void setMdateEnd(java.util.Date value) {
		this.mdateEnd = value;
	}
	
	public java.lang.String getUuid() {
		return this.uuid;
	}
	
	public void setUuid(java.lang.String value) {
		this.uuid = value;
	}
	
	public java.lang.String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(java.lang.String value) {
		this.roleName = value;
	}
	
	public java.lang.String getRoleDesc() {
		return this.roleDesc;
	}
	
	public void setRoleDesc(java.lang.String value) {
		this.roleDesc = value;
	}
	
	public java.lang.Integer getRoleMailNum() {
		return this.roleMailNum;
	}
	
	public void setRoleMailNum(java.lang.Integer value) {
		this.roleMailNum = value;
	}
	
	public java.lang.Integer getRoleNoteNum() {
		return this.roleNoteNum;
	}
	
	public void setRoleNoteNum(java.lang.Integer value) {
		this.roleNoteNum = value;
	}
	
	public java.lang.Integer getPersonMailNum() {
		return this.personMailNum;
	}
	
	public void setPersonMailNum(java.lang.Integer value) {
		this.personMailNum = value;
	}
	
	public java.lang.Integer getPersonNoteNum() {
		return this.personNoteNum;
	}
	
	public void setPersonNoteNum(java.lang.Integer value) {
		this.personNoteNum = value;
	}
	
	public java.lang.Integer getNoreadnum() {
		return this.noreadnum;
	}
	
	public void setNoreadnum(java.lang.Integer value) {
		this.noreadnum = value;
	}
	
	public java.lang.Integer getMailsize() {
		return this.mailsize;
	}
	
	public void setMailsize(java.lang.Integer value) {
		this.mailsize = value;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

