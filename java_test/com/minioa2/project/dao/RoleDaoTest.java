/*
 */

package com.minioa2.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.edu.dglg.cis.subject.dao.*;
import cn.edu.dglg.cis.subject.model.*;
import cn.edu.dglg.cis.subject.service.*;
import cn.edu.dglg.cis.subject.vo.query.*;
import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

/**
 * @author jxx
 * @version 1.0
 * @since 1.0
 */


public class RoleDaoTest extends BaseDaoTestCase{
	
	private RoleDao dao;
	
	@Autowired
	public void setRoleDao(RoleDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/Role.xml",
		                    "classpath:testdata/Role_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		RoleQuery query = newRoleQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static RoleQuery newRoleQuery() {
		RoleQuery query = new RoleQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setSortColumns(null);
		
	  	query.setCid(new Integer("1"));
		query.setCdateBegin(new Date(System.currentTimeMillis()));
		query.setCdateEnd(new Date(System.currentTimeMillis()));
	  	query.setMid(new Integer("1"));
		query.setMdateBegin(new Date(System.currentTimeMillis()));
		query.setMdateEnd(new Date(System.currentTimeMillis()));
	  	query.setUuid(new String("1"));
	  	query.setRoleName(new String("1"));
	  	query.setRoleDesc(new String("1"));
	  	query.setRoleMailNum(new Integer("1"));
	  	query.setRoleNoteNum(new Integer("1"));
	  	query.setPersonMailNum(new Integer("1"));
	  	query.setPersonNoteNum(new Integer("1"));
	  	query.setNoreadnum(new Integer("1"));
	  	query.setMailsize(new Integer("1"));
		return query;
	}
	
}
