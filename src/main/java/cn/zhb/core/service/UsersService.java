package cn.zhb.core.service;


import javax.servlet.http.HttpSession;

import cn.zhb.core.entity.Users;

public interface UsersService {
	
	Users getUserByUsername(String userName);
	
	String encodePassword(String password);
	
	void setUserToSession(Users users, HttpSession session);
	
	Users getUserFromSession(HttpSession session);
}
