package com.control;

import com.bean.User;
import com.client.Menu;
import com.utils.Utils;

/**
 *@describe 
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:37:19 
*/
public class UserControlImpl implements UserControl{

	/**
	 * 登陆
	 */
	@Override
	public User login() {
		
		User u =new User();
		
		String name = null;
		String password = null;
		boolean b = false;	//记录用户是否存在
		while (true) {
			name = Utils.inputStr("请输入用户名(exit返回)：");
			if (name.equals("exit")) {
				Menu.welcome();
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					u = user;
					b = true;
					break;
				}
			}
			if (!b) {
				System.out.println("用户不存在！请重新输入");
				continue;
			}
			while (true) {
				password = Utils.inputStr("请输入密码:");
				if (u.getPassword().equals(password)) {
					return u;
				} else {
					System.out.println("密码错误！");
					continue;
				} 
			}
		}
	}

	/**
	 * 注册
	 */
	@Override
	public boolean register() {
		String name;
		String password;
		f1:while (true) {
			name = Utils.inputStr("请输入用户名(exit返回):");
			if (name.equals("exit")) {
				return true;
			}
			for (User user : users) {
				if (user.getName().equals(name)) {
					System.out.println("--用户已存在！请重新输入");
					continue f1;
				}
			} 
			password = Utils.inputStr("请输入密码:");
			users.add(new User(name,password));
			System.out.println("注册成功！");
			return false;
		}
		
	}

}
