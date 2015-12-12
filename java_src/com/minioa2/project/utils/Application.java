package com.minioa2.project.utils;

import java.util.HashMap;
import java.util.Map;

import com.minioa2.project.model.User;

public class Application {
	private Map<Integer, User> onlineUser=new HashMap<Integer, User>();

	public Map<Integer, User> getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(Map<Integer, User> onlineUser) {
		this.onlineUser = onlineUser;
	}


}
