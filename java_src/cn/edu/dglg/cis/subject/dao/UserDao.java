/*
 */

package cn.edu.dglg.cis.subject.dao;

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



import static cn.org.rapid_framework.util.ObjectUtils.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseHibernateDao<User,java.lang.Integer>{

	public Class getEntityClass() {
		return User.class;
	}
	
	public Page findPage(UserQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from User t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
			  	+ "/~ and t.mid = {mid} ~/"
				+ "/~ and t.mdate >= {mdateBegin} ~/"
				+ "/~ and t.mdate <= {mdateEnd} ~/"
			  	+ "/~ and t.uuid like '%[uuid]%' ~/"
			  	+ "/~ and t.userName like '%[userName]%' ~/"
			  	+ "/~ and t.depaId = {depaId} ~/"
			  	+ "/~ and t.jobId like '%[jobId]%' ~/"
			  	+ "/~ and t.email like '%[email]%' ~/"
			  	+ "/~ and t.password like '%[password]%' ~/"
			  	+ "/~ and t.phone like '%[phone]%' ~/"
			  	+ "/~ and t.mobilePhone like '%[mobilePhone]%' ~/"
			  	+ "/~ and t.gender like '%[gender]%' ~/"
			  	+ "/~ and t.displayName like '%[displayName]%' ~/"
			  	+ "/~ and t.isLock like '%[isLock]%' ~/"
			  	+ "/~ and t.jobId2 = {jobId2} ~/"
			  	+ "/~ and t.noteSendNum = {noteSendNum} ~/"
			  	+ "/~ and t.mailSendNum = {mailSendNum} ~/"
			  	+ "/~ and t.status = {status} ~/"
			  	+ "/~ and t.clientid like '%[clientid]%' ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<User> findAllByQuery(UserQuery query){
		String sql = "select t from User t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
				  	+ "/~ and t.mid = {mid} ~/"
					+ "/~ and t.mdate >= {mdateBegin} ~/"
					+ "/~ and t.mdate <= {mdateEnd} ~/"
				  	+ "/~ and t.uuid like '%[uuid]%' ~/"
				  	+ "/~ and t.userName ={userName} ~/"
				  	+ "/~ and t.depaId = {depaId} ~/"
				  	+ "/~ and t.jobId like '%[jobId]%' ~/"
				  	+ "/~ and t.email like '%[email]%' ~/"
				  	+ "/~ and t.password like '%[password]%' ~/"
				  	+ "/~ and t.phone like '%[phone]%' ~/"
				  	+ "/~ and t.mobilePhone like '%[mobilePhone]%' ~/"
				  	+ "/~ and t.gender like '%[gender]%' ~/"
				  	+ "/~ and t.displayName like '%[displayName]%' ~/"
				  	+ "/~ and t.isLock like '%[isLock]%' ~/"
				  	+ "/~ and t.jobId2 = {jobId2} ~/"
				  	+ "/~ and t.noteSendNum = {noteSendNum} ~/"
				  	+ "/~ and t.mailSendNum = {mailSendNum} ~/"
				  	+ "/~ and t.status = {status} ~/"
				  	+ "/~ and t.clientid like '%[clientid]%' ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}
	
}
