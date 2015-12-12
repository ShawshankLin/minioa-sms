/*
 */

package com.minioa2.project.action;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.RequestMap;

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

import com.minioa2.project.model.*;
import com.minioa2.project.dao.*;
import com.minioa2.project.service.*;
import com.minioa2.project.utils.FunctionLib;
import com.minioa2.project.vo.query.*;

import javax.annotation.Resource;

public class LogAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/Log/query.jsp";
	protected static final String LIST_JSP= "/pages/Log/list.jsp";
	protected static final String CREATE_JSP = "/pages/Log/create.jsp";
	protected static final String EDIT_JSP = "/pages/Log/edit.jsp";
	protected static final String SHOW_JSP = "/pages/Log/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/Log/list.do";
	
	private LogManager logManager;
	private Log log;
	java.lang.Integer id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			log = new Log();
		} else {
			log = (Log)logManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setLogManager(LogManager manager) {
		this.logManager = manager;
	}	
	
	public Object getModel() {
		return log;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		LogQuery query = newQuery(LogQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = logManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String search(){
		LogQuery logQuery=new LogQuery();
		String searchType=getRequest().getParameter("searchType");
		String searchInfo=getRequest().getParameter("searchInfo").trim();
		try {
			searchInfo=java.net.URLDecoder.decode(searchInfo,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=searchInfo&&!searchInfo.equals("")){
			if("cid".equals(searchType)){
				if(FunctionLib.isNum(searchInfo)){
					logQuery.setCid(Integer.parseInt(searchInfo));
				}
			}
			if("cdate".equals(searchType)){
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				Date date=null;
				try {
					date = format.parse(searchInfo);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				logQuery.setCdate(date);
			}
			if("ip".equals(searchType)){
				logQuery.setIp(searchInfo);
			}
		}
		Page page = logManager.findPage(logQuery);
		savePage(page,logQuery);
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
		logManager.save(log);
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
		logManager.update(this.log);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	/**删除对象*/
	public String delete(){
		String id=getRequest().getParameter("id");
		if(id!=null){
			logManager.removeById(Integer.parseInt(id));
		}
		showMessage2("删除成功！","/pages/Log/list.do");
		return null;
	}
	/**批量删除对象*/
	public String delBatch() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			logManager.removeById(id);
		}
		showMessage2("删除成功！","/pages/Log/list.do");
		return null;
	}
	public void getRelative(){
	}

}
