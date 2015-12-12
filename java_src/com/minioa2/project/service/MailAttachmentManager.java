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
public class MailAttachmentManager extends BaseManager<MailAttachment,java.lang.Integer>{

	private MailAttachmentDao mailAttachmentDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setMailAttachmentDao(MailAttachmentDao dao) {
		this.mailAttachmentDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.mailAttachmentDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(MailAttachmentQuery query) {
		return mailAttachmentDao.findPage(query);
	}
	@Transactional(readOnly=true)
	public List<MailAttachment> findAll(MailAttachmentQuery query) {
		return mailAttachmentDao.findAllByQuery(query);
	}
	
}
