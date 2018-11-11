package com.client;

import com.bean.User;
import com.control.BookControl;
import com.control.BookControlImpl;
import com.control.UserControl;
import com.control.UserControlImpl;
import com.utils.MenuUtil;
import com.utils.Utils;

/**
 *@describe 显示界面
 *
 *@author liuzhirong
 *@date 2018年8月13日---上午11:34:20 
*/
public class Menu {

	/**
	 * 登陆注册界面选择流程
	 */
	public  static void welcome() {
		UserControl userControl = new UserControlImpl();
		while (true) {
			MenuUtil.welcome();
			int choose = Utils.inputInt("请选择:");
			if (choose < 0 || choose > 3) {
				System.out.println("--选项不存在！");
				continue;
			}
			switch (choose) {
			case 1:
				User user = userControl.login();
				if (user == null) {
					System.out.println("登录失败");
				}else {
					homePage(user);
					return;
				}
				break;
			case 2:
				boolean reg = userControl.register();
				if (reg) {
					continue;
				}
				break;
			case 3:
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * 进入图书管理系统，传入登陆的用户
	 * @param user	登陆的用户
	 */
	private static void homePage(User user) {
		BookControl bControl = new BookControlImpl();
		while (true) {
			MenuUtil.homePage(user);
			int choose = Utils.inputInt("请选择:");
			if (choose < 0 || choose > 5) {
				System.out.println("--选项不存在！");
				continue;
			} 
			switch (choose) {
			case 1:
				bControl.showBooks();
				break;
			case 2:
				bControl.borrowBooks(user);
				break;
			case 3:
				bControl.returnBooks(user);
				break;
			case 4:
				bControl.showMyBooks(user);
				break;
			case 5:
				welcome();
				break;
			}
		}
	}
	
}
