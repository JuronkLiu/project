package com.lx.utils;

import com.lx.bean.User;

/**
 *@describe 界面类
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:00:05 
*/
public class MenuUtil {

	/**
	 * 登录注册界面
	 */
	public static  void welcome() {
		System.out.println("***欢迎登录超市管理系统***");
		System.out.println("   1.登录");
		System.out.println("   2.注册");
		System.out.println("   3.退出系统");
		
	}
	
	/**
	 * 超市管理系统主界面---管理员
	 * @param user
	 */
	public static void adminHome(User user) {
		System.out.println("******欢迎管理员"+user.getName()+"使用超市管理系统******");
		System.out.println("      1.查看商品全部信息");
		System.out.println("      2.添加商品信息");
		System.out.println("      3.删除商品信息(商品id索引)");
		System.out.println("      4.查看商品信息");
		System.out.println("      5.修改商品信息(商品id索引)");
		System.out.println("      6.返回上一级");
	}
	
	/**
	 * 超市管理系统主界面---普通用户
	 * @param user
	 */
	public static void userHome(User user) {
		System.out.println("******欢迎用户"+user.getName()+"使用超市管理系统******");
		System.out.println("      1.逛超市");
		System.out.println("      2.寻找商品");
		System.out.println("      3.添加商品到购物车(商品id索引)");
		System.out.println("      4.删除购物车的商品信息(商品id索引)");
		System.out.println("      5.清空购物车");
		System.out.println("      6.查看购物车某商品的信息(商品id索引)");
		System.out.println("      7.修改购物车的商品信息(商品id索引)");
		System.out.println("      8.查看我的购物车");
		System.out.println("      9.支付");
		System.out.println("      10.返回上一级");
	}
}
