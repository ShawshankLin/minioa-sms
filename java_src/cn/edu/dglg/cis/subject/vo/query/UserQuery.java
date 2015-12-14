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


public class UserQuery extends BaseQuery implements Serializable {
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
	/** userName */
	private java.lang.String userName;
	/** depaId */
	private java.lang.Integer depaId;
	/** jobId */
	private java.lang.String jobId;
	/** email */
	private java.lang.String email;
	/** password */
	private java.lang.String password;
	/** phone */
	private java.lang.String phone;
	/** mobilePhone */
	private java.lang.String mobilePhone;
	/** gender */
	private java.lang.String gender;
	/** displayName */
	private java.lang.String displayName;
	/** isLock */
	private java.lang.String isLock;
	/** jobId2 */
	private java.lang.Integer jobId2;
	/** noteSendNum */
	private java.lang.Integer noteSendNum;
	/** mailSendNum */
	private java.lang.Integer mailSendNum;
	/** status */
	private java.lang.Integer status;
	/** clientid */
	private java.lang.String clientid;

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
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.Integer getDepaId() {
		return this.depaId;
	}
	
	public void setDepaId(java.lang.Integer value) {
		this.depaId = value;
	}
	
	public java.lang.String getJobId() {
		return this.jobId;
	}
	
	public void setJobId(java.lang.String value) {
		this.jobId = value;
	}
	
	public java.lang.String getEmail() {
		return this.email;
	}
	
	public void setEmail(java.lang.String value) {
		this.email = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPhone() {
		return this.phone;
	}
	
	public void setPhone(java.lang.String value) {
		this.phone = value;
	}
	
	public java.lang.String getMobilePhone() {
		return this.mobilePhone;
	}
	
	public void setMobilePhone(java.lang.String value) {
		this.mobilePhone = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getDisplayName() {
		return this.displayName;
	}
	
	public void setDisplayName(java.lang.String value) {
		this.displayName = value;
	}
	
	public java.lang.String getIsLock() {
		return this.isLock;
	}
	
	public void setIsLock(java.lang.String value) {
		this.isLock = value;
	}
	
	public java.lang.Integer getJobId2() {
		return this.jobId2;
	}
	
	public void setJobId2(java.lang.Integer value) {
		this.jobId2 = value;
	}
	
	public java.lang.Integer getNoteSendNum() {
		return this.noteSendNum;
	}
	
	public void setNoteSendNum(java.lang.Integer value) {
		this.noteSendNum = value;
	}
	
	public java.lang.Integer getMailSendNum() {
		return this.mailSendNum;
	}
	
	public void setMailSendNum(java.lang.Integer value) {
		this.mailSendNum = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.String getClientid() {
		return this.clientid;
	}
	
	public void setClientid(java.lang.String value) {
		this.clientid = value;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

