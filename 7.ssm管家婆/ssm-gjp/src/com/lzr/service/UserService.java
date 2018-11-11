package com.lzr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.lzr.mapper.UserMapper;
import com.lzr.pojo.User;

@Service("userService")
public class UserService {
	
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	public User findUserById(Integer id){
		return userMapper.findUserById(id);
	}
}
