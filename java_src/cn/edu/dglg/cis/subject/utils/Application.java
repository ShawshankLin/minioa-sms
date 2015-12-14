package cn.edu.dglg.cis.subject.utils;

import java.util.HashMap;
import java.util.Map;

import cn.edu.dglg.cis.subject.model.User;

public class Application {
	private Map<Integer, User> onlineUser=new HashMap<Integer, User>();

	public Map<Integer, User> getOnlineUser() {
		return onlineUser;
	}

	public void setOnlineUser(Map<Integer, User> onlineUser) {
		this.onlineUser = onlineUser;
	}


}
