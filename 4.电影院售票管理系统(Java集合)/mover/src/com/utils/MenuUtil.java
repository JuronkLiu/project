package com.utils;

import com.bean.User;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月23日---下午4:01:42 
*/
public class MenuUtil {

	public static void welcome() {
		System.out.println("***欢迎登录电影售票系统***");
		System.out.println("   1.查看电影");
		System.out.println("   2.登录");
		System.out.println("   3.注册");
	}

	public static void home(User user) {
		System.out.println("******欢迎用户"+user.getName()+"使用电影售票系统******");
		System.out.println("   1.查看预订好的电影票");
		System.out.println("   2.预订");
		System.out.println("   3.购买");
		System.out.println("   4.取消预订");
		System.out.println("   5.查看已购买的电影票");
		System.out.println("   6.返回上一级");
	}
	
	public static void adminHome(User user) {
		System.out.println("******欢迎管理员"+user.getName()+"登录电影售票管理系统******");
		System.out.println("   1.添加电影");
		System.out.println("   2.删除电影");
		System.out.println("   3.修改电影");
		System.out.println("   4.查看电影(按电影id查看)");
		System.out.println("   5.查看全部电影信息");
		System.out.println("   6.返回上一级");
	}
}
