/*
 */

package cn.edu.dglg.cis.subject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class UserDepaRelationManager extends BaseManager<UserDepaRelation,java.lang.Integer>{

	private UserDepaRelationDao userDepaRelationDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserDepaRelationDao(UserDepaRelationDao dao) {
		this.userDepaRelationDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.userDepaRelationDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(UserDepaRelationQuery query) {
		return userDepaRelationDao.findPage(query);
	}
	@Transactional(readOnly=true)
	public List<UserDepaRelation> findAll(UserDepaRelationQuery query) {
		return userDepaRelationDao.findAllByQuery(query);
	}
	
}
