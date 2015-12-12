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


public class NoteSendManagerTest extends BaseManagerTestCase{

	private NoteSendManager manager;
	
	@Autowired
	public void setNoteSendManager(NoteSendManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/NoteSend.xml",
                            "classpath:testdata/NoteSend_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		NoteSend obj = newNoteSend();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static NoteSend newNoteSend() {
		NoteSend obj = new NoteSend();
		
	  	obj.setCid(new java.lang.Integer("1"));
	  	obj.setCdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setMid(new java.lang.Integer("1"));
	  	obj.setMdate(new java.util.Date(System.currentTimeMillis()));
	  	obj.setUuid(new java.lang.String("1"));
	  	obj.setRecipient(new java.lang.String("1"));
	  	obj.setSubject(new java.lang.String("1"));
	  	obj.setMessage(new java.lang.String("1"));
	  	obj.setNotestatus(new java.lang.String("1"));
	  	obj.setSendlist(new java.lang.String("1"));
	  	obj.setSendid(new java.lang.String("1"));
	  	obj.setMsgTxt(new java.lang.String("1"));
	  	obj.setType(new java.lang.Integer("1"));
	  	obj.setUrl(new java.lang.String("1"));
		return obj;
	}
}
