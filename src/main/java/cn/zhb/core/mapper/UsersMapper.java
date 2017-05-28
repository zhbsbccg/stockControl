package cn.zhb.core.mapper;

import org.springframework.stereotype.Repository;

import cn.zhb.core.entity.Users;

@Repository
public interface UsersMapper {
	Users getUserByUsername(String userName);
}
