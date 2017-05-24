package cn.zhb.core.service.impl;

import org.springframework.stereotype.Service;

import cn.zhb.core.entity.User;
import cn.zhb.core.mapper.UserMapper;
import cn.zhb.core.service.UserService;

@Service("userService")
public class UserServiceI implements UserService {
	
	private UserMapper userMappe;
	
	@Override
	public User getUserByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
