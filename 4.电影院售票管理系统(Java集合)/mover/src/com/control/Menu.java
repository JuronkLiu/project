package com.control;

import com.bean.User;
import com.utils.MenuUtil;
import com.utils.Util;

/**
 * @describe 程序入口控制
 *
 * @author liuzhirong
 * @date 2018年8月23日---下午4:10:16
 */
public class Menu {

	static Mover mover = new Mover();

	// 登录注册界面控制
	public static void welcome() {
		while (true) {
			MenuUtil.welcome();
			int inputInt = Util.inputInt("请输入您的选择：");
			switch (inputInt) {
			case 1:
				mover.showTickets();
				break;
			case 2:
				User user = mover.userLogin();
				if (user == null) {
					System.out.println("登录失败");
				} else if (user.isTag()) {
					adminHome(user,mover);
				} else {
					home(user);
				}
				break;
			case 3:
				mover.userRegister();
				break;

			default:
				System.out.println("您输入的选项不存在！请重新输入！！！");
				break;
			}
		}
	}

	private static void adminHome(User user, Mover m) {
		while (true) {
			MenuUtil.adminHome(user);
			int inputInt = Util.inputInt("请输入您的选择：");
			switch (inputInt) {
			case 1:
				mover.addTickTypes();
				break;
			case 2:
				mover.delTickTypes();
				break;
			case 3:
				mover.updateTickTypes();
				break;
			case 4:
				mover.showTickTypesById();
				break;
			case 5:
				mover.showAllTickTypes();
				break;
			case 6:
				welcome();
				break;
			default:
				System.out.println("您输入的选项不存在！请重新输入！！！");
				break;
			}
		}
		
	}

	private static void home(User user) {
		while (true) {
			MenuUtil.home(user);
			int inputInt = Util.inputInt("请输入您的选择：");
			switch (inputInt) {
			case 1:
				user.showBuyBefore();
				break;
			case 2:
				user.buyBefore(mover);
				break;
			case 3:
				user.buy(mover);
				break;
			case 4:
				user.removeBuyBefore(mover);
				break;
			case 5:
				user.showBuy();
				break;
			case 6:
				welcome();
				break;
			default:
				System.out.println("您输入的选项不存在！请重新输入！！！");
				break;
			}
		}
	}

}
