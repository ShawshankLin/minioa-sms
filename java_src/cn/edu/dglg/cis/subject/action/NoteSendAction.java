/*
 */

package cn.edu.dglg.cis.subject.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletContext;
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

public class NoteSendAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = "cdate desc"; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/NoteSend/query.jsp";
	protected static final String LIST_JSP= "/pages/NoteSend/list.jsp";
	protected static final String CREATE_JSP = "/pages/NoteSend/create.jsp";
	protected static final String EDIT_JSP = "/pages/NoteSend/edit.jsp";
	protected static final String SHOW_JSP = "/pages/NoteSend/show.jsp";
	protected static final String NOTE_NEW_JSP = "/pages/NoteSend/note_new.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/NoteSend/list.do";
	
	private NoteSendManager noteSendManager;
	@Resource private NoteReceiveManager noteReceiveManager;
	@Resource private UserManager userManager;
	private NoteSend noteSend;
	java.lang.Integer id = null;
	private String[] items;

	/** 收件人id-name*/
	private String sendid;
	private String sendname;
	
	public String getSendid() {
		return sendid;
	}

	public void setSendid(String sendid) {
		this.sendid = sendid;
	}

	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

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
			noteSend = new NoteSend();
		} else {
			noteSend = (NoteSend)noteSendManager.getById(id);
		}
	}
	
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setNoteSendManager(NoteSendManager manager) {
		this.noteSendManager = manager;
	}	
	
	public Object getModel() {
		return noteSend;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		
		//NoteSendQuery query = newQuery(NoteSendQuery.class,DEFAULT_SORT_COLUMNS);
		NoteSendQuery query =newQuery(NoteSendQuery.class,DEFAULT_SORT_COLUMNS);
		query.setCid(getMySession().getUser().getId());
		Page page = noteSendManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String search(){
		NoteSendQuery sendQuery=new NoteSendQuery();
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
				sendQuery.setSendid(searchInfo);
			}
			if("recipient".equals(searchType)){
				sendQuery.setRecipient(searchInfo);
			}
			if("message".equals(searchType)){
				sendQuery.setMessage(searchInfo);
			}
		}
		Page page = noteSendManager.findPage(sendQuery);
		savePage(page,sendQuery);
		return LIST_JSP;
	}
	/** 发送内部短信 */
	public String newNote() {
		return NOTE_NEW_JSP;
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
		try {
			String[] sendids=sendid.split(",");
			String[] sendnames=sendname.split(",");
			//发件人存档
			noteSend.setCid(getMySession().getUser().getId());
			noteSend.setCdate(new Date());
			noteSend.setRecipient("【发送】"+sendname);
			noteSend.setSendid(sendid);
			noteSend.setNotestatus("nosee");
			noteSend.setType(0);
			noteSend.setUuid(UUID.randomUUID().toString());
			noteSendManager.save(noteSend);
			noteSend.setUrl("/pages/NoteSend/showNoteReceiveView.do?id="+noteSend.getId());
			//收件人存档
			for(int i=0;i<sendids.length;i++){
				NoteReceive noteReceive=new NoteReceive();
				noteReceive.setCid(getMySession().getUser().getId());
				noteReceive.setCdate(new Date());
				noteReceive.setRecipient(sendnames[i]);
				noteReceive.setSendid(sendids[i]);
				noteReceive.setFromid(noteSend.getId());
				noteReceive.setNotestatus("nosee");
				noteReceive.setUuid(UUID.randomUUID().toString());
				noteReceive.setMessage(noteSend.getMessage());
				noteReceive.setType(0);
				noteReceive.setMsgTxt(noteSend.getMessage());
				noteReceiveManager.save(noteReceive);
				noteReceive.setUrl("/pages/NoteSend/showNoteReceiveView.do?id="+noteReceive.getId()+"&uuid="+noteReceive.getUuid());
				noteReceiveManager.saveOrUpdate(noteReceive);
			}
			showMessage2("发送短信成功！","/pages/NoteSend/list.do");
		} catch (Exception e) {
			// TODO: handle exception.
			showMessage2("发送短信失败！","/pages/NoteSend/list.do");
		}
		return LIST_ACTION;
	}
	
	public String resend(){
		String id=getRequest().getParameter("id");
		NoteSend noteSend=noteSendManager.getById(this.id);
		String[] sendids=noteSend.getSendid().split(",");
		String[] sendnames=noteSend.getRecipient().split(",");
		//发件人存档
		noteSend.setCid(0);
		noteSend.setCdate(new Date());
		noteSend.setSendid(sendid);
		noteSend.setNotestatus("nosee");
		noteSend.setUuid(UUID.randomUUID().toString());
		noteSendManager.save(noteSend);
		noteSend.setUrl("/pages/NoteSend/showNoteReceiveView.do?id="+noteSend.getId());
		//收件人存档
		for(int i=0;i<sendids.length;i++){
			NoteReceive noteReceive=new NoteReceive();
			noteReceive.setCid(0);
			noteReceive.setCdate(new Date());
			noteReceive.setRecipient(sendnames[i]);
			noteReceive.setSendid(sendids[i]);
			noteReceive.setNotestatus("nosee");
			noteReceive.setUuid(UUID.randomUUID().toString());
			noteReceive.setMessage(noteSend.getMessage());
			noteReceive.setMsgTxt(noteSend.getMessage());
			noteReceiveManager.save(noteReceive);
			noteReceive.setUrl("/pages/NoteSend/showNoteReceiveView.do?id="+noteReceive.getId()+"&uuid="+noteReceive.getUuid());
			noteReceiveManager.saveOrUpdate(noteReceive);
		}
		showMessage2("发送短信成功！","/pages/NoteSend/list.do");
		return LIST_ACTION;
	}
	/**进入更新页面*/
	public String edit() {
		getRelative();
		String id=getRequest().getParameter("id");
		if(id!=null){
			NoteSend noteSend=noteSendManager.getById(Integer.parseInt(id));
			getRequest().setAttribute("noteSend", noteSend);
		}
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		noteSendManager.update(this.noteSend);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	public String delete(){
		String id=getRequest().getParameter("id");
		if(id!=null){
			noteSendManager.removeById(Integer.parseInt(id));
		}
		showMessage2("删除成功！","/pages/NoteSend/list.do");
		return LIST_ACTION;
	}
	/**删除对象*/
	public String delBatch() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			noteSendManager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	
	public void getRelative(){
	}
	/**回复短信*/
	public String reply(){
		User user=userManager.getById(Integer.parseInt(noteSend.getSendid()));
		getRequest().setAttribute("user", user);
		return NOTE_NEW_JSP;
	}
}
