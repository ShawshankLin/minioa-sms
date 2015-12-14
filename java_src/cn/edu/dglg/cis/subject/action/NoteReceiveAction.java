/*
 */

package cn.edu.dglg.cis.subject.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javassist.expr.NewArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.RequestMap;
import org.springframework.web.util.WebUtils;

import cn.edu.dglg.cis.subject.dao.*;
import cn.edu.dglg.cis.subject.model.*;
import cn.edu.dglg.cis.subject.service.*;
import cn.edu.dglg.cis.subject.utils.MySession;
import cn.edu.dglg.cis.subject.vo.query.*;
import cn.org.rapid_framework.beanutils.BeanUtils;
import cn.org.rapid_framework.web.scope.Flash;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ModelDriven;

import java.util.*;

import javacommon.base.*;
import javacommon.util.*;
import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import javax.annotation.Resource;

public class NoteReceiveAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "cdate desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/NoteReceive/query.jsp";
	protected static final String LIST_JSP= "/pages/NoteReceive/list.jsp";
	protected static final String CREATE_JSP = "/pages/NoteReceive/create.jsp";
	protected static final String EDIT_JSP = "/pages/NoteReceive/edit.jsp";
	protected static final String SHOW_JSP = "/pages/NoteReceive/show.jsp";
	protected static final String NOTE_NOSEE_JSP="/pages/NoteReceive/note_nosee.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/NoteReceive/list.do";
	protected static final String NOTE_NOSEE_ACTION="/pages/NoteSend/note_nosee.do";
	
	private NoteReceiveManager noteReceiveManager;
	private NoteReceive noteReceive;
	@Resource NoteSendManager noteSendManager;
	java.lang.Integer id = null;
	private String[] items;

	public MySession mySession;
	
	public MySession getMySession() {
		MySession mySession=(MySession)WebUtils.getSessionAttribute(getRequest(), "MySession");
		if(mySession!=null){
			return mySession;
		}else{
			showMessage2("页面长时间不活动，已推出", "/login.jsp");
			return null;
		}
	}

	public void setMySession(MySession mySession) {
		this.mySession = mySession;
	}
	
	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			noteReceive = new NoteReceive();
		} else {
			noteReceive = (NoteReceive)noteReceiveManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setNoteReceiveManager(NoteReceiveManager manager) {
		this.noteReceiveManager = manager;
	}	
	
	public Object getModel() {
		return noteReceive;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		//NoteReceiveQuery query = newQuery(NoteReceiveQuery.class,DEFAULT_SORT_COLUMNS);
		NoteReceiveQuery query =newQuery(NoteReceiveQuery.class,DEFAULT_SORT_COLUMNS);
		query.setSendid(getMySession().getUser().getId().toString());
		Page page = noteReceiveManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	
	/** 执行搜索 */
	public String search(){
		NoteReceiveQuery receiveQuery=new NoteReceiveQuery();
		String searchType=getRequest().getParameter("searchType");
		String searchInfo=getRequest().getParameter("searchInfo").trim();
		try {
			searchInfo=java.net.URLDecoder.decode(searchInfo,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=searchInfo&&!searchInfo.equals("")){
			if("sendid".equals(searchType)){
				receiveQuery.setSendid(searchInfo);
			}
			if("recipient".equals(searchType)){
				receiveQuery.setRecipient(searchInfo);
			}
			if("message".equals(searchType)){
				receiveQuery.setMessage(searchInfo);
			}
		}
		Page page = noteReceiveManager.findPage(receiveQuery);
		savePage(page,receiveQuery);
		return LIST_JSP;
	}
	/**显示未读短信*/
	public String getNoseeNote(){
		NoteReceiveQuery query =new NoteReceiveQuery();
		query.setSendid(getMySession().getUser().getId().toString());
		query.setNotestatus("nosee");
		Page page = noteReceiveManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	/** 查看对象*/
	public String show() {
		return SHOW_JSP;
	}
	
	/** 进入新增页面*/
	public String create() {
		getRelative();
		return CREATE_JSP;
	}
	
	/** 保存新增对象 */
	public String save() {
		noteReceiveManager.save(noteReceive);
		Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
		return LIST_ACTION;
	}
	
	/**进入更新页面*/
	public String edit() {
		getRelative();
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		noteReceiveManager.update(this.noteReceive);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	/**删除对象*/
	public String delete(){
		String id=getRequest().getParameter("id");
		if(id!=null){
			noteReceiveManager.removeById(Integer.parseInt(id));
		}
		showMessage2("删除成功！","/pages/NoteReceive/list.do");
		return LIST_ACTION;
	}
	/**批量删除对象*/
	public String delBatch() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			noteReceiveManager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	public void getRelative(){
	}
	/**批量标记已读*/
	public String markRead(){
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			NoteReceive noteReceive=noteReceiveManager.getById(id);
			noteReceive.setNotestatus("see");
			noteReceiveManager.update(noteReceive);
		}
		return LIST_ACTION;
	}
	/**更新短信状态*/
	public String updStatus(){
		try {
			NoteReceive receive=noteReceiveManager.getById(noteReceive.getId());
			receive.setNotestatus("see");
			noteReceiveManager.update(receive);
			boolean flat=true;
			NoteReceiveQuery query=new NoteReceiveQuery();
			query.setFromid(receive.getFromid());
			List<NoteReceive> list=noteReceiveManager.findAll(query);
			for(int i=0;i<list.size();i++){
				NoteReceive noteReceive=list.get(i);
				if("nosee".equals(noteReceive.getNotestatus())){
					flat=false;
					break;
				}
			}
			if(flat){
				//更新发件人短信状态
				NoteSend noteSend=noteSendManager.getById(receive.getFromid());
				noteSend.setNotestatus("see");
				noteSendManager.saveOrUpdate(noteSend);
			}
			PrintWriter out=getResponse().getWriter();
			out.println(1);
		} catch (Exception e) {
			// TODO: handle exception
			showMessage("更新失败！！");
		}
		return null;
	}
	/**得到未读短信数目*/
	public String getNoseeNoteNum(){
		int sendid=Integer.parseInt(noteReceive.getSendid());
		int noseeNum=noteReceiveManager.getNoseeNoteNum(sendid);
		PrintWriter out=null;
		try {
			out = getResponse().getWriter();
			out.println(noseeNum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
