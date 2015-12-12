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


public class MailReceiveDaoTest extends BaseDaoTestCase{
	
	private MailReceiveDao dao;
	
	@Autowired
	public void setMailReceiveDao(MailReceiveDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/MailReceive.xml",
		                    "classpath:testdata/MailReceive_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		MailReceiveQuery query = newMailReceiveQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static MailReceiveQuery newMailReceiveQuery() {
		MailReceiveQuery query = new MailReceiveQuery();
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
	  	query.setRecipient(new String("1"));
	  	query.setSubject(new String("1"));
	  	query.setMessage(new String("1"));
	  	query.setSendtype(new String("1"));
	  	query.setMailstatus(new String("1"));
	  	query.setSenduserlist(new String("1"));
	  	query.setSendid(new String("1"));
	  	query.setMailtype(new String("1"));
	  	query.setMsgTxt(new String("1"));
	  	query.setSize(new String("1"));
		return query;
	}
	
}
