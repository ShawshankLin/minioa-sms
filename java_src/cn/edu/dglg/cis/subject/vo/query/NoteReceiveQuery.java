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


public class NoteReceiveQuery extends BaseQuery implements Serializable {
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
	/** recipient */
	private java.lang.String recipient;
	/** subject */
	private java.lang.String subject;
	/** message */
	private java.lang.String message;
	/** notestatus */
	private java.lang.String notestatus;
	/** sendlist */
	private java.lang.String sendlist;
	/** sendid */
	private java.lang.String sendid;
	/** fromid */
	private java.lang.Integer fromid;
	/** msgTxt */
	private java.lang.String msgTxt;
	/** type */
	private java.lang.Integer type;
	/** url */
	private java.lang.String url;

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
	
	public java.lang.String getRecipient() {
		return this.recipient;
	}
	
	public void setRecipient(java.lang.String value) {
		this.recipient = value;
	}
	
	public java.lang.String getSubject() {
		return this.subject;
	}
	
	public void setSubject(java.lang.String value) {
		this.subject = value;
	}
	
	public java.lang.String getMessage() {
		return this.message;
	}
	
	public void setMessage(java.lang.String value) {
		this.message = value;
	}
	
	public java.lang.String getNotestatus() {
		return this.notestatus;
	}
	
	public void setNotestatus(java.lang.String value) {
		this.notestatus = value;
	}
	
	public java.lang.String getSendlist() {
		return this.sendlist;
	}
	
	public void setSendlist(java.lang.String value) {
		this.sendlist = value;
	}
	
	public java.lang.String getSendid() {
		return this.sendid;
	}
	
	public void setSendid(java.lang.String value) {
		this.sendid = value;
	}
	
	public java.lang.Integer getFromid() {
		return this.fromid;
	}
	
	public void setFromid(java.lang.Integer value) {
		this.fromid = value;
	}
	
	public java.lang.String getMsgTxt() {
		return this.msgTxt;
	}
	
	
	public void setMsgTxt(java.lang.String value) {
		this.msgTxt = value;
	}
	
	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setType(java.lang.Integer value) {
		this.type = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
		private java.lang.String cidModelTag;
		private java.lang.String midModelTag;
		private java.lang.String fromidModelTag;
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
		public java.lang.String getFromidModelTag(){
			return this.fromidModelTag;
		}
		
		public  void setFromidModelTag(String noteSendTag){
			this.fromidModelTag=noteSendTag;
		}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

