package com.lx.control;


import com.lx.bean.User;
import com.lx.utils.MenuUtil;
import com.lx.utils.Utils;

/**
 *@describe 界面控制
 *
 *@author liuzhirong
 *@date 2018年8月20日---上午11:17:31 
*/
public class Menu {
	static Supermarket supermarket = new SupermarketImpl();
	static Cart cart = new CartImpl();
	
	//登录注册界面控制
	public static void welcome() {
		while(true){
			MenuUtil.welcome();
			int inputInt = Utils.inputInt("请输入您的选择：");
			switch (inputInt) {
			case 1:
				User user = supermarket.userLogin();
				if (user == null) {
					System.out.println("登录失败");
				}else {
					if (user.isAdmin()) {
						adminHome(user);
					}else{
						userHome(user);
					}
				}
				break;
			case 2:
				supermarket.userRegister();
				break;
			case 3:
				System.exit(0);
				break;

			default:
				System.out.println("您输入的选项不存在！请重新输入！！！");
				break;
			}
		}
	}
	
	//超市界面控制---管理员
	private static void adminHome(User user) {
		while(true){
			MenuUtil.adminHome(user);
			int choose = Utils.inputInt("请输入您的选择：");
			switch (choose) {
			case 1:
				supermarket.showGoods();
				break;
			case 2:
				supermarket.addGoods();
				break;
			case 3:
				supermarket.delGoods();
				break;
			case 4:
				supermarket.queryGoods();
				break;
			case 5:
				supermarket.updateGods();
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
	
	
	//超市界面控制---普通用户
	public static void userHome(User user){
		while(true){
			MenuUtil.userHome(user);
			int choose = Utils.inputInt("请输入您的选择：");
			switch (choose) {
			case 1:
				supermarket.showGoods();
				break;
			case 2:
				supermarket.queryGoods();
				break;
			case 3:
				cart.addCart(supermarket,user);
				break;
			case 4:
				cart.delCart(supermarket,user);
				break;
			case 5:
				cart.delAllCart(user);
				break;
			case 6:
				cart.queryCart(user);
				break;
			case 7:
				cart.updateCart(supermarket,user);
				break;
			case 8:
				cart.showMyCart(user);
				break;
			case 9:
				cart.pay(supermarket,user);
				break;
			case 10:
				welcome();
				break;
			default:
				System.out.println("您输入的选项不存在！请重新输入！！！");
				break;
			}
		}
	}
	
}
