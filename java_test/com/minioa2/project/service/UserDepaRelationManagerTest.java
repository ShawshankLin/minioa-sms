/*
 */

package com.minioa2.project.service;

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


public class UserDepaRelationManagerTest extends BaseManagerTestCase{

	private UserDepaRelationManager manager;
	
	@Autowired
	public void setUserDepaRelationManager(UserDepaRelationManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/UserDepaRelation.xml",
                            "classpath:testdata/UserDepaRelation_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		UserDepaRelation obj = newUserDepaRelation();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static UserDepaRelation newUserDepaRelation() {
		UserDepaRelation obj = new UserDepaRelation();
		
	  	obj.setCid(new java.lang.Integer("1"));
	  	obj.setCdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setUserid(new java.lang.Integer("1"));
	  	obj.setDepaid(new java.lang.Integer("1"));
		return obj;
	}
}
