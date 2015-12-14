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
public class RoleUserRelationDao extends BaseHibernateDao<RoleUserRelation,java.lang.Integer>{

	public Class getEntityClass() {
		return RoleUserRelation.class;
	}
	
	public Page findPage(RoleUserRelationQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from RoleUserRelation t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
			  	+ "/~ and t.roleId = {roleId} ~/"
			  	+ "/~ and t.userId = {userId} ~/"
					+ "/~ and t.roleIdModel.id like '%[roleIdModelTag]%'  ~/"
					+ "/~ and t.userIdModel.id like '%[userIdModelTag]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<RoleUserRelation> findAllByQuery(RoleUserRelationQuery query){
		String sql = "select t from RoleUserRelation t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
				  	+ "/~ and t.roleId = {roleId} ~/"
				  	+ "/~ and t.userId = {userId} ~/"
					+ "/~ and t.roleIdModel.id like '%[roleIdModelTag]%'  ~/"
					+ "/~ and t.userIdModel.id like '%[userIdModelTag]%'  ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}

}
