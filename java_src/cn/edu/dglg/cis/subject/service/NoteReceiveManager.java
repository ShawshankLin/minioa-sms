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
public class NoteReceiveManager extends BaseManager<NoteReceive,java.lang.Integer>{

	private NoteReceiveDao noteReceiveDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setNoteReceiveDao(NoteReceiveDao dao) {
		this.noteReceiveDao = dao;
	}
	public EntityDao getEntityDao() {
		return this.noteReceiveDao;
	}
	
	@Transactional(readOnly=true)
	public Page findPage(NoteReceiveQuery query) {
		return noteReceiveDao.findPage(query);
	}
	@Transactional(readOnly=true)
	public List<NoteReceive> findAll(NoteReceiveQuery query) {
		return noteReceiveDao.findAllByQuery(query);
	}
	public int getSendPeopleNum(int cid){
		return noteReceiveDao.getSendPeopleNum(cid);
	}
	public int getNoseeNoteNum(int cid){
		return noteReceiveDao.getNoseeNoteNum(cid);
	}
}
