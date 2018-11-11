package com.lzr.mapper;

import com.lzr.pojo.User;

public interface UserMapper {

	// 用户注册
	Integer register(User user);
	
	//用户登录
	Integer login(User user);

}
