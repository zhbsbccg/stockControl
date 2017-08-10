package cn.zhb.core.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import cn.zhb.core.entity.Users;
import cn.zhb.core.mapper.UsersMapper;
import cn.zhb.core.service.UsersService;


@Service("userService")
public class UsersServiceI implements UsersService {
	@Resource
	private UsersMapper userMappe;
	
	public Users getUserByUsername(String userName) {
		return userMappe.getUserByUsername(userName);
	}
	
	/**
	 * 加密密码
	 * @throws NoSuchAlgorithmException 
	 */
	public String encodePassword(String password) {
		return DigestUtils.md5Hex(password);
	}

	@Override
	public void setUserToSession(Users users, HttpSession session) {
		users.setPassword("");
		session.setAttribute("currUser", users);
	}

	@Override
	public Users getUserFromSession(HttpSession session) {
		return (Users) session.getAttribute("currUser");
	}

	@Override
	public Users getById(Integer id) {
		return userMappe.getById(id);
	}
	
	
	
	
	
}
