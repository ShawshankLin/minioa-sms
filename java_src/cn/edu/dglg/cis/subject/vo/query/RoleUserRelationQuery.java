/*
 */

package cn.edu.dglg.cis.subject.vo.query;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;
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


public class RoleUserRelationQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** cid */
	private java.lang.Integer cid;
	/** cdate */
	private java.util.Date cdateBegin;
	private java.util.Date cdateEnd;
	/** roleId */
	private java.lang.Integer roleId;
	/** userId */
	private java.lang.Integer userId;

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
	
	public java.lang.Integer getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Integer value) {
		this.roleId = value;
	}
	
	public java.lang.Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Integer value) {
		this.userId = value;
	}
	
		private java.lang.String roleIdModelTag;
		private java.lang.String userIdModelTag;
		public java.lang.String getRoleIdModelTag(){
			return this.roleIdModelTag;
		}
		
		public  void setRoleIdModelTag(String roleTag){
			this.roleIdModelTag=roleTag;
		}
		public java.lang.String getUserIdModelTag(){
			return this.userIdModelTag;
		}
		
		public  void setUserIdModelTag(String userTag){
			this.userIdModelTag=userTag;
		}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

