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
public class MailSendManager extends BaseManager<MailSend,java.lang.Integer>{

	private MailSendDao mailSendDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setMailSendDao(MailSendDao dao) {
		this.mailSendDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.mailSendDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(MailSendQuery query) {
		return mailSendDao.findPage(query);
	}
	@Transactional(readOnly=true)
	public List<MailSend> findAll(MailSendQuery query) {
		return mailSendDao.findAllByQuery(query);
	}
	
}
