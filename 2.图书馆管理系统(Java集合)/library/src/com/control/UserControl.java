package com.control;

import java.util.ArrayList;
import java.util.List;

import com.bean.User;

/**
 *@describe �û�����
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:32:22 
*/
public interface UserControl {

	List<User> users = new ArrayList<>();
	
	public User login() ;

	public boolean register();


}
