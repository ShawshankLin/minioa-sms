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


public class DepartmentQuery extends BaseQuery implements Serializable {
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
	/** orgId */
	private java.lang.Integer orgId;
	/** parentId */
	private java.lang.Integer parentId;
	/** depaName */
	private java.lang.String depaName;
	/** depaDesc */
	private java.lang.String depaDesc;
	/** sequence */
	private java.lang.Integer sequence;

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
	
	public java.lang.Integer getOrgId() {
		return this.orgId;
	}
	
	public void setOrgId(java.lang.Integer value) {
		this.orgId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.String getDepaName() {
		return this.depaName;
	}
	
	public void setDepaName(java.lang.String value) {
		this.depaName = value;
	}
	
	public java.lang.String getDepaDesc() {
		return this.depaDesc;
	}
	
	public void setDepaDesc(java.lang.String value) {
		this.depaDesc = value;
	}
	
	public java.lang.Integer getSequence() {
		return this.sequence;
	}
	
	public void setSequence(java.lang.Integer value) {
		this.sequence = value;
	}
	
		private java.lang.String cidModelTag;
		private java.lang.String midModelTag;
		public java.lang.String getCidModelTag(){
			return this.cidModelTag;
		}
		
		public  void setCidModelTag(String userTag){
			this.cidModelTag=userTag;
		}
		public java.lang.String getMidModelTag(){
			return this.midModelTag;
		}
		
		public  void setMidModelTag(String userTag){
			this.midModelTag=userTag;
		}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

