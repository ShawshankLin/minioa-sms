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
import static cn.org.rapid_framework.util.ObjectUtils.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class LogDao extends BaseHibernateDao<Log,java.lang.Integer>{

	public Class getEntityClass() {
		return Log.class;
	}
	
	public Page findPage(LogQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from Log t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
				+ "/~ and t.cdate = {cdate} ~/"
			  	+ "/~ and t.tag like '%[tag]%' ~/"
			  	+ "/~ and t.refId = {refId} ~/"
			  	+ "/~ and t.summary like '%[summary]%' ~/"
			  	+ "/~ and t.details like '%[details]%' ~/"
			  	+ "/~ and t.ip like '%[ip]%' ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<Log> findAllByQuery(LogQuery query){
		String sql = "select t from Log t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
					+ "/~ and t.cdate = {cdate} ~/"
				  	+ "/~ and t.tag like '%[tag]%' ~/"
				  	+ "/~ and t.refId = {refId} ~/"
				  	+ "/~ and t.summary like '%[summary]%' ~/"
				  	+ "/~ and t.details like '%[details]%' ~/"
				  	+ "/~ and t.ip like '%[ip]%' ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}
	public String getLastLoginTime(int cid){
		String sql="select cdate from Log where cid=:cid and tag='login' order by id desc";
		return getSession().createQuery(sql).setParameter("cid", cid).setMaxResults(1).uniqueResult().toString();
	}
	public int getLoginNum(int cid){
		String sql="select count(*) from Log where cid=:cid and tag='login'";
		return Integer.parseInt(getSession().createQuery(sql).setParameter("cid", cid).uniqueResult().toString());
	}
}
