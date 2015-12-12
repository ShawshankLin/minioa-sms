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


public class MailAttachmentQuery extends BaseQuery implements Serializable {
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
	/** filename */
	private java.lang.String filename;
	/** filetype */
	private java.lang.String filetype;
	/** filesize */
	private java.lang.Integer filesize;
	/** oldname */
	private java.lang.String oldname;

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
	
	public java.lang.String getFilename() {
		return this.filename;
	}
	
	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	public java.lang.String getFiletype() {
		return this.filetype;
	}
	
	public void setFiletype(java.lang.String value) {
		this.filetype = value;
	}
	
	public java.lang.Integer getFilesize() {
		return this.filesize;
	}
	
	public void setFilesize(java.lang.Integer value) {
		this.filesize = value;
	}
	
	public java.lang.String getOldname() {
		return this.oldname;
	}
	
	public void setOldname(java.lang.String value) {
		this.oldname = value;
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

