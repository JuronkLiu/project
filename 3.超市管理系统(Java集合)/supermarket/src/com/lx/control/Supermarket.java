package com.lx.control;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.lx.bean.Goods;
import com.lx.bean.User;

/**
 *@describe 超市接口
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:06:34 
*/
public interface Supermarket {
	
	Set<User> users = new HashSet<>();
	Set<Goods> goods = new HashSet<>();

	User userLogin();

	void userRegister();

	void showGoods();

	void addGoods();

	void delGoods();

	void queryGoods();
	
	void queryGoodsByName();

	void updateGods();
	
	Goods  findGoods(Integer id);
	

}
