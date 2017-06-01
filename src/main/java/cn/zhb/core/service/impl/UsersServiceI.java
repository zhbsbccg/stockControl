package cn.zhb.core.service.impl;

import javax.annotation.Resource;

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
	
	
	
}
