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
public class UserDepaRelationDao extends BaseHibernateDao<UserDepaRelation,java.lang.Integer>{

	public Class getEntityClass() {
		return UserDepaRelation.class;
	}
	
	public Page findPage(UserDepaRelationQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from UserDepaRelation t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
			  	+ "/~ and t.userid = {userid} ~/"
			  	+ "/~ and t.depaid = {depaid} ~/"
					+ "/~ and t.useridModel.id like '%[useridModelTag]%'  ~/"
					+ "/~ and t.depaidModel.id like '%[depaidModelTag]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<UserDepaRelation> findAllByQuery(UserDepaRelationQuery query){
		String sql = "select t from UserDepaRelation t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
				  	+ "/~ and t.userid = {userid} ~/"
				  	+ "/~ and t.depaid = {depaid} ~/"
					+ "/~ and t.useridModel.id like '%[useridModelTag]%'  ~/"
					+ "/~ and t.depaidModel.id like '%[depaidModelTag]%'  ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}

}
