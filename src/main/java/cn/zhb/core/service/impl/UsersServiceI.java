package cn.zhb.core.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhb.core.entity.Users;
import cn.zhb.core.mapper.UsersMapper;
import cn.zhb.core.service.UsersService;


@Service("userService")
public class UsersServiceI implements UsersService {
	/*@Resource
	private UsersMapper userMapper;*/
	
	@Autowired
	SQLManager sql;
	
	public Users getUserByUsername(String userName) {
		return sql.query(Users.class).andEq("username", userName).unique();
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
		session.setAttribute("currUser", users.getId());
	}

	@Override
	public Users getUserFromSession(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("currUser");
		return this.getById(userId) ;
	}

	@Override
	public Users getById(Integer id) {
		return sql.unique(Users.class, id);
	}

	@Override
	public int update(Users user) {
		// TODO Auto-generated method stub
		return sql.updateTemplateById(user);
	}

	@Override
	public boolean checkPasswordById(Integer id, String password) {
		boolean isRight = false;
		Users users = this.getById(id);
		if(StringUtils.equals(users.getPassword(), encodePassword(password))) {
			isRight = true;
		}
		return isRight;
	}
	
	
	
	
	
}
