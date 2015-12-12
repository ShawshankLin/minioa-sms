/*
 */

package com.minioa2.project.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javacommon.base.BaseStruts2Action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.web.util.WebUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.web.scope.Flash;
import cn.org.rapid_framework.web.util.HttpUtils;

import com.minioa2.project.model.Log;
import com.minioa2.project.model.User;
import com.minioa2.project.service.LogManager;
import com.minioa2.project.service.NoteReceiveManager;
import com.minioa2.project.service.NoteSendManager;
import com.minioa2.project.service.UserManager;
import com.minioa2.project.utils.Application;
import com.minioa2.project.utils.FunctionLib;
import com.minioa2.project.utils.MD5Util;
import com.minioa2.project.utils.MySession;
import com.minioa2.project.vo.query.UserQuery;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class UserAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/User/query.jsp";
	protected static final String LIST_JSP= "/pages/User/list.jsp";
	protected static final String CREATE_JSP = "/pages/User/create.jsp";
	protected static final String EDIT_JSP = "/pages/User/edit.jsp";
	protected static final String SHOW_JSP = "/pages/User/show.jsp";
	//redirect paths,startWith: !
	protected static final String INDEX_JSP = "!/index.jsp";
	protected static final String LOGIN_JSP="!/login.jsp";
	protected static final String LIST_ACTION = "!/pages/User/list.do";
	
	private UserManager userManager;
	@Resource private LogManager logManager;
	@Resource private NoteSendManager noteSendManager;
	@Resource private NoteReceiveManager noteReceiveManager;
	private User user;
	java.lang.Integer id = null;
	private String[] items;
	public void prepare() throws Exception {
		user = new User();
		/*if (isNullOrEmptyString(id)) {
			user = new User();
		} else {
			user = (User)userManager.getById(id);
		}*/
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setUserManager(UserManager manager) {
		this.userManager = manager;
	}	
	
	public Object getModel() {
		return user;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		UserQuery query = newQuery(UserQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = userManager.findPage(query);
		savePage(page,query);
		return LIST_JSP;
	}
	/** 执行搜索 */
	public String search(){
		UserQuery userQuery=new UserQuery();
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
				if(FunctionLib.isNum(searchInfo)){
					userQuery.setId(Integer.parseInt(searchInfo));
				}
			}
			if("recipient".equals(searchType)){
				userQuery.setUserName(searchInfo);
			}
		}
		Page page = userManager.findPage(userQuery);
		savePage(page,userQuery);
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
		try {
			if("".equals(user.getUserName()!=null)){
				showMessage("用户名不能为空！");
				return null;
			}
			if(isUserExists(user.getUserName())){
				showMessage("用户名不能重复！");
				return null;
			}
			if("".equals(user.getPassword()!=null)){
				showMessage("密码不能为空！");
				return null;
			}
			user.setCid(0);
			user.setCdate(new Date());
			user.setUuid(UUID.randomUUID().toString());
			user.setPassword(MD5Util.createPassword(user.getPassword()));
			userManager.save(user);
			showMessage2("创建用户成功！","/pages/User/list.do");
		} catch (Exception e) {
			// TODO: handle exception
			showMessage2("创建用户失败！","/pages/User/list.do");
		}
		return LIST_ACTION;
		//Flash.current().success(CREATED_SUCCESS); //存放在Flash中的数据,在下一次http请求中仍然可以读取数据,error()用于显示错误消息
	}
	
	public boolean isUserExists(String username){
		UserQuery userQuery=new UserQuery();
		userQuery.setUserName(username);
		List<User> list=userManager.findAll(userQuery);
		if(list.isEmpty()){
			return false;
		}
		return true;
	}
	/**进入更新页面*/
	public String edit() {
		getRelative();
		String id=getRequest().getParameter("id");
		if(id!=null){
			User user=userManager.getById(Integer.parseInt(id));
			getRequest().setAttribute("user", user);
		}
		return EDIT_JSP;
	}
	
	/**保存更新对象*/
	public String update() {
		try {
			if("".equals(user.getUserName()!=null)){
				showMessage("用户名不能为空！");
				return null;
			}
			if(userManager.isUnique(user, user.getUserName())){
				showMessage("用户名不能重复！");
				return null;
			}
			if("".equals(user.getPassword()!=null)){
				showMessage("密码不能为空！");
				return null;
			}
			user.setMid(user.getId());
			user.setMdate(new Date());
			userManager.update(this.user);
			showMessage("更新用户成功！");
		} catch (Exception e) {
			// TODO: handle exception
			showMessage("更新用户失败！");
		}
		return LIST_ACTION;
	}
	/**删除对象*/
	public String delete(){
		String id=getRequest().getParameter("id");
		if(id!=null){
			userManager.removeById(Integer.parseInt(id));
		}
		//showMessage("删除成功！");
		return LIST_ACTION;
	}
	/**删除对象*/
	public String delBatch() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			userManager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	public void getRelative(){
	}
	/**初始化人员树*/
	public String getUserTree(){
		String appName=getRequest().getServletContext().getContextPath();
		JSONArray treeNodes=new JSONArray();
		List<User> list=userManager.findAll();
		JSONObject item=new JSONObject();
		item.put("id", 0+"");
	  	item.put("pId", 0+"");
	  	item.put("name","发送人");
	  	item.put("open", true);
	  	item.put("isParent", true);
	  	item.put("icon", appName+"/scripts/zTree/image/users.png");
	  	treeNodes.add(item);
		for(int i=0;i<list.size();i++){
			  item=new JSONObject();
			  User user=list.get(i);
		  	  item.put("id", user.getId()+"");
		  	  item.put("pId", 0+"");
		  	  item.put("name",user.getDisplayName()+"");
		  	  item.put("open", true);
		  	  item.put("isParent", false);
		  	  item.put("icon", appName+"/scripts/zTree/image/user.png");
		  	treeNodes.add(item);
		}
		PrintWriter out = null;
		try {
			out = getResponse().getWriter();
			out.println(treeNodes.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//检查用户合法性
		public String login(){
			UserQuery userQuery = new UserQuery();
			if(user.getUserName()!=null){
				userQuery.setUserName(user.getUserName());
			}
			List<User> list = userManager.findAll(userQuery);
			//使用md5算法效验密码
			if(list.size()==1){
				if(list.get(0).getIsLock()!="Y"){
					if (MD5Util.authenticatePassword(list.get(0).getPassword(),user.getPassword())) {
						ServletContext servletContext=getRequest().getServletContext();
						Application application=null;
						if(servletContext!=null&&servletContext.getAttribute("Application")!=null){
							application=(Application) servletContext.getAttribute("Application");
						}else {
							application=new Application();
						}
						//添加在线用户信息
						Map<Integer, User> onlineMap=null;
						if(application.getOnlineUser()!=null&&!application.getOnlineUser().isEmpty()){
							onlineMap=application.getOnlineUser();
						}else {
							onlineMap=new HashMap<Integer, User>();
						}
						onlineMap.put(list.get(0).getId(), list.get(0));
						application.setOnlineUser(onlineMap);
						servletContext.setAttribute("Application", application);
						//创建session
						HttpSession session=getRequest().getSession();
						MySession mySession=null;
						if(session!=null&&session.getAttribute("MySession")!=null){
							mySession=(MySession) session.getAttribute("MySession");
						}else{
							mySession=new MySession();
						}
						//保存在线用户信息
						mySession.setUser(list.get(0));
						//得到当天发送短信数
						mySession.setSendNoteNum(noteSendManager.getSendNoteNum(list.get(0).getId()));
						//得到当天发送短信的人数
						mySession.setSendPeopleNum(noteReceiveManager.getSendPeopleNum(list.get(0).getId()));
						//得到未读短信数
						mySession.setNoseeNoteNum(noteReceiveManager.getNoseeNoteNum(list.get(0).getId()));
						//得到用户最后登陆时间
						mySession.setLastLoginTime(logManager.getLastLoginTime(list.get(0).getId()));
						//得到用户登陆的次数
						mySession.setLoginNum(logManager.getLoginNum(list.get(0).getId()));
						//设置登录状态
						mySession.setLogin(true);
						//保存session						
						session.setAttribute("MySession", mySession);
						//插入日记
						Log log=new Log();
						log.setCid(list.get(0).getId());
						log.setTag("login");
						log.setCdate(new Date());
						log.setSummary(list.get(0).getUserName()+"登陆系统！");
						log.setIp(getRequest().getLocalAddr());
						logManager.save(log);
						return INDEX_JSP;
					}else{
						showMessage("账号或密码错误！");
					}
				}else{
					showMessage("此账号已锁定，请联系管理人员协助！");
				}
			}else{
				showMessage("无此用户存在！");
			}
			
			return LOGIN_JSP;

		}
		
		public String logout(){
			HttpSession session=getRequest().getSession(false);
			ServletContext servletContext=getRequest().getServletContext();
			if(session!=null){
				MySession mySession=(MySession) session.getAttribute("MySession");
				if(mySession!=null){
					//退出在线人员名单
					Application application=(Application) servletContext.getAttribute("Application");
					if(application!=null){
						application.getOnlineUser().remove(mySession.getUser().getId());
						servletContext.setAttribute("Application", application);
					}
					//注销session
					session.removeAttribute("MySession");
				}
			}
			return LOGIN_JSP;
		}
}
