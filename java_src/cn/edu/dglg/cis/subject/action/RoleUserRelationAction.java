/*
 */

package cn.edu.dglg.cis.subject.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.RequestMap;

import cn.edu.dglg.cis.subject.dao.*;
import cn.edu.dglg.cis.subject.model.*;
import cn.edu.dglg.cis.subject.service.*;
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


/**
 * @author jxx
 * @version 1.0
 * @since 1.0
 */


import javax.annotation.Resource;

public class RoleUserRelationAction extends BaseStruts2Action implements Preparable,ModelDriven{
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	//forward paths
	protected static final String QUERY_JSP = "/pages/RoleUserRelation/query.jsp";
	protected static final String LIST_JSP= "/pages/RoleUserRelation/list.jsp";
	protected static final String CREATE_JSP = "/pages/RoleUserRelation/create.jsp";
	protected static final String EDIT_JSP = "/pages/RoleUserRelation/edit.jsp";
	protected static final String SHOW_JSP = "/pages/RoleUserRelation/show.jsp";
	//redirect paths,startWith: !
	protected static final String LIST_ACTION = "!/pages/RoleUserRelation/list.do";
	
	private RoleUserRelationManager roleUserRelationManager;
	@Resource private RoleManager roleManager;
	@Resource private UserManager userManager;
	private RoleUserRelation roleUserRelation;
	java.lang.Integer id = null;
	private String[] items;

	public void prepare() throws Exception {
		if (isNullOrEmptyString(id)) {
			roleUserRelation = new RoleUserRelation();
		} else {
			roleUserRelation = (RoleUserRelation)roleUserRelationManager.getById(id);
		}
	}
	
	/** 增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,注意大小写 */
	public void setRoleUserRelationManager(RoleUserRelationManager manager) {
		this.roleUserRelationManager = manager;
	}	
	
	public Object getModel() {
		return roleUserRelation;
	}
	
	public void setId(java.lang.Integer val) {
		this.id = val;
	}

	public void setItems(String[] items) {
		this.items = items;
	}
	
	/** 执行搜索 */
	public String list() {
		RoleUserRelationQuery query = newQuery(RoleUserRelationQuery.class,DEFAULT_SORT_COLUMNS);
		
		Page page = roleUserRelationManager.findPage(query);
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
		roleUserRelationManager.save(roleUserRelation);
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
		roleUserRelationManager.update(this.roleUserRelation);
		Flash.current().success(UPDATE_SUCCESS);
		return LIST_ACTION;
	}
	
	/**删除对象*/
	public String delete() {
		for(int i = 0; i < items.length; i++) {
			Hashtable params = HttpUtils.parseQueryString(items[i]);
			java.lang.Integer id = new java.lang.Integer((String)params.get("id"));
			roleUserRelationManager.removeById(id);
		}
		Flash.current().success(DELETE_SUCCESS);
		return LIST_ACTION;
	}
	public void getRelative(){
		List<Role> roleList =  roleManager.findAll();
		requestMap.put("roleList",roleList);
		List<User> userList =  userManager.findAll();
		requestMap.put("userList",userList);
	}

}
