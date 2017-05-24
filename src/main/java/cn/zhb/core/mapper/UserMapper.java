package cn.zhb.core.mapper;

import org.springframework.stereotype.Repository;

import cn.zhb.core.entity.User;

@Repository
public interface UserMapper {
	User getUserByUsername(String userName);
}
