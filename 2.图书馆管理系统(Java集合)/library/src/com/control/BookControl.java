package com.control;

import com.bean.User;

/**
 *@describe ͼ�����
 *
 *@author liuzhirong
 *@date 2018��8��13��---����11:32:35 
*/
public interface BookControl {

	
	void showBooks();

	void borrowBooks(User user);

	void showMyBooks(User user);

	void returnBooks(User user);


}
