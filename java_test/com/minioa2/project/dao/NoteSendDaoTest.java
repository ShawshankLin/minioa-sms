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


public class NoteSendDaoTest extends BaseDaoTestCase{
	
	private NoteSendDao dao;
	
	@Autowired
	public void setNoteSendDao(NoteSendDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/NoteSend.xml",
		                    "classpath:testdata/NoteSend_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		NoteSendQuery query = newNoteSendQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static NoteSendQuery newNoteSendQuery() {
		NoteSendQuery query = new NoteSendQuery();
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
	  	query.setNotestatus(new String("1"));
	  	query.setSendlist(new String("1"));
	  	query.setSendid(new String("1"));
	  	query.setMsgTxt(new String("1"));
	  	query.setType(new Integer("1"));
	  	query.setUrl(new String("1"));
		return query;
	}
	
}
