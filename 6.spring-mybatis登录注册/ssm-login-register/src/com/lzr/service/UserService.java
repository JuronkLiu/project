package com.lzr.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.lzr.mapper.UserMapper;
import com.lzr.pojo.User;

@Service("userService")
public class UserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;


	/*
	 * 用户注册
	 */
	public Integer register(User user) {
		return userMapper.register(user);
	}

	/*
	 * 用户登录
	 */
	public Integer login(User user) {
		return userMapper.login(user);
	}

}