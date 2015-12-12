/*
 */

package com.minioa2.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class DepartmentManager extends BaseManager<Department,java.lang.Integer>{

	private DepartmentDao departmentDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setDepartmentDao(DepartmentDao dao) {
		this.departmentDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.departmentDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(DepartmentQuery query) {
		return departmentDao.findPage(query);
	}
	@Transactional(readOnly=true)
	public List<Department> findAll(DepartmentQuery query) {
		return departmentDao.findAllByQuery(query);
	}
	
}
