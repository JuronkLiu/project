package com.lzr.mapper;

import java.util.List;

import com.lzr.pojo.Adminuser;
import com.lzr.pojo.Page;
import com.lzr.pojo.QueryVo;

public interface AdminuserMapper {

	// 用户注册
	Integer register(Adminuser user);

	// 用户登录
	Adminuser login(Adminuser user);
	
	// 按照昵称查找用户
	Integer findUser(String usernichen);
	
	// 查找全部用户
	List<Adminuser> findAllUser(QueryVo vo);
	
	// 查找用户数量
	Integer countUser(String usernichen);
}
