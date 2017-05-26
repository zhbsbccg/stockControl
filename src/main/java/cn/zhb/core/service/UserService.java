package cn.zhb.core.service;

import cn.zhb.core.entity.Users;

public interface UserService {
	Users getUserByUsername(String userName);
}
