/*
 */

package com.minioa2.project.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;

import static junit.framework.Assert.*;

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


public class UserDaoTest extends BaseDaoTestCase{
	
	private UserDao dao;
	
	@Autowired
	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/User.xml",
		                    "classpath:testdata/User_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		UserQuery query = newUserQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static UserQuery newUserQuery() {
		UserQuery query = new UserQuery();
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
	  	query.setUserName(new String("1"));
	  	query.setDepaId(new Integer("1"));
	  	query.setJobId(new String("1"));
	  	query.setEmail(new String("1"));
	  	query.setPassword(new String("1"));
	  	query.setPhone(new String("1"));
	  	query.setMobilePhone(new String("1"));
	  	query.setGender(new String("1"));
	  	query.setDisplayName(new String("1"));
	  	query.setIsLock(new String("1"));
	  	query.setJobId2(new Integer("1"));
	  	query.setNoteSendNum(new Integer("1"));
	  	query.setMailSendNum(new Integer("1"));
	  	query.setStatus(new Integer("1"));
	  	query.setClientid(new String("1"));
		return query;
	}
	
}
