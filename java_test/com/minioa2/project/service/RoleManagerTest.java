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


public class RoleManagerTest extends BaseManagerTestCase{

	private RoleManager manager;
	
	@Autowired
	public void setRoleManager(RoleManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/Role.xml",
                            "classpath:testdata/Role_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		Role obj = newRole();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static Role newRole() {
		Role obj = new Role();
		
	  	obj.setCid(new java.lang.Integer("1"));
	  	obj.setCdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setMid(new java.lang.Integer("1"));
	  	obj.setMdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setUuid(new java.lang.String("1"));
	  	obj.setRoleName(new java.lang.String("1"));
	  	obj.setRoleDesc(new java.lang.String("1"));
	  	obj.setRoleMailNum(new java.lang.Integer("1"));
	  	obj.setRoleNoteNum(new java.lang.Integer("1"));
	  	obj.setPersonMailNum(new java.lang.Integer("1"));
	  	obj.setPersonNoteNum(new java.lang.Integer("1"));
	  	obj.setNoreadnum(new java.lang.Integer("1"));
	  	obj.setMailsize(new java.lang.Integer("1"));
		return obj;
	}
}
