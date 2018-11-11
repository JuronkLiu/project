package com.lx.control;


import com.lx.bean.User;
import com.lx.utils.MenuUtil;
import com.lx.utils.Utils;

/**
 *@describe �������
 *
 *@author liuzhirong
 *@date 2018��8��20��---����11:17:31 
*/
public class Menu {
	static Supermarket supermarket = new SupermarketImpl();
	static Cart cart = new CartImpl();
	
	//��¼ע��������
	public static void welcome() {
		while(true){
			MenuUtil.welcome();
			int inputInt = Utils.inputInt("����������ѡ��");
			switch (inputInt) {
			case 1:
				User user = supermarket.userLogin();
				if (user == null) {
					System.out.println("��¼ʧ��");
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
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
	}
	
	//���н������---����Ա
	private static void adminHome(User user) {
		while(true){
			MenuUtil.adminHome(user);
			int choose = Utils.inputInt("����������ѡ��");
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
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
	}
	
	
	//���н������---��ͨ�û�
	public static void userHome(User user){
		while(true){
			MenuUtil.userHome(user);
			int choose = Utils.inputInt("����������ѡ��");
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
				System.out.println("�������ѡ����ڣ����������룡����");
				break;
			}
		}
	}
	
}
