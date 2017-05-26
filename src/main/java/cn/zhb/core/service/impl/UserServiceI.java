package cn.zhb.core.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zhb.core.entity.Users;
import cn.zhb.core.mapper.UserMapper;
import cn.zhb.core.service.UserService;

@Service("userService")
public class UserServiceI implements UserService {
	@Resource
	private UserMapper userMappe;
	
	@Override
	public Users getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return userMappe.getUserByUsername(userName);
	}
	
}
