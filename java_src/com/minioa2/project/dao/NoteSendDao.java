/*
 */

package com.minioa2.project.dao;

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


import static cn.org.rapid_framework.util.ObjectUtils.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoteSendDao extends BaseHibernateDao<NoteSend,java.lang.Integer>{

	public Class getEntityClass() {
		return NoteSend.class;
	}
	
	public Page findPage(NoteSendQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from NoteSend t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
			  	+ "/~ and t.mid = {mid} ~/"
				+ "/~ and t.mdate >= {mdateBegin} ~/"
				+ "/~ and t.mdate <= {mdateEnd} ~/"
			  	+ "/~ and t.uuid like '%[uuid]%' ~/"
			  	+ "/~ and t.recipient like '%[recipient]%' ~/"
			  	+ "/~ and t.subject like '%[subject]%' ~/"
			  	+ "/~ and t.message like '%[message]%' ~/"
			  	+ "/~ and t.notestatus like '%[notestatus]%' ~/"
			  	+ "/~ and t.sendlist like '%[sendlist]%' ~/"
			  	+ "/~ and t.sendid like '%[sendid]%' ~/"
			  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
			  	+ "/~ and t.type = {type} ~/"
			  	+ "/~ and t.url like '%[url]%' ~/"
					+ "/~ and t.cidModel.id like '%[cidModelTag]%'  ~/"
					+ "/~ and t.midModel.id like '%[midModelTag]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<NoteSend> findAllByQuery(NoteSendQuery query){
		String sql = "select t from NoteSend t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
				  	+ "/~ and t.mid = {mid} ~/"
					+ "/~ and t.mdate >= {mdateBegin} ~/"
					+ "/~ and t.mdate <= {mdateEnd} ~/"
				  	+ "/~ and t.uuid like '%[uuid]%' ~/"
				  	+ "/~ and t.recipient like '%[recipient]%' ~/"
				  	+ "/~ and t.subject like '%[subject]%' ~/"
				  	+ "/~ and t.message like '%[message]%' ~/"
				  	+ "/~ and t.notestatus like '%[notestatus]%' ~/"
				  	+ "/~ and t.sendlist like '%[sendlist]%' ~/"
				  	+ "/~ and t.sendid like '%[sendid]%' ~/"
				  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
				  	+ "/~ and t.type = {type} ~/"
				  	+ "/~ and t.url like '%[url]%' ~/"
					+ "/~ and t.cidModel.id like '%[cidModelTag]%'  ~/"
					+ "/~ and t.midModel.id like '%[midModelTag]%'  ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}
	public int getSendNoteNum(int cid){
		String sql="select count(*) from NoteSend where cid=:cid and to_days(CDATE_) = to_days(now())";
		return Integer.parseInt(getSession().createQuery(sql).setParameter("cid", cid).uniqueResult().toString());
	}

}
