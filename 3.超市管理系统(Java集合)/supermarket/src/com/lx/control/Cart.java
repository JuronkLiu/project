package com.lx.control;

import com.lx.bean.User;

/**
 *@describe 购物车接口
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:06:45 
*/
public interface Cart {

	
	
	void addCart(Supermarket supermarket, User user);

	void delCart(Supermarket supermarket, User user);

	void delAllCart(User user);

	void queryCart(User user);

	void updateCart(Supermarket supermarket, User user);

	Double showMyCart(User user);

	void pay(Supermarket supermarket, User user);

}
