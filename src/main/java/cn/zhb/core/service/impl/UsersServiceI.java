package cn.zhb.core.service.impl;

import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

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
		// TODO Auto-generated method stub
		return userMappe.getUserByUsername(userName);
	}
	
	/**
	 * 加密密码
	 * @throws NoSuchAlgorithmException 
	 */
	public String encodePassword(String password) {
		// TODO Auto-generated method stub
		return DigestUtils.md5Hex(password);
	}
	
	
	
}
