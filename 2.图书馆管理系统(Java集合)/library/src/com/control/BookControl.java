package com.control;

import com.bean.User;

/**
 *@describe 图书管理
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:32:35 
*/
public interface BookControl {

	
	void showBooks();

	void borrowBooks(User user);

	void showMyBooks(User user);

	void returnBooks(User user);


}
