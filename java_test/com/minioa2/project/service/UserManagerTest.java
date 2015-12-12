/*
 */

package com.minioa2.project.service;

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


public class UserManagerTest extends BaseManagerTestCase{

	private UserManager manager;
	
	@Autowired
	public void setUserManager(UserManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/User.xml",
                            "classpath:testdata/User_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		User obj = newUser();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static User newUser() {
		User obj = new User();
		
	  	obj.setCid(new java.lang.Integer("1"));
	  	obj.setCdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setMid(new java.lang.Integer("1"));
	  	obj.setMdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setUuid(new java.lang.String("1"));
	  	obj.setUserName(new java.lang.String("1"));
	  	obj.setDepaId(new java.lang.Integer("1"));
	  	obj.setJobId(new java.lang.String("1"));
	  	obj.setEmail(new java.lang.String("1"));
	  	obj.setPassword(new java.lang.String("1"));
	  	obj.setPhone(new java.lang.String("1"));
	  	obj.setMobilePhone(new java.lang.String("1"));
	  	obj.setGender(new java.lang.String("1"));
	  	obj.setDisplayName(new java.lang.String("1"));
	  	obj.setIsLock(new java.lang.String("1"));
	  	obj.setJobId2(new java.lang.Integer("1"));
	  	obj.setNoteSendNum(new java.lang.Integer("1"));
	  	obj.setMailSendNum(new java.lang.Integer("1"));
	  	obj.setStatus(new java.lang.Integer("1"));
	  	obj.setClientid(new java.lang.String("1"));
		return obj;
	}
}
