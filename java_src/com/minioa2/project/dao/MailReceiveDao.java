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
public class MailReceiveDao extends BaseHibernateDao<MailReceive,java.lang.Integer>{

	public Class getEntityClass() {
		return MailReceive.class;
	}
	
	public Page findPage(MailReceiveQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from MailReceive t where 1=1 "
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
			  	+ "/~ and t.sendtype like '%[sendtype]%' ~/"
			  	+ "/~ and t.mailstatus like '%[mailstatus]%' ~/"
			  	+ "/~ and t.senduserlist like '%[senduserlist]%' ~/"
			  	+ "/~ and t.sendid like '%[sendid]%' ~/"
			  	+ "/~ and t.mailtype like '%[mailtype]%' ~/"
			  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
			  	+ "/~ and t.size like '%[size]%' ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<MailReceive> findAllByQuery(MailReceiveQuery query){
		String sql = "select t from MailReceive t where 1=1 "
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
				  	+ "/~ and t.sendtype like '%[sendtype]%' ~/"
				  	+ "/~ and t.mailstatus like '%[mailstatus]%' ~/"
				  	+ "/~ and t.senduserlist like '%[senduserlist]%' ~/"
				  	+ "/~ and t.sendid like '%[sendid]%' ~/"
				  	+ "/~ and t.mailtype like '%[mailtype]%' ~/"
				  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
				  	+ "/~ and t.size like '%[size]%' ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}

}