/*
 */

package cn.edu.dglg.cis.subject.dao;

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
import static cn.org.rapid_framework.util.ObjectUtils.*;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class NoteReceiveDao extends BaseHibernateDao<NoteReceive,java.lang.Integer>{

	public Class getEntityClass() {
		return NoteReceive.class;
	}
	
	public Page findPage(NoteReceiveQuery query) {
        //XsqlBuilder syntax,please see http://code.google.com/p/rapid-xsqlbuilder
        // [column]为字符串拼接, {column}为使用占位符. [column]为使用字符串拼接,如username='[username]',偷懒时可以使用字符串拼接 
        // [column] 为PageRequest的属性
		String sql = "select t from NoteReceive t where 1=1 "
			  	+ "/~ and t.cid = {cid} ~/"
				+ "/~ and t.cdate >= {cdateBegin} ~/"
				+ "/~ and t.cdate <= {cdateEnd} ~/"
			  	+ "/~ and t.mid = {mid} ~/"
				+ "/~ and t.mdate >= {mdateBegin} ~/"
				+ "/~ and t.mdate <= {mdateEnd} ~/"
			  	+ "/~ and t.uuid like '%[uuid]%' ~/"
			  	+ "/~ and t.recipient like '%[recipient]%' ~/"
			  	+ "/~ and t.subject like '%[subject]%' ~/"
			  	+ "/~ and t.message like '%[message]%' ~/"
			  	+ "/~ and t.notestatus like '%[notestatus]%' ~/"
			  	+ "/~ and t.sendlist like '%[sendlist]%' ~/"
			  	+ "/~ and t.sendid like '%[sendid]%' ~/"
			  	+ "/~ and t.fromid = {fromid} ~/"
			  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
			  	+ "/~ and t.type = {type} ~/"
			  	+ "/~ and t.url like '%[url]%' ~/"
					+ "/~ and t.cidModel.id like '%[cidModelTag]%'  ~/"
					+ "/~ and t.midModel.id like '%[midModelTag]%'  ~/"
				+ "/~ order by [sortColumns] ~/";
        
		return pageQuery(sql,query);
	}
	public List<NoteReceive> findAllByQuery(NoteReceiveQuery query){
		String sql = "select t from NoteReceive t where 1=1 "
				  	+ "/~ and t.cid = {cid} ~/"
					+ "/~ and t.cdate >= {cdateBegin} ~/"
					+ "/~ and t.cdate <= {cdateEnd} ~/"
				  	+ "/~ and t.mid = {mid} ~/"
					+ "/~ and t.mdate >= {mdateBegin} ~/"
					+ "/~ and t.mdate <= {mdateEnd} ~/"
				  	+ "/~ and t.uuid like '%[uuid]%' ~/"
				  	+ "/~ and t.recipient like '%[recipient]%' ~/"
				  	+ "/~ and t.subject like '%[subject]%' ~/"
				  	+ "/~ and t.message like '%[message]%' ~/"
				  	+ "/~ and t.notestatus like '%[notestatus]%' ~/"
				  	+ "/~ and t.sendlist like '%[sendlist]%' ~/"
				  	+ "/~ and t.sendid like '%[sendid]%' ~/"
				  	+ "/~ and t.fromid = {fromid} ~/"
				  	+ "/~ and t.msgTxt like '%[msgTxt]%' ~/"
				  	+ "/~ and t.type = {type} ~/"
				  	+ "/~ and t.url like '%[url]%' ~/"
					+ "/~ and t.cidModel.id like '%[cidModelTag]%'  ~/"
					+ "/~ and t.midModel.id like '%[midModelTag]%'  ~/"
					+ "/~ order by [sortColumns] ~/";
		return findAllBy(sql,query);
	}
	public int getSendPeopleNum(int cid){
		String sql="SELECT count(DISTINCT recipient) FROM note_receive where CID_=:cid and TO_DAYS(CDATE_)=TO_DAYS(NOW())";
		return Integer.parseInt(getSession().createSQLQuery(sql).setParameter("cid", cid).uniqueResult().toString());
	}
	public int getNoseeNoteNum(int sendid){
		String sql="select count(*) as col_0_0_ from note_receive notereceiv0_ where notereceiv0_.sendid=:sendid and notereceiv0_.notestatus='nosee'";
		return Integer.parseInt(getSession().createSQLQuery(sql).setParameter("sendid", sendid).uniqueResult().toString());
	}
}
