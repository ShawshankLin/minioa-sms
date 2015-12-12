package com.minioa2.project.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.minioa2.project.model.RoleUserRelation;
import com.minioa2.project.model.User;

public class MySession {
	/**
	 * 用户信息
	 */
	private User user;
	/**
	 * 用户角色
	 */
	private List<RoleUserRelation> roleList=new ArrayList<RoleUserRelation>();

	/**
	 * 每天发送短信数量
	 */
	private int sendNoteNum;
	/**
	 * 每天发送短信人数
	 */
	private int sendPeopleNum;
	/**
	 * 未读短信数量
	 */
	private int noseeNoteNum;
	/**
	 * 最后登陆的时间
	 */
	private String lastLoginTime;
	/**
	 * 登陆的次数
	 */
	private int loginNum;
	/**
	 * 是否登陆
	 */
	private boolean isLogin;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<RoleUserRelation> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleUserRelation> roleList) {
		this.roleList = roleList;
	}
	public int getSendNoteNum() {
		return sendNoteNum;
	}
	public void setSendNoteNum(int sendNoteNum) {
		this.sendNoteNum = sendNoteNum;
	}
	public int getSendPeopleNum() {
		return sendPeopleNum;
	}
	public void setSendPeopleNum(int sendPeopleNum) {
		this.sendPeopleNum = sendPeopleNum;
	}
	public int getNoseeNoteNum() {
		return noseeNoteNum;
	}
	public void setNoseeNoteNum(int noseeNoteNum) {
		this.noseeNoteNum = noseeNoteNum;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public int getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}
	public boolean isLogin() {
		return isLogin;
	}
	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
	
	
}
