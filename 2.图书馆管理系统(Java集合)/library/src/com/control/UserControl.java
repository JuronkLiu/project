package com.control;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;

/**
 *@describe 用户管理
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:32:22 
*/
public interface UserControl {

	List<User> users = new ArrayList<>();
	
	public User login() ;

	public boolean register();


}
