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


public class LogQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

	/** id */
	private java.lang.Integer id;
	/** cid */
	private java.lang.Integer cid;
	/** cdate */
	private java.util.Date cdateBegin;
	private java.util.Date cdateEnd;
	private java.util.Date cdate;
	/** tag */
	private java.lang.String tag;
	/** refId */
	private java.lang.Integer refId;
	/** summary */
	private java.lang.String summary;
	/** details */
	private java.lang.String details;
	/** ip */
	private java.lang.String ip;

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
	
	public java.lang.String getTag() {
		return this.tag;
	}
	
	public void setTag(java.lang.String value) {
		this.tag = value;
	}
	
	public java.lang.Integer getRefId() {
		return this.refId;
	}
	
	public void setRefId(java.lang.Integer value) {
		this.refId = value;
	}
	
	public java.lang.String getSummary() {
		return this.summary;
	}
	
	public void setSummary(java.lang.String value) {
		this.summary = value;
	}
	
	public java.lang.String getDetails() {
		return this.details;
	}
	
	public void setDetails(java.lang.String value) {
		this.details = value;
	}
	
	public java.lang.String getIp() {
		return this.ip;
	}
	
	public void setIp(java.lang.String value) {
		this.ip = value;
	}
	
		private java.lang.String cidModelTag;
		public java.lang.String getCidModelTag(){
			return this.cidModelTag;
		}
		
		public  void setCidModelTag(String userTag){
			this.cidModelTag=userTag;
		}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}

	public java.util.Date getCdate() {
		return cdate;
	}

	public void setCdate(java.util.Date cdate) {
		this.cdate = cdate;
	}
	
}

