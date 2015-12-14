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
@Table(name = "mail_attachment")
public class MailAttachment extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "MailAttachment";
	public static final String ALIAS_ID = "id";
	
	public static final String ALIAS_CID = "cid";
	
	public static final String ALIAS_CDATE = "cdate";
	
	public static final String ALIAS_MID = "mid";
	
	public static final String ALIAS_MDATE = "mdate";
	
	public static final String ALIAS_UUID = "uuid";
	
	public static final String ALIAS_FILENAME = "filename";
	
	public static final String ALIAS_FILETYPE = "filetype";
	
	public static final String ALIAS_FILESIZE = "filesize";
	
	public static final String ALIAS_OLDNAME = "oldname";
	
	
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
     * filename       db_column: filename 
     */ 	
	@Length(max=200)
	private java.lang.String filename;
    /**
     * filetype       db_column: filetype 
     */ 	
	@Length(max=45)
	private java.lang.String filetype;
    /**
     * filesize       db_column: filesize 
     */ 	
	
	private java.lang.Integer filesize;
    /**
     * oldname       db_column: oldname 
     */ 	
	@Length(max=200)
	private java.lang.String oldname;
	//columns END


	public MailAttachment(){
	}

	public MailAttachment(
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
	
	@Column(name = "filename", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getFilename() {
		return this.filename;
	}
	
	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	@Column(name = "filetype", unique = false, nullable = true, insertable = true, updatable = true, length = 45)
	public java.lang.String getFiletype() {
		return this.filetype;
	}
	
	public void setFiletype(java.lang.String value) {
		this.filetype = value;
	}
	
	@Column(name = "filesize", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public java.lang.Integer getFilesize() {
		return this.filesize;
	}
	
	public void setFilesize(java.lang.Integer value) {
		this.filesize = value;
	}
	
	@Column(name = "oldname", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public java.lang.String getOldname() {
		return this.oldname;
	}
	
	public void setOldname(java.lang.String value) {
		this.oldname = value;
	}
	
	//获取表标识列的值,即作为关联类时显示的值
	@Transient
	public String getModelTagValue() {
				return this.id+"";
			
	}
	
	private User cidModel;
	public void setCidModel(User user){
		this.cidModel = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CID_",nullable = false, insertable = false, updatable = false) 
	})
	public User getCidModel() {
		return cidModel;
	}
	private User midModel;
	public void setMidModel(User user){
		this.midModel = user;
	}
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "MID_",nullable = false, insertable = false, updatable = false) 
	})
	public User getMidModel() {
		return midModel;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Cid",getCid())
			.append("Cdate",getCdate())
			.append("Mid",getMid())
			.append("Mdate",getMdate())
			.append("Uuid",getUuid())
			.append("Filename",getFilename())
			.append("Filetype",getFiletype())
			.append("Filesize",getFilesize())
			.append("Oldname",getOldname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MailAttachment == false) return false;
		if(this == obj) return true;
		MailAttachment other = (MailAttachment)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

