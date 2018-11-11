package com.utils;

import com.bean.User;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月14日---上午11:32:38 
*/
public class MenuUtil {

	/**
	 * 登录注册界面
	 */
	public static  void welcome() {
		System.out.println("***欢迎使用图书管理系统***");
		System.out.println("1.登录");
		System.out.println("2.注册");
		System.out.println("3.退出系统");
	}
	
	/**
	 * 图书管理系统主界面
	 * @param user
	 */
	public static void homePage(User user) {
		System.out.println("***欢迎"+user.getName()+"使用图书管理系统***");
		System.out.println("1.查看图书");
		System.out.println("2.借书");
		System.out.println("3.还书");
		System.out.println("4.查看借阅书籍");
		System.out.println("5.返回上一级");
	}
}
